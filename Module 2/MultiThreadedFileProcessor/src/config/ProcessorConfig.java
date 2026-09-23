package config;

/**
 * ProcessorConfig - Configuration for the file processor.
 * Uses the BUILDER PATTERN so we can set options in a clean, readable way.
 *
 * Example usage:
 *   ProcessorConfig config = new ProcessorConfig.Builder()
 *       .threadCount(4)
 *       .inputFolder("data/")
 *       .skipHeader(true)
 *       .build();
 */
public class ProcessorConfig {

    // --- Fields (all private, set via Builder) ---
    private final int    threadCount;    // How many threads to use
    private final String inputFolder;   // Folder containing CSV files
    private final String outputFile;    // Where to write the report
    private final boolean skipHeader;   // Skip first line of CSV?
    private final char    delimiter;    // CSV separator character

    // Private constructor — only Builder can call this
    private ProcessorConfig(Builder builder) {
        this.threadCount  = builder.threadCount;
        this.inputFolder  = builder.inputFolder;
        this.outputFile   = builder.outputFile;
        this.skipHeader   = builder.skipHeader;
        this.delimiter    = builder.delimiter;
    }

    // --- Getters ---
    public int     getThreadCount()  { return threadCount; }
    public String  getInputFolder()  { return inputFolder; }
    public String  getOutputFile()   { return outputFile; }
    public boolean isSkipHeader()    { return skipHeader; }
    public char    getDelimiter()    { return delimiter; }

    @Override
    public String toString() {
        return String.format(
            "ProcessorConfig{threads=%d, inputFolder='%s', outputFile='%s', skipHeader=%b, delimiter='%c'}",
            threadCount, inputFolder, outputFile, skipHeader, delimiter
        );
    }

    // =========================================================
    //  BUILDER CLASS (inner static class)
    // =========================================================
    public static class Builder {

        // Default values
        private int    threadCount = 2;
        private String inputFolder = "data/";
        private String outputFile  = "report.txt";
        private boolean skipHeader = true;
        private char    delimiter  = ',';

        // Setter methods — each returns 'this' so we can chain them
        public Builder threadCount(int threadCount) {
            if (threadCount < 1) throw new IllegalArgumentException("Thread count must be >= 1");
            this.threadCount = threadCount;
            return this;
        }

        public Builder inputFolder(String inputFolder) {
            this.inputFolder = inputFolder;
            return this;
        }

        public Builder outputFile(String outputFile) {
            this.outputFile = outputFile;
            return this;
        }

        public Builder skipHeader(boolean skipHeader) {
            this.skipHeader = skipHeader;
            return this;
        }

        public Builder delimiter(char delimiter) {
            this.delimiter = delimiter;
            return this;
        }

        // Final step: create the immutable ProcessorConfig object
        public ProcessorConfig build() {
            return new ProcessorConfig(this);
        }
    }
}
