package org.apache.spark.sql.streaming.ui;
  class StreamingQueryStatisticsPage extends org.apache.spark.ui.WebUIPage implements org.apache.spark.internal.Logging {
  public   StreamingQueryStatisticsPage (org.apache.spark.sql.streaming.ui.StreamingQueryTab parent)  { throw new RuntimeException(); }
  public  scala.xml.NodeBuffer generateAggregatedCustomMetrics (org.apache.spark.sql.streaming.ui.StreamingQueryUIData query, long minBatchTime, long maxBatchTime, org.apache.spark.ui.JsCollector jsCollector)  { throw new RuntimeException(); }
  public  scala.xml.NodeBuffer generateAggregatedStateOperators (org.apache.spark.sql.streaming.ui.StreamingQueryUIData query, long minBatchTime, long maxBatchTime, org.apache.spark.ui.JsCollector jsCollector)  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.xml.Node> generateBasicInfo (org.apache.spark.sql.streaming.ui.StreamingQueryUIData uiData)  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.xml.Node> generateFormattedTimeTipStrings (scala.Tuple2<java.lang.Object, java.lang.Object>[] values)  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.xml.Node> generateLoadResources (javax.servlet.http.HttpServletRequest request)  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.xml.Node> generateStatTable (org.apache.spark.sql.streaming.ui.StreamingQueryUIData query)  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.xml.Node> generateTimeMap (scala.collection.Seq<java.lang.Object> times)  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.xml.Node> generateTimeTipStrings (scala.Tuple2<java.lang.Object, java.lang.Object>[] values)  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.xml.Node> generateTimeToValues (scala.Tuple2<java.lang.Object, java.util.Map<java.lang.String, java.lang.Long>>[] values)  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.xml.Node> generateWatermark (org.apache.spark.sql.streaming.ui.StreamingQueryUIData query, long minBatchTime, long maxBatchTime, org.apache.spark.ui.JsCollector jsCollector)  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.xml.Node> render (javax.servlet.http.HttpServletRequest request)  { throw new RuntimeException(); }
}
