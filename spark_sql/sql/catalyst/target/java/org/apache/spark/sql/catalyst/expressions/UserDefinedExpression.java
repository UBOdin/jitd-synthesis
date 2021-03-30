package org.apache.spark.sql.catalyst.expressions;
/**
 * Common base trait for user-defined functions, including UDF/UDAF/UDTF of different languages
 * and Hive function wrappers.
 */
public  interface UserDefinedExpression {
  public  java.lang.String name ()  ;
}
