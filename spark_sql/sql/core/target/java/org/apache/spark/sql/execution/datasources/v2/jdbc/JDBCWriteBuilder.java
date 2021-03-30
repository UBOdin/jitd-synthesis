package org.apache.spark.sql.execution.datasources.v2.jdbc;
public  class JDBCWriteBuilder implements org.apache.spark.sql.connector.write.WriteBuilder, org.apache.spark.sql.connector.write.SupportsTruncate, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.jdbc.JdbcOptionsInWrite options ()  { throw new RuntimeException(); }
  // not preceding
  public   JDBCWriteBuilder (org.apache.spark.sql.types.StructType schema, org.apache.spark.sql.execution.datasources.jdbc.JdbcOptionsInWrite options)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.WriteBuilder truncate ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.V1Write build ()  { throw new RuntimeException(); }
}
