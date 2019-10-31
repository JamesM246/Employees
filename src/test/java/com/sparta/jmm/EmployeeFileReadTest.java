package com.sparta.jmm;

import com.sparta.jmm.manager.Employee;
import com.sparta.jmm.manager.EmployeeManager;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

import java.io.IOException;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class EmployeeFileReadTest {
    private EmployeeManager employeeManager;
    private DateTimeFormatter dateFormat;

    @Before
    public void testSetup(){
        employeeManager.addFromFileToDB("resources/EmployeeRecordsTestData.csv");
        dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");
    }

    @Test
    public void fileToArrayTest(){
        Employee employee;
        employee = new Employee(198429,"Mrs.","Serafina",'I',"Bumgarner",'F',"serafina.bumgarner@exxonmobil.com", LocalDate.parse("9/21/1982",dateFormat),LocalDate.parse("2/1/2008",dateFormat),69294);
        assertEquals(employee.toString(),employeeManager.getEmployeeMap().get(198429).toString());
    }
}
