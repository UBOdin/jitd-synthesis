package org.apache.spark.sql.expressions;
/**
 * A user-defined function. To create one, use the <code>udf</code> functions in <code>functions</code>.
 * <p>
 * As an example:
 * <pre><code>
 *   // Define a UDF that returns true or false based on some numeric score.
 *   val predict = udf((score: Double) =&gt; score &gt; 0.5)
 *
 *   // Projects a column that adds a prediction column based on the score column.
 *   df.select( predict(df("score")) )
 * </code></pre>
 * <p>
 * @since 1.3.0
 */
public abstract class UserDefinedFunction {
  // not preceding
  public   UserDefinedFunction ()  { throw new RuntimeException(); }
  /**
   * Returns an expression that invokes the UDF, using the given arguments.
   * <p>
   * @since 1.3.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column apply (org.apache.spark.sql.Column... exprs)  { throw new RuntimeException(); }
  /**
   * Returns an expression that invokes the UDF, using the given arguments.
   * <p>
   * @since 1.3.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.Column apply (scala.collection.Seq<org.apache.spark.sql.Column> exprs)  ;
  /**
   * Updates UserDefinedFunction to non-nullable.
   * <p>
   * @since 2.3.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.expressions.UserDefinedFunction asNonNullable ()  ;
  /**
   * Updates UserDefinedFunction to nondeterministic.
   * <p>
   * @since 2.3.0
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.expressions.UserDefinedFunction asNondeterministic ()  ;
  /**
   * Returns true iff the UDF is deterministic, i.e. the UDF produces the same output given the same
   * input.
   * <p>
   * @since 2.3.0
   * @return (undocumented)
   */
  public abstract  boolean deterministic ()  ;
  /**
   * Returns true when the UDF can return a nullable value.
   * <p>
   * @since 2.3.0
   * @return (undocumented)
   */
  public abstract  boolean nullable ()  ;
  /**
   * Updates UserDefinedFunction with a given name.
   * <p>
   * @since 2.3.0
   * @param name (undocumented)
   * @return (undocumented)
   */
  public abstract  org.apache.spark.sql.expressions.UserDefinedFunction withName (java.lang.String name)  ;
}
