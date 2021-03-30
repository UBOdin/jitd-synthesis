package org.apache.spark.sql.catalyst.expressions;
public  class Cast$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Cast$ MODULE$ = null;
  public   Cast$ ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.trees.TreeNodeTag<java.lang.Object> USER_SPECIFIED_CAST ()  { throw new RuntimeException(); }
  /**
   * Returns true iff we can cast <code>from</code> type to <code>to</code> type.
   * @param from (undocumented)
   * @param to (undocumented)
   * @return (undocumented)
   */
  public  boolean canCast (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  /**
   * Return true if we need to use the <code>timeZone</code> information casting <code>from</code> type to <code>to</code> type.
   * The patterns matched reflect the current implementation in the Cast node.
   * c.f. usage of <code>timeZone</code> in:
   * * Cast.castToString
   * * Cast.castToDate
   * * Cast.castToTimestamp
   * @param from (undocumented)
   * @param to (undocumented)
   * @return (undocumented)
   */
  public  boolean needsTimeZone (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  /**
   * Returns true iff we can safely up-cast the <code>from</code> type to <code>to</code> type without any truncating or
   * precision lose or possible runtime failures. For example, long -> int, string -> int are not
   * up-cast.
   * @param from (undocumented)
   * @param to (undocumented)
   * @return (undocumented)
   */
  public  boolean canUpCast (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  /**
   * Returns true iff we can cast the <code>from</code> type to <code>to</code> type as per the ANSI SQL.
   * In practice, the behavior is mostly the same as PostgreSQL. It disallows certain unreasonable
   * type conversions such as converting <code>string</code> to <code>int</code> or <code>double</code> to <code>boolean</code>.
   * @param from (undocumented)
   * @param to (undocumented)
   * @return (undocumented)
   */
  public  boolean canANSIStoreAssign (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  public  boolean canNullSafeCastToDecimal (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DecimalType to)  { throw new RuntimeException(); }
  /**
   * Returns <code>true</code> if casting non-nullable values from <code>from</code> type to <code>to</code> type
   * may return null. Note that the caller side should take care of input nullability
   * first and only call this method if the input is not nullable.
   * @param from (undocumented)
   * @param to (undocumented)
   * @return (undocumented)
   */
  public  boolean forceNullable (org.apache.spark.sql.types.DataType from, org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  public  boolean resolvableNullability (boolean from, boolean to)  { throw new RuntimeException(); }
  /**
   * We process literals such as 'Infinity', 'Inf', '-Infinity' and 'NaN' etc in case
   * insensitive manner to be compatible with other database systems such as PostgreSQL and DB2.
   * @param v (undocumented)
   * @param isFloat (undocumented)
   * @return (undocumented)
   */
  public  Object processFloatingPointSpecialLiterals (java.lang.String v, boolean isFloat)  { throw new RuntimeException(); }
}
