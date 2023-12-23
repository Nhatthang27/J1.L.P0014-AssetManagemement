/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;
import util.MyUtil;

/**
 *
 * @author Nhatthang
 */
public class Employee implements Serializable{
    private String employID;
    private String name;
    private LocalDate birthDate;
    private String role;
    private String sex;
    private String password;
    public static final String dateFormat = "dd/MM/yyyy";
    
    public Employee() {
    }

    public Employee(String employID, String name, LocalDate birthDate, String role, String sex, String password) {
        this.employID = employID;
        this.name = name;
        this.birthDate = birthDate;
        this.role = role;
        this.sex = sex;
        this.password = password;
    }
    
    
    
    public static String getHeader() {
        return String.format("|%-8s|%-8s|%-10s|%-4s|%-4s|%-8s|", 
                                "employID", "name", "birthDate", "role", "sex", "password");
    }
    
    public String toString() {
        return String.format("|%-8s|%-8s|%-10s|%-4s|%-4s|%-8s|", 
                                employID, name, MyUtil.dateToString(birthDate, dateFormat), role, sex, password);
    }

    public String getEmployID() {
        return employID;
    }

    public void setEmployID(String employID) {
        this.employID = employID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    
}
