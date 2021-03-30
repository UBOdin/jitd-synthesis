package org.apache.spark.sql.execution.adaptive;
/**
 * A rule to optimize the shuffle reader to local reader iff no additional shuffles
 * will be introduced:
 * 1. if the input plan is a shuffle, add local reader directly as we can never introduce
 * extra shuffles in this case.
 * 2. otherwise, add local reader to the probe side of broadcast hash join and
 * then run <code>EnsureRequirements</code> to check whether additional shuffle introduced.
 * If introduced, we will revert all the local readers.
 */
public  class OptimizeLocalShuffleReader {
  static public  class BroadcastJoinWithShuffleLeft$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final BroadcastJoinWithShuffleLeft$ MODULE$ = null;
    public   BroadcastJoinWithShuffleLeft$ ()  { throw new RuntimeException(); }
    public  scala.Option<scala.Tuple2<org.apache.spark.sql.execution.SparkPlan, org.apache.spark.sql.catalyst.optimizer.BuildSide>> unapply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
  }
  static public  class BroadcastJoinWithShuffleRight$ {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final BroadcastJoinWithShuffleRight$ MODULE$ = null;
    public   BroadcastJoinWithShuffleRight$ ()  { throw new RuntimeException(); }
    public  scala.Option<scala.Tuple2<org.apache.spark.sql.execution.SparkPlan, org.apache.spark.sql.catalyst.optimizer.BuildSide>> unapply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
  }
  static public  scala.collection.Seq<org.apache.spark.sql.execution.exchange.ShuffleOrigin> supportedShuffleOrigins ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.SparkPlan apply (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
  static public  boolean canUseLocalShuffleReader (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
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
