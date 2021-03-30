package org.apache.spark.sql.catalyst.expressions;
public  class NthValue extends org.apache.spark.sql.catalyst.expressions.AggregateWindowFunction implements org.apache.spark.sql.catalyst.expressions.OffsetWindowFunction, org.apache.spark.sql.catalyst.expressions.ImplicitCastInputTypes, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.SpecifiedWindowFrame fakeFrame ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression input ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression offset ()  { throw new RuntimeException(); }
  public  boolean ignoreNulls ()  { throw new RuntimeException(); }
  // not preceding
  public   NthValue (org.apache.spark.sql.catalyst.expressions.Expression input, org.apache.spark.sql.catalyst.expressions.Expression offset, boolean ignoreNulls)  { throw new RuntimeException(); }
  public   NthValue (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.catalyst.expressions.Expression offset)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.WindowFrame frame ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkInputDataTypes ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggBufferAttributes ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Literal> initialValues ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> updateExpressions ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.AttributeReference evaluateExpression ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
