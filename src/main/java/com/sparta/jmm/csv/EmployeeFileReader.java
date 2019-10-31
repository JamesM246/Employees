package com.sparta.jmm.csv;

import com.sparta.jmm.manager.Employee;
import com.sparta.jmm.manager.EmployeeManager;

import java.io.*;
import java.text.ParseException;
import java.util.HashMap;

public class EmployeeFileReader {
    private static BufferedReader bufferedReader;

    public static HashMap<Integer, Employee> readFileToMap(String filePath) throws IOException{
        HashMap<Integer,Employee> employeeMap = new HashMap<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String line;
        String[] lineArray;
        bufferedReader.readLine();
        while((line = bufferedReader.readLine()) != null){
            lineArray = line.split(",");
            if(employeeMap.containsKey(lineArray[0])){

            }
            employeeMap.put(Integer.parseInt(lineArray[0]),new Employee(lineArray));
        }
        bufferedReader.close();
        return employeeMap;
    }

    public static HashMap<Integer, Employee> readFileUsingLambda(String filePath) throws IOException{
        HashMap<Integer,Employee> employeeMap = new HashMap<>();
        try {
            bufferedReader = new BufferedReader(new FileReader(filePath));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        bufferedReader.readLine();

        bufferedReader.lines()
                .map(line -> line.split(","))   // maps each "line" to a "lineArray"
                .forEach(lineArray -> employeeMap.put(Integer.parseInt(lineArray[0]),new Employee(lineArray)));

        bufferedReader.close();
        return employeeMap;
    }
}
