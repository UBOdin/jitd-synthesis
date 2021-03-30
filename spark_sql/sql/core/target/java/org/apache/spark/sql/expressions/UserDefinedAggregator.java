package org.apache.spark.sql.expressions;
  class UserDefinedAggregator<IN extends java.lang.Object, BUF extends java.lang.Object, OUT extends java.lang.Object> extends org.apache.spark.sql.expressions.UserDefinedFunction implements scala.Product, scala.Serializable {
  public  org.apache.spark.sql.Column apply (org.apache.spark.sql.Column... exprs)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.expressions.Aggregator<IN, BUF, OUT> aggregator ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Encoder<IN> inputEncoder ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> name ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  boolean deterministic ()  { throw new RuntimeException(); }
  // not preceding
  public   UserDefinedAggregator (org.apache.spark.sql.expressions.Aggregator<IN, BUF, OUT> aggregator, org.apache.spark.sql.Encoder<IN> inputEncoder, scala.Option<java.lang.String> name, boolean nullable, boolean deterministic)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Column apply (scala.collection.Seq<org.apache.spark.sql.Column> exprs)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.aggregate.ScalaAggregator<IN, BUF, OUT> scalaAggregator (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprs)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.expressions.UserDefinedAggregator<IN, BUF, OUT> withName (java.lang.String name)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.expressions.UserDefinedAggregator<IN, BUF, OUT> asNonNullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.expressions.UserDefinedAggregator<IN, BUF, OUT> asNondeterministic ()  { throw new RuntimeException(); }
}
