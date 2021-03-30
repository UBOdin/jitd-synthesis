package org.apache.spark.sql.catalyst.plans.logical;
/**
 * A constructor for creating a pivot, which will later be converted to a {@link Project}
 * or an {@link Aggregate} during the query analysis.
 * <p>
 * param:  groupByExprsOpt A sequence of group by expressions. This field should be None if coming
 *                        from SQL, in which group by expressions are not explicitly specified.
 * param:  pivotColumn     The pivot column.
 * param:  pivotValues     A sequence of values for the pivot column.
 * param:  aggregates      The aggregation expressions, each with or without an alias.
 * param:  child           Child operator
 */
public  class Pivot extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Option<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression>> groupByExprsOpt ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression pivotColumn ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> pivotValues ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> aggregates ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   Pivot (scala.Option<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression>> groupByExprsOpt, org.apache.spark.sql.catalyst.expressions.Expression pivotColumn, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> pivotValues, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> aggregates, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
