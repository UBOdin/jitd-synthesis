package org.apache.spark.sql.execution.streaming;
public  class HDFSMetadataLog$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final HDFSMetadataLog$ MODULE$ = null;
  public   HDFSMetadataLog$ ()  { throw new RuntimeException(); }
  /**
   * Verify if batchIds are continuous and between <code>startId</code> and <code>endId</code> (both inclusive and
   * startId assumed to be <= endId).
   * <p>
   * @param batchIds the sorted ids to verify.
   * @param startId the start id. If it's set, batchIds should start with this id.
   * @param endId the start id. If it's set, batchIds should end with this id.
   */
  public  void verifyBatchIds (scala.collection.Seq<java.lang.Object> batchIds, scala.Option<java.lang.Object> startId, scala.Option<java.lang.Object> endId)  { throw new RuntimeException(); }
}
