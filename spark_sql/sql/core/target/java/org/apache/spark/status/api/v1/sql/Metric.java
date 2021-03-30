package org.apache.spark.status.api.v1.sql;
public  class Metric implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  java.lang.String value ()  { throw new RuntimeException(); }
  // not preceding
     Metric (java.lang.String name, java.lang.String value)  { throw new RuntimeException(); }
}
