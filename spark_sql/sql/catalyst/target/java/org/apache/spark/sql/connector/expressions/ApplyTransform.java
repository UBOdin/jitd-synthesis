package org.apache.spark.sql.connector.expressions;
 final class ApplyTransform implements org.apache.spark.sql.connector.expressions.Transform, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.connector.expressions.Expression> args ()  { throw new RuntimeException(); }
  // not preceding
  public   ApplyTransform (java.lang.String name, scala.collection.Seq<org.apache.spark.sql.connector.expressions.Expression> args)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.Expression[] arguments ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.expressions.NamedReference[] references ()  { throw new RuntimeException(); }
  public  java.lang.String describe ()  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
