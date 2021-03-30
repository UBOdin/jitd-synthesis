package org.apache.spark.sql.execution.datasources.parquet;
/** A no-op updater used for root converter (who doesn't have a parent). */
public  class NoopUpdater {
  static public  void start ()  { throw new RuntimeException(); }
  static public  void end ()  { throw new RuntimeException(); }
  static public  void set (Object value)  { throw new RuntimeException(); }
  static public  void setBoolean (boolean value)  { throw new RuntimeException(); }
  static public  void setByte (byte value)  { throw new RuntimeException(); }
  static public  void setShort (short value)  { throw new RuntimeException(); }
  static public  void setInt (int value)  { throw new RuntimeException(); }
  static public  void setLong (long value)  { throw new RuntimeException(); }
  static public  void setFloat (float value)  { throw new RuntimeException(); }
  static public  void setDouble (double value)  { throw new RuntimeException(); }
}
