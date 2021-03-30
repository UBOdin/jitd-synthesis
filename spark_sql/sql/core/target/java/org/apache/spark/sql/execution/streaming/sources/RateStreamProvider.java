package org.apache.spark.sql.execution.streaming.sources;
/**
 *  A source that generates increment long values with timestamps. Each generated row has two
 *  columns: a timestamp column for the generated time and an auto increment long column starting
 *  with 0L.
 * <p>
 *  This source supports the following options:
 *  - <code>rowsPerSecond</code> (e.g. 100, default: 1): How many rows should be generated per second.
 *  - <code>rampUpTime</code> (e.g. 5s, default: 0s): How long to ramp up before the generating speed
 *    becomes <code>rowsPerSecond</code>. Using finer granularities than seconds will be truncated to integer
 *    seconds.
 *  - <code>numPartitions</code> (e.g. 10, default: Spark's default parallelism): The partition number for the
 *    generated rows. The source will try its best to reach <code>rowsPerSecond</code>, but the query may
 *    be resource constrained, and <code>numPartitions</code> can be tweaked to help reach the desired speed.
 */
public  class RateStreamProvider implements org.apache.spark.sql.internal.connector.SimpleTableProvider, org.apache.spark.sql.sources.DataSourceRegister {
  static public  org.apache.spark.sql.types.StructType SCHEMA ()  { throw new RuntimeException(); }
  static public  int VERSION ()  { throw new RuntimeException(); }
  static public  java.lang.String NUM_PARTITIONS ()  { throw new RuntimeException(); }
  static public  java.lang.String ROWS_PER_SECOND ()  { throw new RuntimeException(); }
  static public  java.lang.String RAMP_UP_TIME ()  { throw new RuntimeException(); }
  /** Calculate the end value we will emit at the time `seconds`. */
  static public  long valueAtSecond (long seconds, long rowsPerSecond, long rampUpTimeSeconds)  { throw new RuntimeException(); }
  public   RateStreamProvider ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.catalog.Table getTable (org.apache.spark.sql.util.CaseInsensitiveStringMap options)  { throw new RuntimeException(); }
  public  java.lang.String shortName ()  { throw new RuntimeException(); }
}
