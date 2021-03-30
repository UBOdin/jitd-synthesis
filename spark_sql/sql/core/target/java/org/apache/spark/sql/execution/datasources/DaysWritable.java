package org.apache.spark.sql.execution.datasources;
/**
 * The class accepts/returns days in Gregorian calendar and rebase them
 * via conversion to local date in Julian calendar for dates before 1582-10-15
 * in read/write for backward compatibility with Spark 2.4 and earlier versions.
 * <p>
 * param:  gregorianDays The number of days since the epoch 1970-01-01 in
 *                      Gregorian calendar.
 * param:  julianDays The number of days since the epoch 1970-01-01 in
 *                   Julian calendar.
 */
public  class DaysWritable extends org.apache.hadoop.hive.serde2.io.DateWritable {
  // not preceding
  public   DaysWritable (int gregorianDays, int julianDays)  { throw new RuntimeException(); }
  public   DaysWritable ()  { throw new RuntimeException(); }
  public   DaysWritable (int gregorianDays)  { throw new RuntimeException(); }
  public   DaysWritable (org.apache.hadoop.hive.serde2.io.DateWritable dateWritable)  { throw new RuntimeException(); }
  public  java.sql.Date get ()  { throw new RuntimeException(); }
  public  java.sql.Date get (boolean doesTimeMatter)  { throw new RuntimeException(); }
  public  int getDays ()  { throw new RuntimeException(); }
  public  int gregorianDays ()  { throw new RuntimeException(); }
  public  int julianDays ()  { throw new RuntimeException(); }
  public  void readFields (java.io.DataInput in) throws java.io.IOException { throw new RuntimeException(); }
  public  void set (int d)  { throw new RuntimeException(); }
  public  void write (java.io.DataOutput out) throws java.io.IOException { throw new RuntimeException(); }
}
