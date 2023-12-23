/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import model.Asset;
import util.MyUtil;

/**
 *
 * @author Nhatthang
 */
public class AssetManager extends ArrayList<Asset> {

    public static final String pathFile = "./src/data/asset.dat";

    public AssetManager() {
        try {
            ArrayList<Asset> tmp = MyUtil.readFromFile(pathFile);
            if (tmp == null || tmp.isEmpty()) {
                throw new Exception();
            }
            for (Asset asset : tmp) {
                this.add(asset);
            }
        } catch (Exception e) {
            init(pathFile);
        }

    }

    public void init(String pathFile) {
        Asset a1 = new Asset("A001", "Samsung projector", "White", 500, 3.2, 10);
        Asset a2 = new Asset("A002", "Macbook pro 2016", "Silver", 1000, 2.2, 5);

        this.add(a1);
        this.add(a2);

        try {
            MyUtil.writeToFile(pathFile, this);
        } catch (IOException ioE) {
            System.err.println("I/O Exception when writing file");
        }
    }

    public ArrayList<Asset> sortID(ArrayList<Asset> arr, boolean isASC) {
        if (arr == null) {
            return null;
        }
        Comparator<Asset> cmp = new Comparator<Asset>() {
            @Override
            public int compare(Asset o1, Asset o2) {
                if (isASC) {
                    return o1.getAssetID().compareTo(o2.getAssetID());
                } else {
                    return o2.getAssetID().compareTo(o1.getAssetID());
                }
            }
        };
        ArrayList<Asset> tmp = new ArrayList<>(arr);
        Collections.sort(tmp, cmp);
        return tmp;
    }

    public ArrayList<Asset> searchByName(String name) {
        ArrayList<Asset> searchList = null;
        for (Asset ass : this) {
            if (ass.getName().contains(name)) {
                if (searchList == null) {
                    searchList = new ArrayList<>();
                }
                searchList.add(ass);
            }
        }
        return searchList;
    }

    public void searchByName() {
        String name = MyUtil.inputAString("Name of asset to search: ", "Name is required!");
        ArrayList<Asset> searchList = searchByName(name);
        if (searchList == null) {
            System.out.println("Nothing found!");
        } else {
            MyUtil.displayArrayList(sortID(searchList, false), Asset.getHeader(), "List asset found (DESC): ", "");
        }
    }

    public Asset searchById(String id) {
        Asset ass = null;
        for (Asset a : this) {
            if (a.getAssetID().equals(id)) {
                ass = a;
                break;
            }
        }
        return ass;
    }

    public void createAsset() {
        do {
            Asset newAss = new Asset();
            newAss.fillSelf();
            this.add(newAss);
            System.out.println("Created successfully and added to list asset!");
            try {
                MyUtil.writeToFile(pathFile, this);
            } catch (IOException ioE) {
                System.err.println("I/O Exception when writing file");
            }
        } while (MyUtil.selectYesNo("Do you want to create one more asset (Y/N): ", "(Y/N) only!", "Y", "N"));
    }

    public Asset update(String id) {
        Asset ass = searchById(id);
        if (ass == null) {
            return null;
        } else {
            System.out.println("Input new info to update: ");
            String newName = MyUtil.inputAString("New name: ");
            String newColor = MyUtil.inputAString("New color: ");

            if (!newName.isEmpty()) {
                ass.setName(newName);
            }
            if (!newColor.isEmpty()) {
                ass.setName(newColor);
            }

            do {
                try {
                    String newPrice = MyUtil.inputAString("New price: ");
                    if (newPrice.isEmpty()) {
                        break;
                    } else {
                        int p = Integer.parseInt(newPrice);
                        if (p < 0) {
                            throw new NumberFormatException();
                        } else {
                            ass.setPrice(p);
                            break;
                        }
                    }
                } catch (NumberFormatException nfE) {
                    System.err.println("Weight must be a positive number!");
                }
            } while (true);

            do {
                try {
                    String newWeight = MyUtil.inputAString("New weight: ");
                    if (newWeight.isEmpty()) {
                        break;
                    } else {
                        double w = Double.parseDouble(newWeight);
                        if (w < 0) {
                            throw new NumberFormatException();
                        } else {
                            ass.setWeight(w);
                            break;
                        }
                    }
                } catch (NumberFormatException nfE) {
                    System.err.println("Weight must be a positive number!");
                }
            } while (true);

            do {
                try {
                    String newQuantity = MyUtil.inputAString("New quantity: ");
                    if (newQuantity.isEmpty()) {
                        break;
                    } else {
                        int q = Integer.parseInt(newQuantity);
                        if (q < 0) {
                            throw new NumberFormatException();
                        } else {
                            ass.setQuantity(q);
                            break;
                        }
                    }
                } catch (NumberFormatException nfE) {
                    System.err.println("Quantity must be a positive number!");
                }
            } while (true);
            return ass;
        }
    }

    public void update() {
        String id = MyUtil.inputAString("Id of asset to update: ", "Id is required!");
        Asset ass = update(id);
        System.out.println("Asset after updating: ");
        System.out.println(Asset.getHeader());
        System.out.println(ass);
    }
}