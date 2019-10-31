package com.sparta.jmm.manager;

public class Main {
    public static void main(String[] args){
        EmployeeManager employeeManager = new EmployeeManager();
//        employeeManager.addFromFileToDB("resources/EmployeeRecordsTestData.csv");
        employeeManager.addFromFileToDB("resources/EmployeeRecords.csv");
    }
}
