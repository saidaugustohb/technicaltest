package com.appgate.application.dynamo.service;

import com.amazonaws.services.dynamodbv2.document.*;
import com.amazonaws.services.dynamodbv2.document.spec.ScanSpec;
import com.appgate.application.interfaces.DynamoDbRepo;
import com.appgate.application.entity.EmployeeDyDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
@Service
public class EmployeeService {
    @Autowired
    DynamoDbRepo dynamoDBRepo;

    public void createTable(String tableName) throws Exception
    {
        if (dynamoDBRepo.getTable(tableName) != null)
        {
            dynamoDBRepo.createEmployeeTable();
        }
    }



    public void saveProduct(EmployeeDyDB employeeDyDB) throws Exception
    {
       // createTable("employee");
        Table table = dynamoDBRepo.getTable("employee");
        try
        {
            String id = UUID.randomUUID().toString();
            System.out.println("Id:" + id);
            PutItemOutcome outcome = table.putItem(new Item().withPrimaryKey("id", id)
                    .with("idEmpleado", employeeDyDB.getIdEmpleado())
                    .with("nombre", employeeDyDB.getNombre())
                    .with("meses", employeeDyDB.getMeses())
                    .with("salario", employeeDyDB.getSalario()));
            System.out.println("PutItem succeeded:\n" + outcome.getPutItemResult());
        }
        catch (Exception e)
        {
            System.out.println(e);
        }
    }



    public List<EmployeeDyDB> getAllEmployee() throws Exception
    {
        ScanSpec scanSpec = new ScanSpec();
        List<EmployeeDyDB> employeeDyDBList = new ArrayList<>();
        try
        {
            Table table = dynamoDBRepo.getTable("employee");
            ItemCollection<ScanOutcome> items = table.scan(scanSpec);
            Iterator<Item> iter = items.iterator();
            while (iter.hasNext())
            {
                Item item = iter.next();
                if (item != null)
                {
                    EmployeeDyDB   employeeDyDB = new EmployeeDyDB();
                    employeeDyDB.setId(item.getString("id"));
                    employeeDyDB.setIdEmpleado(item.getString("idEmpleado"));
                    employeeDyDB.setNombre(item.getString("nombre"));
                    employeeDyDB.setMeses(item.getInt("meses"));
                    employeeDyDB.setSalario(item.getInt("salario"));
                    employeeDyDBList.add(employeeDyDB);
                }
                System.out.println(item.toString());
            }

        }
        catch (Exception e)
        {
            System.err.println("Unable to scan the table:");
            System.err.println(e.getMessage());
            throw new Exception("Error has been occured while getting list of product");
        }
        return employeeDyDBList;
    }




}
