package org.apache.spark.sql.catalyst.catalog;
/**
 * Thrown when a query failed for invalid function class, usually because a SQL
 * function's class does not follow the rules of the UDF/UDAF/UDTF class definition.
 */
public  class InvalidUDFClassException extends org.apache.spark.sql.AnalysisException {
     InvalidUDFClassException (java.lang.String message)  { throw new RuntimeException(); }
}
