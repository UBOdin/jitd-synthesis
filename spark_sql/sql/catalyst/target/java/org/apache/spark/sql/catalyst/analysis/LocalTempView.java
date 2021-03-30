package org.apache.spark.sql.catalyst.analysis;
/**
 * LocalTempView means session-scoped local temporary views. Its lifetime is the lifetime of the
 * session that created it, i.e. it will be automatically dropped when the session terminates. It's
 * not tied to any databases, i.e. we can't use <code>db1.view1</code> to reference a local temporary view.
 */
public  class LocalTempView {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
}
