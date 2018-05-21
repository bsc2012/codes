package com.bsc.kafka.clients.serializer.avro;

import java.util.EnumSet;
import org.apache.avro.specific.SpecificRecordBase;
import com.bsc.kafka.clients.serializer.avro.record.User;

public enum Topic {
    USER("test", new User());
 
    public final String topicName;
    public final SpecificRecordBase topicType;
 
    Topic(String topicName, SpecificRecordBase topicType) {
        this.topicName = topicName;
        this.topicType = topicType;
    }
 
    public static Topic matchFor(String topicName) {
    	EnumSet<Topic> tpoicSet = EnumSet.allOf(Topic.class);
    	for(Topic topic: tpoicSet){
    		if(topic.topicName.equals(topicName)){
    			return topic;
    		}
    	}
    	return null;
    }
}
