package org.apache.spark.sql.execution.streaming.sources;
/**
 * Interface that is meant to be extended by Python classes via Py4J.
 * Py4J allows Python classes to implement Java interfaces so that the JVM can call back
 * Python objects. In this case, this allows the user-defined Python <code>foreachBatch</code> function
 * to be called from JVM when the query is active.
 * */
public  interface PythonForeachBatchFunction {
  /** Call the Python implementation of this function */
  public  void call (org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> batchDF, long batchId)  ;
}
