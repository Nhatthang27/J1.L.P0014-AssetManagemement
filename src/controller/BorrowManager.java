/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import model.Asset;
import model.Borrow;
import util.MyUtil;

/**
 *
 * @author Nhatthang
 */
public class BorrowManager extends ArrayList<Borrow> {

    public static final String pathFile = "./src/data/borrow.dat";
    public BorrowManager() {
        try {
            ArrayList<Borrow> tmp = MyUtil.readFromFile(pathFile);
            if (tmp == null || tmp.isEmpty()) {
                throw new Exception();
            }
            for (Borrow borrow : tmp) {
                this.add(borrow);
            }
        } catch (Exception e) {
            init(pathFile);
        }

    }

    public void init(String pathFile) {
        Borrow b1 = new Borrow("B001", "A001", "E160001", 1, MyUtil.parseToDateTime("23-12-2021 15:13:46", Borrow.dateTimeFormat));
        Borrow b2 = new Borrow("B002", "A001", "E160001", 2, MyUtil.parseToDateTime("25-12-2021 16:14:56", Borrow.dateTimeFormat));
        Borrow b3 = new Borrow("B003", "A002", "E160798", 3, MyUtil.parseToDateTime("15-12-2021 17:15:52", Borrow.dateTimeFormat));
        Borrow b4 = new Borrow("B007", "A001", "E160240", 2, MyUtil.parseToDateTime("26-12-2021 12:16:53", Borrow.dateTimeFormat));

        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);

        try {
            MyUtil.writeToFile(pathFile, this);
        } catch (IOException ioE) {
            System.err.println("I/O Exception when writing file");
        }
    }
}
