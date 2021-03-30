package org.apache.spark.sql.types;
/**
 * An <code>AbstractDataType</code> that matches any concrete data types.
 */
public  class AnyDataType$ extends org.apache.spark.sql.types.AbstractDataType implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final AnyDataType$ MODULE$ = null;
  public   AnyDataType$ ()  { throw new RuntimeException(); }
    org.apache.spark.sql.types.DataType defaultConcreteType ()  { throw new RuntimeException(); }
    java.lang.String simpleString ()  { throw new RuntimeException(); }
    boolean acceptsType (org.apache.spark.sql.types.DataType other)  { throw new RuntimeException(); }
}
