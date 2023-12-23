/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;
import util.MyUtil;

/**
 *
 * @author Nhatthang
 */
public class Borrow implements Serializable{
    private String bID;
    private String assetID;
    private String employeeID;
    private int quantity;
    private LocalDateTime borrowDateTime;
    public static final String dateTimeFormat = "dd-MM-yyyy HH:mm:ss";
    
    public Borrow() {
    }

    public Borrow(String bID, String assetID, String employeeID, int quantity, LocalDateTime borrowDateTime) {
        this.bID = bID;
        this.assetID = assetID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.borrowDateTime = borrowDateTime;
    }
    
    public static String getHeader() {
        return String.format("|%-4s|%-8s|%-10s|%-8s|%-19s|", 
                                "bID", "assetID", "employeeID", "quantity", "borrowDateTime");
    }
    
    @Override
    public String toString() {
        return String.format("|%-4s|%-8s|%-10s|%-8d|%-19s|", 
                                bID, assetID, employeeID, quantity, MyUtil.dateTimeToString(borrowDateTime, dateTimeFormat));
    }

    public String getbID() {
        return bID;
    }

    public void setbID(String bID) {
        this.bID = bID;
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public LocalDateTime getBorrowDateTime() {
        return borrowDateTime;
    }

    public void setBorrowDateTime(LocalDateTime borrowDateTime) {
        this.borrowDateTime = borrowDateTime;
    }
    
}
