package org.apache.spark.sql.catalyst.expressions;
/**
 * A higher order function takes one or more (lambda) functions and applies these to some objects.
 * The function produces a number of variables which can be consumed by some lambda function.
 */
public  interface HigherOrderFunction extends org.apache.spark.sql.catalyst.expressions.ExpectsInputTypes {
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> argumentTypes ()  ;
  /**
   * Arguments of the higher ordered function.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments ()  ;
  /**
   * All arguments have been resolved. This means that the types and nullability of (most of) the
   * lambda function arguments is known, and that we can start binding the lambda functions.
   * @return (undocumented)
   */
  public  boolean argumentsResolved ()  ;
  /**
   * Bind the lambda functions to the {@link HigherOrderFunction} using the given bind function. The
   * bind function takes the potential lambda and it's (partial) arguments and converts this into
   * a bound lambda function.
   * @param f (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.HigherOrderFunction bind (scala.Function2<org.apache.spark.sql.catalyst.expressions.Expression, scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.types.DataType, java.lang.Object>>, org.apache.spark.sql.catalyst.expressions.LambdaFunction> f)  ;
  /**
   * Checks the argument data types, returns <code>TypeCheckResult.success</code> if it's valid,
   * or returns a <code>TypeCheckResult</code> with an error message if invalid.
   * Note: it's not valid to call this method until <code>argumentsResolved == true</code>.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.analysis.TypeCheckResult checkArgumentDataTypes ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> functionTypes ()  ;
  /**
   * Functions applied by the higher order function.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> functions ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> functionsForEval ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> inputTypes ()  ;
  public  boolean nullable ()  ;
  /**
   * All inputs must be resolved and all functions must be resolved lambda functions.
   * @return (undocumented)
   */
  public  boolean resolved ()  ;
}
