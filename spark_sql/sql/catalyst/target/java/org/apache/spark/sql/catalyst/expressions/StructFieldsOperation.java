package org.apache.spark.sql.catalyst.expressions;
/**
 * Represents an operation to be applied to the fields of a struct.
 */
public  interface StructFieldsOperation {
  /**
   * Returns an updated list of StructFields and Expressions that will ultimately be used
   * as the fields argument for {@link StructType} and as the children argument for
   * {@link CreateNamedStruct} respectively inside of {@link UpdateFields}.
   * @param values (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.types.StructField, org.apache.spark.sql.catalyst.expressions.Expression>> apply (scala.collection.Seq<scala.Tuple2<org.apache.spark.sql.types.StructField, org.apache.spark.sql.catalyst.expressions.Expression>> values)  ;
  public  scala.Function2<java.lang.String, java.lang.String, java.lang.Object> resolver ()  ;
}
