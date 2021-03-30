package org.apache.spark.sql.catalyst.expressions;
/**
 * A trait used for resolving nullable flags, including <code>nullable</code>, <code>containsNull</code> of {@link ArrayType}
 * and <code>valueContainsNull</code> of {@link MapType}, containsNull, valueContainsNull flags of the output date
 * type. This is usually utilized by the expressions (e.g. {@link CaseWhen}) that combine data from
 * multiple child expressions of non-primitive types.
 */
public  interface ComplexTypeMergingExpression {
  public  org.apache.spark.sql.types.DataType dataType ()  ;
  public  void dataTypeCheck ()  ;
  /**
   * A collection of data types used for resolution the output type of the expression. By default,
   * data types of all child expressions. The collection must not be empty.
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.types.DataType> inputTypesForMerging ()  ;
}
