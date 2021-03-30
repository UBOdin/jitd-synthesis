package org.apache.spark.sql.catalyst.csv;
/**
 * Checks that column names in a CSV header and field names in the schema are the same
 * by taking into account case sensitivity.
 * <p>
 * param:  schema provided (or inferred) schema to which CSV must conform.
 * param:  options parsed CSV options.
 * param:  source name of CSV source that are currently checked. It is used in error messages.
 * param:  isStartOfFile indicates if the currently processing partition is the start of the file.
 *                      if unknown or not applicable (for instance when the input is a dataset),
 *                      can be omitted.
 */
public  class CSVHeaderChecker implements org.apache.spark.internal.Logging {
  public   CSVHeaderChecker (org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.catalyst.csv.CSVOptions options, java.lang.String source, boolean isStartOfFile)  { throw new RuntimeException(); }
  public  void checkHeaderColumnNames (java.lang.String line)  { throw new RuntimeException(); }
    void checkHeaderColumnNames (com.univocity.parsers.csv.CsvParser tokenizer)  { throw new RuntimeException(); }
    void checkHeaderColumnNames (scala.collection.Iterator<java.lang.String> lines, com.univocity.parsers.csv.CsvParser tokenizer)  { throw new RuntimeException(); }
}
