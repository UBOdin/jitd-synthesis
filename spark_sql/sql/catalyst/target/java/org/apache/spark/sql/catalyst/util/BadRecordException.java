package org.apache.spark.sql.catalyst.util;
/**
 * Exception thrown when the underlying parser meet a bad record and can't parse it.
 * param:  record a function to return the record that cause the parser to fail
 * param:  partialResult a function that returns an optional row, which is the partial result of
 *                      parsing this bad record.
 * param:  cause the actual exception about why the record is bad and can't be parsed.
 */
public  class BadRecordException extends java.lang.Exception implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Function0<org.apache.spark.unsafe.types.UTF8String> record ()  { throw new RuntimeException(); }
  public  scala.Function0<scala.Option<org.apache.spark.sql.catalyst.InternalRow>> partialResult ()  { throw new RuntimeException(); }
  public  java.lang.Throwable cause ()  { throw new RuntimeException(); }
  // not preceding
  public   BadRecordException (scala.Function0<org.apache.spark.unsafe.types.UTF8String> record, scala.Function0<scala.Option<org.apache.spark.sql.catalyst.InternalRow>> partialResult, java.lang.Throwable cause)  { throw new RuntimeException(); }
}
