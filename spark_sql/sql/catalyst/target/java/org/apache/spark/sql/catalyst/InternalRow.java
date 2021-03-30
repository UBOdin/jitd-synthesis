package org.apache.spark.sql.catalyst;
/**
 * An abstract class for row used internally in Spark SQL, which only contains the columns as
 * internal types.
 */
public abstract class InternalRow implements org.apache.spark.sql.catalyst.expressions.SpecializedGetters, scala.Serializable {
  /**
   * This method can be used to construct a {@link InternalRow} with the given values.
   * @param values (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.InternalRow apply (scala.collection.Seq<java.lang.Object> values)  { throw new RuntimeException(); }
  /**
   * This method can be used to construct a {@link InternalRow} from a {@link Seq} of values.
   * @param values (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.catalyst.InternalRow fromSeq (scala.collection.Seq<java.lang.Object> values)  { throw new RuntimeException(); }
  /** Returns an empty {@link InternalRow}. */
  static public  org.apache.spark.sql.catalyst.InternalRow empty ()  { throw new RuntimeException(); }
  /**
   * Copies the given value if it's string/struct/array/map type.
   * @param value (undocumented)
   * @return (undocumented)
   */
  static public  Object copyValue (Object value)  { throw new RuntimeException(); }
  /**
   * Returns an accessor for an <code>InternalRow</code> with given data type. The returned accessor
   * actually takes a <code>SpecializedGetters</code> input because it can be generalized to other classes
   * that implements <code>SpecializedGetters</code> (e.g., <code>ArrayData</code>) too.
   * @param dt (undocumented)
   * @param nullable (undocumented)
   * @return (undocumented)
   */
  static public  scala.Function2<org.apache.spark.sql.catalyst.expressions.SpecializedGetters, java.lang.Object, java.lang.Object> getAccessor (org.apache.spark.sql.types.DataType dt, boolean nullable)  { throw new RuntimeException(); }
  /**
   * Returns a writer for an <code>InternalRow</code> with given data type.
   * @param ordinal (undocumented)
   * @param dt (undocumented)
   * @return (undocumented)
   */
  static public  scala.Function2<org.apache.spark.sql.catalyst.InternalRow, java.lang.Object, scala.runtime.BoxedUnit> getWriter (int ordinal, org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
  public   InternalRow ()  { throw new RuntimeException(); }
  public abstract  int numFields ()  ;
  public  java.lang.String getString (int ordinal)  { throw new RuntimeException(); }
  public abstract  void setNullAt (int i)  ;
  /**
   * Updates the value at column <code>i</code>. Note that after updating, the given value will be kept in this
   * row, and the caller side should guarantee that this value won't be changed afterwards.
   * @param i (undocumented)
   * @param value (undocumented)
   */
  public abstract  void update (int i, Object value)  ;
  public  void setBoolean (int i, boolean value)  { throw new RuntimeException(); }
  public  void setByte (int i, byte value)  { throw new RuntimeException(); }
  public  void setShort (int i, short value)  { throw new RuntimeException(); }
  public  void setInt (int i, int value)  { throw new RuntimeException(); }
  public  void setLong (int i, long value)  { throw new RuntimeException(); }
  public  void setFloat (int i, float value)  { throw new RuntimeException(); }
  public  void setDouble (int i, double value)  { throw new RuntimeException(); }
  /**
   * Update the decimal column at <code>i</code>.
   * <p>
   * Note: In order to support update decimal with precision > 18 in UnsafeRow,
   * CAN NOT call setNullAt() for decimal column on UnsafeRow, call setDecimal(i, null, precision).
   * @param i (undocumented)
   * @param value (undocumented)
   * @param precision (undocumented)
   */
  public  void setDecimal (int i, org.apache.spark.sql.types.Decimal value, int precision)  { throw new RuntimeException(); }
  public  void setInterval (int i, org.apache.spark.unsafe.types.CalendarInterval value)  { throw new RuntimeException(); }
  /**
   * Make a copy of the current {@link InternalRow} object.
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.catalyst.InternalRow copy ()  ;
  /** Returns true if there are any NULL values in this row. */
  public  boolean anyNull ()  { throw new RuntimeException(); }
  /**
   * Return a Scala Seq representing the row. Elements are placed in the same order in the Seq.
   * @param fieldTypes (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<java.lang.Object> toSeq (scala.collection.Seq<org.apache.spark.sql.types.DataType> fieldTypes)  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.Object> toSeq (org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
}
