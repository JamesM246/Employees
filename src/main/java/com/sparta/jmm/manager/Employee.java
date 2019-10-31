package com.sparta.jmm.manager;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employee {
    private int id;
    private String prefix;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private char gender;
    private String email;
    private LocalDate dateBirth;
    private LocalDate dateJoin;
    private int salary;

    public Employee(String[] employeeArray){
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");

        id = Integer.parseInt(employeeArray[0]);
        prefix = employeeArray[1];
        firstName = employeeArray[2];
        middleInitial = employeeArray[3].charAt(0);
        lastName = (employeeArray[4]);
        gender = (employeeArray[5].charAt(0));
        email = (employeeArray[6]);
        dateBirth = (LocalDate.parse(employeeArray[7], dateFormat));
        dateJoin = (LocalDate.parse(employeeArray[8], dateFormat));
        salary = (Integer.parseInt(employeeArray[9]));
    }

    public Employee(int id, String prefix, String firstName, char middleInitial, String lastName, char gender, String email, String dateBirth, String dateJoin, int salary) {
        DateTimeFormatter dateFormat = DateTimeFormatter.ofPattern("M/d/yyyy");

        this.id = id;
        this.prefix = prefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateBirth = (LocalDate.parse(dateBirth,dateFormat));
        this.dateJoin = (LocalDate.parse(dateJoin,dateFormat));
        this.salary = salary;
    }

    public Employee(int id, String prefix, String firstName, char middleInitial, String lastName, char gender, String email, LocalDate dateBirth, LocalDate dateJoin, int salary) {
        this.id = id;
        this.prefix = prefix;
        this.firstName = firstName;
        this.middleInitial = middleInitial;
        this.lastName = lastName;
        this.gender = gender;
        this.email = email;
        this.dateBirth = dateBirth;
        this.dateJoin = dateJoin;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", prefix='" + prefix + '\'' +
                ", firstName='" + firstName + '\'' +
                ", middleInitial=" + middleInitial +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", email='" + email + '\'' +
                ", dateBirth=" + dateBirth +
                ", dateJoin=" + dateJoin +
                ", salary=" + salary +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrefix() {
        return prefix;
    }

    public void setPrefix(String prefix) {
        this.prefix = prefix;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public char getMiddleInitial() {
        return middleInitial;
    }

    public void setMiddleInitial(char middleInitial) {
        this.middleInitial = middleInitial;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(LocalDate dateBirth) {
        this.dateBirth = dateBirth;
    }

    public LocalDate getDateJoin() {
        return dateJoin;
    }

    public void setDateJoin(LocalDate dateJoin) {
        this.dateJoin = dateJoin;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }
}
