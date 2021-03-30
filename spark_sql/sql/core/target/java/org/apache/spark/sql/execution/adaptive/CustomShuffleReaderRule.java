package org.apache.spark.sql.execution.adaptive;
/**
 * Adaptive Query Execution rule that may create {@link CustomShuffleReaderExec} on top of query stages.
 */
public  interface CustomShuffleReaderRule {
  /**
   * Returns the list of {@link ShuffleOrigin}s supported by this rule.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.execution.exchange.ShuffleOrigin> supportedShuffleOrigins ()  ;
}
