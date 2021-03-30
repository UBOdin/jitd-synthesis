package org.apache.spark.sql.catalyst.expressions;
public  class DatePart extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.RuntimeReplaceable, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.Expression parseExtractField (java.lang.String extractField, org.apache.spark.sql.catalyst.expressions.Expression source, scala.Function0<scala.runtime.Nothing$> errorHandleFunc)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.expressions.Expression toEquivalentExpr (org.apache.spark.sql.catalyst.expressions.Expression field, org.apache.spark.sql.catalyst.expressions.Expression source)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression canonicalized ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression field ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression source ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  // not preceding
  public   DatePart (org.apache.spark.sql.catalyst.expressions.Expression field, org.apache.spark.sql.catalyst.expressions.Expression source, org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public   DatePart (org.apache.spark.sql.catalyst.expressions.Expression field, org.apache.spark.sql.catalyst.expressions.Expression source)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<java.lang.Object> flatArguments ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprsReplaced ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
