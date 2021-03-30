package org.apache.spark.sql.execution.joins;
/**
 * An abstract iterator for sharing code between {@link LeftOuterIterator} and {@link RightOuterIterator}.
 * <p>
 * Each {@link OneSideOuterIterator} has a streamed side and a buffered side. Each row on the
 * streamed side will output 0 or many rows, one for each matching row on the buffered side.
 * If there are no matches, then the buffered side of the joined output will be a null row.
 * <p>
 * In left outer join, the left is the streamed side and the right is the buffered side.
 * In right outer join, the right is the streamed side and the left is the buffered side.
 * <p>
 * param:  smjScanner a scanner that streams rows and buffers any matching rows
 * param:  bufferedSideNullRow the default row to return when a streamed row has no matches
 * param:  boundCondition an additional filter condition for buffered rows
 * param:  resultProj how the output should be projected
 * param:  numOutputRows an accumulator metric for the number of rows output
 */
public abstract class OneSideOuterIterator extends org.apache.spark.sql.execution.RowIterator {
  public   OneSideOuterIterator (org.apache.spark.sql.execution.joins.SortMergeJoinScanner smjScanner, org.apache.spark.sql.catalyst.InternalRow bufferedSideNullRow, scala.Function1<org.apache.spark.sql.catalyst.InternalRow, java.lang.Object> boundCondition, scala.Function1<org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.catalyst.InternalRow> resultProj, org.apache.spark.sql.execution.metric.SQLMetric numOutputRows)  { throw new RuntimeException(); }
  public  boolean advanceNext ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.InternalRow getRow ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.JoinedRow joinedRow ()  { throw new RuntimeException(); }
  protected abstract  void setBufferedSideOutput (org.apache.spark.sql.catalyst.InternalRow row)  ;
  protected abstract  void setStreamSideOutput (org.apache.spark.sql.catalyst.InternalRow row)  ;
}
