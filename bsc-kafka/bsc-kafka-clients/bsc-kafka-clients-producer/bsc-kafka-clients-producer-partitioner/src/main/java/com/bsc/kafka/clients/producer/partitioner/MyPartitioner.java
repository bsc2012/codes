package com.bsc.kafka.clients.producer.partitioner;

import java.util.Map;

import org.apache.kafka.clients.producer.Partitioner;
import org.apache.kafka.common.Cluster;

public class MyPartitioner implements Partitioner {

	@Override
	public void configure(Map<String, ?> configs) {
	}

	private int index;

	@Override
	public int partition(String topic, Object key, byte[] keyBytes, Object value, byte[] valueBytes, Cluster cluster) {
		return index++ % 4;
	}

	@Override
	public void close() {

	}

}
