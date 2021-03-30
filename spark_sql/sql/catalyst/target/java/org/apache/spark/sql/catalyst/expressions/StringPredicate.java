package org.apache.spark.sql.catalyst.expressions;
/** A base trait for functions that compare two strings, returning a boolean. */
public abstract class StringPredicate extends org.apache.spark.sql.catalyst.expressions.BinaryExpression implements org.apache.spark.sql.catalyst.expressions.Predicate, org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, org.apache.spark.sql.catalyst.expressions.NullIntolerant {
  public   StringPredicate ()  { throw new RuntimeException(); }
  public abstract  boolean compare (org.apache.spark.unsafe.types.UTF8String l, org.apache.spark.unsafe.types.UTF8String r)  ;
  public  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputTypes ()  { throw new RuntimeException(); }
  protected  Object nullSafeEval (Object input1, Object input2)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
