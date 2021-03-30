package org.apache.spark.sql.catalyst.expressions;
public  class Uuid extends org.apache.spark.sql.catalyst.expressions.LeafExpression implements org.apache.spark.sql.catalyst.expressions.Stateful, org.apache.spark.sql.catalyst.expressions.ExpressionWithRandomSeed, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public final  boolean deterministic ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> randomSeed ()  { throw new RuntimeException(); }
  // not preceding
  public   Uuid (scala.Option<java.lang.Object> randomSeed)  { throw new RuntimeException(); }
  public   Uuid ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression seedExpression ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Uuid withNewSeed (long seed)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  protected  void initializeInternal (int partitionIndex)  { throw new RuntimeException(); }
  protected  Object evalInternal (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Uuid freshCopy ()  { throw new RuntimeException(); }
}
