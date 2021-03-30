package org.apache.spark.sql.catalyst.expressions;
/**
 * A function that takes a character string, removes the leading and trailing characters matching
 * with any character in the trim string, returns the new string.
 * trimStr: A character string to be trimmed from the source string, if it has multiple characters,
 * the function searches for each character in the source string, removes the characters from the
 * source string until it encounters the first non-match character.
 */
public  class StringTrimBoth extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.RuntimeReplaceable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression canonicalized ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression srcStr ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> trimStr ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  // not preceding
  public   StringTrimBoth (org.apache.spark.sql.catalyst.expressions.Expression srcStr, scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> trimStr, org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public   StringTrimBoth (org.apache.spark.sql.catalyst.expressions.Expression srcStr, org.apache.spark.sql.catalyst.expressions.Expression trimStr)  { throw new RuntimeException(); }
  public   StringTrimBoth (org.apache.spark.sql.catalyst.expressions.Expression srcStr)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprsReplaced ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<java.lang.Object> flatArguments ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
