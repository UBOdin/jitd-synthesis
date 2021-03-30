package org.apache.spark.sql.catalyst.expressions;
public abstract class StringRegexExpression extends org.apache.spark.sql.catalyst.expressions.BinaryExpression implements org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant {
  public   StringRegexExpression ()  { throw new RuntimeException(); }
  protected  java.util.regex.Pattern compile (java.lang.String str)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public abstract  java.lang.String escape (java.lang.String v)  ;
  public  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputTypes ()  { throw new RuntimeException(); }
  public abstract  boolean matches (java.util.regex.Pattern regex, java.lang.String str)  ;
  protected  Object nullSafeEval (Object input1, Object input2)  { throw new RuntimeException(); }
  protected  java.util.regex.Pattern pattern (java.lang.String str)  { throw new RuntimeException(); }
}
