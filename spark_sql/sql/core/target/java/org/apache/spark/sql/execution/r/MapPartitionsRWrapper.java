package org.apache.spark.sql.execution.r;
/**
 * A function wrapper that applies the given R function to each partition.
 */
public  class MapPartitionsRWrapper implements scala.Function1<scala.collection.Iterator<java.lang.Object>, scala.collection.Iterator<java.lang.Object>>, scala.Product, scala.Serializable {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  byte[] func ()  { throw new RuntimeException(); }
  public  byte[] packageNames ()  { throw new RuntimeException(); }
  public  org.apache.spark.broadcast.Broadcast<java.lang.Object>[] broadcastVars ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType inputSchema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType outputSchema ()  { throw new RuntimeException(); }
  // not preceding
  public   MapPartitionsRWrapper (byte[] func, byte[] packageNames, org.apache.spark.broadcast.Broadcast<java.lang.Object>[] broadcastVars, org.apache.spark.sql.types.StructType inputSchema, org.apache.spark.sql.types.StructType outputSchema)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<java.lang.Object> apply (scala.collection.Iterator<java.lang.Object> iter)  { throw new RuntimeException(); }
}
