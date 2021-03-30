package org.apache.spark.sql.types;
/**
 * A non-concrete data type, reserved for internal uses.
 */
 abstract class AbstractDataType {
  public   AbstractDataType ()  { throw new RuntimeException(); }
  /**
   * Returns true if <code>other</code> is an acceptable input type for a function that expects this,
   * possibly abstract DataType.
   * <p>
   * <pre><code>
   *   // this should return true
   *   DecimalType.acceptsType(DecimalType(10, 2))
   *
   *   // this should return true as well
   *   NumericType.acceptsType(DecimalType(10, 2))
   * </code></pre>
   * @param other (undocumented)
   * @return (undocumented)
   */
   abstract  boolean acceptsType (org.apache.spark.sql.types.DataType other)  ;
  /**
   * The default concrete type to use if we want to cast a null literal into this type.
   * @return (undocumented)
   */
   abstract  org.apache.spark.sql.types.DataType defaultConcreteType ()  ;
  /** Readable string representation for the type. */
   abstract  java.lang.String simpleString ()  ;
}
