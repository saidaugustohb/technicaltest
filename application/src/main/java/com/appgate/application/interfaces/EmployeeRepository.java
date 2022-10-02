package com.appgate.application.interfaces;

import com.appgate.application.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Collection;
import java.util.List;
import java.util.Set;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Query(value ="select * from employee where meses>?1 and  salario>?2", nativeQuery = true)
    public List<Employee> findAllBySalaryAndMonth(Integer month, Integer salary);

}
