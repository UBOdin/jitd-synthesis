package org.apache.spark.sql.catalyst.plans.logical;
/**
 * Aliased subquery.
 * <p>
 * param:  identifier the alias identifier for this subquery.
 * param:  child the logical plan of this subquery.
 */
public  class SubqueryAlias extends org.apache.spark.sql.catalyst.plans.logical.OrderPreservingUnaryNode implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.plans.logical.SubqueryAlias apply (java.lang.String identifier, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.logical.SubqueryAlias apply (java.lang.String identifier, java.lang.String database, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.logical.SubqueryAlias apply (scala.collection.Seq<java.lang.String> multipartIdentifier, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.AliasIdentifier identifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   SubqueryAlias (org.apache.spark.sql.catalyst.AliasIdentifier identifier, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  public  java.lang.String alias ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> metadataOutput ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan doCanonicalize ()  { throw new RuntimeException(); }
}
