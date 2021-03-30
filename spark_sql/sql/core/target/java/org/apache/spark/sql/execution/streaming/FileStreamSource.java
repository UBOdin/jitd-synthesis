package org.apache.spark.sql.execution.streaming;
/**
 * A very simple source that reads files from the given directory as they appear.
 */
public  class FileStreamSource implements org.apache.spark.sql.connector.read.streaming.SupportsAdmissionControl, org.apache.spark.sql.execution.streaming.Source, org.apache.spark.internal.Logging {
  static public  class FileEntry implements scala.Serializable, scala.Product {
    public  java.lang.String path ()  { throw new RuntimeException(); }
    public  long timestamp ()  { throw new RuntimeException(); }
    public  long batchId ()  { throw new RuntimeException(); }
    // not preceding
    public   FileEntry (java.lang.String path, long timestamp, long batchId)  { throw new RuntimeException(); }
  }
  static public  class FileEntry$ extends scala.runtime.AbstractFunction3<java.lang.String, java.lang.Object, java.lang.Object, org.apache.spark.sql.execution.streaming.FileStreamSource.FileEntry> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final FileEntry$ MODULE$ = null;
    public   FileEntry$ ()  { throw new RuntimeException(); }
  }
  static  abstract class FileStreamSourceCleaner implements org.apache.spark.internal.Logging {
    public   FileStreamSourceCleaner ()  { throw new RuntimeException(); }
    public  void stop ()  { throw new RuntimeException(); }
    public  void clean (org.apache.spark.sql.execution.streaming.FileStreamSource.FileEntry entry)  { throw new RuntimeException(); }
    protected abstract  void cleanTask (org.apache.spark.sql.execution.streaming.FileStreamSource.FileEntry entry)  ;
  }
  static public  class FileStreamSourceCleaner$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final FileStreamSourceCleaner$ MODULE$ = null;
    public   FileStreamSourceCleaner$ ()  { throw new RuntimeException(); }
    public  scala.Option<org.apache.spark.sql.execution.streaming.FileStreamSource.FileStreamSourceCleaner> apply (org.apache.hadoop.fs.FileSystem fileSystem, org.apache.hadoop.fs.Path sourcePath, org.apache.spark.sql.execution.streaming.FileStreamOptions option, org.apache.hadoop.conf.Configuration hadoopConf)  { throw new RuntimeException(); }
  }
  /**
   * A custom hash map used to track the list of files seen. This map is not thread-safe.
   * <p>
   * To prevent the hash map from growing indefinitely, a purge function is available to
   * remove files "maxAgeMs" older than the latest file.
   */
  static public  class SeenFilesMap {
    public   SeenFilesMap (long maxAgeMs, boolean fileNameOnly)  { throw new RuntimeException(); }
    /** Add a new file to the map. */
    public  void add (java.lang.String path, long timestamp)  { throw new RuntimeException(); }
    /**
     * Returns true if we should consider this file a new file. The file is only considered "new"
     * if it is new enough that we are still tracking, and we have not seen it before.
     * @param path (undocumented)
     * @param timestamp (undocumented)
     * @return (undocumented)
     */
    public  boolean isNewFile (java.lang.String path, long timestamp)  { throw new RuntimeException(); }
    /** Removes aged entries and returns the number of files removed. */
    public  int purge ()  { throw new RuntimeException(); }
    public  int size ()  { throw new RuntimeException(); }
  }
  static   class SourceFileArchiver extends org.apache.spark.sql.execution.streaming.FileStreamSource.FileStreamSourceCleaner implements org.apache.spark.internal.Logging {
    public   SourceFileArchiver (org.apache.hadoop.fs.FileSystem fileSystem, org.apache.hadoop.fs.Path sourcePath, org.apache.hadoop.fs.FileSystem baseArchiveFileSystem, org.apache.hadoop.fs.Path baseArchivePath)  { throw new RuntimeException(); }
    protected  void cleanTask (org.apache.spark.sql.execution.streaming.FileStreamSource.FileEntry entry)  { throw new RuntimeException(); }
  }
  static   class SourceFileRemover extends org.apache.spark.sql.execution.streaming.FileStreamSource.FileStreamSourceCleaner implements org.apache.spark.internal.Logging {
    public   SourceFileRemover (org.apache.hadoop.fs.FileSystem fileSystem)  { throw new RuntimeException(); }
    protected  void cleanTask (org.apache.spark.sql.execution.streaming.FileStreamSource.FileEntry entry)  { throw new RuntimeException(); }
  }
  static public  double DISCARD_UNSEEN_FILES_RATIO ()  { throw new RuntimeException(); }
  static public  int MAX_CACHED_UNSEEN_FILES ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  // not preceding
  public   FileStreamSource (org.apache.spark.sql.SparkSession sparkSession, java.lang.String path, java.lang.String fileFormatClassName, org.apache.spark.sql.types.StructType schema, scala.collection.Seq<java.lang.String> partitionColumns, java.lang.String metadataPath, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /** A mapping from a file that we have processed to some timestamp it was last modified. */
  public  org.apache.spark.sql.execution.streaming.FileStreamSource.SeenFilesMap seenFiles ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.ReadLimit getDefaultReadLimit ()  { throw new RuntimeException(); }
  /**
   * For test only. Run <code>func</code> with the internal lock to make sure when <code>func</code> is running,
   * the current offset won't be changed and no new batch will be emitted.
   * @param func (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> T withBatchingLocked (scala.Function0<T> func)  { throw new RuntimeException(); }
  /** Return the latest offset in the {@link FileStreamSourceLog} */
  public  long currentLogOffset ()  { throw new RuntimeException(); }
  /**
   * Returns the data that is between the offsets (<code>start</code>, <code>end</code>].
   * @param start (undocumented)
   * @param end (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> getBatch (scala.Option<org.apache.spark.sql.execution.streaming.Offset> start, org.apache.spark.sql.execution.streaming.Offset end)  { throw new RuntimeException(); }
  /**
   * If the source has a metadata log indicating which files should be read, then we should use it.
   * Only when user gives a non-glob path that will we figure out whether the source has some
   * metadata log
   * <p>
   * None        means we don't know at the moment
   * Some(true)  means we know for sure the source DOES have metadata
   * Some(false) means we know for sure the source DOSE NOT have metadata
   * @return (undocumented)
   */
    scala.Option<java.lang.Object> sourceHasMetadata ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.execution.streaming.Offset> getOffset ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.connector.read.streaming.Offset latestOffset (org.apache.spark.sql.connector.read.streaming.Offset startOffset, org.apache.spark.sql.connector.read.streaming.ReadLimit limit)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  /**
   * Informs the source that Spark has completed processing all data for offsets less than or
   * equal to <code>end</code> and will only request offsets greater than <code>end</code> in the future.
   * @param end (undocumented)
   */
  public  void commit (org.apache.spark.sql.execution.streaming.Offset end)  { throw new RuntimeException(); }
  public  void stop ()  { throw new RuntimeException(); }
}
