package org.apache.spark.sql.catalyst.expressions;
/**
 * Wrapper around another generator to specify outer behavior. This is used to implement functions
 * such as explode_outer. This expression gets replaced during analysis.
 */
public  class GeneratorOuter extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.Generator, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Generator child ()  { throw new RuntimeException(); }
  // not preceding
  public   GeneratorOuter (org.apache.spark.sql.catalyst.expressions.Generator child)  { throw new RuntimeException(); }
  public final  scala.collection.TraversableOnce<org.apache.spark.sql.catalyst.InternalRow> eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  protected final  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.StructType elementSchema ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
}
