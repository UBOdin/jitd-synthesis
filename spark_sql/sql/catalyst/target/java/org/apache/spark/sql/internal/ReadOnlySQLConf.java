package org.apache.spark.sql.internal;
/**
 * A readonly SQLConf that will be created by tasks running at the executor side. It reads the
 * configs from the local properties which are propagated from driver to executors.
 */
public  class ReadOnlySQLConf extends org.apache.spark.sql.internal.SQLConf {
  public   ReadOnlySQLConf (org.apache.spark.TaskContext context)  { throw new RuntimeException(); }
  public  void clear ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.internal.SQLConf clone ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.internal.SQLConf copy (scala.collection.Seq<scala.Tuple2<org.apache.spark.internal.config.ConfigEntry<?>, java.lang.Object>> entries)  { throw new RuntimeException(); }
  protected  org.apache.spark.internal.config.ConfigReader reader ()  { throw new RuntimeException(); }
  protected  void setConfWithCheck (java.lang.String key, java.lang.String value)  { throw new RuntimeException(); }
  public  java.util.Map<java.lang.String, java.lang.String> settings ()  { throw new RuntimeException(); }
  public  void unsetConf (java.lang.String key)  { throw new RuntimeException(); }
  public  void unsetConf (org.apache.spark.internal.config.ConfigEntry<?> entry)  { throw new RuntimeException(); }
}
