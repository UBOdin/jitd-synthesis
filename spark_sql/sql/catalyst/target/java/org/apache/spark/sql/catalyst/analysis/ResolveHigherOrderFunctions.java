package org.apache.spark.sql.catalyst.analysis;
/**
 * Resolve a higher order functions from the catalog. This is different from regular function
 * resolution because lambda functions can only be resolved after the function has been resolved;
 * so we need to resolve higher order function when all children are either resolved or a lambda
 * function.
 */
public  class ResolveHigherOrderFunctions extends org.apache.spark.sql.catalyst.rules.Rule<org.apache.spark.sql.catalyst.plans.logical.LogicalPlan> implements scala.Product, scala.Serializable {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog ()  { throw new RuntimeException(); }
  // not preceding
  public   ResolveHigherOrderFunctions (org.apache.spark.sql.catalyst.catalog.SessionCatalog catalog)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
}
