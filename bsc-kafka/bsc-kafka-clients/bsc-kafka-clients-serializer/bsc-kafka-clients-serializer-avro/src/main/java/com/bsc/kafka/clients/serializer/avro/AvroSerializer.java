package com.bsc.kafka.clients.serializer.avro;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.avro.io.BinaryEncoder;
import org.apache.avro.io.DatumWriter;
import org.apache.avro.io.EncoderFactory;
import org.apache.avro.specific.SpecificDatumWriter;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Serializer;

public class AvroSerializer<T extends SpecificRecordBase> implements Serializer<T> {

	@Override
	public void configure(Map<String, ?> configs, boolean isKey) {

	}

	@Override
	public byte[] serialize(String topic, T data) {
		DatumWriter<T> userDatumWriter = new SpecificDatumWriter<>(data.getSchema());
		ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
		BinaryEncoder binaryEncoder = EncoderFactory.get().directBinaryEncoder(outputStream, null);
		try {
			userDatumWriter.write(data, binaryEncoder);
		} catch (IOException e) {
			throw new SerializationException(e.getMessage());
		}
		return outputStream.toByteArray();
	}

	@Override
	public void close() {

	}
}
