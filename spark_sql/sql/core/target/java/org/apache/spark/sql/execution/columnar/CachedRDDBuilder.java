package org.apache.spark.sql.execution.columnar;
  class CachedRDDBuilder implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.columnar.CachedBatchSerializer serializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.storage.StorageLevel storageLevel ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan cachedPlan ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> tableName ()  { throw new RuntimeException(); }
  // not preceding
  public   CachedRDDBuilder (org.apache.spark.sql.columnar.CachedBatchSerializer serializer, org.apache.spark.storage.StorageLevel storageLevel, org.apache.spark.sql.execution.SparkPlan cachedPlan, scala.Option<java.lang.String> tableName)  { throw new RuntimeException(); }
  public  org.apache.spark.util.LongAccumulator sizeInBytesStats ()  { throw new RuntimeException(); }
  public  org.apache.spark.util.LongAccumulator rowCountStats ()  { throw new RuntimeException(); }
  public  java.lang.String cachedName ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.columnar.CachedBatch> cachedColumnBuffers ()  { throw new RuntimeException(); }
  public  void clearCache (boolean blocking)  { throw new RuntimeException(); }
  public  boolean isCachedColumnBuffersLoaded ()  { throw new RuntimeException(); }
}
