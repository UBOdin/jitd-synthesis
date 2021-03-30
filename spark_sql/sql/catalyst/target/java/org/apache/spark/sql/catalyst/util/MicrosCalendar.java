package org.apache.spark.sql.catalyst.util;
/**
 * The custom sub-class of <code>GregorianCalendar</code> is needed to get access to
 * protected <code>fields</code> immediately after parsing. We cannot use
 * the <code>get()</code> method because it performs normalization of the fraction
 * part. Accordingly, the <code>MILLISECOND</code> field doesn't contain original value.
 * <p>
 * Also this class allows to set raw value to the <code>MILLISECOND</code> field
 * directly before formatting.
 */
public  class MicrosCalendar extends java.util.GregorianCalendar {
  public   MicrosCalendar (java.util.TimeZone tz, int digitsInFraction)  { throw new RuntimeException(); }
  public  long getMicros ()  { throw new RuntimeException(); }
  public  void setMicros (long micros)  { throw new RuntimeException(); }
}
