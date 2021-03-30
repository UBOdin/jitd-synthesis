package org.apache.spark.sql.catalyst.plans.logical;
public  class Expand$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Expand$ MODULE$ = null;
  public   Expand$ ()  { throw new RuntimeException(); }
  /**
   * Apply the all of the GroupExpressions to every input row, hence we will get
   * multiple output rows for an input row.
   * <p>
   * @param groupingSetsAttrs The attributes of grouping sets
   * @param groupByAliases The aliased original group by expressions
   * @param groupByAttrs The attributes of aliased group by expressions
   * @param gid Attribute of the grouping id
   * @param child Child operator
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.Expand apply (scala.collection.Seq<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute>> groupingSetsAttrs, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Alias> groupByAliases, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupByAttrs, org.apache.spark.sql.catalyst.expressions.Attribute gid, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
}
