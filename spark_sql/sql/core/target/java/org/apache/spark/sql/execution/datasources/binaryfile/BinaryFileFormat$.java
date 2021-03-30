package org.apache.spark.sql.execution.datasources.binaryfile;
public  class BinaryFileFormat$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final BinaryFileFormat$ MODULE$ = null;
  public   BinaryFileFormat$ ()  { throw new RuntimeException(); }
    java.lang.String PATH ()  { throw new RuntimeException(); }
    java.lang.String MODIFICATION_TIME ()  { throw new RuntimeException(); }
    java.lang.String LENGTH ()  { throw new RuntimeException(); }
    java.lang.String CONTENT ()  { throw new RuntimeException(); }
    java.lang.String BINARY_FILE ()  { throw new RuntimeException(); }
  /**
   * Schema for the binary file data source.
   * <p>
   * Schema:
   *  - path (StringType): The path of the file.
   *  - modificationTime (TimestampType): The modification time of the file.
   *    In some Hadoop FileSystem implementation, this might be unavailable and fallback to some
   *    default value.
   *  - length (LongType): The length of the file in bytes.
   *  - content (BinaryType): The content of the file.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
    scala.Function1<org.apache.hadoop.fs.FileStatus, java.lang.Object> createFilterFunction (org.apache.spark.sql.sources.Filter filter)  { throw new RuntimeException(); }
}
