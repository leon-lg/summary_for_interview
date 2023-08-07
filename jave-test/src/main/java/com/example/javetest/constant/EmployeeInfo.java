package com.example.javetest.constant;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class EmployeeInfo {
    private String name;
    private int salary;
    private String gender;
    private int age;
    private String region;
}
