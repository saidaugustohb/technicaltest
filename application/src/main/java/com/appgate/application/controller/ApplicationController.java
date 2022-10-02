package com.appgate.application.controller;

import com.appgate.application.interfaces.EmployeeRepository;
import com.appgate.application.kafka.Producer;
import com.appgate.application.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {
    private final Producer producer;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    public ApplicationController(Producer producer){
        this.producer=producer;
    }

    @PostMapping("/add")
    public ResponseEntity<String> messageInformationToTopic(@RequestBody Employee body){

        this.producer.sendMessage(body);
        return ResponseEntity.ok("Message sent to kafka topic");
    }
    @GetMapping("/views")
    public List<Employee> views(@RequestParam("month") Integer month,@RequestParam("salary") Integer salary){
        return employeeRepository.findAllBySalaryAndMonth(month,salary);
    }
}
