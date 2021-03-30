package org.apache.spark.sql.catalyst;
/**
 * A simple utility for tracking runtime and associated stats in query planning.
 * <p>
 * There are two separate concepts we track:
 * <p>
 * 1. Phases: These are broad scope phases in query planning, as listed below, i.e. analysis,
 * optimization and physical planning (just planning).
 * <p>
 * 2. Rules: These are the individual Catalyst rules that we track. In addition to time, we also
 * track the number of invocations and effective invocations.
 */
public  class QueryPlanningTracker$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final QueryPlanningTracker$ MODULE$ = null;
  public   QueryPlanningTracker$ ()  { throw new RuntimeException(); }
  public  java.lang.String PARSING ()  { throw new RuntimeException(); }
  public  java.lang.String ANALYSIS ()  { throw new RuntimeException(); }
  public  java.lang.String OPTIMIZATION ()  { throw new RuntimeException(); }
  public  java.lang.String PLANNING ()  { throw new RuntimeException(); }
  /** Returns the current tracker in scope, based on the thread local variable. */
  public  scala.Option<org.apache.spark.sql.catalyst.QueryPlanningTracker> get ()  { throw new RuntimeException(); }
  /** Sets the current tracker for the execution of function f. We assume f is single-threaded. */
  public <T extends java.lang.Object> T withTracker (org.apache.spark.sql.catalyst.QueryPlanningTracker tracker, scala.Function0<T> f)  { throw new RuntimeException(); }
}
