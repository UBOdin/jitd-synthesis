package org.apache.spark.sql.execution.joins;
public  interface HashJoin extends org.apache.spark.sql.execution.joins.JoinCodegenSupport {
  public  org.apache.spark.sql.catalyst.optimizer.BuildSide buildSide ()  ;
  public  java.lang.String simpleStringWithNodeId ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  ;
  public  org.apache.spark.sql.catalyst.plans.physical.Partitioning outputPartitioning ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> outputOrdering ()  ;
  // not preceding
  public  org.apache.spark.sql.execution.SparkPlan buildPlan ()  ;
  public  org.apache.spark.sql.execution.SparkPlan streamedPlan ()  ;
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> buildKeys ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> streamedKeys ()  ;
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> buildOutput ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> streamedOutput ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> buildBoundKeys ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> streamedBoundKeys ()  ;
  public  org.apache.spark.sql.catalyst.expressions.Projection buildSideKeyGenerator ()  ;
  public  org.apache.spark.sql.catalyst.expressions.UnsafeProjection streamSideKeyGenerator ()  ;
  public  scala.Function1<org.apache.spark.sql.catalyst.InternalRow, java.lang.Object> boundCondition ()  ;
  public  scala.Function1<org.apache.spark.sql.catalyst.InternalRow, org.apache.spark.sql.catalyst.InternalRow> createResultProjection ()  ;
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> innerJoin (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> streamIter, org.apache.spark.sql.execution.joins.HashedRelation hashedRelation)  ;
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> outerJoin (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> streamedIter, org.apache.spark.sql.execution.joins.HashedRelation hashedRelation)  ;
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> semiJoin (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> streamIter, org.apache.spark.sql.execution.joins.HashedRelation hashedRelation)  ;
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> existenceJoin (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> streamIter, org.apache.spark.sql.execution.joins.HashedRelation hashedRelation)  ;
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> antiJoin (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> streamIter, org.apache.spark.sql.execution.joins.HashedRelation hashedRelation)  ;
  public  scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> join (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> streamedIter, org.apache.spark.sql.execution.joins.HashedRelation hashed, org.apache.spark.sql.execution.metric.SQLMetric numOutputRows)  ;
  public  java.lang.String doProduce (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  ;
  public  java.lang.String doConsume (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> input, org.apache.spark.sql.catalyst.expressions.codegen.ExprCode row)  ;
  /**
   * Returns the code for generating join key for stream side, and expression of whether the key
   * has any null in it or not.
   * @param ctx (undocumented)
   * @param input (undocumented)
   * @return (undocumented)
   */
  public  scala.Tuple2<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode, java.lang.String> genStreamSideJoinKey (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> input)  ;
  /**
   * Generates the code for Inner join.
   * @param ctx (undocumented)
   * @param input (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String codegenInner (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> input)  ;
  /**
   * Generates the code for left or right outer join.
   * @param ctx (undocumented)
   * @param input (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String codegenOuter (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> input)  ;
  /**
   * Generates the code for left semi join.
   * @param ctx (undocumented)
   * @param input (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String codegenSemi (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> input)  ;
  /**
   * Generates the code for anti join.
   * @param ctx (undocumented)
   * @param input (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String codegenAnti (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> input)  ;
  /**
   * Generates the code for existence join.
   * @param ctx (undocumented)
   * @param input (undocumented)
   * @return (undocumented)
   */
  public  java.lang.String codegenExistence (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.codegen.ExprCode> input)  ;
  public  org.apache.spark.sql.execution.joins.HashedRelationInfo prepareRelation (org.apache.spark.sql.catalyst.expressions.codegen.CodegenContext ctx)  ;
}
