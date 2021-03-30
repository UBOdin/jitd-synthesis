package org.apache.spark.sql.catalyst;
public  class InternalRow$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final InternalRow$ MODULE$ = null;
  public   InternalRow$ ()  { throw new RuntimeException(); }
  /**
   * This method can be used to construct a {@link InternalRow} with the given values.
   * @param values (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.InternalRow apply (scala.collection.Seq<java.lang.Object> values)  { throw new RuntimeException(); }
  /**
   * This method can be used to construct a {@link InternalRow} from a {@link Seq} of values.
   * @param values (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.InternalRow fromSeq (scala.collection.Seq<java.lang.Object> values)  { throw new RuntimeException(); }
  /** Returns an empty {@link InternalRow}. */
  public  org.apache.spark.sql.catalyst.InternalRow empty ()  { throw new RuntimeException(); }
  /**
   * Copies the given value if it's string/struct/array/map type.
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  Object copyValue (Object value)  { throw new RuntimeException(); }
  /**
   * Returns an accessor for an <code>InternalRow</code> with given data type. The returned accessor
   * actually takes a <code>SpecializedGetters</code> input because it can be generalized to other classes
   * that implements <code>SpecializedGetters</code> (e.g., <code>ArrayData</code>) too.
   * @param dt (undocumented)
   * @param nullable (undocumented)
   * @return (undocumented)
   */
  public  scala.Function2<org.apache.spark.sql.catalyst.expressions.SpecializedGetters, java.lang.Object, java.lang.Object> getAccessor (org.apache.spark.sql.types.DataType dt, boolean nullable)  { throw new RuntimeException(); }
  /**
   * Returns a writer for an <code>InternalRow</code> with given data type.
   * @param ordinal (undocumented)
   * @param dt (undocumented)
   * @return (undocumented)
   */
  public  scala.Function2<org.apache.spark.sql.catalyst.InternalRow, java.lang.Object, scala.runtime.BoxedUnit> getWriter (int ordinal, org.apache.spark.sql.types.DataType dt)  { throw new RuntimeException(); }
}
