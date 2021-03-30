package org.apache.spark.sql.hive;
/**
 * Object to synchronize on when calling org.apache.hadoop.hive.serde2.Deserializer#initialize.
 * <p>
 * [SPARK-17398] org.apache.hive.hcatalog.data.JsonSerDe#initialize calls the non-thread-safe
 * HCatRecordObjectInspectorFactory.getHCatRecordObjectInspector, the results of which are
 * returned by JsonSerDe#getObjectInspector.
 * To protect against this bug in Hive (HIVE-15773/HIVE-21752), we synchronize on this object
 * when calling initialize on Deserializer instances that could be JsonSerDe instances.
 */
public  class DeserializerLock$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DeserializerLock$ MODULE$ = null;
  public   DeserializerLock$ ()  { throw new RuntimeException(); }
}
