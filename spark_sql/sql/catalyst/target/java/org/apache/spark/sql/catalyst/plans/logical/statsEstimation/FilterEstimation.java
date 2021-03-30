package org.apache.spark.sql.catalyst.plans.logical.statsEstimation;
public  class FilterEstimation implements org.apache.spark.internal.Logging, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.plans.logical.Filter plan ()  { throw new RuntimeException(); }
  // not preceding
  public   FilterEstimation (org.apache.spark.sql.catalyst.plans.logical.Filter plan)  { throw new RuntimeException(); }
  /**
   * Returns an option of Statistics for a Filter logical plan node.
   * For a given compound expression condition, this method computes filter selectivity
   * (or the percentage of rows meeting the filter condition), which
   * is used to compute row count, size in bytes, and the updated statistics after a given
   * predicated is applied.
   * <p>
   * @return Option[Statistics] When there is no statistics collected, it returns None.
   */
  public  scala.Option<org.apache.spark.sql.catalyst.plans.logical.Statistics> estimate ()  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting a condition in Filter node.
   * If it's a single condition, we calculate the percentage directly.
   * If it's a compound condition, it is decomposed into multiple single conditions linked with
   * AND, OR, NOT.
   * For logical AND conditions, we need to update stats after a condition estimation
   * so that the stats will be more accurate for subsequent estimation.  This is needed for
   * range condition such as (c > 40 AND c <= 50)
   * For logical OR and NOT conditions, we do not update stats after a condition estimation.
   * <p>
   * @param condition the compound logical expression
   * @param update a boolean flag to specify if we need to update ColumnStat of a column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition.
   *         It returns None if the condition is not supported.
   */
  public  scala.Option<java.lang.Object> calculateFilterSelectivity (org.apache.spark.sql.catalyst.expressions.Expression condition, boolean update)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting a single condition in Filter node.
   * Currently we only support binary predicates where one side is a column,
   * and the other is a literal.
   * <p>
   * @param condition a single logical expression
   * @param update a boolean flag to specify if we need to update ColumnStat of a column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition.
   *         It returns None if the condition is not supported.
   */
  public  scala.Option<java.lang.Object> calculateSingleCondition (org.apache.spark.sql.catalyst.expressions.Expression condition, boolean update)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting "IS NULL" or "IS NOT NULL" condition.
   * <p>
   * @param attr an Attribute (or a column)
   * @param isNull set to true for "IS NULL" condition.  set to false for "IS NOT NULL" condition
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   *         It returns None if no statistics collected for a given column.
   */
  public  scala.Option<java.lang.Object> evaluateNullCheck (org.apache.spark.sql.catalyst.expressions.Attribute attr, boolean isNull, boolean update)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting a binary comparison expression.
   * <p>
   * @param op a binary comparison operator such as =, <, <=, >, >=
   * @param attr an Attribute (or a column)
   * @param literal a literal value (or constant)
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   *         It returns None if no statistics exists for a given column or wrong value.
   */
  public  scala.Option<java.lang.Object> evaluateBinary (org.apache.spark.sql.catalyst.expressions.BinaryComparison op, org.apache.spark.sql.catalyst.expressions.Attribute attr, org.apache.spark.sql.catalyst.expressions.Literal literal, boolean update)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting an equality (=) expression.
   * This method evaluates the equality predicate for all data types.
   * <p>
   * For EqualNullSafe (<=&gt;), if the literal is not null, result will be the same as EqualTo;
   * if the literal is null, the condition will be changed to IsNull after optimization.
   * So we don't need specific logic for EqualNullSafe here.
   * <p>
   * @param attr an Attribute (or a column)
   * @param literal a literal value (or constant)
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   */
  public  scala.Option<java.lang.Object> evaluateEquality (org.apache.spark.sql.catalyst.expressions.Attribute attr, org.apache.spark.sql.catalyst.expressions.Literal literal, boolean update)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting a Literal expression.
   * This method evaluates all the possible literal cases in Filter.
   * <p>
   * FalseLiteral and TrueLiteral should be eliminated by optimizer, but null literal might be added
   * by optimizer rule NullPropagation. For safety, we handle all the cases here.
   * <p>
   * @param literal a literal value (or constant)
   * @return an optional double value to show the percentage of rows meeting a given condition
   */
  public  scala.Option<java.lang.Object> evaluateLiteral (org.apache.spark.sql.catalyst.expressions.Literal literal)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting "IN" operator expression.
   * This method evaluates the equality predicate for all data types.
   * <p>
   * @param attr an Attribute (or a column)
   * @param hSet a set of literal values
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   *         It returns None if no statistics exists for a given column.
   */
  public  scala.Option<java.lang.Object> evaluateInSet (org.apache.spark.sql.catalyst.expressions.Attribute attr, scala.collection.immutable.Set<java.lang.Object> hSet, boolean update)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting a binary comparison expression.
   * This method evaluate expression for Numeric/Date/Timestamp/Boolean columns.
   * <p>
   * @param op a binary comparison operator such as =, <, <=, >, >=
   * @param attr an Attribute (or a column)
   * @param literal a literal value (or constant)
   * @param update a boolean flag to specify if we need to update ColumnStat of a given column
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   */
  public  scala.Option<java.lang.Object> evaluateBinaryForNumeric (org.apache.spark.sql.catalyst.expressions.BinaryComparison op, org.apache.spark.sql.catalyst.expressions.Attribute attr, org.apache.spark.sql.catalyst.expressions.Literal literal, boolean update)  { throw new RuntimeException(); }
  /**
   * Returns a percentage of rows meeting a binary comparison expression containing two columns.
   * In SQL queries, we also see predicate expressions involving two columns
   * such as "column-1 (op) column-2" where column-1 and column-2 belong to same table.
   * Note that, if column-1 and column-2 belong to different tables, then it is a join
   * operator's work, NOT a filter operator's work.
   * <p>
   * @param op a binary comparison operator, including =, <=&gt;, <, <=, >, >=
   * @param attrLeft the left Attribute (or a column)
   * @param attrRight the right Attribute (or a column)
   * @param update a boolean flag to specify if we need to update ColumnStat of the given columns
   *               for subsequent conditions
   * @return an optional double value to show the percentage of rows meeting a given condition
   */
  public  scala.Option<java.lang.Object> evaluateBinaryForTwoColumns (org.apache.spark.sql.catalyst.expressions.BinaryComparison op, org.apache.spark.sql.catalyst.expressions.Attribute attrLeft, org.apache.spark.sql.catalyst.expressions.Attribute attrRight, boolean update)  { throw new RuntimeException(); }
}
