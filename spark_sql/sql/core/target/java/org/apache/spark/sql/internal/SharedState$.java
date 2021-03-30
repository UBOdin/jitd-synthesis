package org.apache.spark.sql.internal;
public  class SharedState$ implements org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SharedState$ MODULE$ = null;
  public   SharedState$ ()  { throw new RuntimeException(); }
  /**
   * Determine the warehouse path using the key <code>spark.sql.warehouse.dir</code> in the {@link SparkConf}
   * or the initial options from the very first created SparkSession instance, and
   * <code>hive.metastore.warehouse.dir</code> in hadoop {@link Configuration}.
   * The priority order is:
   * s.s.w.d in initialConfigs
   *   > s.s.w.d in spark conf (user specified)
   *   > h.m.w.d in hadoop conf (user specified)
   *   > s.s.w.d in spark conf (default)
   * <p>
   * @return the resolved warehouse path.
   * @param sparkConf (undocumented)
   * @param hadoopConf (undocumented)
   * @param initialConfigs (undocumented)
   */
  public  java.lang.String resolveWarehousePath (org.apache.spark.SparkConf sparkConf, org.apache.hadoop.conf.Configuration hadoopConf, scala.collection.Map<java.lang.String, java.lang.String> initialConfigs)  { throw new RuntimeException(); }
  public  java.lang.String qualifyWarehousePath (org.apache.hadoop.conf.Configuration hadoopConf, java.lang.String warehousePath)  { throw new RuntimeException(); }
  public  void setWarehousePathConf (org.apache.spark.SparkConf sparkConf, org.apache.hadoop.conf.Configuration hadoopConf, java.lang.String warehousePath)  { throw new RuntimeException(); }
}
