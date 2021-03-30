package org.apache.spark.sql.catalyst;
public  class CustomLogger$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final CustomLogger$ MODULE$ = null;
  public   CustomLogger$ ()  { throw new RuntimeException(); }
  public  scala.collection.mutable.Stack<java.lang.String> stateExecuteStack ()  { throw new RuntimeException(); }
  public  scala.collection.mutable.Stack<java.lang.String> stateStack ()  { throw new RuntimeException(); }
  public  scala.collection.mutable.Stack<org.apache.spark.sql.catalyst.myBuffer> rewriteBufferStack ()  { throw new RuntimeException(); }
  public  long mostRecentStamp ()  { throw new RuntimeException(); }
  public  long runningSearchTime ()  { throw new RuntimeException(); }
  public  long runningRewriteTime ()  { throw new RuntimeException(); }
  public  long runningExecutionTime ()  { throw new RuntimeException(); }
  public  long execRunningSearchTime ()  { throw new RuntimeException(); }
  public  long noExecRunningSearchTime ()  { throw new RuntimeException(); }
  public  long execRunningRewriteTime ()  { throw new RuntimeException(); }
  public  long noExecRunningRewriteTime ()  { throw new RuntimeException(); }
  public  long runningRewriteTimeEffective ()  { throw new RuntimeException(); }
  public  long runningRewriteTimeInEffective ()  { throw new RuntimeException(); }
  public  scala.collection.mutable.Set<java.lang.String> allRulesSet ()  { throw new RuntimeException(); }
  public  scala.collection.mutable.Set<java.lang.String> effectiveRuleSet ()  { throw new RuntimeException(); }
  public  void assertNumbers (java.lang.String descriptor)  { throw new RuntimeException(); }
  public  void ASTSize (java.lang.String descriptor, java.lang.Integer optimizedPlanSize, java.lang.Integer analyzedPlanSize)  { throw new RuntimeException(); }
  public  void printTotalTiming (java.lang.String descriptor)  { throw new RuntimeException(); }
  public  void logAllRulesAsSet (java.lang.String ruleName)  { throw new RuntimeException(); }
  public  void logEffectiveRulesAsSet (java.lang.String ruleName)  { throw new RuntimeException(); }
  public  void printAllRulesSet (java.lang.String descriptor)  { throw new RuntimeException(); }
  public  void onEnterTime (java.lang.String state, long time)  { throw new RuntimeException(); }
  public  void onExitTime (java.lang.String state, long time)  { throw new RuntimeException(); }
  public <F extends java.lang.Object> F logTransformTime (java.lang.String descriptor, java.lang.String context, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> log, scala.Function0<F> anonFunc)  { throw new RuntimeException(); }
  public <F extends java.lang.Object> F logMatchTime (java.lang.String descriptor, boolean unAffected, java.lang.String context, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> log, scala.Function0<F> anonFunc)  { throw new RuntimeException(); }
  public  void pushCounterStacks (java.lang.String descriptor)  { throw new RuntimeException(); }
  public  void popCounterStacks (boolean ruleEffectFromExecute, java.lang.String descriptor)  { throw new RuntimeException(); }
  public <F extends java.lang.Object> F logExecutionTime (java.lang.String descriptor, java.lang.String context, scala.Function1<java.lang.String, scala.runtime.BoxedUnit> log, scala.Function0<F> anonFunc)  { throw new RuntimeException(); }
}
