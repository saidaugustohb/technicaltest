package com.appgate.connection.models;

import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class EmployeeMapper implements RowMapper<Employee> {
    @Override
    public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
        return new Employee(rs.getInt("IdEmpleado"),rs.getString("Nombre"),rs.getInt("Meses"),rs.getInt("Salario"));
    }
}
