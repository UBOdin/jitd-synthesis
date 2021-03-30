package org.apache.spark.sql.catalyst.analysis;
/**
 * The hint error handler that logs warnings for each hint error.
 */
public  class HintErrorLogger$ implements org.apache.spark.sql.catalyst.plans.logical.HintErrorHandler, org.apache.spark.internal.Logging {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final HintErrorLogger$ MODULE$ = null;
  public   HintErrorLogger$ ()  { throw new RuntimeException(); }
  public  void hintNotRecognized (java.lang.String name, scala.collection.Seq<java.lang.Object> parameters)  { throw new RuntimeException(); }
  public  void hintRelationsNotFound (java.lang.String name, scala.collection.Seq<java.lang.Object> parameters, scala.collection.immutable.Set<scala.collection.Seq<java.lang.String>> invalidRelations)  { throw new RuntimeException(); }
  public  void joinNotFoundForJoinHint (org.apache.spark.sql.catalyst.plans.logical.HintInfo hint)  { throw new RuntimeException(); }
  public  void hintOverridden (org.apache.spark.sql.catalyst.plans.logical.HintInfo hint)  { throw new RuntimeException(); }
}
