package org.apache.spark.sql.hive;
/**
 * Here we cannot extends <code>ImplicitTypeCasts</code> to compatible with UDF input data type, the reason is:
 * we use children data type to reflect UDF method first and will get exception if it fails so that
 * we can never go into <code>ImplicitTypeCasts</code>.
 */
  class HiveSimpleUDF extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.hive.HiveInspectors, org.apache.spark.sql.catalyst.expressions.codegen.CodegenFallback, org.apache.spark.internal.Logging, org.apache.spark.sql.catalyst.expressions.UserDefinedExpression, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.hive.HiveShim.HiveFunctionWrapper funcWrapper ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public   HiveSimpleUDF (java.lang.String name, org.apache.spark.sql.hive.HiveShim.HiveFunctionWrapper funcWrapper, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  // not preceding
  public  boolean deterministic ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.hadoop.hive.ql.exec.UDF function ()  { throw new RuntimeException(); }
  public  boolean foldable ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.Function1<java.lang.Object, java.lang.Object> unwrapper ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
