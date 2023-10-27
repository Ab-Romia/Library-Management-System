/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


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
public class ProductDatabase extends Database<Product> {


    public ProductDatabase(String fileName) {
        this.t = new ArrayList<>();
        this.fileName = fileName;
    }


    public Product createRecordFrom(String line) {
        String[] data = line.split(",");
        String productID = data[0];
        String productName = data[1];
        String manufacturerName = data[2];
        String supplierName = data[3];
        int quantity = Integer.parseInt(data[4]);
        float price = Float.parseFloat(data[5]);
        return new Product(productID, productName, manufacturerName, supplierName, quantity,price);
    }
    public boolean contains(String key) {
        for (Product product : t) {
            if (product.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public Product getRecord(String key) {
        for (Product product : t) {
            if (product.getSearchKey().equals(key)) {
                return product;
            }
        }
        return null;
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(fileName))) {
            for (Product product : t) {
                writer.write(product.lineRepresentation());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}