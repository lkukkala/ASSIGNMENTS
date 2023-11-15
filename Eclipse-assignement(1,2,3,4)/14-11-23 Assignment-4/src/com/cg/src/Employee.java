package com.cg.src;

import java.util.Arrays;
import java.util.Comparator;
 
class Employee {
    String name;
    int salary;
 
    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
 
    public String getName() {
        return name;
    }
 
    public int getSalary() {
        return salary;
    }
 
    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                '}';
    }
 
    public static void main(String[] args) {
        Employee[] employees = {
                new Employee("John", 50000),
                new Employee("Alice", 60000),
                new Employee("Bob", 40000),
                new Employee("Charlie", 30000)
        };
 
        Arrays.sort(employees, Comparator.comparingInt(Employee::getSalary));
 
        System.out.println(Arrays.toString(employees));
    }
}