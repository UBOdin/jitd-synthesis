package org.apache.spark.sql.catalyst.analysis;
/**
 * Mix-in trait for constructing valid {@link Cast} expressions.
 */
public  interface CastSupport {
  /**
   * Create a Cast expression with the session local time zone.
   * @param child (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Cast cast (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.types.DataType dataType)  ;
}
