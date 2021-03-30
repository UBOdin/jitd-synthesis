package org.apache.spark.sql.catalyst.plans.logical;
public  class Range extends org.apache.spark.sql.catalyst.plans.logical.LeafNode implements org.apache.spark.sql.catalyst.analysis.MultiInstanceRelation, scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.plans.logical.Range apply (long start, long end, long step, scala.Option<java.lang.Object> numSlices, boolean isStreaming)  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.logical.Range apply (long start, long end, long step, int numSlices)  { throw new RuntimeException(); }
  public  long start ()  { throw new RuntimeException(); }
  public  long end ()  { throw new RuntimeException(); }
  public  long step ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> numSlices ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  boolean isStreaming ()  { throw new RuntimeException(); }
  // not preceding
  public   Range (long start, long end, long step, scala.Option<java.lang.Object> numSlices, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, boolean isStreaming)  { throw new RuntimeException(); }
  public  scala.math.BigInt numElements ()  { throw new RuntimeException(); }
  public  java.lang.String toSQL ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Range newInstance ()  { throw new RuntimeException(); }
  public  java.lang.String simpleString (int maxFields)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> maxRows ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Statistics computeStats ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  { throw new RuntimeException(); }
}
