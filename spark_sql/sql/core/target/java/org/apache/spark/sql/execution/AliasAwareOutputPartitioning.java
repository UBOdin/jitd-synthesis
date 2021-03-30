package org.apache.spark.sql.execution;
/**
 * A trait that handles aliases in the <code>outputExpressions</code> to produce <code>outputPartitioning</code> that
 * satisfies distribution requirements.
 */
public  interface AliasAwareOutputPartitioning extends org.apache.spark.sql.execution.AliasAwareOutputExpression {
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Partitioning> flattenPartitioning (org.apache.spark.sql.catalyst.plans.physical.Partitioning partitioning)  ;
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  ;
}
