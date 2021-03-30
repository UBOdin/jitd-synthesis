package org.apache.spark.sql.connector.write;
  class LogicalWriteInfoImpl implements org.apache.spark.sql.connector.write.LogicalWriteInfo, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String queryId ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.util.CaseInsensitiveStringMap options ()  { throw new RuntimeException(); }
  // not preceding
  public   LogicalWriteInfoImpl (java.lang.String queryId, org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
}
