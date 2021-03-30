package org.apache.spark.sql.execution.adaptive;
public  class ShufflePartitionsUtil {
  static public final  double SMALL_PARTITION_FACTOR ()  { throw new RuntimeException(); }
  static public final  double MERGED_PARTITION_FACTOR ()  { throw new RuntimeException(); }
  /**
   * Coalesce the partitions from multiple shuffles. This method assumes that all the shuffles
   * have the same number of partitions, and the partitions of same index will be read together
   * by one task.
   * <p>
   * The strategy used to determine the number of coalesced partitions is described as follows.
   * To determine the number of coalesced partitions, we have a target size for a coalesced
   * partition. Once we have size statistics of all shuffle partitions, we will do
   * a pass of those statistics and pack shuffle partitions with continuous indices to a single
   * coalesced partition until adding another shuffle partition would cause the size of a
   * coalesced partition to be greater than the target size.
   * <p>
   * For example, we have two shuffles with the following partition size statistics:
   *  - shuffle 1 (5 partitions): [100 MiB, 20 MiB, 100 MiB, 10MiB, 30 MiB]
   *  - shuffle 2 (5 partitions): [10 MiB,  10 MiB, 70 MiB,  5 MiB, 5 MiB]
   * Assuming the target size is 128 MiB, we will have 4 coalesced partitions, which are:
   *  - coalesced partition 0: shuffle partition 0 (size 110 MiB)
   *  - coalesced partition 1: shuffle partition 1 (size 30 MiB)
   *  - coalesced partition 2: shuffle partition 2 (size 170 MiB)
   *  - coalesced partition 3: shuffle partition 3 and 4 (size 50 MiB)
   * <p>
   *  @return A sequence of {@link CoalescedPartitionSpec}s. For example, if partitions [0, 1, 2, 3, 4]
   *          split at indices [0, 2, 3], the returned partition specs will be:
   *          CoalescedPartitionSpec(0, 2), CoalescedPartitionSpec(2, 3) and
   *          CoalescedPartitionSpec(3, 5).
   * @param mapOutputStatistics (undocumented)
   * @param advisoryTargetSize (undocumented)
   * @param minNumPartitions (undocumented)
   */
  static public  scala.collection.Seq<org.apache.spark.sql.execution.ShufflePartitionSpec> coalescePartitions (org.apache.spark.MapOutputStatistics[] mapOutputStatistics, long advisoryTargetSize, int minNumPartitions)  { throw new RuntimeException(); }
  /**
   * Given a list of size, return an array of indices to split the list into multiple partitions,
   * so that the size sum of each partition is close to the target size. Each index indicates the
   * start of a partition.
   * @param sizes (undocumented)
   * @param targetSize (undocumented)
   * @return (undocumented)
   */
  static public  int[] splitSizeListByTargetSize (scala.collection.Seq<java.lang.Object> sizes, long targetSize)  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
  static protected  java.lang.String logName ()  { throw new RuntimeException(); }
  static protected  org.slf4j.Logger log ()  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg)  { throw new RuntimeException(); }
  static protected  void logInfo (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logDebug (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logTrace (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logWarning (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  void logError (scala.Function0<java.lang.String> msg, java.lang.Throwable throwable)  { throw new RuntimeException(); }
  static protected  boolean isTraceEnabled ()  { throw new RuntimeException(); }
  static protected  void initializeLogIfNecessary (boolean isInterpreter)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
  static protected  boolean initializeLogIfNecessary$default$2 ()  { throw new RuntimeException(); }
  static   void initializeForcefully (boolean isInterpreter, boolean silent)  { throw new RuntimeException(); }
}
