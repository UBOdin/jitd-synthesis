package org.apache.spark.sql.catalyst.expressions;
/**
 * An interpreted row ordering comparator.
 */
public  class InterpretedOrdering extends org.apache.spark.sql.catalyst.expressions.BaseOrdering {
  /**
   * Creates a {@link InterpretedOrdering} for the given schema, in natural ascending order.
   * @param dataTypes (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.expressions.InterpretedOrdering forSchema (scala.collection.Seq<org.apache.spark.sql.types.DataType> dataTypes)  { throw new RuntimeException(); }
  public   InterpretedOrdering (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering)  { throw new RuntimeException(); }
  public   InterpretedOrdering (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> ordering, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  public  int compare (org.apache.spark.sql.catalyst.InternalRow a, org.apache.spark.sql.catalyst.InternalRow b)  { throw new RuntimeException(); }
}
