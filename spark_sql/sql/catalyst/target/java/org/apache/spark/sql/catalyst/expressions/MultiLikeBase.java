package org.apache.spark.sql.catalyst.expressions;
public abstract class MultiLikeBase extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant {
  public   MultiLikeBase ()  { throw new RuntimeException(); }
  // not preceding
  protected  scala.collection.Seq<java.util.regex.Pattern> cache ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  // not preceding
  protected  boolean hasNull ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputTypes ()  { throw new RuntimeException(); }
  protected abstract  boolean isNotSpecified ()  ;
  // not preceding
  protected  scala.Function2<java.util.regex.Pattern, java.lang.String, java.lang.Object> matchFunc ()  { throw new RuntimeException(); }
  protected abstract  Object matches (java.lang.String exprValue)  ;
  public  boolean nullable ()  { throw new RuntimeException(); }
  protected abstract  scala.collection.Seq<org.apache.spark.unsafe.types.UTF8String> patterns ()  ;
}
