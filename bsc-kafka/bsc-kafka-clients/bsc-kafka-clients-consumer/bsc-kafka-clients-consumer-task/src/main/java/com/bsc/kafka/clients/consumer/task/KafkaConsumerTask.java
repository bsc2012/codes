package com.bsc.kafka.clients.consumer.task;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.bsc.kafka.clients.properties.KafkaProperties;

public class KafkaConsumerTask implements Runnable {

	private KafkaConsumer<String, String> kafkaConsumer;

	public KafkaConsumerTask(String topic, Properties props) {
		Properties properties = KafkaProperties.defaultKafkaConsumerProperties();
		for (Map.Entry<Object, Object> entry : props.entrySet()) {
			properties.put(entry.getKey(), entry.getValue());
		}
		kafkaConsumer = new KafkaConsumer<String, String>(properties);
		kafkaConsumer.subscribe(Collections.singletonList(topic));
	}

	@Override
	public void run() {
		while (true) {
			ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				System.out
						.println(Thread.currentThread().getName() + " consumer Message:key:" + record.key() + ",value:"
								+ record.value() + ",partition:" + record.partition() + ",offset:" + record.offset());
			}
		}
	}

	public static void main(String[] args) {
		Properties props = new Properties();
		String bootstrap_servers = "192.168.58.129:9092";
		props.put(KafkaProperties.bootstrap_servers, bootstrap_servers);
		props.put(KafkaProperties.group_id, "test-consumer-group");
		// props.put("max.partition.fetch.bytes", "256");

		String topic = "topic-p4-r1";
		System.out.println("consumer for topic:" + topic + "," + bootstrap_servers);
		KafkaConsumerTask consumerTask1 = new KafkaConsumerTask(topic, props);
		KafkaConsumerTask consumerTask2 = new KafkaConsumerTask(topic, props);
		KafkaConsumerTask consumerTask3 = new KafkaConsumerTask(topic, props);
		KafkaConsumerTask consumerTask4 = new KafkaConsumerTask(topic, props);
		new Thread(consumerTask1).start();
		new Thread(consumerTask2).start();
		new Thread(consumerTask3).start();
		new Thread(consumerTask4).start();
	}
}
