package com.appgate.application.kafka;

import com.appgate.application.entity.Employee;
import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class Producer {
    private static final String TOPIC="my_topic";
    @Autowired
    private KafkaTemplate<String,Message<Employee>> kafkaTemplate;


    public void sendMessage(Employee body){
        Message<Employee> message = MessageBuilder
                .withPayload(body)
                .setHeader(KafkaHeaders.TOPIC, TOPIC)
                .build();
        this.kafkaTemplate.send(TOPIC,message);
    }

    @Bean
    public NewTopic createTopic(){
        return new NewTopic(TOPIC,3,(short) 1);
    }
}
