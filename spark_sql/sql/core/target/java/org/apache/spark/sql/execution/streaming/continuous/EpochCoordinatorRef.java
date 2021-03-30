package org.apache.spark.sql.execution.streaming.continuous;
/** Helper object used to create reference to {@link EpochCoordinator}. */
public  class EpochCoordinatorRef {
  /**
   * Create a reference to a new {@link EpochCoordinator}.
   * @param writeSupport (undocumented)
   * @param stream (undocumented)
   * @param query (undocumented)
   * @param epochCoordinatorId (undocumented)
   * @param startEpoch (undocumented)
   * @param session (undocumented)
   * @param env (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.rpc.RpcEndpointRef create (org.apache.spark.sql.connector.write.streaming.StreamingWrite writeSupport, org.apache.spark.sql.connector.read.streaming.ContinuousStream stream, org.apache.spark.sql.execution.streaming.continuous.ContinuousExecution query, java.lang.String epochCoordinatorId, long startEpoch, org.apache.spark.sql.SparkSession session, org.apache.spark.SparkEnv env)  { throw new RuntimeException(); }
  static public  org.apache.spark.rpc.RpcEndpointRef get (java.lang.String id, org.apache.spark.SparkEnv env)  { throw new RuntimeException(); }
  static public  org.slf4j.Logger org$apache$spark$internal$Logging$$log_ ()  { throw new RuntimeException(); }
  static public  void org$apache$spark$internal$Logging$$log__$eq (org.slf4j.Logger x$1)  { throw new RuntimeException(); }
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
}
