package org.apache.spark.sql.connector.expressions;
 final class IdentityTransform extends org.apache.spark.sql.connector.expressions.SingleColumnTransform implements scala.Product, scala.Serializable {
  static public  scala.Option<org.apache.spark.sql.connector.expressions.FieldReference> unapply (org.apache.spark.sql.connector.expressions.Expression expr)  { throw new RuntimeException(); }
  static public  scala.Option<org.apache.spark.sql.connector.expressions.FieldReference> unapply (org.apache.spark.sql.connector.expressions.Transform transform)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.NamedReference ref ()  { throw new RuntimeException(); }
  // not preceding
  public   IdentityTransform (org.apache.spark.sql.connector.expressions.NamedReference ref)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  java.lang.String describe ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.connector.expressions.Transform withNewRef (org.apache.spark.sql.connector.expressions.NamedReference ref)  { throw new RuntimeException(); }
}
