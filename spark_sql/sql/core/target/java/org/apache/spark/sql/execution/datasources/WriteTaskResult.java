package org.apache.spark.sql.execution.datasources;
/** The result of a successful write task. */
public  class WriteTaskResult implements org.apache.spark.sql.connector.write.WriterCommitMessage, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.internal.io.FileCommitProtocol.TaskCommitMessage commitMsg ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.datasources.ExecutedWriteSummary summary ()  { throw new RuntimeException(); }
  // not preceding
  public   WriteTaskResult (org.apache.spark.internal.io.FileCommitProtocol.TaskCommitMessage commitMsg, org.apache.spark.sql.execution.datasources.ExecutedWriteSummary summary)  { throw new RuntimeException(); }
}
