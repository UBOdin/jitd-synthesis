package org.apache.spark.sql.catalyst.plans;
/**
 * The explicitCartesian flag indicates if the inner join was constructed with a CROSS join
 * indicating a cartesian product has been explicitly requested.
 */
public abstract class InnerLike extends org.apache.spark.sql.catalyst.plans.JoinType {
  public   InnerLike ()  { throw new RuntimeException(); }
  public abstract  boolean explicitCartesian ()  ;
}
