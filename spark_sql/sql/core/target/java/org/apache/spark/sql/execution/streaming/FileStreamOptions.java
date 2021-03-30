package org.apache.spark.sql.execution.streaming;
/**
 * User specified options for file streams.
 */
public  class FileStreamOptions implements org.apache.spark.internal.Logging {
  public   FileStreamOptions (org.apache.spark.sql.catalyst.util.CaseInsensitiveMap<java.lang.String> parameters)  { throw new RuntimeException(); }
  public   FileStreamOptions (scala.collection.immutable.Map<java.lang.String, java.lang.String> parameters)  { throw new RuntimeException(); }
  /**
   * Defines how to clean up completed files. Available options are "archive", "delete", "off".
   * @return (undocumented)
   */
  public  scala.Enumeration.Value cleanSource ()  { throw new RuntimeException(); }
  /**
   * Whether to check new files based on only the filename instead of on the full path.
   * <p>
   * With this set to <code>true</code>, the following files would be considered as the same file, because
   * their filenames, "dataset.txt", are the same:
   * - "file:///dataset.txt"
   * - "s3://a/dataset.txt"
   * - "s3n://a/b/dataset.txt"
   * - "s3a://a/b/c/dataset.txt"
   * @return (undocumented)
   */
  public  boolean fileNameOnly ()  { throw new RuntimeException(); }
  /**
   * Whether to scan latest files first. If it's true, when the source finds unprocessed files in a
   * trigger, it will first process the latest files.
   * @return (undocumented)
   */
  public  boolean latestFirst ()  { throw new RuntimeException(); }
  /**
   * Maximum age of a file that can be found in this directory, before it is ignored. For the
   * first batch all files will be considered valid. If <code>latestFirst</code> is set to <code>true</code> and
   * <code>maxFilesPerTrigger</code> is set, then this parameter will be ignored, because old files that are
   * valid, and should be processed, may be ignored. Please refer to SPARK-19813 for details.
   * <p>
   * The max age is specified with respect to the timestamp of the latest file, and not the
   * timestamp of the current system. That this means if the last file has timestamp 1000, and the
   * current system time is 2000, and max age is 200, the system will purge files older than
   * 800 (rather than 1800) from the internal state.
   * <p>
   * Default to a week.
   * @return (undocumented)
   */
  public  long maxFileAgeMs ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> maxFilesPerTrigger ()  { throw new RuntimeException(); }
  /** Options as specified by the user, in a case-insensitive map, without "path" set. */
  public  scala.collection.immutable.Map<java.lang.String, java.lang.String> optionMapWithoutPath ()  { throw new RuntimeException(); }
  /**
   * The archive directory to move completed files. The option will be only effective when
   * "cleanSource" is set to "archive".
   * <p>
   * Note that the completed file will be moved to this archive directory with respecting to
   * its own path.
   * <p>
   * For example, if the path of source file is "/a/b/dataset.txt", and the path of archive
   * directory is "/archived/here", file will be moved to "/archived/here/a/b/dataset.txt".
   * @return (undocumented)
   */
  public  scala.Option<java.lang.String> sourceArchiveDir ()  { throw new RuntimeException(); }
}
