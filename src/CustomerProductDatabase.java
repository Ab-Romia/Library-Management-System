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
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author mohab
 */
public class CustomerProductDatabase {
    private ArrayList<CustomerProduct> records;
    private String filename;

    public CustomerProductDatabase(String filename) {
        this.records = new ArrayList<>();
        this.filename = filename;
    }

    public void readFromFile() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                CustomerProduct record = createRecordFrom(line);
                records.add(record);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public CustomerProduct createRecordFrom(String line) {
        String[] parts = line.split(",");
        String customerSSN = parts[0].trim();
        String productID = parts[1].trim();
        LocalDate purchaseDate = LocalDate.parse(parts[2].trim());
        return new CustomerProduct(customerSSN, productID, purchaseDate);
    }

    public ArrayList<CustomerProduct> returnAllRecords() {
        return records;
    }

    public boolean contains(String key) {
        for (CustomerProduct record : records) {
            if (record.getSearchKey().equals(key)) {
                return true;
            }
        }
        return false;
    }

    public CustomerProduct getRecord(String key) {
        for (CustomerProduct record : records) {
            if (record.getSearchKey().equals(key)) {
                return record;
            }
        }
        return null;
    }

    public void insertRecord(CustomerProduct record) {
        records.add(record);
    }

    public void deleteRecord(String key) {
        for (int i = 0; i < records.size(); i++) {
            CustomerProduct record = records.get(i);
            if (record.getSearchKey().equals(key)) {
                records.remove(i);
                break;
            }
        }
    }

    public void saveToFile() {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            for (CustomerProduct record : records) {
                writer.write(record.lineRepresentation());
                writer.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
