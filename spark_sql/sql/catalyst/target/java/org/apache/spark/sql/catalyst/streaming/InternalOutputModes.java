package org.apache.spark.sql.catalyst.streaming;
/**
 * Internal helper class to generate objects representing various <code>OutputMode</code>s,
 */
public  class InternalOutputModes {
  /**
   * OutputMode in which only the new rows in the streaming DataFrame/Dataset will be
   * written to the sink. This output mode can be only be used in queries that do not
   * contain any aggregation.
   */
  static public  class Append$ extends org.apache.spark.sql.streaming.OutputMode implements scala.Product, scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Append$ MODULE$ = null;
    public   Append$ ()  { throw new RuntimeException(); }
  }
  /**
   * OutputMode in which all the rows in the streaming DataFrame/Dataset will be written
   * to the sink every time these is some updates. This output mode can only be used in queries
   * that contain aggregations.
   */
  static public  class Complete$ extends org.apache.spark.sql.streaming.OutputMode implements scala.Product, scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Complete$ MODULE$ = null;
    public   Complete$ ()  { throw new RuntimeException(); }
  }
  /**
   * OutputMode in which only the rows in the streaming DataFrame/Dataset that were updated will be
   * written to the sink every time these is some updates. If the query doesn't contain
   * aggregations, it will be equivalent to <code>Append</code> mode.
   */
  static public  class Update$ extends org.apache.spark.sql.streaming.OutputMode implements scala.Product, scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final Update$ MODULE$ = null;
    public   Update$ ()  { throw new RuntimeException(); }
  }
  static public  org.apache.spark.sql.streaming.OutputMode apply (java.lang.String outputMode)  { throw new RuntimeException(); }
}
