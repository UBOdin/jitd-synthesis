package org.apache.spark.sql.catalyst.plans.logical;
public  class LocalRelation extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements org.apache.spark.sql.catalyst.analysis.MultiInstanceRelation, scala.Product, scala.Serializable {
  // not preceding
  static public  org.apache.spark.sql.catalyst.plans.logical.LocalRelation apply (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.logical.LocalRelation apply (org.apache.spark.sql.types.StructField output1, scala.collection.Seq<org.apache.spark.sql.types.StructField> output)  { throw new RuntimeException(); }
  // not preceding
  static public  org.apache.spark.sql.catalyst.plans.logical.LocalRelation fromExternalRows (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, scala.collection.Seq<org.apache.spark.sql.Row> data)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.logical.LocalRelation fromProduct (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, scala.collection.Seq<scala.Product> data)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> data ()  { throw new RuntimeException(); }
  public  boolean isStreaming ()  { throw new RuntimeException(); }
  public   LocalRelation (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, scala.collection.Seq<org.apache.spark.sql.catalyst.InternalRow> data, boolean isStreaming)  { throw new RuntimeException(); }
  /**
   * Returns an identical copy of this relation with new exprIds for all attributes.  Different
   * attributes are required when a relation is going to be included multiple times in the same
   * query.
   * @return (undocumented)
   */
  public final  org.apache.spark.sql.catalyst.plans.logical.LocalRelation newInstance ()  { throw new RuntimeException(); }
  protected  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics computeStats ()  { throw new RuntimeException(); }
  public  java.lang.String toSQL (java.lang.String inlineTableName)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> maxRows ()  { throw new RuntimeException(); }
}
