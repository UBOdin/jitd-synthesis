package org.apache.spark.sql.catalyst.planning;
/**
 * An extractor used when planning physical execution of a window. This extractor outputs
 * the window function type of the logical window.
 * <p>
 * The input logical window must contain same type of window functions, which is ensured by
 * the rule ExtractWindowExpressions in the analyzer.
 */
public  class PhysicalWindow {
  static public  scala.Option<scala.Tuple5<org.apache.spark.sql.catalyst.expressions.WindowFunctionType, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder>, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan>> unapply (Object a)  { throw new RuntimeException(); }
}
