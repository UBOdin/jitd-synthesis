package org.apache.spark.sql.catalyst.expressions;
/**
 * Expressions that don't have SQL representation should extend this trait.  Examples are
 * <code>ScalaUDF</code>, <code>ScalaUDAF</code>, and object expressions like <code>MapObjects</code> and <code>Invoke</code>.
 */
public  interface NonSQLExpression {
  public  java.lang.String sql ()  ;
}
