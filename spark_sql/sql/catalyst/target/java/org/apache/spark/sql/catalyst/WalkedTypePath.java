package org.apache.spark.sql.catalyst;
/**
 * This class records the paths the serializer and deserializer walk through to reach current path.
 * Note that this class adds new path in prior to recorded paths so it maintains
 * the paths as reverse order.
 */
public  class WalkedTypePath implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  // not preceding
  public   WalkedTypePath (scala.collection.Seq<java.lang.String> walkedPaths)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.WalkedTypePath recordRoot (java.lang.String className)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.WalkedTypePath recordOption (java.lang.String className)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.WalkedTypePath recordArray (java.lang.String elementClassName)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.WalkedTypePath recordMap (java.lang.String keyClassName, java.lang.String valueClassName)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.WalkedTypePath recordKeyForMap (java.lang.String keyClassName)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.WalkedTypePath recordValueForMap (java.lang.String valueClassName)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.WalkedTypePath recordField (java.lang.String className, java.lang.String fieldName)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> getPaths ()  { throw new RuntimeException(); }
}
