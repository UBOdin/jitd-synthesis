package org.apache.spark.sql.execution.joins;
/**
 * A HashedRelation for UnsafeRow, which is backed BytesToBytesMap.
 * <p>
 * It's serialized in the following format:
 *  [number of keys]
 *  [size of key] [size of value] [key bytes] [bytes for value]
 */
  class UnsafeHashedRelation implements org.apache.spark.sql.execution.joins.HashedRelation, java.io.Externalizable, com.esotericsoftware.kryo.KryoSerializable {
  static public  org.apache.spark.sql.execution.joins.HashedRelation apply (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> input, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> key, int sizeEstimate, org.apache.spark.memory.TaskMemoryManager taskMemoryManager, boolean isNullAware, boolean allowsNullKey)  { throw new RuntimeException(); }
  // not preceding
  public   UnsafeHashedRelation (int numKeys, int numFields, org.apache.spark.unsafe.map.BytesToBytesMap binaryMap)  { throw new RuntimeException(); }
     UnsafeHashedRelation ()  { throw new RuntimeException(); }
  public  boolean keyIsUnique ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.joins.UnsafeHashedRelation asReadOnlyCopy ()  { throw new RuntimeException(); }
  public  long estimatedSize ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.UnsafeRow resultRow ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.joins.ValueRowWithKeyIndex valueRowWithKeyIndex ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> get (org.apache.spark.sql.catalyst.InternalRow key)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow getValue (org.apache.spark.sql.catalyst.InternalRow key)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.execution.joins.ValueRowWithKeyIndex> getWithKeyIndex (org.apache.spark.sql.catalyst.InternalRow key)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.joins.ValueRowWithKeyIndex getValueWithKeyIndex (org.apache.spark.sql.catalyst.InternalRow key)  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.execution.joins.ValueRowWithKeyIndex> valuesWithKeyIndex ()  { throw new RuntimeException(); }
  public  int maxNumKeysIndex ()  { throw new RuntimeException(); }
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> keys ()  { throw new RuntimeException(); }
  public  void close ()  { throw new RuntimeException(); }
  public  void writeExternal (java.io.ObjectOutput out)  { throw new RuntimeException(); }
  public  void write (com.esotericsoftware.kryo.Kryo kryo, com.esotericsoftware.kryo.io.Output out)  { throw new RuntimeException(); }
  public  void readExternal (java.io.ObjectInput in)  { throw new RuntimeException(); }
  public  void read (com.esotericsoftware.kryo.Kryo kryo, com.esotericsoftware.kryo.io.Input in)  { throw new RuntimeException(); }
}
