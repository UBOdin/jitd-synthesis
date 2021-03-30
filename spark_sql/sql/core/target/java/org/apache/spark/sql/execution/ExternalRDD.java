package org.apache.spark.sql.execution;
public  class ExternalRDD<T extends java.lang.Object> extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements org.apache.spark.sql.catalyst.plans.logical.ObjectProducer, org.apache.spark.sql.catalyst.analysis.MultiInstanceRelation, scala.Product, scala.Serializable {
  static public <T extends java.lang.Object> org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.rdd.RDD<T> rdd, org.apache.spark.sql.SparkSession session, org.apache.spark.sql.Encoder<T> evidence$1)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr ()  { throw new RuntimeException(); }
  public  org.apache.spark.rdd.RDD<T> rdd ()  { throw new RuntimeException(); }
  // not preceding
  public   ExternalRDD (org.apache.spark.sql.catalyst.expressions.Attribute outputObjAttr, org.apache.spark.rdd.RDD<T> rdd, org.apache.spark.sql.SparkSession session)  { throw new RuntimeException(); }
  protected final  scala.collection.Seq<java.lang.Object> otherCopyArgs ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.ExternalRDD<T> newInstance ()  { throw new RuntimeException(); }
  protected  scala.collection.Iterator<java.lang.Object> stringArgs ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics computeStats ()  { throw new RuntimeException(); }
}
