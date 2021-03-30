package org.apache.spark.sql.execution;
/**
 * The physical node of in-subquery. This is for Dynamic Partition Pruning only, as in-subquery
 * coming from the original query will always be converted to joins.
 */
public  class InSubqueryExec extends org.apache.spark.sql.execution.ExecSubqueryExpression implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.Expression child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.BaseSubqueryExec plan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExprId exprId ()  { throw new RuntimeException(); }
  // not preceding
  public   InSubqueryExec (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.execution.BaseSubqueryExec plan, org.apache.spark.sql.catalyst.expressions.ExprId exprId, org.apache.spark.broadcast.Broadcast<java.lang.Object[]> resultBroadcast)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.InSubqueryExec withNewPlan (org.apache.spark.sql.execution.BaseSubqueryExec plan)  { throw new RuntimeException(); }
  public  boolean semanticEquals (org.apache.spark.sql.catalyst.expressions.Expression other)  { throw new RuntimeException(); }
  public  void updateResult ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object[]> values ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.execution.InSubqueryExec canonicalized ()  { throw new RuntimeException(); }
}
