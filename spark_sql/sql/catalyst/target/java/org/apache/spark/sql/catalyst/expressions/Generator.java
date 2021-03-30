package org.apache.spark.sql.catalyst.expressions;
/**
 * An expression that produces zero or more rows given a single input row.
 * <p>
 * Generators produce multiple output rows instead of a single value like other expressions,
 * and thus they must have a schema to associate with the rows that are output.
 * <p>
 * However, unlike row producing relational operators, which are either leaves or determine their
 * output schema functionally from their input, generators can contain other expressions that
 * might result in their modification by rules.  This structure means that they might be copied
 * multiple times after first determining their output schema. If a new output schema is created for
 * each copy references up the tree might be rendered invalid. As a result generators must
 * instead define a function <code>makeOutput</code> which is called only once when the schema is first
 * requested.  The attributes produced by this function will be automatically copied anytime rules
 * result in changes to the Generator or its children.
 */
public  interface Generator {
  public  org.apache.spark.sql.types.DataType dataType ()  ;
  /**
   * The output element schema.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType elementSchema ()  ;
  /** Should be implemented by child classes to perform specific Generators. */
  public  scala.collection.TraversableOnce<org.apache.spark.sql.catalyst.InternalRow> eval (org.apache.spark.sql.catalyst.InternalRow input)  ;
  public  boolean foldable ()  ;
  public  boolean nullable ()  ;
  /**
   * Check if this generator supports code generation.
   * @return (undocumented)
   */
  public  boolean supportCodegen ()  ;
  /**
   * Notifies that there are no more rows to process, clean up code, and additional
   * rows can be made here.
   * @return (undocumented)
   */
  public  scala.collection.TraversableOnce<org.apache.spark.sql.catalyst.InternalRow> terminate ()  ;
}
