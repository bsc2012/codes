package com.bsc.kafka.clients.properties;

import java.util.Properties;

import org.apache.kafka.common.serialization.StringDeserializer;
import org.apache.kafka.common.serialization.StringSerializer;

public class KafkaProperties {

	public final static String bootstrap_servers = "bootstrap.servers";
	public final static String bootstrap_servers_default = "localhost:9092";

	public final static String group_id = "group.id";

	public final static String partitioner_class = "partitioner.class";

	public final static String key_serializer = "key.serializer";
	public final static String key_serializer_default = StringSerializer.class.getName();

	public final static String value_serializer = "value.serializer";
	public final static String value_serializer_default = StringSerializer.class.getName();

	public final static String key_deserializer = "key.deserializer";
	public final static String key_deserializer_default = StringDeserializer.class.getName();

	public final static String value_deserializer = "value.deserializer";
	public final static String value_deserializer_default = StringDeserializer.class.getName();

	public static Properties defaultKafkaProducerProperties() {
		Properties props = new Properties();
		props.put(bootstrap_servers, bootstrap_servers_default);

		props.put(key_serializer, key_serializer_default);
		props.put(value_serializer, value_serializer_default);
		return props;
	}

	public static Properties defaultKafkaConsumerProperties() {
		Properties props = new Properties();
		props.put(bootstrap_servers, bootstrap_servers_default);

		props.put(key_deserializer, key_deserializer_default);
		props.put(value_deserializer, value_deserializer_default);
		return props;
	}
}
