package org.apache.spark.sql.catalyst.analysis;
/**
 * A plan containing resolved (temp) views.
 */
public  class ResolvedView extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Identifier identifier ()  { throw new RuntimeException(); }
  public  boolean isTemp ()  { throw new RuntimeException(); }
  // not preceding
  public   ResolvedView (org.apache.spark.sql.connector.catalog.Identifier identifier, boolean isTemp)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
