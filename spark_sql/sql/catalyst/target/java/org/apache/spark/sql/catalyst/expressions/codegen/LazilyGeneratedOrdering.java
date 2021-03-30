package org.apache.spark.sql.catalyst.expressions.codegen;
/**
 * A lazily generated row ordering comparator.
 */
public  class LazilyGeneratedOrdering implements scala.math.Ordering<org.apache.spark.sql.catalyst.InternalRow>, com.esotericsoftware.kryo.KryoSerializable {
  /**
   * Creates a {@link LazilyGeneratedOrdering} for the given schema, in natural ascending order.
   * @param schema (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.expressions.codegen.LazilyGeneratedOrdering forSchema (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering ()  { throw new RuntimeException(); }
  // not preceding
  public   LazilyGeneratedOrdering (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering)  { throw new RuntimeException(); }
  public   LazilyGeneratedOrdering (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  public  int compare (org.apache.spark.sql.catalyst.InternalRow a, org.apache.spark.sql.catalyst.InternalRow b)  { throw new RuntimeException(); }
  public  void write (com.esotericsoftware.kryo.Kryo kryo, com.esotericsoftware.kryo.io.Output out)  { throw new RuntimeException(); }
  public  void read (com.esotericsoftware.kryo.Kryo kryo, com.esotericsoftware.kryo.io.Input in)  { throw new RuntimeException(); }
}
