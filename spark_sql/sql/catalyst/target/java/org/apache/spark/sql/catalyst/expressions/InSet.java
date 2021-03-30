package org.apache.spark.sql.catalyst.expressions;
/**
 * Optimized version of In clause, when all filter values of In clause are
 * static.
 */
public  class InSet extends org.apache.spark.sql.catalyst.expressions.UnaryExpression implements org.apache.spark.sql.catalyst.expressions.Predicate, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Set<java.lang.Object> hset ()  { throw new RuntimeException(); }
  // not preceding
  public   InSet (org.apache.spark.sql.catalyst.expressions.Expression child, scala.collection.immutable.Set<java.lang.Object> hset)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  protected  Object nullSafeEval (Object value)  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.immutable.Set<java.lang.Object> set ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
}
