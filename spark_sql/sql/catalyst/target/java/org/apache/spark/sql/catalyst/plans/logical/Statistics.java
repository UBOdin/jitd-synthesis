package org.apache.spark.sql.catalyst.plans.logical;
public  class Statistics implements scala.Product, scala.Serializable {
  // not preceding
  static public  org.apache.spark.sql.catalyst.plans.logical.Statistics DUMMY ()  { throw new RuntimeException(); }
  public  scala.math.BigInt sizeInBytes ()  { throw new RuntimeException(); }
  public  scala.Option<scala.math.BigInt> rowCount ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> attributeStats ()  { throw new RuntimeException(); }
  public   Statistics (scala.math.BigInt sizeInBytes, scala.Option<scala.math.BigInt> rowCount, org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.plans.logical.ColumnStat> attributeStats)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  /** Readable string representation for the Statistics. */
  public  java.lang.String simpleString ()  { throw new RuntimeException(); }
}
