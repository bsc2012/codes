package com.bsc.kafka.clients.producer.task;

import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.bsc.kafka.clients.producer.partitioner.MyPartitioner;
import com.bsc.kafka.clients.properties.KafkaProperties;

public class KafkaProducerTask implements Runnable {

	private KafkaProducer<String, String> kafkaProducer;

	private String topic;

	public KafkaProducerTask(String topic, Properties props) {
		Properties properties = KafkaProperties.defaultKafkaProducerProperties();
		for (Map.Entry<Object, Object> entry : props.entrySet()) {
			properties.put(entry.getKey(), entry.getValue());
		}
		kafkaProducer = new KafkaProducer<String, String>(properties);
		this.topic = topic;
	}

	private BlockingQueue<ProducerRecord<String, String>> queue = new LinkedBlockingDeque<ProducerRecord<String, String>>(
			1024 * 1024 * 1024);

	public void sendMessage(String key, String value) {
		ProducerRecord<String, String> record = new ProducerRecord<String, String>(topic, key, value);
		try {
			queue.put(record);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		ProducerRecord<String, String> record;
		try {
			while (true) {
				record = queue.take();
				//kafkaProducer.send(record);
				 RecordMetadata recordMetadata = kafkaProducer.send(record).get();
				 System.out.println("offset:" + recordMetadata.offset() + ",partition:" +
				 recordMetadata.partition());
				System.out.println(
						Thread.currentThread().getName() + " producer Message:" + record.key() + ":" + record.value());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Properties props = new Properties();
		props.put(KafkaProperties.bootstrap_servers, "132.121.88.104:9092");
		//props.put(KafkaProperties.partitioner_class, MyPartitioner.class.getName());

		//String topic = "topic-p4-r1";
		String topic = "test";
		KafkaProducerTask producerTask = new KafkaProducerTask(topic, props);
		Thread KafkaProducerThread = new Thread(producerTask);
		KafkaProducerThread.start();

		int count = 0;
		while (true) {
			producerTask.sendMessage(String.valueOf(System.currentTimeMillis()), UUID.randomUUID().toString());
			if (++count >= 1000000) {
				break;
			}
			Thread.sleep(1000);
		}
	}

}
