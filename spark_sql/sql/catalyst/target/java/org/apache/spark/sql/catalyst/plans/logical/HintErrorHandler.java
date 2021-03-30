package org.apache.spark.sql.catalyst.plans.logical;
/**
 * The callback for implementing customized strategies of handling hint errors.
 */
public  interface HintErrorHandler {
  /**
   * Callback for an unknown hint.
   * @param name the unrecognized hint name
   * @param parameters the hint parameters
   */
  public  void hintNotRecognized (java.lang.String name, scala.collection.Seq<java.lang.Object> parameters)  ;
  /**
   * Callback for a hint being overridden by another conflicting hint of the same kind.
   * @param hint the {@link HintInfo} being overridden
   */
  public  void hintOverridden (org.apache.spark.sql.catalyst.plans.logical.HintInfo hint)  ;
  /**
   * Callback for relation names specified in a hint that cannot be associated with any relation
   * in the current scope.
   * @param name the hint name
   * @param parameters the hint parameters
   * @param invalidRelations the set of relation names that cannot be associated
   */
  public  void hintRelationsNotFound (java.lang.String name, scala.collection.Seq<java.lang.Object> parameters, scala.collection.immutable.Set<scala.collection.Seq<java.lang.String>> invalidRelations)  ;
  /**
   * Callback for a join hint specified on a relation that is not part of a join.
   * @param hint the {@link HintInfo}
   */
  public  void joinNotFoundForJoinHint (org.apache.spark.sql.catalyst.plans.logical.HintInfo hint)  ;
}
