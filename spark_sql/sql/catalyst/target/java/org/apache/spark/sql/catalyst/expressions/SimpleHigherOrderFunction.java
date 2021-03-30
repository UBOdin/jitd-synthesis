package org.apache.spark.sql.catalyst.expressions;
/**
 * Trait for functions having as input one argument and one function.
 */
public  interface SimpleHigherOrderFunction extends org.apache.spark.sql.catalyst.expressions.HigherOrderFunction {
  public  org.apache.spark.sql.catalyst.expressions.Expression argument ()  ;
  public  org.apache.spark.sql.types.AbstractDataType argumentType ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> argumentTypes ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> arguments ()  ;
  public  Object eval (org.apache.spark.sql.catalyst.InternalRow inputRow)  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression function ()  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression functionForEval ()  ;
  public  org.apache.spark.sql.types.AbstractDataType functionType ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.types.AbstractDataType> functionTypes ()  ;
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> functions ()  ;
  /**
   * Called by {@link eval}. If a subclass keeps the default nullability, it can override this method
   * in order to save null-check code.
   * @param inputRow (undocumented)
   * @param argumentValue (undocumented)
   * @return (undocumented)
   */
  public  Object nullSafeEval (org.apache.spark.sql.catalyst.InternalRow inputRow, Object argumentValue)  ;
}
