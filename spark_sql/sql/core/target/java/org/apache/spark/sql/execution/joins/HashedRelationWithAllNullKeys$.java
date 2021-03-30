package org.apache.spark.sql.execution.joins;
/**
 * A special HashedRelation indicating that it's built from a non-empty input:Iterator[InternalRow]
 * with all the keys to be null.
 */
public  class HashedRelationWithAllNullKeys$ implements org.apache.spark.sql.execution.joins.HashedRelation, scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final HashedRelationWithAllNullKeys$ MODULE$ = null;
  public   HashedRelationWithAllNullKeys$ ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> get (org.apache.spark.sql.catalyst.InternalRow key)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow getValue (org.apache.spark.sql.catalyst.InternalRow key)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.joins.HashedRelationWithAllNullKeys$ asReadOnlyCopy ()  { throw new RuntimeException(); }
  public  boolean keyIsUnique ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> keys ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  long estimatedSize ()  { throw new RuntimeException(); }
}
