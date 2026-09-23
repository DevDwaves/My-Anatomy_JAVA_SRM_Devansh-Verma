package report;

import model.SalesRecord;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.*;

/**
 * ReportAggregator - Takes ALL records from ALL CSV files and
 * computes summary statistics, then writes a report.
 *
 * This runs AFTER all threads finish (aggregation phase).
 */
public class ReportAggregator {

    private final List<SalesRecord> allRecords = new ArrayList<>();

    /**
     * Add records from one processed file into the aggregator.
     * (Called once per file after each thread completes.)
     */
    public void addRecords(List<SalesRecord> records) {
        allRecords.addAll(records);
    }

    /**
     * Compute and print the report to console AND write to a file.
     */
    public void generateReport(String outputFilePath) {

        // ---- Compute Aggregations ----
        int    totalRecords  = allRecords.size();
        double totalRevenue  = 0;
        int    totalQuantity = 0;

        // Revenue per category
        Map<String, Double> revenueByCategory  = new TreeMap<>();
        // Quantity per category
        Map<String, Integer> quantityByCategory = new TreeMap<>();
        // Best selling product (by quantity)
        Map<String, Integer> quantityByProduct  = new TreeMap<>();

        for (SalesRecord r : allRecords) {
            double rev = r.getTotalRevenue();
            totalRevenue  += rev;
            totalQuantity += r.getQuantity();

            revenueByCategory.merge(r.getCategory(), rev, Double::sum);
            quantityByCategory.merge(r.getCategory(), r.getQuantity(), Integer::sum);
            quantityByProduct.merge(r.getProduct(), r.getQuantity(), Integer::sum);
        }

        // Find best selling product
        String topProduct = quantityByProduct.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");

        // Find top category by revenue
        String topCategory = revenueByCategory.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse("N/A");

        // ---- Build Report String ----
        String separator = "=".repeat(55);
        String report = buildReport(separator, totalRecords, totalQuantity, totalRevenue,
                topProduct, topCategory, revenueByCategory, quantityByCategory);

        // ---- Print to Console ----
        System.out.println(report);

        // ---- Write to File ----
        try (PrintWriter writer = new PrintWriter(new FileWriter(outputFilePath))) {
            writer.print(report);
            System.out.println("Report saved to: " + outputFilePath);
        } catch (Exception e) {
            System.err.println("Could not write report file: " + e.getMessage());
        }
    }

    /** Builds the formatted report string. */
    private String buildReport(
            String separator,
            int totalRecords,
            int totalQuantity,
            double totalRevenue,
            String topProduct,
            String topCategory,
            Map<String, Double>  revenueByCategory,
            Map<String, Integer> quantityByCategory
    ) {
        StringBuilder sb = new StringBuilder();

        sb.append("\n").append(separator).append("\n");
        sb.append("       SALES AGGREGATED REPORT\n");
        sb.append(separator).append("\n\n");

        sb.append("  Total Records Processed : ").append(totalRecords).append("\n");
        sb.append(String.format("  Total Quantity Sold     : %,d units\n", totalQuantity));
        sb.append(String.format("  Total Revenue           : $%,.2f\n", totalRevenue));
        sb.append(String.format("  Average Revenue/Record  : $%,.2f\n",
                totalRecords > 0 ? totalRevenue / totalRecords : 0));
        sb.append("\n");
        sb.append("  Top-Selling Product     : ").append(topProduct).append("\n");
        sb.append("  Top Revenue Category    : ").append(topCategory).append("\n");

        sb.append("\n").append(separator).append("\n");
        sb.append("  REVENUE BY CATEGORY:\n");
        sb.append(separator).append("\n");
        revenueByCategory.forEach((cat, rev) ->
            sb.append(String.format("  %-20s : $%,12.2f\n", cat, rev))
        );

        sb.append("\n").append(separator).append("\n");
        sb.append("  QUANTITY SOLD BY CATEGORY:\n");
        sb.append(separator).append("\n");
        quantityByCategory.forEach((cat, qty) ->
            sb.append(String.format("  %-20s : %,8d units\n", cat, qty))
        );

        sb.append("\n").append(separator).append("\n");

        return sb.toString();
    }
}
