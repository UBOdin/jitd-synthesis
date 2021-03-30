package org.apache.spark.sql.execution.datasources;
/**
 * {@link OutputWriter} is used together with {@link HadoopFsRelation} for persisting rows to the
 * underlying file system.  Subclasses of {@link OutputWriter} must provide a zero-argument constructor.
 * An {@link OutputWriter} instance is created and initialized when a new output file is opened on
 * executor side.  This instance is used to persist rows to this single output file.
 */
public abstract class OutputWriter {
  public   OutputWriter ()  { throw new RuntimeException(); }
  /**
   * Closes the {@link OutputWriter}. Invoked on the executor side after all rows are persisted, before
   * the task output is committed.
   */
  public abstract  void close ()  ;
  /**
   * Persists a single row.  Invoked on the executor side.  When writing to dynamically partitioned
   * tables, dynamic partition columns are not included in rows to be written.
   * @param row (undocumented)
   */
  public abstract  void write (org.apache.spark.sql.catalyst.InternalRow row)  ;
}
