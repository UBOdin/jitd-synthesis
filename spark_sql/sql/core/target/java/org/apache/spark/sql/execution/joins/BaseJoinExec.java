package org.apache.spark.sql.execution.joins;
/**
 * Holds common logic for join operators
 */
public  interface BaseJoinExec extends org.apache.spark.sql.execution.BinaryExecNode {
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> condition ()  ;
  public  org.apache.spark.sql.catalyst.plans.JoinType joinType ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> leftKeys ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> rightKeys ()  ;
  public  java.lang.String simpleStringWithNodeId ()  ;
  public  java.lang.String verboseStringWithOperatorId ()  ;
}
