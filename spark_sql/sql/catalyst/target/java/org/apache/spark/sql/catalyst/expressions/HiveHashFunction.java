package org.apache.spark.sql.catalyst.expressions;
public  class HiveHashFunction {
  static protected  long hashInt (int i, long seed)  { throw new RuntimeException(); }
  static protected  long hashLong (long l, long seed)  { throw new RuntimeException(); }
  static protected  long hashUnsafeBytes (java.lang.Object base, long offset, int len, long seed)  { throw new RuntimeException(); }
  static public  java.math.BigDecimal normalizeDecimal (java.math.BigDecimal input)  { throw new RuntimeException(); }
  /**
   * Mimics TimestampWritable.hashCode() in Hive
   * @param timestamp (undocumented)
   * @return (undocumented)
   */
  static public  long hashTimestamp (long timestamp)  { throw new RuntimeException(); }
  /**
   * Hive allows input intervals to be defined using units below but the intervals
   * have to be from the same category:
   * - year, month (stored as HiveIntervalYearMonth)
   * - day, hour, minute, second, nanosecond (stored as HiveIntervalDayTime)
   * <p>
   * e.g. (INTERVAL '30' YEAR + INTERVAL '-23' DAY) fails in Hive
   * <p>
   * This method mimics HiveIntervalDayTime.hashCode() in Hive.
   * <p>
   * Two differences wrt Hive due to how intervals are stored in Spark vs Hive:
   * <p>
   * - If the <code>INTERVAL</code> is backed as HiveIntervalYearMonth in Hive, then this method will not
   *   produce Hive compatible result. The reason being Spark's representation of calendar does not
   *   have such categories based on the interval and is unified.
   * <p>
   * - Spark's {@link CalendarInterval} has precision upto microseconds but Hive's
   *   HiveIntervalDayTime can store data with precision upto nanoseconds. So, any input intervals
   *   with nanosecond values will lead to wrong output hashes (i.e. non adherent with Hive output)
   * @param calendarInterval (undocumented)
   * @return (undocumented)
   */
  static public  long hashCalendarInterval (org.apache.spark.unsafe.types.CalendarInterval calendarInterval)  { throw new RuntimeException(); }
  static public  long hash (Object value, org.apache.spark.sql.types.DataType dataType, long seed)  { throw new RuntimeException(); }
}
