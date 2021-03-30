package org.apache.spark.sql.catalyst.csv;
public  class UnivocityParser$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final UnivocityParser$ MODULE$ = null;
  public   UnivocityParser$ ()  { throw new RuntimeException(); }
  /**
   * Parses a stream that contains CSV strings and turns it into an iterator of tokens.
   * @param inputStream (undocumented)
   * @param shouldDropHeader (undocumented)
   * @param tokenizer (undocumented)
   * @param encoding (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<java.lang.String[]> tokenizeStream (java.io.InputStream inputStream, boolean shouldDropHeader, com.univocity.parsers.csv.CsvParser tokenizer, java.lang.String encoding)  { throw new RuntimeException(); }
  /**
   * Parses a stream that contains CSV strings and turns it into an iterator of rows.
   * @param inputStream (undocumented)
   * @param parser (undocumented)
   * @param headerChecker (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> parseStream (java.io.InputStream inputStream, org.apache.spark.sql.catalyst.csv.UnivocityParser parser, org.apache.spark.sql.catalyst.csv.CSVHeaderChecker headerChecker, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Parses an iterator that contains CSV strings and turns it into an iterator of rows.
   * @param lines (undocumented)
   * @param parser (undocumented)
   * @param headerChecker (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> parseIterator (scala.collection.Iterator<java.lang.String> lines, org.apache.spark.sql.catalyst.csv.UnivocityParser parser, org.apache.spark.sql.catalyst.csv.CSVHeaderChecker headerChecker, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
}
