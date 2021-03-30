package org.apache.spark.sql.execution.joins;
/**
 * Interface for a hashed relation by some key. Use {@link HashedRelation.apply} to create a concrete
 * object.
 */
public  interface HashedRelation extends org.apache.spark.util.KnownSizeEstimation {
  /**
   * Returns matched rows.
   * <p>
   * Returns null if there is no matched rows.
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> get (org.apache.spark.sql.catalyst.InternalRow key)  ;
  /**
   * Returns matched rows for a key that has only one column with LongType.
   * <p>
   * Returns null if there is no matched rows.
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> get (long key)  ;
  /**
   * Returns the matched single row.
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.InternalRow getValue (org.apache.spark.sql.catalyst.InternalRow key)  ;
  /**
   * Returns the matched single row with key that have only one column of LongType.
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.InternalRow getValue (long key)  ;
  /**
   * Returns an iterator for key index and matched rows.
   * <p>
   * Returns null if there is no matched rows.
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.execution.joins.ValueRowWithKeyIndex> getWithKeyIndex (org.apache.spark.sql.catalyst.InternalRow key)  ;
  /**
   * Returns key index and matched single row.
   * This is for unique key case.
   * <p>
   * Returns null if there is no matched rows.
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.joins.ValueRowWithKeyIndex getValueWithKeyIndex (org.apache.spark.sql.catalyst.InternalRow key)  ;
  /**
   * Returns an iterator for keys index and rows of InternalRow type.
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.execution.joins.ValueRowWithKeyIndex> valuesWithKeyIndex ()  ;
  /**
   * Returns the maximum number of allowed keys index.
   * @return (undocumented)
   */
  public  int maxNumKeysIndex ()  ;
  /**
   * Returns true iff all the keys are unique.
   * @return (undocumented)
   */
  public  boolean keyIsUnique ()  ;
  /**
   * Returns an iterator for keys of InternalRow type.
   * @return (undocumented)
   */
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> keys ()  ;
  /**
   * Returns a read-only copy of this, to be safely used in current thread.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.execution.joins.HashedRelation asReadOnlyCopy ()  ;
  /**
   * Release any used resources.
   */
  public  void close ()  ;
}
