package org.apache.spark.sql.expressions;
  class SparkUserDefinedFunction extends org.apache.spark.sql.expressions.UserDefinedFunction implements scala.Product, scala.Serializable {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Column apply (org.apache.spark.sql.Column... exprs)  { throw new RuntimeException(); }
  // not preceding
  public  java.lang.Object f ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Option<org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<?>>> inputEncoders ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<?>> outputEncoder ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> name ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  boolean deterministic ()  { throw new RuntimeException(); }
  // not preceding
  public   SparkUserDefinedFunction (java.lang.Object f, org.apache.spark.sql.types.DataType dataType, scala.collection.Seq<scala.Option<org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<?>>> inputEncoders, scala.Option<org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<?>> outputEncoder, scala.Option<java.lang.String> name, boolean nullable, boolean deterministic)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Column apply (scala.collection.Seq<org.apache.spark.sql.Column> exprs)  { throw new RuntimeException(); }
    org.apache.spark.sql.catalyst.expressions.ScalaUDF createScalaUDF (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprs)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.expressions.SparkUserDefinedFunction withName (java.lang.String name)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.expressions.SparkUserDefinedFunction asNonNullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.expressions.SparkUserDefinedFunction asNondeterministic ()  { throw new RuntimeException(); }
}
