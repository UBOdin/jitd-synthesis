package org.apache.spark.sql.catalyst;
public  class QueryPlanningTracker {
  /**
   * Summary for a rule.
   * param:  totalTimeNs total amount of time, in nanosecs, spent in this rule.
   * param:  numInvocations number of times the rule has been invoked.
   * param:  numEffectiveInvocations number of times the rule has been invoked and
   *                                resulted in a plan change.
   */
  static public  class RuleSummary {
    // not preceding
    public   RuleSummary (long totalTimeNs, long numInvocations, long numEffectiveInvocations)  { throw new RuntimeException(); }
    public   RuleSummary ()  { throw new RuntimeException(); }
    public  long numEffectiveInvocations ()  { throw new RuntimeException(); }
    public  long numInvocations ()  { throw new RuntimeException(); }
    public  java.lang.String toString ()  { throw new RuntimeException(); }
    public  long totalTimeNs ()  { throw new RuntimeException(); }
  }
  /**
   * Summary of a phase, with start time and end time so we can construct a timeline.
   */
  static public  class PhaseSummary {
    // not preceding
    public   PhaseSummary (long startTimeMs, long endTimeMs)  { throw new RuntimeException(); }
    public  long durationMs ()  { throw new RuntimeException(); }
    public  long endTimeMs ()  { throw new RuntimeException(); }
    public  long startTimeMs ()  { throw new RuntimeException(); }
    public  java.lang.String toString ()  { throw new RuntimeException(); }
  }
  static public  java.lang.String PARSING ()  { throw new RuntimeException(); }
  static public  java.lang.String ANALYSIS ()  { throw new RuntimeException(); }
  static public  java.lang.String OPTIMIZATION ()  { throw new RuntimeException(); }
  static public  java.lang.String PLANNING ()  { throw new RuntimeException(); }
  /** Returns the current tracker in scope, based on the thread local variable. */
  static public  scala.Option<org.apache.spark.sql.catalyst.QueryPlanningTracker> get ()  { throw new RuntimeException(); }
  /** Sets the current tracker for the execution of function f. We assume f is single-threaded. */
  static public <T extends java.lang.Object> T withTracker (org.apache.spark.sql.catalyst.QueryPlanningTracker tracker, scala.Function0<T> f)  { throw new RuntimeException(); }
  public   QueryPlanningTracker ()  { throw new RuntimeException(); }
  /**
   * Measure the start and end time of a phase. Note that if this function is called multiple
   * times for the same phase, the recorded start time will be the start time of the first call,
   * and the recorded end time will be the end time of the last call.
   * @param phase (undocumented)
   * @param f (undocumented)
   * @return (undocumented)
   */
  public <T extends java.lang.Object> T measurePhase (java.lang.String phase, scala.Function0<T> f)  { throw new RuntimeException(); }
  /**
   * Record a specific invocation of a rule.
   * <p>
   * @param rule name of the rule
   * @param timeNs time taken to run this invocation
   * @param effective whether the invocation has resulted in a plan change
   */
  public  void recordRuleInvocation (java.lang.String rule, long timeNs, boolean effective)  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.catalyst.QueryPlanningTracker.RuleSummary> rules ()  { throw new RuntimeException(); }
  public  scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.catalyst.QueryPlanningTracker.PhaseSummary> phases ()  { throw new RuntimeException(); }
  /**
   * Returns the top k most expensive rules (as measured by time). If k is larger than the rules
   * seen so far, return all the rules. If there is no rule seen so far or k <= 0, return empty seq.
   * @param k (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<scala.Tuple2<java.lang.String, org.apache.spark.sql.catalyst.QueryPlanningTracker.RuleSummary>> topRulesByTime (int k)  { throw new RuntimeException(); }
}
