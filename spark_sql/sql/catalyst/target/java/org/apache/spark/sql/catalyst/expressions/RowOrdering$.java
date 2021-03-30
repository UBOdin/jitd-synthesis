package org.apache.spark.sql.catalyst.expressions;
public  class RowOrdering$ extends org.apache.spark.sql.catalyst.expressions.CodeGeneratorWithInterpretedFallback<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder>, org.apache.spark.sql.catalyst.expressions.BaseOrdering> {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final RowOrdering$ MODULE$ = null;
  public   RowOrdering$ ()  { throw new RuntimeException(); }
  /**
   * Returns true iff the data type can be ordered (i.e. can be sorted).
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  boolean isOrderable (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Returns true iff outputs from the expressions can be ordered.
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  boolean isOrderable (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> exprs)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.BaseOrdering createCodeGeneratedObject (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> in)  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.catalyst.expressions.BaseOrdering createInterpretedObject (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> in)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.BaseOrdering create (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SortOrder> order, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema)  { throw new RuntimeException(); }
  /**
   * Creates a row ordering for the given schema, in natural ascending order.
   * @param dataTypes (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.BaseOrdering createNaturalAscendingOrdering (scala.collection.Seq<org.apache.spark.sql.types.DataType> dataTypes)  { throw new RuntimeException(); }
}
