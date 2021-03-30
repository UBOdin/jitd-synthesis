package org.apache.spark.sql.execution.datasources;
/**
 * Find the column name of an expression that can be pushed down.
 */
public abstract class PushableColumnBase {
  public   PushableColumnBase ()  { throw new RuntimeException(); }
  public abstract  boolean nestedPredicatePushdownEnabled ()  ;
  public  scala.Option<java.lang.String> unapply (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
}
