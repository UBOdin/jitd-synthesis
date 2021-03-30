package org.apache.spark.sql.execution;
/**
 * A trait that is used as a tag to indicate a transition from columns to rows. This allows plugins
 * to replace the current {@link ColumnarToRowExec} with an optimized version and still have operations
 * that walk a spark plan looking for this type of transition properly match it.
 */
public  interface ColumnarToRowTransition extends org.apache.spark.sql.execution.UnaryExecNode {
}
