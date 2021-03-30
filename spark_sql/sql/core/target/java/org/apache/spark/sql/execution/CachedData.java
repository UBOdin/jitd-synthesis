package org.apache.spark.sql.execution;
/** Holds a cached logical plan and its data */
public  class CachedData implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.columnar.InMemoryRelation cachedRepresentation ()  { throw new RuntimeException(); }
  // not preceding
  public   CachedData (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, org.apache.spark.sql.execution.columnar.InMemoryRelation cachedRepresentation)  { throw new RuntimeException(); }
}
