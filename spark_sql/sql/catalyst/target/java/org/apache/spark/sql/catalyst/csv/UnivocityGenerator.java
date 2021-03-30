package org.apache.spark.sql.catalyst.csv;
public  class UnivocityGenerator {
  public   UnivocityGenerator (org.apache.spark.sql.types.StructType schema, java.io.Writer writer, org.apache.spark.sql.catalyst.csv.CSVOptions options)  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  void flush ()  { throw new RuntimeException(); }
  /**
   * Writes a single InternalRow to CSV using Univocity.
   * @param row (undocumented)
   */
  public  void write (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
  public  void writeHeaders ()  { throw new RuntimeException(); }
  public  java.lang.String writeToString (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
}
