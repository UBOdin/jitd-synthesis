package org.apache.spark.sql.catalyst.expressions;
/** Generate a random column with i.i.d. values drawn from the standard normal distribution. */
public  class Randn extends org.apache.spark.sql.catalyst.expressions.RDG implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.expressions.Randn apply (long seed)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  boolean hideSeed ()  { throw new RuntimeException(); }
  // not preceding
  public   Randn (org.apache.spark.sql.catalyst.expressions.Expression child, boolean hideSeed)  { throw new RuntimeException(); }
  public   Randn ()  { throw new RuntimeException(); }
  public   Randn (org.apache.spark.sql.catalyst.expressions.Expression child)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Randn withNewSeed (long seed)  { throw new RuntimeException(); }
  protected  double evalInternal (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Randn freshCopy ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<java.lang.Object> flatArguments ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
