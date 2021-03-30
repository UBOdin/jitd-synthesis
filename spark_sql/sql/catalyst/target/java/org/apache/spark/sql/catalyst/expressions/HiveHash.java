package org.apache.spark.sql.catalyst.expressions;
/**
 * Simulates Hive's hashing function from Hive v1.2.1 at
 * org.apache.hadoop.hive.serde2.objectinspector.ObjectInspectorUtils#hashcode()
 * <p>
 * We should use this hash function for both shuffle and bucket of Hive tables, so that
 * we can guarantee shuffle and bucketing have same data distribution
 */
public  class HiveHash extends org.apache.spark.sql.catalyst.expressions.HashExpression<java.lang.Object> implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public   HiveHash (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  public  int seed ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
  protected  java.lang.String hasherClassName ()  { throw new RuntimeException(); }
  protected  int computeHash (Object value, org.apache.spark.sql.types.DataType dataType, int seed)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.codegen.ExprCode doGenCode (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode ev)  { throw new RuntimeException(); }
  public  int eval (org.apache.spark.sql.catalyst.InternalRow input)  { throw new RuntimeException(); }
  protected  java.lang.String genHashInt (java.lang.String i, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashLong (java.lang.String l, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashBytes (java.lang.String b, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashDecimal (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, org.apache.spark.sql.types.DecimalType d, java.lang.String input, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashCalendarInterval (java.lang.String input, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashTimestamp (java.lang.String input, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashString (java.lang.String input, java.lang.String result)  { throw new RuntimeException(); }
  protected  java.lang.String genHashForArray (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, java.lang.String input, java.lang.String result, org.apache.spark.sql.types.DataType elementType, boolean containsNull)  { throw new RuntimeException(); }
  protected  java.lang.String genHashForMap (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, java.lang.String input, java.lang.String result, org.apache.spark.sql.types.DataType keyType, org.apache.spark.sql.types.DataType valueType, boolean valueContainsNull)  { throw new RuntimeException(); }
  protected  java.lang.String genHashForStruct (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, java.lang.String input, java.lang.String result, org.apache.spark.sql.types.StructField[] fields)  { throw new RuntimeException(); }
}
