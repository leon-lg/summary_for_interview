package com.leonlg.stream;

import com.leonlg.constant.EmployeeInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamExam {
    public static void main(String[] args) {
        ArrayList<EmployeeInfo> list = new ArrayList<>();

        list.add(new EmployeeInfo(10000, "10000", "12"));
        list.add(new EmployeeInfo(1000, "1000", "12"));
        list.add(new EmployeeInfo(9000, "9000", "12"));
        list.add(new EmployeeInfo(11000, "11000", "12"));

        List<EmployeeInfo> collect = list.stream().filter(employee -> employee.getSalary() > 8000).collect(Collectors.toList());
        System.out.println(collect);
    }
}
