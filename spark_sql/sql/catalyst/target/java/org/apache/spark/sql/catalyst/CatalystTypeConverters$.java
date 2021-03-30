package org.apache.spark.sql.catalyst;
/**
 * Functions to convert Scala types to Catalyst types and vice versa.
 */
public  class CatalystTypeConverters$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CatalystTypeConverters$ MODULE$ = null;
  public   CatalystTypeConverters$ ()  { throw new RuntimeException(); }
    boolean isPrimitive (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Creates a converter function that will convert Scala objects to the specified Catalyst type.
   * Typical use case would be converting a collection of rows that have the same schema. You will
   * call this function once to get a converter, and apply it to every row.
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  scala.Function1<java.lang.Object, java.lang.Object> createToCatalystConverter (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Creates a converter function that will convert Catalyst types to Scala type.
   * Typical use case would be converting a collection of rows that have the same schema. You will
   * call this function once to get a converter, and apply it to every row.
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  scala.Function1<java.lang.Object, java.lang.Object> createToScalaConverter (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   *  Converts Scala objects to Catalyst rows / types.
   * <p>
   *  Note: This should be called before do evaluation on Row
   *        (It does not support UDT)
   *  This is used to create an RDD or test results with correct types for Catalyst.
   * @param a (undocumented)
   * @return (undocumented)
   */
  public  Object convertToCatalyst (Object a)  { throw new RuntimeException(); }
  /**
   * Converts Catalyst types used internally in rows to standard Scala types
   * This method is slow, and for batch conversion you should be using converter
   * produced by createToScalaConverter.
   * @param catalystValue (undocumented)
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  Object convertToScala (Object catalystValue, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
}
