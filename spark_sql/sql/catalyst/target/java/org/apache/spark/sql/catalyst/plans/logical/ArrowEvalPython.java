package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A logical plan that evaluates a {@link PythonUDF} with Apache Arrow.
 */
public  class ArrowEvalPython extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements org.apache.spark.sql.catalyst.plans.logical.BaseEvalPython, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.PythonUDF> udfs ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> resultAttrs ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  public  int evalType ()  { throw new RuntimeException(); }
  // not preceding
  public   ArrowEvalPython (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.PythonUDF> udfs, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> resultAttrs, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, int evalType)  { throw new RuntimeException(); }
}
