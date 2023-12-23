/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.ArrayList;

/**
 *
 * @author Nhatthang
 */
public class Menu extends ArrayList<String>{
    private String title;
    
    public Menu(String title) {
        this.title = title;
    }
    
    public void displayOption() {
        System.out.println("========= " + title + " ==========");
        for (String op : this) {
            System.out.println(op);
        }
    }
}
