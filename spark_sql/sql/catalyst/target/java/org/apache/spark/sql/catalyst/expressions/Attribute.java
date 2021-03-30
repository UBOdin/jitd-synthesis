package org.apache.spark.sql.catalyst.expressions;
public abstract class Attribute extends org.apache.spark.sql.catalyst.expressions.LeafExpression implements org.apache.spark.sql.catalyst.expressions.NamedExpression, org.apache.spark.sql.catalyst.expressions.NullIntolerant {
  public   Attribute ()  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.catalyst.expressions.Attribute newInstance ()  ;
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute toAttribute ()  { throw new RuntimeException(); }
  public abstract  org.apache.spark.sql.catalyst.expressions.Attribute withExprId (org.apache.spark.sql.catalyst.expressions.ExprId newExprId)  ;
  public abstract  org.apache.spark.sql.catalyst.expressions.Attribute withMetadata (org.apache.spark.sql.types.Metadata newMetadata)  ;
  public abstract  org.apache.spark.sql.catalyst.expressions.Attribute withName (java.lang.String newName)  ;
  public abstract  org.apache.spark.sql.catalyst.expressions.Attribute withNullability (boolean newNullability)  ;
  public abstract  org.apache.spark.sql.catalyst.expressions.Attribute withQualifier (scala.collection.Seq<java.lang.String> newQualifier)  ;
}
