package com.bsc.kafka.clients.serializer.avro.consumer.task;

import java.util.Collections;
import java.util.Map;
import java.util.Properties;

import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import com.bsc.kafka.clients.properties.KafkaProperties;
import com.bsc.kafka.clients.serializer.avro.AvroDeserializer;
import com.bsc.kafka.clients.serializer.avro.record.User;

public class KafkaConsumerTask<T extends SpecificRecordBase> implements Runnable {

	private KafkaConsumer<String, T> kafkaConsumer;

	public KafkaConsumerTask(String topic, Properties props) {
		Properties properties = KafkaProperties.defaultKafkaConsumerProperties();
		for (Map.Entry<Object, Object> entry : props.entrySet()) {
			properties.put(entry.getKey(), entry.getValue());
		}
		kafkaConsumer = new KafkaConsumer<String,T>(properties);
		kafkaConsumer.subscribe(Collections.singletonList(topic));
	}

	@Override
	public void run() {
		while (true) {
			ConsumerRecords<String, T> records = kafkaConsumer.poll(100);
			for (ConsumerRecord<String, T> record : records) {
				System.out.println(
						Thread.currentThread().getName() + " consumer Message:key:" + record.key() + ",value:" + record.value() + ",partition:" + record.partition() + ",offset:" + record.offset());
			}
		}
	}
	
	public static void main(String[] args) {
		Properties props = new Properties();
		String bootstrap_servers = "192.168.99.100:9092";
		props.put(KafkaProperties.bootstrap_servers, bootstrap_servers);
		props.put(KafkaProperties.group_id, "test-consumer-group");
		props.put(KafkaProperties.value_deserializer, AvroDeserializer.class.getName());
		//props.put("max.partition.fetch.bytes", "256");

		String topic = "test";
		System.out.println("consumer for topic:" + topic + "," + bootstrap_servers);
		KafkaConsumerTask<User> consumerTask1 = new KafkaConsumerTask<>(topic, props);
		new Thread(consumerTask1).start();
	}
}
