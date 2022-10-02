package com.appgate.application.kafka;

import com.appgate.application.entity.Employee;
import com.appgate.application.entity.ReqEmp;
import com.appgate.application.interfaces.EmployeeRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.serializer.JsonDeserializer;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageHeaders;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Service;

@Service
public class Consumer {
    @Autowired
    private EmployeeRepository employeeRepository;
    @KafkaListener(topics = "my_topic",groupId = "group_id")
    public void consumerMessage(String body){
        System.out.println(String.format("Message received -> %s", body.toString()));
        ObjectMapper mapper=new ObjectMapper();
        try {
            ReqEmp employee=mapper.readValue(body,ReqEmp.class);
            employeeRepository.save(employee.payload);

        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

     }


}
