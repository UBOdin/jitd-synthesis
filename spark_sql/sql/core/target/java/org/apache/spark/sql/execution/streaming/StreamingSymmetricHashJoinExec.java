package org.apache.spark.sql.execution.streaming;
/**
 * Performs stream-stream join using symmetric hash join algorithm. It works as follows.
 * <p>
 *                             /-----------------------\
 *   left side input --------->|    left side state    |------\
 *                             \-----------------------/      |
 *                                                            |--------> joined output
 *                             /-----------------------\      |
 *   right side input -------->|    right side state   |------/
 *                             \-----------------------/
 * <p>
 * Each join side buffers past input rows as streaming state so that the past input can be joined
 * with future input on the other side. This buffer state is effectively a multi-map:
 *    equi-join key -> list of past input rows received with the join key
 * <p>
 * For each input row in each side, the following operations take place.
 * - Calculate join key from the row.
 * - Use the join key to append the row to the buffer state of the side that the row came from.
 * - Find past buffered values for the key from the other side. For each such value, emit the
 *   "joined row" (left-row, right-row)
 * - Apply the optional condition to filter the joined rows as the final output.
 * <p>
 * If a timestamp column with event time watermark is present in the join keys or in the input
 * data, then it uses the watermark to figure out which rows in the buffer will not join with
 * the new data, and therefore can be discarded. Depending on the provided query conditions, we
 * can define thresholds on both state key (i.e. joining keys) and state value (i.e. input rows).
 * There are three kinds of queries possible regarding this as explained below.
 * Assume that watermark has been defined on both <code>leftTime</code> and <code>rightTime</code> columns used below.
 * <p>
 * 1. When timestamp/time-window + watermark is in the join keys. Example (pseudo-SQL):
 * <p>
 *      SELECT * FROM leftTable, rightTable
 *      ON
 *        leftKey = rightKey AND
 *        window(leftTime, "1 hour") = window(rightTime, "1 hour")    // 1hr tumbling windows
 * <p>
 *    In this case, this operator will join rows newer than watermark which fall in the same
 *    1 hour window. Say the event-time watermark is "12:34" (both left and right input).
 *    Then input rows can only have time > 12:34. Hence, they can only join with buffered rows
 *    where window >= 12:00 - 1:00 and all buffered rows with join window < 12:00 can be
 *    discarded. In other words, the operator will discard all state where
 *    window in state key (i.e. join key) < event time watermark. This threshold is called
 *    State Key Watermark.
 * <p>
 * 2. When timestamp range conditions are provided (no time/window + watermark in join keys). E.g.
 * <p>
 *      SELECT * FROM leftTable, rightTable
 *      ON
 *        leftKey = rightKey AND
 *        leftTime > rightTime - INTERVAL 8 MINUTES AND leftTime < rightTime + INTERVAL 1 HOUR
 * <p>
 *   In this case, the event-time watermark and the BETWEEN condition can be used to calculate a
 *   state watermark, i.e., time threshold for the state rows that can be discarded.
 *   For example, say each join side has a time column, named "leftTime" and
 *   "rightTime", and there is a join condition "leftTime > rightTime - 8 min".
 *   While processing, say the watermark on right input is "12:34". This means that from henceforth,
 *   only right inputs rows with "rightTime > 12:34" will be processed, and any older rows will be
 *   considered as "too late" and therefore dropped. Then, the left side buffer only needs
 *   to keep rows where "leftTime > rightTime - 8 min > 12:34 - 8m > 12:26".
 *   That is, the left state watermark is 12:26, and any rows older than that can be dropped from
 *   the state. In other words, the operator will discard all state where
 *   timestamp in state value (input rows) < state watermark. This threshold is called
 *   State Value Watermark (to distinguish from the state key watermark).
 * <p>
 *   Note:
 *   - The event watermark value of one side is used to calculate the
 *     state watermark of the other side. That is, a condition ~ "leftTime > rightTime + X" with
 *     right side event watermark is used to calculate the left side state watermark. Conversely,
 *     a condition ~ "left < rightTime + Y" with left side event watermark is used to calculate
 *     right side state watermark.
 *   - Depending on the conditions, the state watermark maybe different for the left and right
 *     side. In the above example, leftTime > 12:26 AND rightTime > 12:34 - 1 hour = 11:34.
 *   - State can be dropped from BOTH sides only when there are conditions of the above forms that
 *     define time bounds on timestamp in both directions.
 * <p>
 * 3. When both window in join key and time range conditions are present, case 1 + 2.
 *    In this case, since window equality is a stricter condition than the time range, we can
 *    use the State Key Watermark = event time watermark to discard state (similar to case 1).
 * <p>
 * param:  leftKeys  Expression to generate key rows for joining from left input
 * param:  rightKeys Expression to generate key rows for joining from right input
 * param:  joinType  Type of join (inner, left outer, etc.)
 * param:  condition Conditions to filter rows, split by left, right, and joined. See
 *                  {@link JoinConditionSplitPredicates}
 * param:  stateInfo Version information required to read join state (buffered rows)
 * param:  eventTimeWatermark Watermark of input event, same for both sides
 * param:  stateWatermarkPredicates Predicates for removal of state, see
 *                                 {@link JoinStateWatermarkPredicates}
 * param:  left      Left child plan
 * param:  right     Right child plan
 */
public  class StreamingSymmetricHashJoinExec extends org.apache.spark.sql.execution.SparkPlan implements org.apache.spark.sql.execution.BinaryExecNode, org.apache.spark.sql.execution.streaming.StateStoreWriter, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.metric.SQLMetric> metrics ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> leftKeys ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> rightKeys ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.JoinType joinType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.StreamingSymmetricHashJoinHelper.JoinConditionSplitPredicates condition ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.execution.streaming.StatefulOperatorStateInfo> stateInfo ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Object> eventTimeWatermark ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.streaming.StreamingSymmetricHashJoinHelper.JoinStateWatermarkPredicates stateWatermarkPredicates ()  { throw new RuntimeException(); }
  public  int stateFormatVersion ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan left ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.SparkPlan right ()  { throw new RuntimeException(); }
  // not preceding
  public   StreamingSymmetricHashJoinExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> leftKeys, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> rightKeys, org.apache.spark.sql.catalyst.plans.JoinType joinType, org.apache.spark.sql.execution.streaming.StreamingSymmetricHashJoinHelper.JoinConditionSplitPredicates condition, scala.Option<org.apache.spark.sql.execution.streaming.StatefulOperatorStateInfo> stateInfo, scala.Option<java.lang.Object> eventTimeWatermark, org.apache.spark.sql.execution.streaming.StreamingSymmetricHashJoinHelper.JoinStateWatermarkPredicates stateWatermarkPredicates, int stateFormatVersion, org.apache.spark.sql.execution.SparkPlan left, org.apache.spark.sql.execution.SparkPlan right)  { throw new RuntimeException(); }
  public   StreamingSymmetricHashJoinExec (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> leftKeys, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> rightKeys, org.apache.spark.sql.catalyst.plans.JoinType joinType, scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> condition, int stateFormatVersion, org.apache.spark.sql.execution.SparkPlan left, org.apache.spark.sql.execution.SparkPlan right)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.GenericInternalRow nullLeft ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.GenericInternalRow nullRight ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.plans.physical.Distribution> requiredChildDistribution ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  { throw new RuntimeException(); }
  public  boolean shouldRunAnotherBatch (org.apache.spark.sql.execution.streaming.OffsetSeqMetadata newMetadata)  { throw new RuntimeException(); }
  protected  org.apache.spark.rdd.RDD<org.apache.spark.sql.catalyst.InternalRow> doExecute ()  { throw new RuntimeException(); }
}
