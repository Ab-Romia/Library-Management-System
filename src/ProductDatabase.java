/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.roles;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author mohab
 */
public class ProductDatabase {
    private ArrayList<Product> records;
    private String filename;

    public ProductDatabase(String filename) {
        this.records = new ArrayList<>();
        this.filename = filename;
    }

    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Product product = createRecordFrom(line);
                records.add(product);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Product createRecordFrom(String line) {
        String[] data = line.split(",");
        String productID = data[0];
        String productName = data[1];
        String manufacturerName = data[2];
        String supplierName = data[3];
        int quantity = Integer.parseInt(data[4]);
        float price = Float.parseFloat(data[5]);
        return new Product(productID, productName, manufacturerName, supplierName, quantity);
    }

    public ArrayList<Product> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (Product product : records) {
            if (product.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Product getRecord(String key) {
        for (Product product : records) {
            if (product.getSearchKey().equals(key)) {
                return product;
            }
        }
        return null;
    }

    public void insertRecord(Product record) {
        records.add(record);
    }

    public void deleteRecord(String key) {
        Iterator<Product> iterator = records.iterator();
        while (iterator.hasNext()) {
            Product product = iterator.next();
            if (product.getSearchKey().equals(key)) {
                iterator.remove();
                break;
            }
        }
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (Product product : records) {
                writer.write(product.lineRepresentation());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}