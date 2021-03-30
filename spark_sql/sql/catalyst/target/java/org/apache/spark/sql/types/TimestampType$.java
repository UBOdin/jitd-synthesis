package org.apache.spark.sql.types;
/**
 * The companion case object and its class is separated so the companion object also subclasses
 * the TimestampType class. Otherwise, the companion object would be of type "TimestampType$"
 * in byte code. Defined with a private constructor so the companion object is the only possible
 * instantiation.
 * <p>
 * @since 1.3.0
 */
public  class TimestampType$ extends org.apache.spark.sql.types.TimestampType implements scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final TimestampType$ MODULE$ = null;
  public   TimestampType$ ()  { throw new RuntimeException(); }
}
