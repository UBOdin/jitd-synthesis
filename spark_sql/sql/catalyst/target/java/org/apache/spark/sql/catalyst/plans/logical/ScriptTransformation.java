package org.apache.spark.sql.catalyst.plans.logical;
/**
 * Transforms the input by forking and running the specified script.
 * <p>
 * param:  input the set of expression that should be passed to the script.
 * param:  script the command that should be executed.
 * param:  output the attributes that are produced by the script.
 * param:  ioschema the input and output schema applied in the execution of the script.
 */
public  class ScriptTransformation extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> input ()  { throw new RuntimeException(); }
  public  java.lang.String script ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.ScriptInputOutputSchema ioschema ()  { throw new RuntimeException(); }
  // not preceding
  public   ScriptTransformation (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> input, java.lang.String script, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child, org.apache.spark.sql.catalyst.plans.logical.ScriptInputOutputSchema ioschema)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
}
