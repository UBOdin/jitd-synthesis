package org.apache.spark.sql.catalyst.plans.logical;
public  class Union extends org.apache.spark.sql.catalyst.plans.logical.LogicalPlan implements scala.Product, scala.Serializable {
  // not preceding
  static public  org.apache.spark.sql.catalyst.plans.logical.Union apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan left, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan right)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children ()  { throw new RuntimeException(); }
  public  boolean byName ()  { throw new RuntimeException(); }
  public  boolean allowMissingCol ()  { throw new RuntimeException(); }
  public   Union (scala.collection.Seq<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> children, boolean byName, boolean allowMissingCol)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> maxRows ()  { throw new RuntimeException(); }
  /**
   * Note the definition has assumption about how union is implemented physically.
   * @return (undocumented)
   */
  public  scala.Option<java.lang.Object> maxRowsPerPartition ()  { throw new RuntimeException(); }
  public  boolean duplicateResolved ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  // not preceding
  protected  org.apache.spark.sql.catalyst.expressions.ExpressionSet validConstraints ()  { throw new RuntimeException(); }
}
