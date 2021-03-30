package org.apache.spark.sql.execution.streaming.state;
public  class FlatMapGroupsWithStateExecHelper {
  /**
   * Class to capture deserialized state and timestamp return by the state manager.
   * This is intended for reuse.
   */
  static public  class StateData implements scala.Product, scala.Serializable {
    public  org.apache.spark.sql.catalyst.expressions.UnsafeRow keyRow ()  { throw new RuntimeException(); }
    public  org.apache.spark.sql.catalyst.expressions.UnsafeRow stateRow ()  { throw new RuntimeException(); }
    public  Object stateObj ()  { throw new RuntimeException(); }
    public  long timeoutTimestamp ()  { throw new RuntimeException(); }
    // not preceding
    public   StateData (org.apache.spark.sql.catalyst.expressions.UnsafeRow keyRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow stateRow, Object stateObj, long timeoutTimestamp)  { throw new RuntimeException(); }
      org.apache.spark.sql.execution.streaming.state.FlatMapGroupsWithStateExecHelper.StateData withNew (org.apache.spark.sql.catalyst.expressions.UnsafeRow newKeyRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow newStateRow, Object newStateObj, long newTimeout)  { throw new RuntimeException(); }
  }
  static public  class StateData$ extends scala.runtime.AbstractFunction4<org.apache.spark.sql.catalyst.expressions.UnsafeRow, org.apache.spark.sql.catalyst.expressions.UnsafeRow, java.lang.Object, java.lang.Object, org.apache.spark.sql.execution.streaming.state.FlatMapGroupsWithStateExecHelper.StateData> implements scala.Serializable {
    /**
     * Static reference to the singleton instance of this Scala object.
     */
    public static final StateData$ MODULE$ = null;
    public   StateData$ ()  { throw new RuntimeException(); }
  }
  /** Interface for interacting with state data of FlatMapGroupsWithState */
  static public  interface StateManager extends scala.Serializable {
    public  scala.collection.Iterator<org.apache.spark.sql.execution.streaming.state.FlatMapGroupsWithStateExecHelper.StateData> getAllState (org.apache.spark.sql.execution.streaming.state.StateStore store)  ;
    public  org.apache.spark.sql.execution.streaming.state.FlatMapGroupsWithStateExecHelper.StateData getState (org.apache.spark.sql.execution.streaming.state.StateStore store, org.apache.spark.sql.catalyst.expressions.UnsafeRow keyRow)  ;
    public  void putState (org.apache.spark.sql.execution.streaming.state.StateStore store, org.apache.spark.sql.catalyst.expressions.UnsafeRow keyRow, Object state, long timeoutTimestamp)  ;
    public  void removeState (org.apache.spark.sql.execution.streaming.state.StateStore store, org.apache.spark.sql.catalyst.expressions.UnsafeRow keyRow)  ;
    public  org.apache.spark.sql.types.StructType stateSchema ()  ;
  }
  static public  scala.collection.Seq<java.lang.Object> supportedVersions ()  { throw new RuntimeException(); }
  static public  int legacyVersion ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.execution.streaming.state.FlatMapGroupsWithStateExecHelper.StateManager createStateManager (org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<java.lang.Object> stateEncoder, boolean shouldStoreTimestamp, int stateFormatVersion)  { throw new RuntimeException(); }
}
