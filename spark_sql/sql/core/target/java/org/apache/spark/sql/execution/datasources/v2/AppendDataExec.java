package org.apache.spark.sql.execution.datasources.v2;
/**
 * Physical plan node for append into a v2 table.
 * <p>
 * Rows in the output data set are appended.
 */
public  class AppendDataExec extends org.apache.spark.sql.execution.datasources.v2.V2CommandExec implements org.apache.spark.sql.execution.datasources.v2.V2ExistingTableWriteExec, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.execution.datasources.v2.StreamWriterCommitProgress> commitProgress ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan query ()  { throw new RuntimeException(); }
  public  scala.Function0<scala.runtime.BoxedUnit> refreshCache ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.write.Write write ()  { throw new RuntimeException(); }
  // not preceding
  public   AppendDataExec (org.apache.spark.sql.execution.SparkPlan query, scala.Function0<scala.runtime.BoxedUnit> refreshCache, org.apache.spark.sql.connector.write.Write write)  { throw new RuntimeException(); }
}
