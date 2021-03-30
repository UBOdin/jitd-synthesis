package org.apache.spark.sql.execution.streaming;
/**
 * Used when loading a JSON serialized offset from external storage.
 * We are currently not responsible for converting JSON serialized
 * data into an internal (i.e., object) representation. Sources should
 * define a factory method in their source Offset companion objects
 * that accepts a {@link SerializedOffset} for doing the conversion.
 */
public  class SerializedOffset extends org.apache.spark.sql.execution.streaming.Offset implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String json ()  { throw new RuntimeException(); }
  // not preceding
  public   SerializedOffset (java.lang.String json)  { throw new RuntimeException(); }
}
