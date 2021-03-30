package org.apache.spark.sql.execution.ui;
  class ExecutionDataSource extends org.apache.spark.ui.PagedDataSource<org.apache.spark.sql.execution.ui.ExecutionTableRowData> {
  public   ExecutionDataSource (scala.collection.Seq<org.apache.spark.sql.execution.ui.SQLExecutionUIData> executionData, long currentTime, int pageSize, java.lang.String sortColumn, boolean desc, boolean showRunningJobs, boolean showSucceededJobs, boolean showFailedJobs)  { throw new RuntimeException(); }
  public  int dataSize ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.execution.ui.ExecutionTableRowData> sliceData (int from, int to)  { throw new RuntimeException(); }
}
