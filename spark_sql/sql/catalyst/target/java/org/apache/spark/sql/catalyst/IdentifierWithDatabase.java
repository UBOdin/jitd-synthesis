package org.apache.spark.sql.catalyst;
/**
 * An identifier that optionally specifies a database.
 * <p>
 * Format (unquoted): "name" or "db.name"
 * Format (quoted): "<code>name</code>" or "<code>db</code>.<code>name</code>"
 */
public  interface IdentifierWithDatabase {
  public  scala.Option<java.lang.String> database ()  ;
  public  java.lang.String identifier ()  ;
  public  java.lang.String quoteIdentifier (java.lang.String name)  ;
  public  java.lang.String quotedString ()  ;
  public  java.lang.String toString ()  ;
  public  java.lang.String unquotedString ()  ;
}
