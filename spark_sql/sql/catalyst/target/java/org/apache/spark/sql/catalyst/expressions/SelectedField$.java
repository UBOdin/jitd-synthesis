package org.apache.spark.sql.catalyst.expressions;
/**
 * A Scala extractor that builds a {@link org.apache.spark.sql.types.StructField} from a Catalyst
 * complex type extractor. For example, consider a relation with the following schema:
 * <p>
 * <pre><code>
 * root
 * |-- name: struct (nullable = true)
 * |    |-- first: string (nullable = true)
 * |    |-- last: string (nullable = true)
 * </code></pre>
 * <p>
 * Further, suppose we take the select expression <code>name.first</code>. This will parse into an
 * <code>Alias(child, "first")</code>. Ignoring the alias, <code>child</code> matches the following pattern:
 * <p>
 * <pre><code>
 * GetStructFieldObject(
 *   AttributeReference("name", StructType(_), _, _),
 *   StructField("first", StringType, _, _))
 * </code></pre>
 * <p>
 * {@link SelectedField} converts that expression into
 * <p>
 * <pre><code>
 * StructField("name", StructType(Array(StructField("first", StringType))))
 * </code></pre>
 * <p>
 * by mapping each complex type extractor to a {@link org.apache.spark.sql.types.StructField} with the
 * same name as its child (or "parent" going right to left in the select expression) and a data
 * type appropriate to the complex type extractor. In our example, the name of the child expression
 * is "name" and its data type is a {@link org.apache.spark.sql.types.StructType} with a single string
 * field named "first".
 */
public  class SelectedField$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SelectedField$ MODULE$ = null;
  public   SelectedField$ ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.StructField> unapply (org.apache.spark.sql.catalyst.expressions.Expression expr)  { throw new RuntimeException(); }
}
