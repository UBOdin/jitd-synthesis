package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for overwrite into a v2 table with V1 write interfaces. Note that when this
 * interface is used, the atomicity of the operation depends solely on the target data source.
 * <p>
 * Overwrites data in a table matched by a set of filters. Rows matching all of the filters will be
 * deleted and rows in the output data set are appended.
 * <p>
 * This plan is used to implement SaveMode.Overwrite. The behavior of SaveMode.Overwrite is to
 * truncate the table -- delete all rows -- and append the output data set. This uses the filter
 * AlwaysTrue to delete all rows.
 */
public  class OverwriteByExpressionExecV1 extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements org.apache.spark.sql.execution.datasources.v2.V1FallbackWriters, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.SupportsWrite table ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan ()  { throw new RuntimeException(); }
  public  scala.Function0<scala.runtime.BoxedUnit> refreshCache ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.V1Write write ()  { throw new RuntimeException(); }
  // not preceding
  public   OverwriteByExpressionExecV1 (org.apache.spark.sql.connector.catalog.SupportsWrite table, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan, scala.Function0<scala.runtime.BoxedUnit> refreshCache, org.apache.spark.sql.connector.write.V1Write write)  { throw new RuntimeException(); }
}
