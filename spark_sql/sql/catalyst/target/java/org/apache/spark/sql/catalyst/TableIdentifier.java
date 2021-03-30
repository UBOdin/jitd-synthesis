package org.apache.spark.sql.catalyst;
/**
 * Identifies a table in a database.
 * If <code>database</code> is not defined, the current database is used.
 * When we register a permanent function in the FunctionRegistry, we use
 * unquotedString as the function name.
 */
public  class TableIdentifier implements org.apache.spark.sql.catalyst.IdentifierWithDatabase, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.TableIdentifier apply (java.lang.String tableName)  { throw new RuntimeException(); }
  public  java.lang.String table ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> database ()  { throw new RuntimeException(); }
  // not preceding
  public   TableIdentifier (java.lang.String table, scala.Option<java.lang.String> database)  { throw new RuntimeException(); }
  public  java.lang.String identifier ()  { throw new RuntimeException(); }
  public   TableIdentifier (java.lang.String table)  { throw new RuntimeException(); }
}
