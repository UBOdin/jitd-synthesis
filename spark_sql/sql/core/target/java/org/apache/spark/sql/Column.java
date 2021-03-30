package org.apache.spark.sql;
/**
 * A column that will be computed based on the data in a <code>DataFrame</code>.
 * <p>
 * A new column can be constructed based on the input columns present in a DataFrame:
 * <p>
 * <pre><code>
 *   df("columnName")            // On a specific `df` DataFrame.
 *   col("columnName")           // A generic column not yet associated with a DataFrame.
 *   col("columnName.field")     // Extracting a struct field
 *   col("`a.column.with.dots`") // Escape `.` in column names.
 *   $"columnName"               // Scala short hand for a named column.
 * </code></pre>
 * <p>
 * {@link Column} objects can be composed to form complex expressions:
 * <p>
 * <pre><code>
 *   $"a" + 1
 *   $"a" === $"b"
 * </code></pre>
 * <p>
 * @note The internal Catalyst expression can be accessed via {@link expr}, but this method is for
 * debugging purposes only and can change in any future Spark releases.
 * <p>
 * @groupname java_expr_ops Java-specific expression operators
 * @groupname expr_ops Expression operators
 * @groupname df_ops DataFrame functions
 * @groupname Ungrouped Support functions for DataFrames
 * <p>
 * @since 1.3.0
 */
public  class Column implements org.apache.spark.internal.Logging {
  static public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> unapply (org.apache.spark.sql.Column col)  { throw new RuntimeException(); }
  static   java.lang.String generateAlias (org.apache.spark.sql.catalyst.expressions.Expression e)  { throw new RuntimeException(); }
  static   org.apache.spark.sql.catalyst.expressions.AttributeReference stripColumnReferenceMetadata (org.apache.spark.sql.catalyst.expressions.AttributeReference a)  { throw new RuntimeException(); }
  /**
   * A boolean expression that is evaluated to true if the value of this expression is contained
   * by the evaluated values of the arguments.
   * <p>
   * Note: Since the type of the elements in the list are inferred only during the run time,
   * the elements will be "up-casted" to the most common type for comparison.
   * For eg:
   *   1) In the case of "Int vs String", the "Int" will be up-casted to "String" and the
   * comparison will look like "String vs String".
   *   2) In the case of "Float vs Double", the "Float" will be up-casted to "Double" and the
   * comparison will look like "Double vs Double"
   * <p>
   * @group expr_ops
   * @since 1.5.0
   * @param list (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column isin (java.lang.Object... list)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.Expression expr ()  { throw new RuntimeException(); }
  // not preceding
  public   Column (org.apache.spark.sql.catalyst.expressions.Expression expr)  { throw new RuntimeException(); }
  public   Column (java.lang.String name)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  boolean equals (Object that)  { throw new RuntimeException(); }
  public  int hashCode ()  { throw new RuntimeException(); }
  /**
   * Returns the expression for this column either with an existing or auto assigned name.
   * @return (undocumented)
   */
    org.apache.spark.sql.catalyst.expressions.NamedExpression named ()  { throw new RuntimeException(); }
  /**
   * Provides a type hint about the expected return value of this column.  This information can
   * be used by operations such as <code>select</code> on a {@link Dataset} to automatically convert the
   * results into the correct JVM types.
   * @since 1.6.0
   * @param evidence$1 (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.TypedColumn<java.lang.Object, U> as (org.apache.spark.sql.Encoder<U> evidence$1)  { throw new RuntimeException(); }
  /**
   * Extracts a value or values from a complex type.
   * The following types of extraction are supported:
   * <ul>
   * <li>Given an Array, an integer ordinal can be used to retrieve a single value.</li>
   * <li>Given a Map, a key of the correct type can be used to retrieve an individual value.</li>
   * <li>Given a Struct, a string fieldName can be used to extract that field.</li>
   * <li>Given an Array of Structs, a string fieldName can be used to extract filed
   *    of every struct in that array, and return an Array of fields.</li>
   * </ul>
   * @group expr_ops
   * @since 1.4.0
   * @param extraction (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column apply (Object extraction)  { throw new RuntimeException(); }
  /**
   * Equality test.
   * <pre><code>
   *   // Scala:
   *   df.filter( df("colA") === df("colB") )
   *
   *   // Java
   *   import static org.apache.spark.sql.functions.*;
   *   df.filter( col("colA").equalTo(col("colB")) );
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column equalTo (Object other)  { throw new RuntimeException(); }
  /**
   * Inequality test.
   * <pre><code>
   *   // Scala:
   *   df.select( df("colA") !== df("colB") )
   *   df.select( !(df("colA") === df("colB")) )
   *
   *   // Java:
   *   import static org.apache.spark.sql.functions.*;
   *   df.filter( col("colA").notEqual(col("colB")) );
   * </code></pre>
   * <p>
   * @group java_expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column notEqual (Object other)  { throw new RuntimeException(); }
  /**
   * Greater than.
   * <pre><code>
   *   // Scala: The following selects people older than 21.
   *   people.select( people("age") &gt; lit(21) )
   *
   *   // Java:
   *   import static org.apache.spark.sql.functions.*;
   *   people.select( people.col("age").gt(21) );
   * </code></pre>
   * <p>
   * @group java_expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column gt (Object other)  { throw new RuntimeException(); }
  /**
   * Less than.
   * <pre><code>
   *   // Scala: The following selects people younger than 21.
   *   people.select( people("age") &lt; 21 )
   *
   *   // Java:
   *   people.select( people.col("age").lt(21) );
   * </code></pre>
   * <p>
   * @group java_expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column lt (Object other)  { throw new RuntimeException(); }
  /**
   * Less than or equal to.
   * <pre><code>
   *   // Scala: The following selects people age 21 or younger than 21.
   *   people.select( people("age") &lt;= 21 )
   *
   *   // Java:
   *   people.select( people.col("age").leq(21) );
   * </code></pre>
   * <p>
   * @group java_expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column leq (Object other)  { throw new RuntimeException(); }
  /**
   * Greater than or equal to an expression.
   * <pre><code>
   *   // Scala: The following selects people age 21 or older than 21.
   *   people.select( people("age") &gt;= 21 )
   *
   *   // Java:
   *   people.select( people.col("age").geq(21) )
   * </code></pre>
   * <p>
   * @group java_expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column geq (Object other)  { throw new RuntimeException(); }
  /**
   * Equality test that is safe for null values.
   * <p>
   * @group java_expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column eqNullSafe (Object other)  { throw new RuntimeException(); }
  /**
   * Evaluates a list of conditions and returns one of multiple possible result expressions.
   * If otherwise is not defined at the end, null is returned for unmatched conditions.
   * <p>
   * <pre><code>
   *   // Example: encoding gender string column into integer.
   *
   *   // Scala:
   *   people.select(when(people("gender") === "male", 0)
   *     .when(people("gender") === "female", 1)
   *     .otherwise(2))
   *
   *   // Java:
   *   people.select(when(col("gender").equalTo("male"), 0)
   *     .when(col("gender").equalTo("female"), 1)
   *     .otherwise(2))
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.4.0
   * @param condition (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column when (org.apache.spark.sql.Column condition, Object value)  { throw new RuntimeException(); }
  /**
   * Evaluates a list of conditions and returns one of multiple possible result expressions.
   * If otherwise is not defined at the end, null is returned for unmatched conditions.
   * <p>
   * <pre><code>
   *   // Example: encoding gender string column into integer.
   *
   *   // Scala:
   *   people.select(when(people("gender") === "male", 0)
   *     .when(people("gender") === "female", 1)
   *     .otherwise(2))
   *
   *   // Java:
   *   people.select(when(col("gender").equalTo("male"), 0)
   *     .when(col("gender").equalTo("female"), 1)
   *     .otherwise(2))
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.4.0
   * @param value (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column otherwise (Object value)  { throw new RuntimeException(); }
  /**
   * True if the current column is between the lower bound and upper bound, inclusive.
   * <p>
   * @group java_expr_ops
   * @since 1.4.0
   * @param lowerBound (undocumented)
   * @param upperBound (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column between (Object lowerBound, Object upperBound)  { throw new RuntimeException(); }
  /**
   * True if the current expression is NaN.
   * <p>
   * @group expr_ops
   * @since 1.5.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column isNaN ()  { throw new RuntimeException(); }
  /**
   * True if the current expression is null.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column isNull ()  { throw new RuntimeException(); }
  /**
   * True if the current expression is NOT null.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column isNotNull ()  { throw new RuntimeException(); }
  /**
   * Boolean OR.
   * <pre><code>
   *   // Scala: The following selects people that are in school or employed.
   *   people.filter( people("inSchool") || people("isEmployed") )
   *
   *   // Java:
   *   people.filter( people.col("inSchool").or(people.col("isEmployed")) );
   * </code></pre>
   * <p>
   * @group java_expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column or (org.apache.spark.sql.Column other)  { throw new RuntimeException(); }
  /**
   * Boolean AND.
   * <pre><code>
   *   // Scala: The following selects people that are in school and employed at the same time.
   *   people.select( people("inSchool") &amp;&amp; people("isEmployed") )
   *
   *   // Java:
   *   people.select( people.col("inSchool").and(people.col("isEmployed")) );
   * </code></pre>
   * <p>
   * @group java_expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column and (org.apache.spark.sql.Column other)  { throw new RuntimeException(); }
  /**
   * Sum of this expression and another expression.
   * <pre><code>
   *   // Scala: The following selects the sum of a person's height and weight.
   *   people.select( people("height") + people("weight") )
   *
   *   // Java:
   *   people.select( people.col("height").plus(people.col("weight")) );
   * </code></pre>
   * <p>
   * @group java_expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column plus (Object other)  { throw new RuntimeException(); }
  /**
   * Subtraction. Subtract the other expression from this expression.
   * <pre><code>
   *   // Scala: The following selects the difference between people's height and their weight.
   *   people.select( people("height") - people("weight") )
   *
   *   // Java:
   *   people.select( people.col("height").minus(people.col("weight")) );
   * </code></pre>
   * <p>
   * @group java_expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column minus (Object other)  { throw new RuntimeException(); }
  /**
   * Multiplication of this expression and another expression.
   * <pre><code>
   *   // Scala: The following multiplies a person's height by their weight.
   *   people.select( people("height") * people("weight") )
   *
   *   // Java:
   *   people.select( people.col("height").multiply(people.col("weight")) );
   * </code></pre>
   * <p>
   * @group java_expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column multiply (Object other)  { throw new RuntimeException(); }
  /**
   * Division this expression by another expression.
   * <pre><code>
   *   // Scala: The following divides a person's height by their weight.
   *   people.select( people("height") / people("weight") )
   *
   *   // Java:
   *   people.select( people.col("height").divide(people.col("weight")) );
   * </code></pre>
   * <p>
   * @group java_expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column divide (Object other)  { throw new RuntimeException(); }
  /**
   * Modulo (a.k.a. remainder) expression.
   * <p>
   * @group java_expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column mod (Object other)  { throw new RuntimeException(); }
  /**
   * A boolean expression that is evaluated to true if the value of this expression is contained
   * by the evaluated values of the arguments.
   * <p>
   * Note: Since the type of the elements in the list are inferred only during the run time,
   * the elements will be "up-casted" to the most common type for comparison.
   * For eg:
   *   1) In the case of "Int vs String", the "Int" will be up-casted to "String" and the
   * comparison will look like "String vs String".
   *   2) In the case of "Float vs Double", the "Float" will be up-casted to "Double" and the
   * comparison will look like "Double vs Double"
   * <p>
   * @group expr_ops
   * @since 1.5.0
   * @param list (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column isin (scala.collection.Seq<java.lang.Object> list)  { throw new RuntimeException(); }
  /**
   * A boolean expression that is evaluated to true if the value of this expression is contained
   * by the provided collection.
   * <p>
   * Note: Since the type of the elements in the collection are inferred only during the run time,
   * the elements will be "up-casted" to the most common type for comparison.
   * For eg:
   *   1) In the case of "Int vs String", the "Int" will be up-casted to "String" and the
   * comparison will look like "String vs String".
   *   2) In the case of "Float vs Double", the "Float" will be up-casted to "Double" and the
   * comparison will look like "Double vs Double"
   * <p>
   * @group expr_ops
   * @since 2.4.0
   * @param values (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column isInCollection (scala.collection.Iterable<?> values)  { throw new RuntimeException(); }
  /**
   * A boolean expression that is evaluated to true if the value of this expression is contained
   * by the provided collection.
   * <p>
   * Note: Since the type of the elements in the collection are inferred only during the run time,
   * the elements will be "up-casted" to the most common type for comparison.
   * For eg:
   *   1) In the case of "Int vs String", the "Int" will be up-casted to "String" and the
   * comparison will look like "String vs String".
   *   2) In the case of "Float vs Double", the "Float" will be up-casted to "Double" and the
   * comparison will look like "Double vs Double"
   * <p>
   * @group java_expr_ops
   * @since 2.4.0
   * @param values (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column isInCollection (java.lang.Iterable<?> values)  { throw new RuntimeException(); }
  /**
   * SQL like expression. Returns a boolean column based on a SQL LIKE match.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param literal (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column like (java.lang.String literal)  { throw new RuntimeException(); }
  /**
   * SQL RLIKE expression (LIKE with Regex). Returns a boolean column based on a regex
   * match.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param literal (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column rlike (java.lang.String literal)  { throw new RuntimeException(); }
  /**
   * An expression that gets an item at position <code>ordinal</code> out of an array,
   * or gets a value by key <code>key</code> in a <code>MapType</code>.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param key (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column getItem (Object key)  { throw new RuntimeException(); }
  /**
   * An expression that adds/replaces field in <code>StructType</code> by name.
   * <p>
   * <pre><code>
   *   val df = sql("SELECT named_struct('a', 1, 'b', 2) struct_col")
   *   df.select($"struct_col".withField("c", lit(3)))
   *   // result: {"a":1,"b":2,"c":3}
   *
   *   val df = sql("SELECT named_struct('a', 1, 'b', 2) struct_col")
   *   df.select($"struct_col".withField("b", lit(3)))
   *   // result: {"a":1,"b":3}
   *
   *   val df = sql("SELECT CAST(NULL AS struct&lt;a:int,b:int&gt;) struct_col")
   *   df.select($"struct_col".withField("c", lit(3)))
   *   // result: null of type struct&lt;a:int,b:int,c:int&gt;
   *
   *   val df = sql("SELECT named_struct('a', 1, 'b', 2, 'b', 3) struct_col")
   *   df.select($"struct_col".withField("b", lit(100)))
   *   // result: {"a":1,"b":100,"b":100}
   *
   *   val df = sql("SELECT named_struct('a', named_struct('a', 1, 'b', 2)) struct_col")
   *   df.select($"struct_col".withField("a.c", lit(3)))
   *   // result: {"a":{"a":1,"b":2,"c":3}}
   *
   *   val df = sql("SELECT named_struct('a', named_struct('b', 1), 'a', named_struct('c', 2)) struct_col")
   *   df.select($"struct_col".withField("a.c", lit(3)))
   *   // result: org.apache.spark.sql.AnalysisException: Ambiguous reference to fields
   * </code></pre>
   * <p>
   * This method supports adding/replacing nested fields directly e.g.
   * <p>
   * <pre><code>
   *   val df = sql("SELECT named_struct('a', named_struct('a', 1, 'b', 2)) struct_col")
   *   df.select($"struct_col".withField("a.c", lit(3)).withField("a.d", lit(4)))
   *   // result: {"a":{"a":1,"b":2,"c":3,"d":4}}
   * </code></pre>
   * <p>
   * However, if you are going to add/replace multiple nested fields, it is more optimal to extract
   * out the nested struct before adding/replacing multiple fields e.g.
   * <p>
   * <pre><code>
   *   val df = sql("SELECT named_struct('a', named_struct('a', 1, 'b', 2)) struct_col")
   *   df.select($"struct_col".withField("a", $"struct_col.a".withField("c", lit(3)).withField("d", lit(4))))
   *   // result: {"a":{"a":1,"b":2,"c":3,"d":4}}
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 3.1.0
   * @param fieldName (undocumented)
   * @param col (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column withField (java.lang.String fieldName, org.apache.spark.sql.Column col)  { throw new RuntimeException(); }
  /**
   * An expression that drops fields in <code>StructType</code> by name.
   * This is a no-op if schema doesn't contain field name(s).
   * <p>
   * <pre><code>
   *   val df = sql("SELECT named_struct('a', 1, 'b', 2) struct_col")
   *   df.select($"struct_col".dropFields("b"))
   *   // result: {"a":1}
   *
   *   val df = sql("SELECT named_struct('a', 1, 'b', 2) struct_col")
   *   df.select($"struct_col".dropFields("c"))
   *   // result: {"a":1,"b":2}
   *
   *   val df = sql("SELECT named_struct('a', 1, 'b', 2, 'c', 3) struct_col")
   *   df.select($"struct_col".dropFields("b", "c"))
   *   // result: {"a":1}
   *
   *   val df = sql("SELECT named_struct('a', 1, 'b', 2) struct_col")
   *   df.select($"struct_col".dropFields("a", "b"))
   *   // result: org.apache.spark.sql.AnalysisException: cannot resolve 'update_fields(update_fields(`struct_col`))' due to data type mismatch: cannot drop all fields in struct
   *
   *   val df = sql("SELECT CAST(NULL AS struct&lt;a:int,b:int&gt;) struct_col")
   *   df.select($"struct_col".dropFields("b"))
   *   // result: null of type struct&lt;a:int&gt;
   *
   *   val df = sql("SELECT named_struct('a', 1, 'b', 2, 'b', 3) struct_col")
   *   df.select($"struct_col".dropFields("b"))
   *   // result: {"a":1}
   *
   *   val df = sql("SELECT named_struct('a', named_struct('a', 1, 'b', 2)) struct_col")
   *   df.select($"struct_col".dropFields("a.b"))
   *   // result: {"a":{"a":1}}
   *
   *   val df = sql("SELECT named_struct('a', named_struct('b', 1), 'a', named_struct('c', 2)) struct_col")
   *   df.select($"struct_col".dropFields("a.c"))
   *   // result: org.apache.spark.sql.AnalysisException: Ambiguous reference to fields
   * </code></pre>
   * <p>
   * This method supports dropping multiple nested fields directly e.g.
   * <p>
   * <pre><code>
   *   val df = sql("SELECT named_struct('a', named_struct('a', 1, 'b', 2)) struct_col")
   *   df.select($"struct_col".dropFields("a.b", "a.c"))
   *   // result: {"a":{"a":1}}
   * </code></pre>
   * <p>
   * However, if you are going to drop multiple nested fields, it is more optimal to extract
   * out the nested struct before dropping multiple fields from it e.g.
   * <p>
   * <pre><code>
   *   val df = sql("SELECT named_struct('a', named_struct('a', 1, 'b', 2)) struct_col")
   *   df.select($"struct_col".withField("a", $"struct_col.a".dropFields("b", "c")))
   *   // result: {"a":{"a":1}}
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 3.1.0
   * @param fieldNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column dropFields (scala.collection.Seq<java.lang.String> fieldNames)  { throw new RuntimeException(); }
  /**
   * An expression that gets a field by name in a <code>StructType</code>.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param fieldName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column getField (java.lang.String fieldName)  { throw new RuntimeException(); }
  /**
   * An expression that returns a substring.
   * @param startPos expression for the starting position.
   * @param len expression for the length of the substring.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column substr (org.apache.spark.sql.Column startPos, org.apache.spark.sql.Column len)  { throw new RuntimeException(); }
  /**
   * An expression that returns a substring.
   * @param startPos starting position.
   * @param len length of the substring.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column substr (int startPos, int len)  { throw new RuntimeException(); }
  /**
   * Contains the other element. Returns a boolean column based on a string match.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column contains (Object other)  { throw new RuntimeException(); }
  /**
   * String starts with. Returns a boolean column based on a string match.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column startsWith (org.apache.spark.sql.Column other)  { throw new RuntimeException(); }
  /**
   * String starts with another string literal. Returns a boolean column based on a string match.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param literal (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column startsWith (java.lang.String literal)  { throw new RuntimeException(); }
  /**
   * String ends with. Returns a boolean column based on a string match.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column endsWith (org.apache.spark.sql.Column other)  { throw new RuntimeException(); }
  /**
   * String ends with another string literal. Returns a boolean column based on a string match.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param literal (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column endsWith (java.lang.String literal)  { throw new RuntimeException(); }
  /**
   * Gives the column an alias. Same as <code>as</code>.
   * <pre><code>
   *   // Renames colA to colB in select output.
   *   df.select($"colA".alias("colB"))
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.4.0
   * @param alias (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column alias (java.lang.String alias)  { throw new RuntimeException(); }
  /**
   * Gives the column an alias.
   * <pre><code>
   *   // Renames colA to colB in select output.
   *   df.select($"colA".as("colB"))
   * </code></pre>
   * <p>
   * If the current column has metadata associated with it, this metadata will be propagated
   * to the new column. If this not desired, use the API <code>as(alias: String, metadata: Metadata)</code>
   * with explicit metadata.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param alias (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column as (java.lang.String alias)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Assigns the given aliases to the results of a table generating function.
   * <pre><code>
   *   // Renames colA to colB in select output.
   *   df.select(explode($"myMap").as("key" :: "value" :: Nil))
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.4.0
   * @param aliases (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column as (scala.collection.Seq<java.lang.String> aliases)  { throw new RuntimeException(); }
  /**
   * Assigns the given aliases to the results of a table generating function.
   * <pre><code>
   *   // Renames colA to colB in select output.
   *   df.select(explode($"myMap").as("key" :: "value" :: Nil))
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.4.0
   * @param aliases (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column as (java.lang.String[] aliases)  { throw new RuntimeException(); }
  /**
   * Gives the column an alias.
   * <pre><code>
   *   // Renames colA to colB in select output.
   *   df.select($"colA".as("colB"))
   * </code></pre>
   * <p>
   * If the current column has metadata associated with it, this metadata will be propagated
   * to the new column. If this not desired, use the API <code>as(alias: String, metadata: Metadata)</code>
   * with explicit metadata.
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param alias (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column as (scala.Symbol alias)  { throw new RuntimeException(); }
  /**
   * Gives the column an alias with metadata.
   * <pre><code>
   *   val metadata: Metadata = ...
   *   df.select($"colA".as("colB", metadata))
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param alias (undocumented)
   * @param metadata (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column as (java.lang.String alias, org.apache.spark.sql.types.Metadata metadata)  { throw new RuntimeException(); }
  /**
   * Gives the column a name (alias).
   * <pre><code>
   *   // Renames colA to colB in select output.
   *   df.select($"colA".name("colB"))
   * </code></pre>
   * <p>
   * If the current column has metadata associated with it, this metadata will be propagated
   * to the new column. If this not desired, use the API <code>as(alias: String, metadata: Metadata)</code>
   * with explicit metadata.
   * <p>
   * @group expr_ops
   * @since 2.0.0
   * @param alias (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column name (java.lang.String alias)  { throw new RuntimeException(); }
  /**
   * Casts the column to a different data type.
   * <pre><code>
   *   // Casts colA to IntegerType.
   *   import org.apache.spark.sql.types.IntegerType
   *   df.select(df("colA").cast(IntegerType))
   *
   *   // equivalent to
   *   df.select(df("colA").cast("int"))
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param to (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column cast (org.apache.spark.sql.types.DataType to)  { throw new RuntimeException(); }
  /**
   * Casts the column to a different data type, using the canonical string representation
   * of the type. The supported types are: <code>string</code>, <code>boolean</code>, <code>byte</code>, <code>short</code>, <code>int</code>, <code>long</code>,
   * <code>float</code>, <code>double</code>, <code>decimal</code>, <code>date</code>, <code>timestamp</code>.
   * <pre><code>
   *   // Casts colA to integer.
   *   df.select(df("colA").cast("int"))
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @param to (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column cast (java.lang.String to)  { throw new RuntimeException(); }
  /**
   * Returns a sort expression based on the descending order of the column.
   * <pre><code>
   *   // Scala
   *   df.sort(df("age").desc)
   *
   *   // Java
   *   df.sort(df.col("age").desc());
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column desc ()  { throw new RuntimeException(); }
  /**
   * Returns a sort expression based on the descending order of the column,
   * and null values appear before non-null values.
   * <pre><code>
   *   // Scala: sort a DataFrame by age column in descending order and null values appearing first.
   *   df.sort(df("age").desc_nulls_first)
   *
   *   // Java
   *   df.sort(df.col("age").desc_nulls_first());
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 2.1.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column desc_nulls_first ()  { throw new RuntimeException(); }
  /**
   * Returns a sort expression based on the descending order of the column,
   * and null values appear after non-null values.
   * <pre><code>
   *   // Scala: sort a DataFrame by age column in descending order and null values appearing last.
   *   df.sort(df("age").desc_nulls_last)
   *
   *   // Java
   *   df.sort(df.col("age").desc_nulls_last());
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 2.1.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column desc_nulls_last ()  { throw new RuntimeException(); }
  /**
   * Returns a sort expression based on ascending order of the column.
   * <pre><code>
   *   // Scala: sort a DataFrame by age column in ascending order.
   *   df.sort(df("age").asc)
   *
   *   // Java
   *   df.sort(df.col("age").asc());
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.3.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column asc ()  { throw new RuntimeException(); }
  /**
   * Returns a sort expression based on ascending order of the column,
   * and null values return before non-null values.
   * <pre><code>
   *   // Scala: sort a DataFrame by age column in ascending order and null values appearing first.
   *   df.sort(df("age").asc_nulls_first)
   *
   *   // Java
   *   df.sort(df.col("age").asc_nulls_first());
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 2.1.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column asc_nulls_first ()  { throw new RuntimeException(); }
  /**
   * Returns a sort expression based on ascending order of the column,
   * and null values appear after non-null values.
   * <pre><code>
   *   // Scala: sort a DataFrame by age column in ascending order and null values appearing last.
   *   df.sort(df("age").asc_nulls_last)
   *
   *   // Java
   *   df.sort(df.col("age").asc_nulls_last());
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 2.1.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column asc_nulls_last ()  { throw new RuntimeException(); }
  /**
   * Prints the expression to the console for debugging purposes.
   * <p>
   * @group df_ops
   * @since 1.3.0
   * @param extended (undocumented)
   */
  public  void explain (boolean extended)  { throw new RuntimeException(); }
  /**
   * Compute bitwise OR of this expression with another expression.
   * <pre><code>
   *   df.select($"colA".bitwiseOR($"colB"))
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.4.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column bitwiseOR (Object other)  { throw new RuntimeException(); }
  /**
   * Compute bitwise AND of this expression with another expression.
   * <pre><code>
   *   df.select($"colA".bitwiseAND($"colB"))
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.4.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column bitwiseAND (Object other)  { throw new RuntimeException(); }
  /**
   * Compute bitwise XOR of this expression with another expression.
   * <pre><code>
   *   df.select($"colA".bitwiseXOR($"colB"))
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.4.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column bitwiseXOR (Object other)  { throw new RuntimeException(); }
  /**
   * Defines a windowing column.
   * <p>
   * <pre><code>
   *   val w = Window.partitionBy("name").orderBy("id")
   *   df.select(
   *     sum("price").over(w.rangeBetween(Window.unboundedPreceding, 2)),
   *     avg("price").over(w.rowsBetween(Window.currentRow, 4))
   *   )
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 1.4.0
   * @param window (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column over (org.apache.spark.sql.expressions.WindowSpec window)  { throw new RuntimeException(); }
  /**
   * Defines an empty analytic clause. In this case the analytic function is applied
   * and presented for all rows in the result set.
   * <p>
   * <pre><code>
   *   df.select(
   *     sum("price").over(),
   *     avg("price").over()
   *   )
   * </code></pre>
   * <p>
   * @group expr_ops
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column over ()  { throw new RuntimeException(); }
}
