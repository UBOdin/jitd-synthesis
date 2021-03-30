package org.apache.spark.sql.catalyst.optimizer;
/**
 * A rule that converts conditional expressions to predicate expressions, if possible, in the
 * search condition of the WHERE/HAVING/ON(JOIN) clauses, which contain an implicit Boolean operator
 * "(search condition) = TRUE". After this converting, we can potentially push the filter down to
 * the data source.
 * <p>
 * Supported cases are:
 * - IF(cond, trueVal, false)                   =&gt; AND(cond, trueVal)
 * - IF(cond, trueVal, true)                    =&gt; OR(NOT(cond), trueVal)
 * - IF(cond, false, falseVal)                  =&gt; AND(NOT(cond), elseVal)
 * - IF(cond, true, falseVal)                   =&gt; OR(cond, elseVal)
 * - CASE WHEN cond THEN trueVal ELSE false END =&gt; AND(cond, trueVal)
 * - CASE WHEN cond THEN trueVal END            =&gt; AND(cond, trueVal)
 * - CASE WHEN cond THEN trueVal ELSE null END  =&gt; AND(cond, trueVal)
 * - CASE WHEN cond THEN trueVal ELSE true END  =&gt; OR(NOT(cond), trueVal)
 * - CASE WHEN cond THEN false ELSE elseVal END =&gt; AND(NOT(cond), elseVal)
 * - CASE WHEN cond THEN true ELSE elseVal END  =&gt; OR(cond, elseVal)
 */
public  class SimplifyConditionalsInPredicate {
  static public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan apply (org.apache.spark.sql.catalyst.plans.logical.LogicalPlan plan)  { throw new RuntimeException(); }
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
