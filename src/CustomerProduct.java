/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author mohab
 */
public class CustomerProduct {

    static DateTimeFormatter DATE_FORMATTER;
    private String customerSSN;
    private String productID;
    private LocalDate purchaseDate;

    public CustomerProduct(String customerSSN, String productID, LocalDate purchaseDate) {
        this.customerSSN = customerSSN;
        this.productID = productID;
        this.purchaseDate = purchaseDate;
    }

    public String getCustomerSSN() {
        return customerSSN;
    }

    public String getProductID() {
        return productID;
    }

    public LocalDate getPurchaseDate() {
        return purchaseDate;
    }

    public String lineRepresentation() {
        return customerSSN + "," + productID + "," + purchaseDate.toString();
    }

    public String getSearchKey() {
        return customerSSN + "," + productID + "," + LocalDate.of(purchaseDate.getYear(), purchaseDate.getMonth(), purchaseDate.getDayOfMonth());
    }
}
