package com.sparta.jmm.manager;

import com.sparta.jmm.csv.EmployeeFileReader;
import com.sparta.jmm.jbdc.DAO;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;

public class EmployeeManager {

    public static HashMap<Integer,Employee> employeeMap = new HashMap<>();

    public static void addEmployeeFromStringArray(String[] lineArray){
        employeeMap.put(Integer.parseInt(lineArray[0]),new Employee(lineArray));
        addFromMapToDB();
    }

    public static void addFromFileToDB(String filePath){
        try {
            employeeMap = new HashMap<>(EmployeeFileReader.readFileToMap(filePath));
//            employeeMap = new HashMap<>(EmployeeFileReader.readFileUsingLambda(filePath));
            System.out.println(employeeMap.size());
            addFromMapToDB();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void addFromMapToDB(){
        try {
            DAO.openConnection();
            long start = System.nanoTime();
            for(int key : getKeys()){
                DAO.runQuery(employeeMap.get(key));
            }
            long end = System.nanoTime();
            System.out.println("Time to add to DB: " + (end - start) + " nanoseconds");
            DAO.closeConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void addEmployeeFromMapToDB(Employee employee){
        DAO.runQuery(employee);
    }

    public static HashMap<Integer,Employee> getEmployeeMap(){
        return employeeMap;
    }

    public static Set<Integer> getKeys(){return employeeMap.keySet();}

    public static Collection<Employee> getValues(){return employeeMap.values();}
}
