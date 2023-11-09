/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;


public class CustomerProductDatabase extends Database<CustomerProduct>  {


    public CustomerProductDatabase(String fileName) {
        this.t = new ArrayList<CustomerProduct>();
        this.fileName = fileName;
    }


    public CustomerProduct createRecordFrom(String line) {
        String[] parts = line.split(",");
        String customerSSN = parts[0].trim();
        String productID = parts[1].trim();
        LocalDate purchaseDate = LocalDate.parse(parts[2].trim());
        return new CustomerProduct(customerSSN, productID, purchaseDate);
    }



}
