/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */



import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author mohab
 */
public class Roles {

    public static void main(String[] args) {
        Product product = new Product("P2394", "Laptop", "Apple", "TechSupplier", 10, 1500);
        System.out.println(product.lineRepresentation());
        System.out.println("Product ID: " + product.getSearchKey());
        System.out.println("Quantity: " + product.getQuantity());
        product.setQuantity(5);
        System.out.println("New quantity: " + product.getQuantity());
        ProductDatabase productDatabase = new ProductDatabase("Products.txt");
        productDatabase.readFromFile();

        ArrayList<Product> allRecords = productDatabase.returnAllRecords();
        for (Product pro : allRecords) {
            System.out.println(product.lineRepresentation());
        }

        String searchKey = "P2394";
        if (productDatabase.contains(searchKey)) {
            Product pro = productDatabase.getRecord(searchKey);
            System.out.println("Found product: " + product.lineRepresentation());
        } else {
            System.out.println("Product not found.");
        }

        Product newProduct = new Product("P5678", "Tablet", "Samsung", "TechSupplier", 5, 800);
        productDatabase.insertRecord(newProduct);
        productDatabase.saveToFile();
        String customerSSN = "7845345678";
        String productID = "P2568";
        LocalDate purchaseDate = LocalDate.of(2022, 2, 12);

        CustomerProduct customerProduct = new CustomerProduct(customerSSN, productID, purchaseDate);
        System.out.println("Customer SSN: " + customerProduct.getCustomerSSN());
        System.out.println("Product ID: " + customerProduct.getProductID());
        System.out.println("Purchase Date: " + customerProduct.getPurchaseDate());
        System.out.println("Line Representation: " + customerProduct.lineRepresentation());
        System.out.println("Search Key: " + customerProduct.getSearchKey());
        EmployeeRole employeeRole = new EmployeeRole();

        // Add a new product
        employeeRole.addProduct("P001", "Product 1", "Manufacturer 1", "Supplier 1", 10,700);

        // Get the list of products
        Product[] products = employeeRole.getListOfProducts();
        System.out.println("List of Products:");
        for (Product pro : products) {
            System.out.println(product);
        }
        System.out.println();

        // Purchase a product
        String cSSN = "123456789";
        String proID = "P001";
        LocalDate purDate = LocalDate.now();
        boolean purchaseSuccessful = employeeRole.purchaseProduct(customerSSN, productID, purDate);
        if (purchaseSuccessful) {
            System.out.println("Product purchased successfully.");
        } else {
            System.out.println("Failed to purchase the product.");
        }
        System.out.println();

        // Get the list of purchasing operations
        CustomerProduct[] purchasingOperations = employeeRole.getListOfPurchasingOperations();
        System.out.println("List of Purchasing Operations:");
        for (CustomerProduct operation : purchasingOperations) {
            System.out.println(operation);
        }
        System.out.println();

        // Return a product
        LocalDate returnDate = LocalDate.now().plusDays(7);
        double refundAmount = employeeRole.returnProduct(customerSSN, productID, purchaseDate, returnDate);
        if (refundAmount == -1) {
            System.out.println("Product return failed.");
        } else {
            System.out.println("Product returned successfully. Refund amount: $" + refundAmount);
        }
        System.out.println();

        // Get the updated list of products and purchasing operations
        products = employeeRole.getListOfProducts();
        purchasingOperations = employeeRole.getListOfPurchasingOperations();

        System.out.println("Updated List of Products:");
        for (Product pro : products) {
            System.out.println(pro);
        }
        System.out.println();

        System.out.println("Updated List of Purchasing Operations:");
        for (CustomerProduct operation : purchasingOperations) {
            System.out.println(operation);
        }
        System.out.println();

        // Logout and save data to files
        employeeRole.logout();
    }
    }