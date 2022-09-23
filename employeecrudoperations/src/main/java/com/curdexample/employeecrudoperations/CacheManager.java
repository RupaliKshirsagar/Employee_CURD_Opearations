package com.curdexample.employeecrudoperations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;

@Component
public class CacheManager {

    @Autowired
    EmployeeRepository employeeRepository;

    public static HashMap<Integer, Employee> cache = new HashMap<>();

    @Scheduled(cron = "* * * * * *")// this is cron Expression to call this function according to specific time shown by Expess
    public void LoadCache(){
        System.out.println("Cache Loading Started");
        List<Employee> employeeList=employeeRepository.findAll();
        employeeList.forEach(employee -> cache.put(employee.getEmpId(),employee));
        System.out.println("Cache Loading Ended");
    }
}
