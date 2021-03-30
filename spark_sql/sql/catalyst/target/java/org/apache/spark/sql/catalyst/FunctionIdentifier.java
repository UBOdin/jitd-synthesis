package org.apache.spark.sql.catalyst;
/**
 * Identifies a function in a database.
 * If <code>database</code> is not defined, the current database is used.
 */
public  class FunctionIdentifier implements org.apache.spark.sql.catalyst.IdentifierWithDatabase, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.FunctionIdentifier apply (java.lang.String funcName)  { throw new RuntimeException(); }
  public  java.lang.String funcName ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> database ()  { throw new RuntimeException(); }
  // not preceding
  public   FunctionIdentifier (java.lang.String funcName, scala.Option<java.lang.String> database)  { throw new RuntimeException(); }
  public  java.lang.String identifier ()  { throw new RuntimeException(); }
  public   FunctionIdentifier (java.lang.String funcName)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
