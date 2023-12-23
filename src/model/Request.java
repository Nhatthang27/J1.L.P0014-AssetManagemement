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
public class Request implements Serializable{
    private String rID;
    private String assetID;
    private String employeeID;
    private int quantity;
    private LocalDateTime requestDateTime;
    public static final String dateTimeFormat = "dd-MM-yyyy HH:mm:ss";
    
    public Request() {
    }

    public Request(String rID, String assetID, String employeeID, int quantity, LocalDateTime requestDateTime) {
        this.rID = rID;
        this.assetID = assetID;
        this.employeeID = employeeID;
        this.quantity = quantity;
        this.requestDateTime = requestDateTime;
    }
    
    public static String getHeader() {
        return String.format("|%-4s|%-8s|%-10s|%-8s|%-19s|", 
                                "rID", "assetID", "employeeID", "quantity", "requestDateTime");
    }
    
    @Override
    public String toString() {
        return String.format("|%-4s|%-8s|%-10s|%-8d|%-19s|", 
                                rID, assetID, employeeID, quantity, MyUtil.dateTimeToString(requestDateTime, dateTimeFormat));
    }

    public String getrID() {
        return rID;
    }

    public void setrID(String rID) {
        this.rID = rID;
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

    public LocalDateTime getRequestDateTime() {
        return requestDateTime;
    }

    public void setRequestDateTime(LocalDateTime requestDateTime) {
        this.requestDateTime = requestDateTime;
    }
    
    
}
