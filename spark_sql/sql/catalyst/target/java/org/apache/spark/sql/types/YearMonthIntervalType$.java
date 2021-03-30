package org.apache.spark.sql.types;
/**
 * The companion case object and its class is separated so the companion object also subclasses
 * the YearMonthIntervalType class. Otherwise, the companion object would be of type
 * "YearMonthIntervalType$" in byte code. Defined with a private constructor so the companion object
 * is the only possible instantiation.
 * <p>
 * @since 3.2.0
 */
public  class YearMonthIntervalType$ extends org.apache.spark.sql.types.YearMonthIntervalType implements scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final YearMonthIntervalType$ MODULE$ = null;
  public   YearMonthIntervalType$ ()  { throw new RuntimeException(); }
}
