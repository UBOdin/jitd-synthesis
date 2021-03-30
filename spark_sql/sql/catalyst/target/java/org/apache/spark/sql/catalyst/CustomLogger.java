package org.apache.spark.sql.catalyst;
public  class CustomLogger {
  static public  scala.collection.mutable.Stack<java.lang.String> stateExecuteStack ()  { throw new RuntimeException(); }
  static public  scala.collection.mutable.Stack<java.lang.String> stateStack ()  { throw new RuntimeException(); }
  static public  scala.collection.mutable.Stack<org.apache.spark.sql.catalyst.myBuffer> rewriteBufferStack ()  { throw new RuntimeException(); }
  static public  long mostRecentStamp ()  { throw new RuntimeException(); }
  static public  long runningSearchTime ()  { throw new RuntimeException(); }
  static public  long runningRewriteTime ()  { throw new RuntimeException(); }
  static public  long runningExecutionTime ()  { throw new RuntimeException(); }
  static public  long execRunningSearchTime ()  { throw new RuntimeException(); }
  static public  long noExecRunningSearchTime ()  { throw new RuntimeException(); }
  static public  long execRunningRewriteTime ()  { throw new RuntimeException(); }
  static public  long noExecRunningRewriteTime ()  { throw new RuntimeException(); }
  static public  long runningRewriteTimeEffective ()  { throw new RuntimeException(); }
  static public  long runningRewriteTimeInEffective ()  { throw new RuntimeException(); }
  static public  scala.collection.mutable.Set<java.lang.String> allRulesSet ()  { throw new RuntimeException(); }
  static public  scala.collection.mutable.Set<java.lang.String> effectiveRuleSet ()  { throw new RuntimeException(); }
  static public  void assertNumbers (java.lang.String descriptor)  { throw new RuntimeException(); }
  static public  void ASTSize (java.lang.String descriptor, java.lang.Integer optimizedPlanSize, java.lang.Integer analyzedPlanSize)  { throw new RuntimeException(); }
  static public  void printTotalTiming (java.lang.String descriptor)  { throw new RuntimeException(); }
  static public  void logAllRulesAsSet (java.lang.String ruleName)  { throw new RuntimeException(); }
  static public  void logEffectiveRulesAsSet (java.lang.String ruleName)  { throw new RuntimeException(); }
  static public  void printAllRulesSet (java.lang.String descriptor)  { throw new RuntimeException(); }
  static public  void onEnterTime (java.lang.String state, long time)  { throw new RuntimeException(); }
  static public  void onExitTime (java.lang.String state, long time)  { throw new RuntimeException(); }
  static public <F extends java.lang.Object> F logTransformTime (java.lang.String descriptor, java.lang.String context, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> log, scala.Function0<F> anonFunc)  { throw new RuntimeException(); }
  static public <F extends java.lang.Object> F logMatchTime (java.lang.String descriptor, boolean unAffected, java.lang.String context, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> log, scala.Function0<F> anonFunc)  { throw new RuntimeException(); }
  static public  void pushCounterStacks (java.lang.String descriptor)  { throw new RuntimeException(); }
  static public  void popCounterStacks (boolean ruleEffectFromExecute, java.lang.String descriptor)  { throw new RuntimeException(); }
  static public <F extends java.lang.Object> F logExecutionTime (java.lang.String descriptor, java.lang.String context, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> log, scala.Function0<F> anonFunc)  { throw new RuntimeException(); }
}
