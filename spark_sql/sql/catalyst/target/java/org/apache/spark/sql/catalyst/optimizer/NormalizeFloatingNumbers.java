package org.apache.spark.sql.catalyst.optimizer;
/**
 * We need to take care of special floating numbers (NaN and -0.0) in several places:
 *   1. When compare values, different NaNs should be treated as same, <code>-0.0</code> and <code>0.0</code> should be
 *      treated as same.
 *   2. In aggregate grouping keys, different NaNs should belong to the same group, -0.0 and 0.0
 *      should belong to the same group.
 *   3. In join keys, different NaNs should be treated as same, <code>-0.0</code> and <code>0.0</code> should be
 *      treated as same.
 *   4. In window partition keys, different NaNs should belong to the same partition, -0.0 and 0.0
 *      should belong to the same partition.
 * <p>
 * Case 1 is fine, as we handle NaN and -0.0 well during comparison. For complex types, we
 * recursively compare the fields/elements, so it's also fine.
 * <p>
 * Case 2, 3 and 4 are problematic, as Spark SQL turns grouping/join/window partition keys into
 * binary <code>UnsafeRow</code> and compare the binary data directly. Different NaNs have different binary
 * representation, and the same thing happens for -0.0 and 0.0.
 * <p>
 * This rule normalizes NaN and -0.0 in window partition keys, join keys and aggregate grouping
 * keys.
 * <p>
 * Ideally we should do the normalization in the physical operators that compare the
 * binary <code>UnsafeRow</code> directly. We don't need this normalization if the Spark SQL execution engine
 * is not optimized to run on binary data. This rule is created to simplify the implementation, so
 * that we have a single place to do normalization, which is more maintainable.
 * <p>
 * Note that, this rule must be executed at the end of optimizer, because the optimizer may create
 * new joins(the subquery rewrite) and new join conditions(the join reorder).
 */
public  class NormalizeFloatingNumbers {
  static public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.catalyst.expressions.Expression normalize (org.apache.spark.sql.catalyst.expressions.Expression expr)  { throw new RuntimeException(); }
  static public  scala.Function1<java.lang.Object, java.lang.Object> FLOAT_NORMALIZER ()  { throw new RuntimeException(); }
  static public  scala.Function1<java.lang.Object, java.lang.Object> DOUBLE_NORMALIZER ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.internal.SQLConf conf ()  { throw new RuntimeException(); }
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
  static public  java.lang.String ruleName ()  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
}
