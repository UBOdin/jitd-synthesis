package org.apache.spark.sql.execution;
/**
 * Helper functions for physical operators that work with user defined objects.
 */
public  class ObjectOperator {
  static public  scala.Function1<org.apache.spark.sql.catalyst.InternalRow, java.lang.Object> deserializeRowToObject (org.apache.spark.sql.catalyst.expressions.Expression deserializer, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  static public  scala.Function1<org.apache.spark.sql.catalyst.InternalRow, java.lang.Object> deserializeRowToObject (org.apache.spark.sql.catalyst.expressions.Expression deserializer)  { throw new RuntimeException(); }
  static public  scala.Function1<java.lang.Object, org.apache.spark.sql.catalyst.expressions.UnsafeRow> serializeObjectToRow (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> serializer)  { throw new RuntimeException(); }
  static public  scala.Function1<java.lang.Object, org.apache.spark.sql.catalyst.InternalRow> wrapObjectToRow (org.apache.spark.sql.types.DataType objType)  { throw new RuntimeException(); }
  static public  scala.Function1<org.apache.spark.sql.catalyst.InternalRow, java.lang.Object> unwrapObjectFromRow (org.apache.spark.sql.types.DataType objType)  { throw new RuntimeException(); }
}
