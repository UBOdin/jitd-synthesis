package org.apache.spark.sql.execution;
/**
 * A subquery that will return only one row and one column.
 * <p>
 * This is the physical copy of ScalarSubquery to be used inside SparkPlan.
 */
public  class ScalarSubquery extends org.apache.spark.sql.execution.ExecSubqueryExpression implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  public  org.apache.spark.sql.execution.BaseSubqueryExec plan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExprId exprId ()  { throw new RuntimeException(); }
  // not preceding
  public   ScalarSubquery (org.apache.spark.sql.execution.BaseSubqueryExec plan, org.apache.spark.sql.catalyst.expressions.ExprId exprId)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.ScalarSubquery withNewPlan (org.apache.spark.sql.execution.BaseSubqueryExec query)  { throw new RuntimeException(); }
  public  boolean semanticEquals (org.apache.spark.sql.catalyst.expressions.Expression other)  { throw new RuntimeException(); }
  public  void updateResult ()  { throw new RuntimeException(); }
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
}
