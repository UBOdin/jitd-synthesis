package org.apache.spark.sql.hive;
  class HiveGenericUDF extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.hive.HiveInspectors, org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, org.apache.spark.internal.Logging, org.apache.spark.sql.catalyst.expressions.UserDefinedExpression, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.hive.HiveShim.HiveFunctionWrapper funcWrapper ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public   HiveGenericUDF (java.lang.String name, org.apache.spark.sql.hive.HiveShim.HiveFunctionWrapper funcWrapper, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean deterministic ()  { throw new RuntimeException(); }
  public  boolean foldable ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.hadoop.hive.ql.udf.generic.GenericUDF function ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
