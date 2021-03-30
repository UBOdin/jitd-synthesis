package org.apache.spark.sql.catalyst.analysis;
/**
 * Thrown by a catalog when an item already exists. The analyzer will rethrow the exception
 * as an {@link org.apache.spark.sql.AnalysisException} with the correct position information.
 */
public  class DatabaseAlreadyExistsException extends org.apache.spark.sql.catalyst.analysis.NamespaceAlreadyExistsException {
  public   DatabaseAlreadyExistsException (java.lang.String db)  { throw new RuntimeException(); }
}
