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
		kafkaConsumer = new KafkaConsumer<>(properties);
		kafkaConsumer.subscribe(Collections.singletonList(topic));
	}

	@Override
	public void run() {
		while (true) {
			ConsumerRecords<String, String> records = kafkaConsumer.poll(100);
			for (ConsumerRecord<String, String> record : records) {
				System.out.println(
						Thread.currentThread().getName() + " consumer Message:" + record.key() + ":" + record.value());
			}
		}
	}

	public static void main(String[] args) {
		Properties props = new Properties();
		props.put(KafkaProperties.bootstrap_servers, "192.168.58.129:9091");
		props.put(KafkaProperties.group_id, "test-consumer-group");

		String topic = "topic-p4-r1";
		System.out.println("consumer for topic:" + topic);
		KafkaConsumerTask consumerTask = new KafkaConsumerTask(topic, props);
		new Thread(consumerTask).start();
	}
}
