/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import controller.AssetManager;
import controller.BorrowManager;
import controller.EmployeeManager;
import controller.RequestManager;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import model.Asset;
import model.Borrow;
import model.Employee;
import model.Request;
import util.MyUtil;

/**
 *
 * @author Nhatthang
 */
public class Main {

    public static void main(String[] args) {
        
        AssetManager aM = new AssetManager();
        BorrowManager bM = new BorrowManager();
        EmployeeManager eM = new EmployeeManager();
        RequestManager rM = new RequestManager();

        Menu menu = new Menu("Asset Management");
        menu.add("1. Login");
        menu.add("2. Search asset by name");
        menu.add("3. Create new asset");
        menu.add("4. Updating asset's information");
        menu.add("5. Approve the request of employee");
        menu.add("6. Show list of borrow asset");
        menu.add("Others - Quit");

        int choice;
        do {
            menu.displayOption();
            choice = MyUtil.inputAnInteger("Choose your option: ");
            switch (choice) {
                case 1: {
                    if (eM.login(false) != null) {
                        System.out.println("Login successfully!");
                    } else {
                        System.err.println("Incorrect password or id");
                    }
                    break;
                }
                case 2: {
                    aM.searchByName();
                    break;
                }
                case 3: {
                    Employee emp = eM.login(true);
                    if (emp != null) {
                        System.out.println("Login successfully!");
                        aM.createAsset();
                    } else {
                        System.err.println("Incorrect password or id OR You are not Manager");
                    }
                    break;
                }
                case 4: {
                    Employee emp = eM.login(true);
                    aM.update();
                    break;
                }
                case 5: {
                    Employee emp = eM.login(true);
                    if (emp != null) {
                        System.out.println("Login successfully!");
                        rM.approveARequest(aM, bM);
                    } else {
                        System.err.println("Incorrect password or id OR You are not Manager");
                    }       
                    break; }
                case 6: {
                    MyUtil.displayArrayList(bM, Borrow.getHeader(), "List of Borrow: ", "Borrow list is null!");
                    break;
                }
                default:
                    System.out.println("Thank You!");
                    break;
            }
        } while (choice >= 1 && choice <= 6);
    }
}
