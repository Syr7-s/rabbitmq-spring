package com.syrisa.tr.rabbitmq.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Employee {

    private String empName;
    private String empId;

    @Override
    public String toString() {
        return "Employee{" +
                "empName='" + empName + '\'' +
                ", empId='" + empId + '\'' +
                '}';
    }
}