package org.apache.spark.sql.catalyst.expressions;
/**
 * A proxy for an catalyst <code>Expression</code>. Given a runtime object <code>SubExprEvaluationRuntime</code>,
 * when this is asked to evaluate, it will load from the evaluation cache in the runtime first.
 */
public  class ExpressionProxy extends org.apache.spark.sql.catalyst.expressions.Expression implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  int id ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.SubExprEvaluationRuntime runtime ()  { throw new RuntimeException(); }
  // not preceding
  public   ExpressionProxy (org.apache.spark.sql.catalyst.expressions.Expression child, int id, org.apache.spark.sql.catalyst.expressions.SubExprEvaluationRuntime runtime)  { throw new RuntimeException(); }
  public final  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public final  boolean nullable ()  { throw new RuntimeException(); }
  public final  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  protected final  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  Object proxyEval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  boolean equals (Object obj)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
}
