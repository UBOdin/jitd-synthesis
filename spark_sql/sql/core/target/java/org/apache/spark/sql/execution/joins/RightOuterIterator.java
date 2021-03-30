package org.apache.spark.sql.execution.joins;
/**
 * An iterator for outputting rows in right outer join.
 */
public  class RightOuterIterator extends org.apache.spark.sql.execution.joins.OneSideOuterIterator {
  public   RightOuterIterator (org.apache.spark.sql.execution.joins.SortMergeJoinScanner smjScanner, org.apache.spark.sql.catalyst.InternalRow leftNullRow, scala.Function1<org.apache.spark.sql.catalyst.InternalRow, java.lang.Object> boundCondition, scala.Function1<org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.catalyst.InternalRow> resultProj, org.apache.spark.sql.execution.metric.SQLMetric numOutputRows)  { throw new RuntimeException(); }
  protected  void setBufferedSideOutput (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
  protected  void setStreamSideOutput (org.apache.spark.sql.catalyst.InternalRow row)  { throw new RuntimeException(); }
}
