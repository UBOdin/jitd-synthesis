package org.apache.spark.sql.execution;
/**
 * A Partitioner that might group together one or more partitions from the parent.
 * <p>
 * param:  parent a parent partitioner
 * param:  partitionStartIndices indices of partitions in parent that should create new partitions
 *   in child (this should be an array of increasing partition IDs). For example, if we have a
 *   parent with 5 partitions, and partitionStartIndices is [0, 2, 4], we get three output
 *   partitions, corresponding to partition ranges [0, 1], [2, 3] and [4] of the parent partitioner.
 */
public  class CoalescedPartitioner extends org.apache.spark.Partitioner {
  // not preceding
  public   CoalescedPartitioner (org.apache.spark.Partitioner parent, int[] partitionStartIndices)  { throw new RuntimeException(); }
  public  boolean equals (Object other)  { throw new RuntimeException(); }
  public  int getPartition (Object key)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  public  int numPartitions ()  { throw new RuntimeException(); }
  public  org.apache.spark.Partitioner parent ()  { throw new RuntimeException(); }
  public  int[] partitionStartIndices ()  { throw new RuntimeException(); }
}
