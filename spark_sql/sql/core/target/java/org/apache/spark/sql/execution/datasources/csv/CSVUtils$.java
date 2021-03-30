package org.apache.spark.sql.execution.datasources.csv;
public  class CSVUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CSVUtils$ MODULE$ = null;
  public   CSVUtils$ ()  { throw new RuntimeException(); }
  /**
   * Filter ignorable rows for CSV dataset (lines empty and starting with <code>comment</code>).
   * This is currently being used in CSV schema inference.
   * @param lines (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<java.lang.String> filterCommentAndEmpty (org.apache.spark.sql.Dataset<java.lang.String> lines, org.apache.spark.sql.catalyst.csv.CSVOptions options)  { throw new RuntimeException(); }
  /**
   * Skip the given first line so that only data can remain in a dataset.
   * This is similar with <code>dropHeaderLine</code> below and currently being used in CSV schema inference.
   * @param iter (undocumented)
   * @param firstLine (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<java.lang.String> filterHeaderLine (scala.collection.Iterator<java.lang.String> iter, java.lang.String firstLine, org.apache.spark.sql.catalyst.csv.CSVOptions options)  { throw new RuntimeException(); }
  /**
   * Generates a header from the given row which is null-safe and duplicate-safe.
   * @param row (undocumented)
   * @param caseSensitive (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String[] makeSafeHeader (java.lang.String[] row, boolean caseSensitive, org.apache.spark.sql.catalyst.csv.CSVOptions options)  { throw new RuntimeException(); }
  /**
   * Sample CSV dataset as configured by <code>samplingRatio</code>.
   * @param csv (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<java.lang.String> sample (org.apache.spark.sql.Dataset<java.lang.String> csv, org.apache.spark.sql.catalyst.csv.CSVOptions options)  { throw new RuntimeException(); }
  /**
   * Sample CSV RDD as configured by <code>samplingRatio</code>.
   * @param csv (undocumented)
   * @param options (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.rdd.RDD<java.lang.String[]> sample (org.apache.spark.rdd.RDD<java.lang.String[]> csv, org.apache.spark.sql.catalyst.csv.CSVOptions options)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<java.lang.String> filterCommentAndEmpty (scala.collection.Iterator<java.lang.String> iter, org.apache.spark.sql.catalyst.csv.CSVOptions options)  { throw new RuntimeException(); }
}
