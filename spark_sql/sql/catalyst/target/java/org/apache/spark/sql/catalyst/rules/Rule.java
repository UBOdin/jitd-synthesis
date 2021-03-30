package org.apache.spark.sql.catalyst.rules;
public abstract class Rule<TreeType extends org.apache.spark.sql.catalyst.trees.TreeNode<?>> implements org.apache.spark.sql.catalyst.SQLConfHelper, org.apache.spark.internal.Logging {
  public   Rule ()  { throw new RuntimeException(); }
  public abstract  TreeType apply (TreeType plan)  ;
  /** Name for this rule, automatically inferred based on class name. */
  public  java.lang.String ruleName ()  { throw new RuntimeException(); }
}
