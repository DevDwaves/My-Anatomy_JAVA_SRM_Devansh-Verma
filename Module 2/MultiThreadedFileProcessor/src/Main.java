import config.ProcessorConfig;
import model.SalesRecord;
import processor.CsvFileProcessor;
import report.ReportAggregator;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * ============================================================
 *  Main.java - Entry point for Multi-Threaded File Processor
 * ============================================================
 *
 * How it works (step by step):
 *
 *  1. Build configuration using Builder pattern
 *  2. Find all CSV files in the input folder
 *  3. Create a thread pool (ExecutorService) with N threads
 *  4. Submit one CsvFileProcessor task per CSV file
 *  5. Wait for ALL threads to finish (get results from Futures)
 *  6. Aggregate all results into a ReportAggregator
 *  7. Generate and save the final report
 */
public class Main {

    public static void main(String[] args) {

        System.out.println("============================================");
        System.out.println("  Multi-Threaded CSV File Processor");
        System.out.println("============================================\n");

        // -------------------------------------------------------
        // STEP 1: Build configuration using the Builder Pattern
        // -------------------------------------------------------
        ProcessorConfig config = new ProcessorConfig.Builder()
                .threadCount(3)              // Use 3 threads in the pool
                .inputFolder("data/")        // CSV files are in the "data" folder
                .outputFile("report.txt")    // Output report file name
                .skipHeader(true)            // First line in CSV is a header
                .delimiter(',')              // Comma-separated
                .build();

        System.out.println("Configuration: " + config);
        System.out.println();

        // -------------------------------------------------------
        // STEP 2: Find all CSV files in the input folder
        // -------------------------------------------------------
        File folder = new File(config.getInputFolder());
        File[] csvFiles = folder.listFiles((dir, name) -> name.toLowerCase().endsWith(".csv"));

        if (csvFiles == null || csvFiles.length == 0) {
            System.err.println("No CSV files found in folder: " + config.getInputFolder());
            System.err.println("Please make sure the 'data/' folder exists with .csv files.");
            return;
        }

        System.out.println("Found " + csvFiles.length + " CSV file(s) to process:\n");
        for (File f : csvFiles) {
            System.out.println("  -> " + f.getName());
        }
        System.out.println();

        // -------------------------------------------------------
        // STEP 3: Create the thread pool (ExecutorService)
        //   - Fixed thread pool means at most N threads run at once
        //   - Extra tasks wait in a queue until a thread is free
        // -------------------------------------------------------
        ExecutorService executor = Executors.newFixedThreadPool(config.getThreadCount());

        // -------------------------------------------------------
        // STEP 4: Submit one task per CSV file
        //   - Each task returns Future<List<SalesRecord>>
        //   - A Future is like a "receipt" for a pending result
        // -------------------------------------------------------
        List<Future<List<SalesRecord>>> futures = new ArrayList<>();

        for (File csvFile : csvFiles) {
            CsvFileProcessor task = new CsvFileProcessor(csvFile.getPath(), config);
            Future<List<SalesRecord>> future = executor.submit(task);
            futures.add(future);
        }

        // -------------------------------------------------------
        // STEP 5: Wait for all threads to finish + collect results
        //   - future.get() BLOCKS until that thread is done
        // -------------------------------------------------------
        ReportAggregator aggregator = new ReportAggregator();

        System.out.println("Processing files concurrently...\n");

        for (Future<List<SalesRecord>> future : futures) {
            try {
                List<SalesRecord> records = future.get(); // Wait for this thread to finish
                aggregator.addRecords(records);           // Add its records to aggregator
            } catch (InterruptedException e) {
                System.err.println("Thread was interrupted: " + e.getMessage());
                Thread.currentThread().interrupt();
            } catch (ExecutionException e) {
                System.err.println("Error in thread: " + e.getCause().getMessage());
            }
        }

        // -------------------------------------------------------
        // STEP 6: Shutdown the thread pool gracefully
        //   - No new tasks accepted, existing ones finish normally
        // -------------------------------------------------------
        executor.shutdown();
        System.out.println("\nAll threads finished. Thread pool shut down.\n");

        // -------------------------------------------------------
        // STEP 7: Generate the aggregated report
        // -------------------------------------------------------
        System.out.println("Generating report...");
        aggregator.generateReport(config.getOutputFile());

        System.out.println("\nDone! Check '" + config.getOutputFile() + "' for the full report.");
    }
}
