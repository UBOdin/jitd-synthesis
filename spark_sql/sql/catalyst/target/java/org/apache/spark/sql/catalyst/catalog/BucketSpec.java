package org.apache.spark.sql.catalyst.catalog;
/**
 * A container for bucketing information.
 * Bucketing is a technology for decomposing data sets into more manageable parts, and the number
 * of buckets is fixed so it does not fluctuate with data.
 * <p>
 * param:  numBuckets number of buckets.
 * param:  bucketColumnNames the names of the columns that used to generate the bucket id.
 * param:  sortColumnNames the names of the columns that used to sort data in each bucket.
 */
public  class BucketSpec implements org.apache.spark.sql.catalyst.SQLConfHelper, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3)  ;
  public  int numBuckets ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> bucketColumnNames ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> sortColumnNames ()  { throw new RuntimeException(); }
  // not preceding
  public   BucketSpec (int numBuckets, scala.collection.Seq<java.lang.String> bucketColumnNames, scala.collection.Seq<java.lang.String> sortColumnNames)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.mutable.LinkedHashMap<java.lang.String, java.lang.String> toLinkedHashMap ()  { throw new RuntimeException(); }
}
