package org.apache.spark.sql.execution.arrow;
public  class ArrowWriter {
  static public  org.apache.spark.sql.execution.arrow.ArrowWriter create (org.apache.spark.sql.types.StructType schema, java.lang.String timeZoneId)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.arrow.ArrowWriter create (org.apache.arrow.vector.VectorSchemaRoot root)  { throw new RuntimeException(); }
  public  org.apache.arrow.vector.VectorSchemaRoot root ()  { throw new RuntimeException(); }
  // not preceding
  public   ArrowWriter (org.apache.arrow.vector.VectorSchemaRoot root, org.apache.spark.sql.execution.arrow.ArrowFieldWriter[] fields)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  public  void write (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
  public  void finish ()  { throw new RuntimeException(); }
  public  void reset ()  { throw new RuntimeException(); }
}
