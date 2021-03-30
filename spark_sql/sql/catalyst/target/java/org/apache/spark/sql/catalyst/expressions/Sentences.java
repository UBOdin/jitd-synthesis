package org.apache.spark.sql.catalyst.expressions;
/**
 * Splits a string into arrays of sentences, where each sentence is an array of words.
 * The 'lang' and 'country' arguments are optional, and if omitted, the default locale is used.
 */
public  class Sentences extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression str ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression language ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression country ()  { throw new RuntimeException(); }
  // not preceding
  public   Sentences (org.apache.spark.sql.catalyst.expressions.Expression str, org.apache.spark.sql.catalyst.expressions.Expression language, org.apache.spark.sql.catalyst.expressions.Expression country)  { throw new RuntimeException(); }
  public   Sentences (org.apache.spark.sql.catalyst.expressions.Expression str)  { throw new RuntimeException(); }
  public   Sentences (org.apache.spark.sql.catalyst.expressions.Expression str, org.apache.spark.sql.catalyst.expressions.Expression language)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
}
