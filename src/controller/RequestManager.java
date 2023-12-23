/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.ArrayList;
import model.Asset;
import model.Borrow;
import model.Request;
import util.MyUtil;

/**
 *
 * @author Nhatthang
 */
public class RequestManager extends ArrayList<Request> {

    public static final String pathFile = "./src/data/request.dat";
    public RequestManager() {
        try {
            ArrayList<Request> tmp = MyUtil.readFromFile(pathFile);
            if (tmp == null || tmp.isEmpty()) {
                throw new Exception();
            }
            for (Request request : tmp) {
                this.add(request);
            }
        } catch (Exception e) {
            init(pathFile);
        }
    }

    public void init(String pathFile) {
        Request r1 = new Request("R001", "A001", "E140449", 1, MyUtil.parseToDateTime("23-12-2021 13:17:56", Request.dateTimeFormat));
        Request r2 = new Request("R002", "A002", "E160001", 1, MyUtil.parseToDateTime("24-12-2021 12:18:56", Request.dateTimeFormat));
        Request r3 = new Request("R003", "A001", "E160798", 1, MyUtil.parseToDateTime("23-12-2021 11:19:56", Request.dateTimeFormat));
        Request r4 = new Request("R007", "A002", "E160240", 1, MyUtil.parseToDateTime("24-12-2021 10:10:56", Request.dateTimeFormat));

        this.add(r1);
        this.add(r2);
        this.add(r3);
        this.add(r4);

        try {
            MyUtil.writeToFile(pathFile, this);
        } catch (IOException ioE) {
            System.err.println("I/O Exception when writing file");
        }
    }
    
    public Request searchByID(String id) {
        Request req = null;
        for (Request r : this) {
            if (r.getrID().equals(id)) {
                req = r;
                break;
            }
        }
        return req;
    }
    
    public int approveARequest(String rID, AssetManager aM, BorrowManager bM) {
        Request req = searchByID(rID);
        if (req == null) {
            return -1;
        } 
        
        Asset ass = aM.searchById(req.getAssetID());
        if (ass.getQuantity() < req.getQuantity()) {
            return 0;
        } else {
            Borrow bor = new Borrow("B" + req.getrID().substring(1), req.getAssetID(), req.getEmployeeID(), req.getQuantity(), req.getRequestDateTime());
            bM.add(bor);
            this.remove(req);
            ass.setQuantity(ass.getQuantity() - req.getQuantity());
            
            try {
                MyUtil.writeToFile(pathFile, this);
                MyUtil.writeToFile(aM.pathFile, aM);
                MyUtil.writeToFile(bM.pathFile, bM);
            } catch (IOException e) {
                System.err.println("IOException when approving request!");
            }
            return 1;
        }
    }
    
    public void approveARequest(AssetManager aM, BorrowManager bM) {
        MyUtil.displayArrayList(this, Request.getHeader(), "List of Request: ", "Request list is null!");
        String rID = MyUtil.inputAString("Request ID: ", "Request ID is required!");
        int check = approveARequest(rID, aM, bM);
        if (check == -1) {
            System.out.println("Request ID doesn't exist!");
        } else if (check == 0) {
            System.out.println("Quantity in stock is not enough!");
        } else  {
            System.out.println("Approve successfully!");
        }
    }
}
