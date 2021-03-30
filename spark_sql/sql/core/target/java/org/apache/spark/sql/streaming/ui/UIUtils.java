package org.apache.spark.sql.streaming.ui;
public  class UIUtils {
  /**
   * Check whether <code>number</code> is valid, if not return 0.0d
   * @param number (undocumented)
   * @return (undocumented)
   */
  static public  double withNumberInvalid (scala.Function0<java.lang.Object> number)  { throw new RuntimeException(); }
  /**
   * Execute a block of code when there is already one completed batch in streaming query,
   * otherwise return <code>default</code> value.
   * @param query (undocumented)
   * @param body (undocumented)
   * @param default_ (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> T withNoProgress (org.apache.spark.sql.streaming.ui.StreamingQueryUIData query, scala.Function0<T> body, T default_)  { throw new RuntimeException(); }
  static public  java.lang.String getQueryName (org.apache.spark.sql.streaming.ui.StreamingQueryUIData uiData)  { throw new RuntimeException(); }
  static public  java.lang.String getQueryStatus (org.apache.spark.sql.streaming.ui.StreamingQueryUIData uiData)  { throw new RuntimeException(); }
  static public  long parseProgressTimestamp (java.lang.String timestamp)  { throw new RuntimeException(); }
}
