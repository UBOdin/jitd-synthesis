package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for append into a v2 table using V1 write interfaces.
 * <p>
 * Rows in the output data set are appended.
 */
public  class AppendDataExecV1 extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements org.apache.spark.sql.execution.datasources.v2.V1FallbackWriters, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.SupportsWrite table ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan ()  { throw new RuntimeException(); }
  public  scala.Function0<scala.runtime.BoxedUnit> refreshCache ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.V1Write write ()  { throw new RuntimeException(); }
  // not preceding
  public   AppendDataExecV1 (org.apache.spark.sql.connector.catalog.SupportsWrite table, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, scala.Function0<scala.runtime.BoxedUnit> refreshCache, org.apache.spark.sql.connector.write.V1Write write)  { throw new RuntimeException(); }
}
