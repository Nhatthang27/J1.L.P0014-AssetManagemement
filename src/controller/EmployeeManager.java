/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import model.Asset;
import model.Employee;
import util.MyUtil;

/**
 *
 * @author Nhatthang
 */
public class EmployeeManager extends ArrayList<Employee> {

    public static final String pathFile = "./src/data/employee.dat";
    public EmployeeManager() {
        try {
            ArrayList<Employee> tmp = MyUtil.readFromFile(pathFile);
            if (tmp == null || tmp.isEmpty()) {
                throw new Exception();
            }
            for (Employee employee : tmp) {
                this.add(employee);
            }

        } catch (Exception e) {
            init(pathFile);
        }
    }

    public void init(String pathFile) {
        Employee e1 = new Employee("E160001", "Hiep", MyUtil.parseToDate("12/06/2000", Employee.dateFormat), "EM", "male", "abc123");
        Employee e2 = new Employee("E160240", "Khanh", MyUtil.parseToDate("15/07/2002", Employee.dateFormat), "EM", "male", "abc123");
        Employee e3 = new Employee("E140449", "Nhan", MyUtil.parseToDate("10/07/2002", Employee.dateFormat), "EM", "male", "abc123");
        Employee e4 = new Employee("E160798", "Minh", MyUtil.parseToDate("03/12/2002", Employee.dateFormat), "EM", "male", "abc123");
        Employee e5 = new Employee("E160052", "Doan", MyUtil.parseToDate("05/06/1990", Employee.dateFormat), "MA", "male", "abc123");

        this.add(e1);;
        this.add(e2);
        this.add(e3);
        this.add(e4);
        this.add(e5);

        try {
            MyUtil.writeToFile(pathFile, this);
        } catch (IOException ioE) {
            System.err.println("I/O Exception when writing file");
        }
    }

    public Employee login(String employID, String password, boolean isMa) {
        for (Employee emp : this) {
            if (isMa && !emp.getRole().equals("MA")) {
                continue;
            }
            if (emp.getEmployID().equals(employID) && emp.getPassword().equals(password)) {
                return emp;
            }
        }
        return null;
    }

    public Employee login(boolean isMa) {
        String employID = MyUtil.inputAString("EmployeeID: ", "EmployeeID is required!");
        String password = MyUtil.inputAString("Password: ", "Password is required!");
        return login(employID, password, isMa);
    }
}
