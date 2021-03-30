package org.apache.spark.sql.catalyst.optimizer;
/**
 * This class defines the cost model for a plan.
 * param:  card Cardinality (number of rows).
 * param:  size Size in bytes.
 */
public  class Cost implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.math.BigInt card ()  { throw new RuntimeException(); }
  public  scala.math.BigInt size ()  { throw new RuntimeException(); }
  // not preceding
  public   Cost (scala.math.BigInt card, scala.math.BigInt size)  { throw new RuntimeException(); }
}
