package org.apache.spark.sql.catalyst.util;
public  class ArrayData$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final ArrayData$ MODULE$ = null;
  public   ArrayData$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.util.ArrayData toArrayData (Object input)  { throw new RuntimeException(); }
  /**
   * Allocate {@link UnsafeArrayData} or {@link GenericArrayData} based on given parameters.
   * <p>
   * @param elementSize a size of an element in bytes. If less than zero, the type of an element is
   *                    non-primitive type
   * @param numElements the number of elements the array should contain
   * @param additionalErrorMessage string to include in the error message
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.util.ArrayData allocateArrayData (int elementSize, long numElements, java.lang.String additionalErrorMessage)  { throw new RuntimeException(); }
}
