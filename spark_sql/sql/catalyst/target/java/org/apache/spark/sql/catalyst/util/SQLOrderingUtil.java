package org.apache.spark.sql.catalyst.util;
public  class SQLOrderingUtil {
  /**
   * A special version of double comparison that follows SQL semantic:
   *  1. NaN == NaN
   *  2. NaN is greater than any non-NaN double
   *  3. -0.0 == 0.0
   * @param x (undocumented)
   * @param y (undocumented)
   * @return (undocumented)
   */
  static public  int compareDoubles (double x, double y)  { throw new RuntimeException(); }
  /**
   * A special version of float comparison that follows SQL semantic:
   *  1. NaN == NaN
   *  2. NaN is greater than any non-NaN float
   *  3. -0.0 == 0.0
   * @param x (undocumented)
   * @param y (undocumented)
   * @return (undocumented)
   */
  static public  int compareFloats (float x, float y)  { throw new RuntimeException(); }
}
