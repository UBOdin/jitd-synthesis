package org.apache.spark.sql.catalyst.util;
/**
 * Helper functions for converting between internal and external date and time representations.
 * Dates are exposed externally as java.sql.Date and are represented internally as the number of
 * dates since the Unix epoch (1970-01-01). Timestamps are exposed externally as java.sql.Timestamp
 * and are stored internally as longs, which are capable of storing timestamps with microsecond
 * precision.
 */
public  class DateTimeUtils {
  static public final  int JULIAN_DAY_OF_EPOCH ()  { throw new RuntimeException(); }
  static public final  java.util.TimeZone TimeZoneUTC ()  { throw new RuntimeException(); }
  static public  java.lang.String TIMEZONE_OPTION ()  { throw new RuntimeException(); }
  static public  java.time.ZoneId getZoneId (java.lang.String timeZoneId)  { throw new RuntimeException(); }
  static public  java.util.TimeZone getTimeZone (java.lang.String timeZoneId)  { throw new RuntimeException(); }
  /**
   * Converts microseconds since 1970-01-01 00:00:00Z to days since 1970-01-01 at the given zone ID.
   * @param micros (undocumented)
   * @param zoneId (undocumented)
   * @return (undocumented)
   */
  static public  int microsToDays (long micros, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Converts days since 1970-01-01 at the given zone ID to microseconds since 1970-01-01 00:00:00Z.
   * @param days (undocumented)
   * @param zoneId (undocumented)
   * @return (undocumented)
   */
  static public  long daysToMicros (int days, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Converts a local date at the default JVM time zone to the number of days since 1970-01-01
   * in the hybrid calendar (Julian + Gregorian) by discarding the time part. The resulted days are
   * rebased from the hybrid to Proleptic Gregorian calendar. The days rebasing is performed via
   * UTC time zone for simplicity because the difference between two calendars is the same in
   * any given time zone and UTC time zone.
   * <p>
   * Note: The date is shifted by the offset of the default JVM time zone for backward compatibility
   *       with Spark 2.4 and earlier versions. The goal of the shift is to get a local date derived
   *       from the number of days that has the same date fields (year, month, day) as the original
   *       <code>date</code> at the default JVM time zone.
   * <p>
   * @param date It represents a specific instant in time based on the hybrid calendar which
   *             combines Julian and Gregorian calendars.
   * @return The number of days since the epoch in Proleptic Gregorian calendar.
   */
  static public  int fromJavaDate (java.sql.Date date)  { throw new RuntimeException(); }
  /**
   * Converts days since the epoch 1970-01-01 in Proleptic Gregorian calendar to a local date
   * at the default JVM time zone in the hybrid calendar (Julian + Gregorian). It rebases the given
   * days from Proleptic Gregorian to the hybrid calendar at UTC time zone for simplicity because
   * the difference between two calendars doesn't depend on any time zone. The result is shifted
   * by the time zone offset in wall clock to have the same date fields (year, month, day)
   * at the default JVM time zone as the input <code>daysSinceEpoch</code> in Proleptic Gregorian calendar.
   * <p>
   * Note: The date is shifted by the offset of the default JVM time zone for backward compatibility
   *       with Spark 2.4 and earlier versions.
   * <p>
   * @param days The number of days since 1970-01-01 in Proleptic Gregorian calendar.
   * @return A local date in the hybrid calendar as <code>java.sql.Date</code> from number of days since epoch.
   */
  static public  java.sql.Date toJavaDate (int days)  { throw new RuntimeException(); }
  /**
   * Converts microseconds since the epoch to an instance of <code>java.sql.Timestamp</code>
   * via creating a local timestamp at the system time zone in Proleptic Gregorian
   * calendar, extracting date and time fields like <code>year</code> and <code>hours</code>, and forming
   * new timestamp in the hybrid calendar from the extracted fields.
   * <p>
   * The conversion is based on the JVM system time zone because the <code>java.sql.Timestamp</code>
   * uses the time zone internally.
   * <p>
   * The method performs the conversion via local timestamp fields to have the same date-time
   * representation as <code>year</code>, <code>month</code>, <code>day</code>, ..., <code>seconds</code> in the original calendar
   * and in the target calendar.
   * <p>
   * @param micros The number of microseconds since 1970-01-01T00:00:00.000000Z.
   * @return A <code>java.sql.Timestamp</code> from number of micros since epoch.
   */
  static public  java.sql.Timestamp toJavaTimestamp (long micros)  { throw new RuntimeException(); }
  /**
   * Converts an instance of <code>java.sql.Timestamp</code> to the number of microseconds since
   * 1970-01-01T00:00:00.000000Z. It extracts date-time fields from the input, builds
   * a local timestamp in Proleptic Gregorian calendar from the fields, and binds
   * the timestamp to the system time zone. The resulted instant is converted to
   * microseconds since the epoch.
   * <p>
   * The conversion is performed via the system time zone because it is used internally
   * in <code>java.sql.Timestamp</code> while extracting date-time fields.
   * <p>
   * The goal of the function is to have the same local date-time in the original calendar
   * - the hybrid calendar (Julian + Gregorian) and in the target calendar which is
   * Proleptic Gregorian calendar, see SPARK-26651.
   * <p>
   * @param t It represents a specific instant in time based on
   *          the hybrid calendar which combines Julian and
   *          Gregorian calendars.
   * @return The number of micros since epoch from <code>java.sql.Timestamp</code>.
   */
  static public  long fromJavaTimestamp (java.sql.Timestamp t)  { throw new RuntimeException(); }
  /**
   * Returns the number of microseconds since epoch from Julian day and nanoseconds in a day.
   * @param days (undocumented)
   * @param nanos (undocumented)
   * @return (undocumented)
   */
  static public  long fromJulianDay (int days, long nanos)  { throw new RuntimeException(); }
  /**
   * Returns Julian day and nanoseconds in a day from the number of microseconds
   * <p>
   * Note: support timestamp since 4717 BC (without negative nanoseconds, compatible with Hive).
   * @param micros (undocumented)
   * @return (undocumented)
   */
  static public  scala.Tuple2<java.lang.Object, java.lang.Object> toJulianDay (long micros)  { throw new RuntimeException(); }
  /**
   * Converts the timestamp to milliseconds since epoch. In Spark timestamp values have microseconds
   * precision, so this conversion is lossy.
   * @param micros (undocumented)
   * @return (undocumented)
   */
  static public  long microsToMillis (long micros)  { throw new RuntimeException(); }
  /**
   * Converts milliseconds since the epoch to microseconds.
   * @param millis (undocumented)
   * @return (undocumented)
   */
  static public  long millisToMicros (long millis)  { throw new RuntimeException(); }
  static public  org.apache.spark.unsafe.types.UTF8String cleanLegacyTimestampStr (org.apache.spark.unsafe.types.UTF8String s)  { throw new RuntimeException(); }
  /**
   * Trims and parses a given UTF8 timestamp string to the corresponding a corresponding {@link Long}
   * value. The return type is {@link Option} in order to distinguish between 0L and null. The following
   * formats are allowed:
   * <p>
   * <code>yyyy</code>
   * <code>yyyy-[m]m</code>
   * <code>yyyy-[m]m-[d]d</code>
   * <code>yyyy-[m]m-[d]d </code>
   * <code>yyyy-[m]m-[d]d [h]h:[m]m:[s]s.[ms][ms][ms][us][us][us][zone_id]</code>
   * <code>yyyy-[m]m-[d]dT[h]h:[m]m:[s]s.[ms][ms][ms][us][us][us][zone_id]</code>
   * <code>[h]h:[m]m:[s]s.[ms][ms][ms][us][us][us][zone_id]</code>
   * <code>T[h]h:[m]m:[s]s.[ms][ms][ms][us][us][us][zone_id]</code>
   * <p>
   * where <code>zone_id</code> should have one of the forms:
   *   - Z - Zulu time zone UTC+0
   *   - +|-[h]h:[m]m
   *   - A short id, see https://docs.oracle.com/javase/8/docs/api/java/time/ZoneId.html#SHORT_IDS
   *   - An id with one of the prefixes UTC+, UTC-, GMT+, GMT-, UT+ or UT-,
   *     and a suffix in the formats:
   *     - +|-h[h]
   *     - +|-hh[:]mm
   *     - +|-hh:mm:ss
   *     - +|-hhmmss
   *  - Region-based zone IDs in the form <code>area/city</code>, such as <code>Europe/Paris</code>
   * @param s (undocumented)
   * @param timeZoneId (undocumented)
   * @return (undocumented)
   */
  static public  scala.Option<java.lang.Object> stringToTimestamp (org.apache.spark.unsafe.types.UTF8String s, java.time.ZoneId timeZoneId)  { throw new RuntimeException(); }
  static public  long stringToTimestampAnsi (org.apache.spark.unsafe.types.UTF8String s, java.time.ZoneId timeZoneId)  { throw new RuntimeException(); }
  /**
   * Gets the number of microseconds since the epoch of 1970-01-01 00:00:00Z from the given
   * instance of <code>java.time.Instant</code>. The epoch microsecond count is a simple incrementing count of
   * microseconds where microsecond 0 is 1970-01-01 00:00:00Z.
   * @param instant (undocumented)
   * @return (undocumented)
   */
  static public  long instantToMicros (java.time.Instant instant)  { throw new RuntimeException(); }
  /**
   * Obtains an instance of <code>java.time.Instant</code> using microseconds from
   * the epoch of 1970-01-01 00:00:00Z.
   * @param micros (undocumented)
   * @return (undocumented)
   */
  static public  java.time.Instant microsToInstant (long micros)  { throw new RuntimeException(); }
  /**
   * Converts the local date to the number of days since 1970-01-01.
   * @param localDate (undocumented)
   * @return (undocumented)
   */
  static public  int localDateToDays (java.time.LocalDate localDate)  { throw new RuntimeException(); }
  /**
   * Obtains an instance of <code>java.time.LocalDate</code> from the epoch day count.
   * @param days (undocumented)
   * @return (undocumented)
   */
  static public  java.time.LocalDate daysToLocalDate (int days)  { throw new RuntimeException(); }
  /**
   * Trims and parses a given UTF8 date string to a corresponding {@link Int} value.
   * The return type is {@link Option} in order to distinguish between 0 and null. The following
   * formats are allowed:
   * <p>
   * <code>yyyy</code>
   * <code>yyyy-[m]m</code>
   * <code>yyyy-[m]m-[d]d</code>
   * <code>yyyy-[m]m-[d]d </code>
   * <code>yyyy-[m]m-[d]d *</code>
   * <code>yyyy-[m]m-[d]dT*</code>
   * @param s (undocumented)
   * @param zoneId (undocumented)
   * @return (undocumented)
   */
  static public  scala.Option<java.lang.Object> stringToDate (org.apache.spark.unsafe.types.UTF8String s, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  static public  int stringToDateAnsi (org.apache.spark.unsafe.types.UTF8String s, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Returns the hour value of a given timestamp value. The timestamp is expressed in microseconds.
   * @param micros (undocumented)
   * @param zoneId (undocumented)
   * @return (undocumented)
   */
  static public  int getHours (long micros, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Returns the minute value of a given timestamp value. The timestamp is expressed in
   * microseconds since the epoch.
   * @param micros (undocumented)
   * @param zoneId (undocumented)
   * @return (undocumented)
   */
  static public  int getMinutes (long micros, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Returns the second value of a given timestamp value. The timestamp is expressed in
   * microseconds since the epoch.
   * @param micros (undocumented)
   * @param zoneId (undocumented)
   * @return (undocumented)
   */
  static public  int getSeconds (long micros, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Returns the seconds part and its fractional part with microseconds.
   * @param micros (undocumented)
   * @param zoneId (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.types.Decimal getSecondsWithFraction (long micros, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Returns local seconds, including fractional parts, multiplied by 1000000.
   * <p>
   * @param micros The number of microseconds since the epoch.
   * @param zoneId The time zone id which milliseconds should be obtained in.
   * @return (undocumented)
   */
  static public  int getMicroseconds (long micros, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Returns the 'day in year' value for the given number of days since 1970-01-01.
   * @param days (undocumented)
   * @return (undocumented)
   */
  static public  int getDayInYear (int days)  { throw new RuntimeException(); }
  /**
   * Returns the year value for the given number of days since 1970-01-01.
   * @param days (undocumented)
   * @return (undocumented)
   */
  static public  int getYear (int days)  { throw new RuntimeException(); }
  /**
   * Returns the year which conforms to ISO 8601. Each ISO 8601 week-numbering
   * year begins with the Monday of the week containing the 4th of January.
   * @param days (undocumented)
   * @return (undocumented)
   */
  static public  int getWeekBasedYear (int days)  { throw new RuntimeException(); }
  /** Returns the quarter for the given number of days since 1970-01-01. */
  static public  int getQuarter (int days)  { throw new RuntimeException(); }
  /**
   * Returns the month value for the given number of days since 1970-01-01.
   * January is month 1.
   * @param days (undocumented)
   * @return (undocumented)
   */
  static public  int getMonth (int days)  { throw new RuntimeException(); }
  /**
   * Returns the 'day of month' value for the given number of days since 1970-01-01.
   * @param days (undocumented)
   * @return (undocumented)
   */
  static public  int getDayOfMonth (int days)  { throw new RuntimeException(); }
  /**
   * Returns the day of the week for the given number of days since 1970-01-01
   * (1 = Sunday, 2 = Monday, ..., 7 = Saturday).
   * @param days (undocumented)
   * @return (undocumented)
   */
  static public  int getDayOfWeek (int days)  { throw new RuntimeException(); }
  /**
   * Returns the day of the week for the given number of days since 1970-01-01
   * (0 = Monday, 1 = Tuesday, ..., 6 = Sunday).
   * @param days (undocumented)
   * @return (undocumented)
   */
  static public  int getWeekDay (int days)  { throw new RuntimeException(); }
  /**
   * Returns the week of the year of the given date expressed as the number of days from 1970-01-01.
   * A week is considered to start on a Monday and week 1 is the first week with > 3 days.
   * @param days (undocumented)
   * @return (undocumented)
   */
  static public  int getWeekOfYear (int days)  { throw new RuntimeException(); }
  /**
   * Adds an year-month interval to a date represented as days since 1970-01-01.
   * @return a date value, expressed in days since 1970-01-01.
   * @param days (undocumented)
   * @param months (undocumented)
   */
  static public  int dateAddMonths (int days, int months)  { throw new RuntimeException(); }
  /**
   * Adds months to a timestamp at the given time zone. It converts the input timestamp to a local
   * timestamp at the given time zone, adds months, and converts the resulted local timestamp
   * back to a timestamp, expressed in microseconds since 1970-01-01 00:00:00Z.
   * <p>
   * @param micros The input timestamp value, expressed in microseconds since 1970-01-01 00:00:00Z
   * @param months The amount of months to add. It can be positive or negative.
   * @param zoneId The time zone ID at which the operation is performed.
   * @return A timestamp value, expressed in microseconds since 1970-01-01 00:00:00Z.
   */
  static public  long timestampAddMonths (long micros, int months, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Adds a day-time interval expressed in microseconds to a timestamp at the given time zone.
   * It converts the input timestamp to a local timestamp, and adds the interval by:
   *   - Splitting the interval to days and microsecond adjustment in a day, and
   *   - First of all, it adds days and then the time part.
   * The resulted local timestamp is converted back to an instant at the given time zone.
   * <p>
   * @param micros The input timestamp value, expressed in microseconds since 1970-01-01 00:00:00Z.
   * @param dayTime The amount of microseconds to add. It can be positive or negative.
   * @param zoneId The time zone ID at which the operation is performed.
   * @return A timestamp value, expressed in microseconds since 1970-01-01 00:00:00Z.
   */
  static public  long timestampAddDayTime (long micros, long dayTime, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Adds a full interval (months, days, microseconds) a timestamp represented as the number of
   * microseconds since 1970-01-01 00:00:00Z.
   * @return A timestamp value, expressed in microseconds since 1970-01-01 00:00:00Z.
   * @param start (undocumented)
   * @param months (undocumented)
   * @param days (undocumented)
   * @param microseconds (undocumented)
   * @param zoneId (undocumented)
   */
  static public  long timestampAddInterval (long start, int months, int days, long microseconds, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Adds the interval's months and days to a date expressed as days since the epoch.
   * @return A date value, expressed in days since 1970-01-01.
   * <p>
   * @throws DateTimeException if the result exceeds the supported date range
   * @throws IllegalArgumentException if the interval has <code>microseconds</code> part
   * @param start (undocumented)
   * @param interval (undocumented)
   */
  static public  int dateAddInterval (int start, org.apache.spark.unsafe.types.CalendarInterval interval)  { throw new RuntimeException(); }
  /**
   * Returns number of months between micros1 and micros2. micros1 and micros2 are expressed in
   * microseconds since 1970-01-01. If micros1 is later than micros2, the result is positive.
   * <p>
   * If micros1 and micros2 are on the same day of month, or both are the last day of month,
   * returns, time of day will be ignored.
   * <p>
   * Otherwise, the difference is calculated based on 31 days per month.
   * The result is rounded to 8 decimal places if <code>roundOff</code> is set to true.
   * @param micros1 (undocumented)
   * @param micros2 (undocumented)
   * @param roundOff (undocumented)
   * @param zoneId (undocumented)
   * @return (undocumented)
   */
  static public  double monthsBetween (long micros1, long micros2, boolean roundOff, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Returns day of week from String. Starting from Thursday, marked as 0.
   * (Because 1970-01-01 is Thursday).
   * @throws IllegalArgumentException if the input is not a valid day of week.
   * @param string (undocumented)
   * @return (undocumented)
   */
  static public  int getDayOfWeekFromString (org.apache.spark.unsafe.types.UTF8String string)  { throw new RuntimeException(); }
  /**
   * Returns the first date which is later than startDate and is of the given dayOfWeek.
   * dayOfWeek is an integer ranges in [0, 6], and 0 is Thu, 1 is Fri, etc,.
   * @param startDay (undocumented)
   * @param dayOfWeek (undocumented)
   * @return (undocumented)
   */
  static public  int getNextDateForDayOfWeek (int startDay, int dayOfWeek)  { throw new RuntimeException(); }
  /** Returns last day of the month for the given number of days since 1970-01-01. */
  static public  int getLastDayOfMonth (int days)  { throw new RuntimeException(); }
  static   int TRUNC_INVALID ()  { throw new RuntimeException(); }
  static   int TRUNC_TO_MICROSECOND ()  { throw new RuntimeException(); }
  static   int MIN_LEVEL_OF_TIMESTAMP_TRUNC ()  { throw new RuntimeException(); }
  static   int TRUNC_TO_MILLISECOND ()  { throw new RuntimeException(); }
  static   int TRUNC_TO_SECOND ()  { throw new RuntimeException(); }
  static   int TRUNC_TO_MINUTE ()  { throw new RuntimeException(); }
  static   int TRUNC_TO_HOUR ()  { throw new RuntimeException(); }
  static   int TRUNC_TO_DAY ()  { throw new RuntimeException(); }
  static   int TRUNC_TO_WEEK ()  { throw new RuntimeException(); }
  static   int MIN_LEVEL_OF_DATE_TRUNC ()  { throw new RuntimeException(); }
  static   int TRUNC_TO_MONTH ()  { throw new RuntimeException(); }
  static   int TRUNC_TO_QUARTER ()  { throw new RuntimeException(); }
  static   int TRUNC_TO_YEAR ()  { throw new RuntimeException(); }
  /**
   * Returns the trunc date from original date and trunc level.
   * Trunc level should be generated using <code>parseTruncLevel()</code>, should be between 6 and 9.
   * @param days (undocumented)
   * @param level (undocumented)
   * @return (undocumented)
   */
  static public  int truncDate (int days, int level)  { throw new RuntimeException(); }
  /**
   * Returns the trunc date time from original date time and trunc level.
   * Trunc level should be generated using <code>parseTruncLevel()</code>, should be between 0 and 9.
   * @param micros (undocumented)
   * @param level (undocumented)
   * @param zoneId (undocumented)
   * @return (undocumented)
   */
  static public  long truncTimestamp (long micros, int level, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Returns the truncate level, could be from TRUNC_TO_MICROSECOND to TRUNC_TO_YEAR,
   * or TRUNC_INVALID, TRUNC_INVALID means unsupported truncate level.
   * @param format (undocumented)
   * @return (undocumented)
   */
  static public  int parseTruncLevel (org.apache.spark.unsafe.types.UTF8String format)  { throw new RuntimeException(); }
  /**
   * Converts the timestamp <code>micros</code> from one timezone to another.
   * <p>
   * Time-zone rules, such as daylight savings, mean that not every local date-time
   * is valid for the <code>toZone</code> time zone, thus the local date-time may be adjusted.
   * @param micros (undocumented)
   * @param fromZone (undocumented)
   * @param toZone (undocumented)
   * @return (undocumented)
   */
  static public  long convertTz (long micros, java.time.ZoneId fromZone, java.time.ZoneId toZone)  { throw new RuntimeException(); }
  /**
   * Returns a timestamp of given timezone from UTC timestamp, with the same string
   * representation in their timezone.
   * @param micros (undocumented)
   * @param timeZone (undocumented)
   * @return (undocumented)
   */
  static public  long fromUTCTime (long micros, java.lang.String timeZone)  { throw new RuntimeException(); }
  /**
   * Returns a utc timestamp from a given timestamp from a given timezone, with the same
   * string representation in their timezone.
   * @param micros (undocumented)
   * @param timeZone (undocumented)
   * @return (undocumented)
   */
  static public  long toUTCTime (long micros, java.lang.String timeZone)  { throw new RuntimeException(); }
  /**
   * Obtains the current instant as microseconds since the epoch at the UTC time zone.
   * @return (undocumented)
   */
  static public  long currentTimestamp ()  { throw new RuntimeException(); }
  /**
   * Obtains the current date as days since the epoch in the specified time-zone.
   * @param zoneId (undocumented)
   * @return (undocumented)
   */
  static public  int currentDate (java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Converts notational shorthands that are converted to ordinary timestamps.
   * <p>
   * @param input A trimmed string
   * @param zoneId Zone identifier used to get the current date.
   * @return Some of microseconds since the epoch if the conversion completed
   *         successfully otherwise None.
   */
  static public  scala.Option<java.lang.Object> convertSpecialTimestamp (java.lang.String input, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Converts notational shorthands that are converted to ordinary dates.
   * <p>
   * @param input A trimmed string
   * @param zoneId Zone identifier used to get the current date.
   * @return Some of days since the epoch if the conversion completed successfully otherwise None.
   */
  static public  scala.Option<java.lang.Object> convertSpecialDate (java.lang.String input, java.time.ZoneId zoneId)  { throw new RuntimeException(); }
  /**
   * Subtracts two dates expressed as days since 1970-01-01.
   * <p>
   * @param endDay The end date, exclusive
   * @param startDay The start date, inclusive
   * @return An interval between two dates. The interval can be negative
   *         if the end date is before the start date.
   */
  static public  org.apache.spark.unsafe.types.CalendarInterval subtractDates (int endDay, int startDay)  { throw new RuntimeException(); }
}
