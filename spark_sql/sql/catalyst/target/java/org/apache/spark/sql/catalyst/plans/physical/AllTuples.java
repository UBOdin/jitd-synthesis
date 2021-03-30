package org.apache.spark.sql.catalyst.plans.physical;
/**
 * Represents a distribution that only has a single partition and all tuples of the dataset
 * are co-located.
 */
public  class AllTuples {
  static public  scala.Option<java.lang.Object> requiredNumPartitions ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.plans.physical.Partitioning createPartitioning (int numPartitions)  { throw new RuntimeException(); }
  static public abstract  boolean canEqual (Object that)  ;
  static public abstract  boolean equals (Object that)  ;
  static public abstract  Object productElement (int n)  ;
  static public abstract  int productArity ()  ;
  static public  scala.collection.Iterator<java.lang.Object> productIterator ()  { throw new RuntimeException(); }
  static public  java.lang.String productPrefix ()  { throw new RuntimeException(); }
}
