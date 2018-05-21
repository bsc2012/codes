package com.bsc.kafka.clients.serializer.avro;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Map;

import org.apache.avro.io.BinaryDecoder;
import org.apache.avro.io.DatumReader;
import org.apache.avro.io.DecoderFactory;
import org.apache.avro.specific.SpecificDatumReader;
import org.apache.avro.specific.SpecificRecordBase;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;

public class AvroDeserializer<T extends SpecificRecordBase> implements Deserializer<T> {
	 
    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
    }
 
    @Override
    public T deserialize(String topic, byte[] data) {
        DatumReader<T> userDatumReader = new SpecificDatumReader<>(Topic.matchFor(topic).topicType.getSchema());
        BinaryDecoder binaryEncoder = DecoderFactory.get().directBinaryDecoder(new ByteArrayInputStream(data), null);
        try {
            return userDatumReader.read(null, binaryEncoder);
        } catch (IOException e) {
            throw new SerializationException(e.getMessage());
        }
    }
 
    @Override
    public void close() {
 
    }
}
