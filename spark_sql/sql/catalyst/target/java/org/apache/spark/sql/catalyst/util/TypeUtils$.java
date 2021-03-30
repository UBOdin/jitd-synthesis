package org.apache.spark.sql.catalyst.util;
/**
 * Functions to help with checking for valid data types and value comparison of various types.
 */
public  class TypeUtils$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final TypeUtils$ MODULE$ = null;
  public   TypeUtils$ ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkForNumericExpr (org.apache.spark.sql.types.DataType dt, java.lang.String caller)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkForOrderingExpr (org.apache.spark.sql.types.DataType dt, java.lang.String caller)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkForSameTypeInputExpr (scala.collection.Seq<org.apache.spark.sql.types.DataType> types, java.lang.String caller)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkForMapKeyType (org.apache.spark.sql.types.DataType keyType)  { throw new RuntimeException(); }
  public  scala.math.Numeric<java.lang.Object> getNumeric (org.apache.spark.sql.types.DataType t, boolean exactNumericRequired)  { throw new RuntimeException(); }
  public  scala.math.Ordering<java.lang.Object> getInterpretedOrdering (org.apache.spark.sql.types.DataType t)  { throw new RuntimeException(); }
  public  int compareBinary (byte[] x, byte[] y)  { throw new RuntimeException(); }
  /**
   * Returns true if the equals method of the elements of the data type is implemented properly.
   * This also means that they can be safely used in collections relying on the equals method,
   * as sets or maps.
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  boolean typeWithProperEquals (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public  void failWithIntervalType (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  public  void invokeOnceForInterval (org.apache.spark.sql.types.DataType dataType, scala.Function0<scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
}
