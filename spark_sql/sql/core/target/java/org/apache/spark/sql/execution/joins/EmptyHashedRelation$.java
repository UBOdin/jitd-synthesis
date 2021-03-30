package org.apache.spark.sql.execution.joins;
/**
 * A special HashedRelation indicating that it's built from a empty input:Iterator[InternalRow].
 * get &amp; getValue will return null just like
 * empty LongHashedRelation or empty UnsafeHashedRelation does.
 */
public  class EmptyHashedRelation$ implements org.apache.spark.sql.execution.joins.HashedRelation, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final EmptyHashedRelation$ MODULE$ = null;
  public   EmptyHashedRelation$ ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> get (long key)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> get (org.apache.spark.sql.catalyst.InternalRow key)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow getValue (long key)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow getValue (org.apache.spark.sql.catalyst.InternalRow key)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.joins.EmptyHashedRelation$ asReadOnlyCopy ()  { throw new RuntimeException(); }
  public  boolean keyIsUnique ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> keys ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  long estimatedSize ()  { throw new RuntimeException(); }
}
