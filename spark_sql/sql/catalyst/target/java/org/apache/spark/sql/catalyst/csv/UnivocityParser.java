package org.apache.spark.sql.catalyst.csv;
/**
 * Constructs a parser for a given schema that translates CSV data to an {@link InternalRow}.
 * <p>
 * param:  dataSchema The CSV data schema that is specified by the user, or inferred from underlying
 *                   data files.
 * param:  requiredSchema The schema of the data that should be output for each row. This should be a
 *                       subset of the columns in dataSchema.
 * param:  options Configuration options for a CSV parser.
 * param:  filters The pushdown filters that should be applied to converted values.
 */
public  class UnivocityParser implements org.apache.spark.internal.Logging {
  /**
   * Parses a stream that contains CSV strings and turns it into an iterator of tokens.
   * @param inputStream (undocumented)
   * @param shouldDropHeader (undocumented)
   * @param tokenizer (undocumented)
   * @param encoding (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Iterator<java.lang.String[]> tokenizeStream (java.io.InputStream inputStream, boolean shouldDropHeader, com.univocity.parsers.csv.CsvParser tokenizer, java.lang.String encoding)  { throw new RuntimeException(); }
  /**
   * Parses a stream that contains CSV strings and turns it into an iterator of rows.
   * @param inputStream (undocumented)
   * @param parser (undocumented)
   * @param headerChecker (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> parseStream (java.io.InputStream inputStream, org.apache.spark.sql.catalyst.csv.UnivocityParser parser, org.apache.spark.sql.catalyst.csv.CSVHeaderChecker headerChecker, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Parses an iterator that contains CSV strings and turns it into an iterator of rows.
   * @param lines (undocumented)
   * @param parser (undocumented)
   * @param headerChecker (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> parseIterator (scala.collection.Iterator<java.lang.String> lines, org.apache.spark.sql.catalyst.csv.UnivocityParser parser, org.apache.spark.sql.catalyst.csv.CSVHeaderChecker headerChecker, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.csv.CSVOptions options ()  { throw new RuntimeException(); }
  // not preceding
  public   UnivocityParser (org.apache.spark.sql.types.StructType dataSchema, org.apache.spark.sql.types.StructType requiredSchema, org.apache.spark.sql.catalyst.csv.CSVOptions options, scala.collection.Seq<org.apache.spark.sql.sources.Filter> filters)  { throw new RuntimeException(); }
  public   UnivocityParser (org.apache.spark.sql.types.StructType dataSchema, org.apache.spark.sql.types.StructType requiredSchema, org.apache.spark.sql.catalyst.csv.CSVOptions options)  { throw new RuntimeException(); }
  public   UnivocityParser (org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.catalyst.csv.CSVOptions options)  { throw new RuntimeException(); }
  public  com.univocity.parsers.csv.CsvParser tokenizer ()  { throw new RuntimeException(); }
  /**
   * Create a converter which converts the string value to a value according to a desired type.
   * Currently, we do not support complex types (<code>ArrayType</code>, <code>MapType</code>, <code>StructType</code>).
   * <p>
   * For other nullable types, returns null if it is null or equals to the value specified
   * in <code>nullValue</code> option.
   * @param name (undocumented)
   * @param dataType (undocumented)
   * @param nullable (undocumented)
   * @return (undocumented)
   */
  public  scala.Function1<java.lang.String, java.lang.Object> makeConverter (java.lang.String name, org.apache.spark.sql.types.DataType dataType, boolean nullable)  { throw new RuntimeException(); }
  /**
   * Parses a single CSV string and turns it into either one resulting row or no row (if the
   * the record is malformed).
   * @return (undocumented)
   */
  public  scala.Function1<java.lang.String, scala.Option<org.apache.spark.sql.catalyst.InternalRow>> parse ()  { throw new RuntimeException(); }
}
