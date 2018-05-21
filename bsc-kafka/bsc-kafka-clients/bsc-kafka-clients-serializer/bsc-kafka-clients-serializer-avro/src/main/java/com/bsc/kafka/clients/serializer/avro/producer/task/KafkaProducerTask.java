package com.bsc.kafka.clients.serializer.avro.producer.task;

import java.util.Map;
import java.util.Properties;
import java.util.UUID;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;

import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.clients.producer.RecordMetadata;

import com.bsc.kafka.clients.properties.KafkaProperties;
import com.bsc.kafka.clients.serializer.avro.AvroSerializer;
import com.bsc.kafka.clients.serializer.avro.record.User;

public class KafkaProducerTask<T extends SpecificRecordBase> implements Runnable{

	private KafkaProducer<String, T> kafkaProducer;

	private String topic;

	public KafkaProducerTask(String topic, Properties props) {
		Properties properties = KafkaProperties.defaultKafkaProducerProperties();
		for (Map.Entry<Object, Object> entry : props.entrySet()) {
			properties.put(entry.getKey(), entry.getValue());
		}
		kafkaProducer = new KafkaProducer<String,T>(properties);
		this.topic = topic;
	}

	private BlockingQueue<ProducerRecord<String, T>> queue = new LinkedBlockingDeque<ProducerRecord<String, T>>(1024 * 1024);

	public void sendMessage(String key, T value) {
		ProducerRecord<String, T> record = new ProducerRecord<String,T>(topic, key, value);
		try {
			queue.put(record);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void run() {
		ProducerRecord<String, T> record;
		try {
			while (true) {
				record = queue.take();
				RecordMetadata recordMetadata = kafkaProducer.send(record).get();
				System.out.println("offset:" + recordMetadata.offset() + ",partition:" + recordMetadata.partition());
				System.out.println(
						Thread.currentThread().getName() + " producer Message:" + record.key() + ":" + record.value());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static void main(String[] args) throws InterruptedException {
		Properties props = new Properties();
		props.put(KafkaProperties.bootstrap_servers, "192.168.99.100:9092");
		props.put(KafkaProperties.value_serializer, AvroSerializer.class.getName());

		String topic = "test";
		KafkaProducerTask<User> producerTask = new KafkaProducerTask<>(topic, props);
		new Thread(producerTask).start();

		while (true) {
			User user = User.newBuilder().setName(UUID.randomUUID().toString()).setAddress(UUID.randomUUID().toString()).build();
			producerTask.sendMessage(String.valueOf(System.currentTimeMillis()), user);
			Thread.sleep(10);
		}
	}
}
