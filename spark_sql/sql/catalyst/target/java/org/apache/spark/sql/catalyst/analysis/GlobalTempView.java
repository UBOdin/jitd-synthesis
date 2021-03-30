package org.apache.spark.sql.catalyst.analysis;
/**
 * GlobalTempView means cross-session global temporary views. Its lifetime is the lifetime of the
 * Spark application, i.e. it will be automatically dropped when the application terminates. It's
 * tied to a system preserved database <code>global_temp</code>, and we must use the qualified name to refer a
 * global temp view, e.g. SELECT * FROM global_temp.view1.
 */
public  class GlobalTempView {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
}
