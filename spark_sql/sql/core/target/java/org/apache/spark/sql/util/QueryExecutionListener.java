package org.apache.spark.sql.util;
/**
 * The interface of query execution listener that can be used to analyze execution metrics.
 * <p>
 * @note Implementations should guarantee thread-safety as they can be invoked by
 * multiple different threads.
 */
public  interface QueryExecutionListener {
  /**
   * A callback function that will be called when a query execution failed.
   * <p>
   * @param funcName the name of the action that triggered this query.
   * @param qe the QueryExecution object that carries detail information like logical plan,
   *           physical plan, etc.
   * @param exception the exception that failed this query. If <code>java.lang.Error</code> is thrown during
   *                  execution, it will be wrapped with an <code>Exception</code> and it can be accessed by
   *                  <code>exception.getCause</code>.
   * @note This can be invoked by multiple different threads.
   */
  public  void onFailure (java.lang.String funcName, org.apache.spark.sql.execution.QueryExecution qe, java.lang.Exception exception)  ;
  /**
   * A callback function that will be called when a query executed successfully.
   * <p>
   * @param funcName name of the action that triggered this query.
   * @param qe the QueryExecution object that carries detail information like logical plan,
   *           physical plan, etc.
   * @param durationNs the execution time for this query in nanoseconds.
   * <p>
   * @note This can be invoked by multiple different threads.
   */
  public  void onSuccess (java.lang.String funcName, org.apache.spark.sql.execution.QueryExecution qe, long durationNs)  ;
}
