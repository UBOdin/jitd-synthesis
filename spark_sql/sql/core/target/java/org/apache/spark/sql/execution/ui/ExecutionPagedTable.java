package org.apache.spark.sql.execution.ui;
  class ExecutionPagedTable implements org.apache.spark.ui.PagedTable<org.apache.spark.sql.execution.ui.ExecutionTableRowData> {
  public   ExecutionPagedTable (javax.servlet.http.HttpServletRequest request, org.apache.spark.sql.execution.ui.SQLTab parent, scala.collection.Seq<org.apache.spark.sql.execution.ui.SQLExecutionUIData> data, java.lang.String tableHeaderId, java.lang.String executionTag, java.lang.String basePath, java.lang.String subPath, long currentTime, boolean showRunningJobs, boolean showSucceededJobs, boolean showFailedJobs)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.ui.ExecutionDataSource dataSource ()  { throw new RuntimeException(); }
  public  java.lang.String goButtonFormPath ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.xml.Node> headers ()  { throw new RuntimeException(); }
  public  java.lang.String pageLink (int page)  { throw new RuntimeException(); }
  public  java.lang.String pageNumberFormField ()  { throw new RuntimeException(); }
  public  java.lang.String pageSizeFormField ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.xml.Node> row (org.apache.spark.sql.execution.ui.ExecutionTableRowData executionTableRow)  { throw new RuntimeException(); }
  public  java.lang.String tableCssClass ()  { throw new RuntimeException(); }
  public  java.lang.String tableId ()  { throw new RuntimeException(); }
}
