package processor;

import config.ProcessorConfig;
import model.SalesRecord;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

/**
 * CsvFileProcessor - Reads ONE CSV file and returns a list of SalesRecords.
 *
 * This implements Callable<List<SalesRecord>> so it can run in a thread pool
 * and RETURN a result (unlike Runnable which returns nothing).
 *
 * Each thread gets its own CsvFileProcessor instance for one CSV file.
 */
public class CsvFileProcessor implements Callable<List<SalesRecord>> {

    private final String          filePath;  // Path to the CSV file this thread will process
    private final ProcessorConfig config;    // Configuration (delimiter, skipHeader, etc.)

    public CsvFileProcessor(String filePath, ProcessorConfig config) {
        this.filePath = filePath;
        this.config   = config;
    }

    /**
     * call() is invoked automatically when the thread runs.
     * It reads the CSV file line by line and parses each row.
     */
    @Override
    public List<SalesRecord> call() throws Exception {
        List<SalesRecord> records = new ArrayList<>();

        System.out.println("[Thread: " + Thread.currentThread().getName() + "] Processing: " + filePath);

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {

            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {

                // Skip header row if configured
                if (firstLine && config.isSkipHeader()) {
                    firstLine = false;
                    continue;
                }
                firstLine = false;

                // Skip empty lines
                line = line.trim();
                if (line.isEmpty()) continue;

                // Parse the CSV line
                SalesRecord record = parseLine(line);
                if (record != null) {
                    records.add(record);
                }
            }
        }

        System.out.println("[Thread: " + Thread.currentThread().getName() + "] Done! Parsed "
                + records.size() + " records from: " + filePath);

        return records;
    }

    /**
     * Parses one CSV line into a SalesRecord.
     * Expected format: product,category,quantity,price
     * Example: "Laptop,Electronics,5,999.99"
     */
    private SalesRecord parseLine(String line) {
        try {
            String[] parts = line.split(String.valueOf(config.getDelimiter()));

            // We expect exactly 4 columns
            if (parts.length < 4) {
                System.err.println("  [WARN] Skipping malformed line: " + line);
                return null;
            }

            String product  = parts[0].trim();
            String category = parts[1].trim();
            int    quantity = Integer.parseInt(parts[2].trim());
            double price    = Double.parseDouble(parts[3].trim());

            return new SalesRecord(product, category, quantity, price);

        } catch (NumberFormatException e) {
            System.err.println("  [WARN] Could not parse numbers in line: " + line);
            return null;
        }
    }
}
