package org.apache.spark.sql.catalyst.plans.logical;
/**
 * Type to keep track of Hive serde info
 */
public  class SerdeInfo implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.plans.logical.SerdeInfo empty ()  { throw new RuntimeException(); }
  static public  void checkSerdePropMerging (scala.collection.immutable.Map<java.lang.String, java.lang.String> props1, scala.collection.immutable.Map<java.lang.String, java.lang.String> props2)  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> storedAs ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.FormatClasses> formatClasses ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> serde ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> serdeProperties ()  { throw new RuntimeException(); }
  // not preceding
  public   SerdeInfo (scala.Option<java.lang.String> storedAs, scala.Option<org.apache.spark.sql.catalyst.plans.logical.FormatClasses> formatClasses, scala.Option<java.lang.String> serde, scala.collection.immutable.Map<java.lang.String, java.lang.String> serdeProperties)  { throw new RuntimeException(); }
  public  java.lang.String describe ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.SerdeInfo merge (org.apache.spark.sql.catalyst.plans.logical.SerdeInfo other)  { throw new RuntimeException(); }
}
