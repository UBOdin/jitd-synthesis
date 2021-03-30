package org.apache.spark.sql.catalyst.expressions;
/**
 * Represents the behavior of expressions which have a random seed and can renew the seed.
 * Usually the random seed needs to be renewed at each execution under streaming queries.
 */
public  interface ExpressionWithRandomSeed {
  public  org.apache.spark.sql.catalyst.expressions.Expression seedExpression ()  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression withNewSeed (long seed)  ;
}
