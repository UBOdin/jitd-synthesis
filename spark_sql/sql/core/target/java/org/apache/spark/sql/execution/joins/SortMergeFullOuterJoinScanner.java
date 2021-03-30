package org.apache.spark.sql.execution.joins;
public  class SortMergeFullOuterJoinScanner {
  public   SortMergeFullOuterJoinScanner (org.apache.spark.sql.catalyst.expressions.Projection leftKeyGenerator, org.apache.spark.sql.catalyst.expressions.Projection rightKeyGenerator, scala.math.Ordering<org.apache.spark.sql.catalyst.InternalRow> keyOrdering, org.apache.spark.sql.execution.RowIterator leftIter, org.apache.spark.sql.execution.RowIterator rightIter, scala.Function1<org.apache.spark.sql.catalyst.InternalRow, java.lang.Object> boundCondition, org.apache.spark.sql.catalyst.InternalRow leftNullRow, org.apache.spark.sql.catalyst.InternalRow rightNullRow)  { throw new RuntimeException(); }
  public  boolean advanceNext ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.JoinedRow getJoinedRow ()  { throw new RuntimeException(); }
}
