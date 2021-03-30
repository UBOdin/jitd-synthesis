package org.apache.spark.sql.catalyst.plans.logical;
/**
 * FlatMap groups using a udf: pandas.Dataframe -> pandas.DataFrame.
 * This is used by DataFrame.groupby().apply().
 */
public  class FlatMapGroupsInPandas extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression functionExpr ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   FlatMapGroupsInPandas (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes, org.apache.spark.sql.catalyst.expressions.Expression functionExpr, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  /**
   * This is needed because output attributes are considered <code>references</code> when
   * passed through the constructor.
   * <p>
   * Without this, catalyst will complain that output attributes are missing
   * from the input.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  { throw new RuntimeException(); }
}
