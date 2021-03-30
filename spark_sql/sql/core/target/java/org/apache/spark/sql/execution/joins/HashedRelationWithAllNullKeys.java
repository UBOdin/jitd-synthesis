package org.apache.spark.sql.execution.joins;
/**
 * A special HashedRelation indicating that it's built from a non-empty input:Iterator[InternalRow]
 * with all the keys to be null.
 */
public  class HashedRelationWithAllNullKeys {
  static public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> get (org.apache.spark.sql.catalyst.InternalRow key)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.InternalRow getValue (org.apache.spark.sql.catalyst.InternalRow key)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.joins.HashedRelationWithAllNullKeys$ asReadOnlyCopy ()  { throw new RuntimeException(); }
  static public  boolean keyIsUnique ()  { throw new RuntimeException(); }
  static public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> keys ()  { throw new RuntimeException(); }
  static public  void close ()  { throw new RuntimeException(); }
  static public  long estimatedSize ()  { throw new RuntimeException(); }
  static public  scala.collection.Iterator<org.apache.spark.sql.execution.joins.ValueRowWithKeyIndex> getWithKeyIndex (org.apache.spark.sql.catalyst.InternalRow key)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.joins.ValueRowWithKeyIndex getValueWithKeyIndex (org.apache.spark.sql.catalyst.InternalRow key)  { throw new RuntimeException(); }
  static public  scala.collection.Iterator<org.apache.spark.sql.execution.joins.ValueRowWithKeyIndex> valuesWithKeyIndex ()  { throw new RuntimeException(); }
  static public  int maxNumKeysIndex ()  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
}
