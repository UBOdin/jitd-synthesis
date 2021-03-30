package org.apache.spark.sql.execution.streaming.sources;
/**
 * Commit message for a {@link PackedRowDataWriter}, containing all the rows written in the most
 * recent interval.
 */
public  class PackedRowCommitMessage implements org.apache.spark.sql.connector.write.WriterCommitMessage, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow[] rows ()  { throw new RuntimeException(); }
  // not preceding
  public   PackedRowCommitMessage (org.apache.spark.sql.catalyst.InternalRow[] rows)  { throw new RuntimeException(); }
}
