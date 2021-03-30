package org.apache.spark.sql.execution.datasources.parquet;
/**
 * A {@link ParentContainerUpdater} is used by a Parquet converter to set converted values to some
 * corresponding parent container. For example, a converter for a <code>StructType</code> field may set
 * converted values to a {@link InternalRow}; or a converter for array elements may append converted
 * values to an {@link ArrayBuffer}.
 */
public  interface ParentContainerUpdater {
  /** Called after a record field is being converted */
  public  void end ()  ;
  public  void set (Object value)  ;
  public  void setBoolean (boolean value)  ;
  public  void setByte (byte value)  ;
  public  void setDouble (double value)  ;
  public  void setFloat (float value)  ;
  public  void setInt (int value)  ;
  public  void setLong (long value)  ;
  public  void setShort (short value)  ;
  /** Called before a record field is being converted */
  public  void start ()  ;
}
