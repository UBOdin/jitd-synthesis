package org.apache.spark.sql.catalyst.plans.logical;
/**
 * Applies a {@link Generator} to a stream of input rows, combining the
 * output of each into a new stream of rows.  This operation is similar to a <code>flatMap</code> in functional
 * programming with one important additional feature, which allows the input rows to be joined with
 * their output.
 * <p>
 * param:  generator the generator expression
 * param:  unrequiredChildIndex this parameter starts as Nil and gets filled by the Optimizer.
 *                             It's used as an optimization for omitting data generation that will
 *                             be discarded next by a projection.
 *                             A common use case is when we explode(array(..)) and are interested
 *                             only in the exploded data and not in the original array. before this
 *                             optimization the array got duplicated for each of its elements,
 *                             causing O(n^^2) memory consumption. (see [SPARK-21657])
 * param:  outer when true, each input row will be output at least once, even if the output of the
 *              given <code>generator</code> is empty.
 * param:  qualifier Qualifier for the attributes of generator(UDTF)
 * param:  generatorOutput The output schema of the Generator.
 * param:  child Children logical plan node
 */
public  class Generate extends org.apache.spark.sql.catalyst.plans.logical.UnaryNode implements scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Generator generator ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.Object> unrequiredChildIndex ()  { throw new RuntimeException(); }
  public  boolean outer ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.String> qualifier ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> generatorOutput ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child ()  { throw new RuntimeException(); }
  // not preceding
  public   Generate (org.apache.spark.sql.catalyst.expressions.Generator generator, scala.collection.Seq<java.lang.Object> unrequiredChildIndex, boolean outer, scala.Option<java.lang.String> qualifier, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> generatorOutput, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan child)  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> requiredChildOutput ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet producedAttributes ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> qualifiedGeneratorOutput ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output ()  { throw new RuntimeException(); }
}
