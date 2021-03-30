package org.apache.spark.sql.catalyst.analysis;
/**
 * An analyzer rule that replaces {@link UnresolvedInlineTable} with {@link LocalRelation}.
 */
public  class ResolveInlineTables {
  static public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
  /**
   * Validates the input data dimension:
   * 1. All rows have the same cardinality.
   * 2. The number of column aliases defined is consistent with the number of columns in data.
   * <p>
   * This is package visible for unit testing.
   * @param table (undocumented)
   */
  static   void validateInputDimension (org.apache.spark.sql.catalyst.analysis.UnresolvedInlineTable table)  { throw new RuntimeException(); }
  /**
   * Validates that all inline table data are valid expressions that can be evaluated
   * (in this they must be foldable).
   * <p>
   * This is package visible for unit testing.
   * @param table (undocumented)
   */
  static   void validateInputEvaluable (org.apache.spark.sql.catalyst.analysis.UnresolvedInlineTable table)  { throw new RuntimeException(); }
  /**
   * Convert a valid (with right shape and foldable inputs) {@link UnresolvedInlineTable}
   * into a {@link LocalRelation}.
   * <p>
   * This function attempts to coerce inputs into consistent types.
   * <p>
   * This is package visible for unit testing.
   * @param table (undocumented)
   * @return (undocumented)
   */
  static   org.apache.spark.sql.catalyst.plans.logical.LocalRelation convert (org.apache.spark.sql.catalyst.analysis.UnresolvedInlineTable table)  { throw new RuntimeException(); }
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
  static public  org.apache.spark.sql.catalyst.expressions.Cast cast (org.apache.spark.sql.catalyst.expressions.Expression child, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
}
