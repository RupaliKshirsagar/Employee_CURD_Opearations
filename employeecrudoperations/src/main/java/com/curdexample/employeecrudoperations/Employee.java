package com.curdexample.employeecrudoperations;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Data
@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int empId;

    private String empName;
    private String empAddress;
    private long empSalary;


    public Employee(){

    }
    public Employee(int i, String akshay, String kolhapur, long i1) {
    }
}
