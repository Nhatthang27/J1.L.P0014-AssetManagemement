/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import util.MyUtil;

/**
 *
 * @author Nhatthang
 */
public class Asset implements Serializable{
    private String assetID;
    private String name;
    private String color;
    private int price;
    private double weight;
    private int quantity;

    public Asset() {
    }

    public Asset(String assetID, String name, String color, int price, double weight, int quantity) {
        this.assetID = assetID;
        this.name = name;
        this.color = color;
        this.price = price;
        this.weight = weight;
        this.quantity = quantity;
    }
    
    public static String getHeader() {
        return String.format("|%-8s|%-20s|%-6s|%-5s|%-6s|%-8s|", 
                                "assetID", "name", "color", "price", "weight", "quantity");
    }
    
    public void fillSelf() {
        this.assetID = MyUtil.inputAString("AssetID: ");
        this.name = MyUtil.inputAString("Name: ");
        this.color = MyUtil.inputAString("Color: ");
        this.weight = MyUtil.inputADouble("Weight: ", "Weigh must be a positive number!", 0);
        this.quantity = MyUtil.inputAInteger("Quantity: ", "Quantity must be a positive number: ", 0);
    }
    
    @Override
    public String toString() {
        return String.format("|%-8s|%-20s|%-6s|%-5d|%-6.1f|%-8d|", 
                                assetID, name, color, price, weight, quantity);
    }

    public String getAssetID() {
        return assetID;
    }

    public void setAssetID(String assetID) {
        this.assetID = assetID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    
}
