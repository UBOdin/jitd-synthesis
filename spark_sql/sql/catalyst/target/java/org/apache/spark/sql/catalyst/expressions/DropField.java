package org.apache.spark.sql.catalyst.expressions;
/**
 * Drop a field by name.
 */
public  class DropField implements org.apache.spark.sql.catalyst.expressions.StructFieldsOperation, scala.Product, scala.Serializable {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  // not preceding
  public   DropField (java.lang.String name)  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.types.StructField, org.apache.spark.sql.catalyst.expressions.Expression>> apply (scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.types.StructField, org.apache.spark.sql.catalyst.expressions.Expression>> values)  { throw new RuntimeException(); }
}
