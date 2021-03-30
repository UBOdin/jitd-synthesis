package org.apache.spark.sql.catalyst.analysis;
/**
 * Thrown when an invalid attempt is made to access a property of a tree that has yet to be fully
 * resolved.
 */
public  class UnresolvedException extends org.apache.spark.sql.AnalysisException {
  public   UnresolvedException (java.lang.String function)  { throw new RuntimeException(); }
}
