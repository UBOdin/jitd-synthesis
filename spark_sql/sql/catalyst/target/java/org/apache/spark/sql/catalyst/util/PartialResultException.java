package org.apache.spark.sql.catalyst.util;
/**
 * Exception thrown when the underlying parser returns a partial result of parsing.
 * param:  partialResult the partial result of parsing a bad record.
 * param:  cause the actual exception about why the parser cannot return full result.
 */
public  class PartialResultException extends java.lang.Exception implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow partialResult ()  { throw new RuntimeException(); }
  public  java.lang.Throwable cause ()  { throw new RuntimeException(); }
  // not preceding
  public   PartialResultException (org.apache.spark.sql.catalyst.InternalRow partialResult, java.lang.Throwable cause)  { throw new RuntimeException(); }
}
