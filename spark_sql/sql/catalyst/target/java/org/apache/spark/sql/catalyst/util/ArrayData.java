package org.apache.spark.sql.catalyst.util;
public abstract class ArrayData implements org.apache.spark.sql.catalyst.expressions.SpecializedGetters, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.util.ArrayData toArrayData (Object input)  { throw new RuntimeException(); }
  /**
   * Allocate {@link UnsafeArrayData} or {@link GenericArrayData} based on given parameters.
   * <p>
   * @param elementSize a size of an element in bytes. If less than zero, the type of an element is
   *                    non-primitive type
   * @param numElements the number of elements the array should contain
   * @param additionalErrorMessage string to include in the error message
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.util.ArrayData allocateArrayData (int elementSize, long numElements, java.lang.String additionalErrorMessage)  { throw new RuntimeException(); }
  public   ArrayData ()  { throw new RuntimeException(); }
  public abstract  int numElements ()  ;
  public abstract  org.apache.spark.sql.catalyst.util.ArrayData copy ()  ;
  public abstract  java.lang.Object[] array ()  ;
  public <T extends java.lang.Object> scala.collection.IndexedSeq<T> toSeq (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public abstract  void setNullAt (int i)  ;
  public abstract  void update (int i, Object value)  ;
  public  void setBoolean (int i, boolean value)  { throw new RuntimeException(); }
  public  void setByte (int i, byte value)  { throw new RuntimeException(); }
  public  void setShort (int i, short value)  { throw new RuntimeException(); }
  public  void setInt (int i, int value)  { throw new RuntimeException(); }
  public  void setLong (int i, long value)  { throw new RuntimeException(); }
  public  void setFloat (int i, float value)  { throw new RuntimeException(); }
  public  void setDouble (int i, double value)  { throw new RuntimeException(); }
  public  boolean[] toBooleanArray ()  { throw new RuntimeException(); }
  public  byte[] toByteArray ()  { throw new RuntimeException(); }
  public  short[] toShortArray ()  { throw new RuntimeException(); }
  public  int[] toIntArray ()  { throw new RuntimeException(); }
  public  long[] toLongArray ()  { throw new RuntimeException(); }
  public  float[] toFloatArray ()  { throw new RuntimeException(); }
  public  double[] toDoubleArray ()  { throw new RuntimeException(); }
  public  java.lang.Object[] toObjectArray (org.apache.spark.sql.types.DataType elementType)  { throw new RuntimeException(); }
  public <T extends java.lang.Object> java.lang.Object toArray (org.apache.spark.sql.types.DataType elementType, scala.reflect.ClassTag<T> evidence$1)  { throw new RuntimeException(); }
  public  void foreach (org.apache.spark.sql.types.DataType elementType, scala.Function2<java.lang.Object, java.lang.Object, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
}
