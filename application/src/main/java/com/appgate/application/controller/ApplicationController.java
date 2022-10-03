package com.appgate.application.controller;

import com.appgate.application.dynamo.service.EmployeeService;
import com.appgate.application.entity.EmployeeDyDB;
import com.appgate.application.interfaces.EmployeeRepository;
import com.appgate.application.kafka.Producer;
import com.appgate.application.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApplicationController {
    private final Producer producer;
    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    EmployeeService employeeService;

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

    @GetMapping(value = "/getemployee")
    public ResponseEntity<List<EmployeeDyDB>> getProducts()
    {
        try
        {
            return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping(value = "saveemployee", consumes = "application/json")
    public ResponseEntity saveProduct(@RequestBody EmployeeDyDB employeeDyDB)
    {
        try
        {
            employeeService.saveProduct(employeeDyDB);
            return new ResponseEntity<>(HttpStatus.OK);
        }
        catch (Exception e)
        {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
