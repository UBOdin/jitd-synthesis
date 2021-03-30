package org.apache.spark.sql.execution.streaming;
/** Used to identify the state store for a given operator. */
public  class StatefulOperatorStateInfo implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  public  java.lang.String checkpointLocation ()  { throw new RuntimeException(); }
  public  java.util.UUID queryRunId ()  { throw new RuntimeException(); }
  public  long operatorId ()  { throw new RuntimeException(); }
  public  long storeVersion ()  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
  // not preceding
  public   StatefulOperatorStateInfo (java.lang.String checkpointLocation, java.util.UUID queryRunId, long operatorId, long storeVersion, int numPartitions)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
