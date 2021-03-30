package org.apache.spark.sql.connector.expressions;
 final class BucketTransform implements org.apache.spark.sql.connector.expressions.RewritableTransform, scala.Product, scala.Serializable {
  static public  scala.Option<scala.Tuple2<java.lang.Object, org.apache.spark.sql.connector.expressions.FieldReference>> unapply (org.apache.spark.sql.connector.expressions.Expression expr)  { throw new RuntimeException(); }
  static public  scala.Option<scala.Tuple2<java.lang.Object, org.apache.spark.sql.connector.expressions.NamedReference>> unapply (org.apache.spark.sql.connector.expressions.Transform transform)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.Literal<java.lang.Object> numBuckets ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.connector.expressions.NamedReference> columns ()  { throw new RuntimeException(); }
  // not preceding
  public   BucketTransform (org.apache.spark.sql.connector.expressions.Literal<java.lang.Object> numBuckets, scala.collection.Seq<org.apache.spark.sql.connector.expressions.NamedReference> columns)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.NamedReference[] references ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.Expression[] arguments ()  { throw new RuntimeException(); }
  public  java.lang.String describe ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.Transform withReferences (scala.collection.Seq<org.apache.spark.sql.connector.expressions.NamedReference> newReferences)  { throw new RuntimeException(); }
}
