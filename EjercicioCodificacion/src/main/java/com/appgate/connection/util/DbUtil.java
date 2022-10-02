package com.appgate.connection.util;

import com.appgate.connection.models.Employee;
import com.appgate.connection.models.EmployeeMapper;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;
import java.util.Map;

public class DbUtil {
    private static final String url="jdbc:postgresql://localhost:5432/Empresa";
    private static final String username="postgres";
    private static final String password="toor4321";
    private static final String driver="org.postgresql.Driver";
    private static final String catalog="enterprise";
    private JdbcTemplate jdbcTemplate;

    public DbUtil(){
        DriverManagerDataSource driverManagerDataSource= new DriverManagerDataSource();
        driverManagerDataSource.setUrl(url);
        driverManagerDataSource.setUsername(username);
        driverManagerDataSource.setPassword(password);
        driverManagerDataSource.setDriverClassName(driver);
        driverManagerDataSource.setCatalog(catalog);
        jdbcTemplate= new JdbcTemplate(driverManagerDataSource);
    }

    public Map<String, Object> readRow(String query){
        return jdbcTemplate.queryForMap(query);
    }

    public List<Map<String, Object>> readRows(String query){
        return jdbcTemplate.queryForList(query);
    }

    public Employee getTblEmployeeCustom(String query){
        return  jdbcTemplate.queryForObject(query,new EmployeeMapper());
    }
    public Employee getTblEmployee(String query){
        return  jdbcTemplate.queryForObject(query,new BeanPropertyRowMapper<>(Employee.class));
    }

    public static void main(String[] args) {
        DbUtil dbUtil= new DbUtil();
        System.out.println(dbUtil.getTblEmployeeCustom("select * from enterprise.employee LIMIT 1").getIdEmpleado());
        System.out.println(dbUtil.getTblEmployee("select  * from enterprise.employee LIMIT 1").getNombre());
    }


}
