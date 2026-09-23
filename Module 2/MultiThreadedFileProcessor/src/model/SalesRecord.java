package model;

/**
 * SalesRecord - Represents one row from a CSV file.
 * Fields: product name, category, quantity sold, price per unit.
 */
public class SalesRecord {

    private String product;
    private String category;
    private int quantity;
    private double price;

    // Constructor
    public SalesRecord(String product, String category, int quantity, double price) {
        this.product = product;
        this.category = category;
        this.quantity = quantity;
        this.price = price;
    }

    // Getters
    public String getProduct()  { return product; }
    public String getCategory() { return category; }
    public int    getQuantity() { return quantity; }
    public double getPrice()    { return price; }

    // Total revenue for this record
    public double getTotalRevenue() {
        return quantity * price;
    }

    @Override
    public String toString() {
        return String.format("SalesRecord{product='%s', category='%s', qty=%d, price=%.2f}",
                product, category, quantity, price);
    }
}
