package org.apache.spark.sql.catalyst.expressions;
/**
 * Add or replace a field by name.
 * <p>
 * We extend {@link Unevaluable} here to ensure that {@link UpdateFields} can include it as part of its
 * children, and thereby enable the analyzer to resolve and transform valExpr as necessary.
 */
public  class WithField extends org.apache.spark.sql.catalyst.expressions.Expression implements org.apache.spark.sql.catalyst.expressions.Unevaluable, org.apache.spark.sql.catalyst.expressions.StructFieldsOperation, scala.Product, scala.Serializable {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression valExpr ()  { throw new RuntimeException(); }
  // not preceding
  public   WithField (java.lang.String name, org.apache.spark.sql.catalyst.expressions.Expression valExpr)  { throw new RuntimeException(); }
  public  scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.types.StructField, org.apache.spark.sql.catalyst.expressions.Expression>> apply (scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.types.StructField, org.apache.spark.sql.catalyst.expressions.Expression>> values)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  public  java.lang.String prettyName ()  { throw new RuntimeException(); }
}
