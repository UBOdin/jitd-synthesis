package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for overwrite into a v2 table.
 * <p>
 * Overwrites data in a table matched by a set of filters. Rows matching all of the filters will be
 * deleted and rows in the output data set are appended.
 * <p>
 * This plan is used to implement SaveMode.Overwrite. The behavior of SaveMode.Overwrite is to
 * truncate the table -- delete all rows -- and append the output data set. This uses the filter
 * AlwaysTrue to delete all rows.
 */
public  class OverwriteByExpressionExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements org.apache.spark.sql.execution.datasources.v2.V2ExistingTableWriteExec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.execution.datasources.v2.StreamWriterCommitProgress> commitProgress ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan query ()  { throw new RuntimeException(); }
  public  scala.Function0<scala.runtime.BoxedUnit> refreshCache ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.Write write ()  { throw new RuntimeException(); }
  // not preceding
  public   OverwriteByExpressionExec (org.apache.spark.sql.execution.SparkPlan query, scala.Function0<scala.runtime.BoxedUnit> refreshCache, org.apache.spark.sql.connector.write.Write write)  { throw new RuntimeException(); }
}
