package org.apache.spark.sql.execution;
/**
 * A trait that is used as a tag to indicate a transition from rows to columns. This allows plugins
 * to replace the current {@link RowToColumnarExec} with an optimized version and still have operations
 * that walk a spark plan looking for this type of transition properly match it.
 */
public  interface RowToColumnarTransition extends org.apache.spark.sql.execution.UnaryExecNode {
}
