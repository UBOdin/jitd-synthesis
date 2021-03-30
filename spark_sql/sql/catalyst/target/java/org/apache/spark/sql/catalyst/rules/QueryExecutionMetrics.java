package org.apache.spark.sql.catalyst.rules;
public  class QueryExecutionMetrics implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  long time ()  { throw new RuntimeException(); }
  public  long numRuns ()  { throw new RuntimeException(); }
  public  long numEffectiveRuns ()  { throw new RuntimeException(); }
  public  long timeEffective ()  { throw new RuntimeException(); }
  // not preceding
  public   QueryExecutionMetrics (long time, long numRuns, long numEffectiveRuns, long timeEffective)  { throw new RuntimeException(); }
}
