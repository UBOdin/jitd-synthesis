package org.apache.spark.sql.streaming.ui;
  class StreamingQueryPagedTable implements org.apache.spark.ui.PagedTable<org.apache.spark.sql.streaming.ui.StructuredStreamingRow> {
  public   StreamingQueryPagedTable (javax.servlet.http.HttpServletRequest request, org.apache.spark.sql.streaming.ui.StreamingQueryTab parent, scala.collection.Seq<org.apache.spark.sql.streaming.ui.StreamingQueryUIData> data, java.lang.String tableTag, boolean isActive, java.lang.String basePath, java.lang.String subPath)  { throw new RuntimeException(); }
  public  org.apache.spark.ui.PagedDataSource<org.apache.spark.sql.streaming.ui.StructuredStreamingRow> dataSource ()  { throw new RuntimeException(); }
  public  java.lang.String goButtonFormPath ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.xml.Node> headers ()  { throw new RuntimeException(); }
  public  java.lang.String pageLink (int page)  { throw new RuntimeException(); }
  public  java.lang.String pageNumberFormField ()  { throw new RuntimeException(); }
  public  java.lang.String pageSizeFormField ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.xml.Node> row (org.apache.spark.sql.streaming.ui.StructuredStreamingRow query)  { throw new RuntimeException(); }
  public  java.lang.String tableCssClass ()  { throw new RuntimeException(); }
  public  java.lang.String tableId ()  { throw new RuntimeException(); }
}
