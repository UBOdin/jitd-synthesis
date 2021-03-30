package org.apache.spark.sql.catalyst.expressions;
/**
 * A place holder used when printing expressions without debugging information such as the
 * expression id or the unresolved indicator.
 */
public  class PrettyAttribute extends org.apache.spark.sql.catalyst.expressions.Attribute implements org.apache.spark.sql.catalyst.expressions.Unevaluable, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  // not preceding
  public   PrettyAttribute (java.lang.String name, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public   PrettyAttribute (org.apache.spark.sql.catalyst.expressions.Attribute attribute)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String sql ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute withNullability (boolean newNullability)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute newInstance ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute withQualifier (scala.collection.Seq<java.lang.String> newQualifier)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute withName (java.lang.String newName)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute withMetadata (org.apache.spark.sql.types.Metadata newMetadata)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> qualifier ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.ExprId exprId ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute withExprId (org.apache.spark.sql.catalyst.expressions.ExprId newExprId)  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
}
