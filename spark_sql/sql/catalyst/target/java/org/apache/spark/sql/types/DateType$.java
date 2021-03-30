package org.apache.spark.sql.types;
/**
 * The companion case object and the DateType class is separated so the companion object
 * also subclasses the class. Otherwise, the companion object would be of type "DateType$"
 * in byte code. The DateType class is defined with a private constructor so its companion
 * object is the only possible instantiation.
 * <p>
 * @since 1.3.0
 */
public  class DateType$ extends org.apache.spark.sql.types.DateType implements scala.Product, scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final DateType$ MODULE$ = null;
  public   DateType$ ()  { throw new RuntimeException(); }
}
