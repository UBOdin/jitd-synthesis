package org.apache.spark.sql.catalyst.analysis;
/**
 * LocalTempView means session-scoped local temporary views. Its lifetime is the lifetime of the
 * session that created it, i.e. it will be automatically dropped when the session terminates. It's
 * not tied to any databases, i.e. we can't use <code>db1.view1</code> to reference a local temporary view.
 */
public  class LocalTempView$ implements org.apache.spark.sql.catalyst.analysis.ViewType {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final LocalTempView$ MODULE$ = null;
  public   LocalTempView$ ()  { throw new RuntimeException(); }
}
