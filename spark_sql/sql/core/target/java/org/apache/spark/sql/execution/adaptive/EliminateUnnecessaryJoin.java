package org.apache.spark.sql.execution.adaptive;
/**
 * This optimization rule detects and eliminates unnecessary Join:
 * 1. Join is single column NULL-aware anti join (NAAJ), and broadcasted {@link HashedRelation}
 *    is {@link HashedRelationWithAllNullKeys}. Eliminate join to an empty {@link LocalRelation}.
 * <p>
 * 2. Join is inner join, and either side of join is empty. Eliminate join to an empty
 *    {@link LocalRelation}.
 * <p>
 * 3. Join is left semi join
 *    3.1. Join right side is empty. Eliminate join to an empty {@link LocalRelation}.
 *    3.2. Join right side is non-empty and condition is empty. Eliminate join to its left side.
 * <p>
 * 4. Join is left anti join
 *    4.1. Join right side is empty. Eliminate join to its left side.
 *    4.2. Join right side is non-empty and condition is empty. Eliminate join to an empty
 *         {@link LocalRelation}.
 * <p>
 * This applies to all joins (sort merge join, shuffled hash join, broadcast hash join, and
 * broadcast nested loop join), because sort merge join and shuffled hash join will be changed
 * to broadcast hash join with AQE at the first place.
 */
public  class EliminateUnnecessaryJoin {
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
