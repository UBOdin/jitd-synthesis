package org.apache.spark.sql.execution.ui;
/**
 * Provides a view of a KVStore with methods that make it easy to query Streaming Query state.
 * There's no state kept in this class, so it's ok to have multiple instances of it in an
 * application.
 */
public  class StreamingQueryStatusStore {
  public   StreamingQueryStatusStore (org.apache.spark.util.kvstore.KVStore store)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.streaming.ui.StreamingQueryUIData> allQueryUIData ()  { throw new RuntimeException(); }
    scala.collection.Seq<org.apache.spark.sql.streaming.ui.StreamingQueryProgressWrapper> getQueryProgressData (java.util.UUID runId)  { throw new RuntimeException(); }
}
