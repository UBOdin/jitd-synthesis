package org.apache.spark.sql;
/**
 * Commonly used functions available for DataFrame operations. Using functions defined here provides
 * a little bit more compile-time safety to make sure the function exists.
 * <p>
 * Spark also includes more built-in functions that are less common and are not defined here.
 * You can still access them (and all the functions defined here) using the <code>functions.expr()</code> API
 * and calling them through a SQL expression string. You can find the entire list of functions
 * at SQL API documentation.
 * <p>
 * As an example, <code>isnan</code> is a function that is defined here. You can use <code>isnan(col("myCol"))</code>
 * to invoke the <code>isnan</code> function. This way the programming language's compiler ensures <code>isnan</code>
 * exists and is of the proper form. You can also use <code>expr("isnan(myCol)")</code> function to invoke the
 * same function. In this case, Spark itself will ensure <code>isnan</code> exists when it analyzes the query.
 * <p>
 * <code>regr_count</code> is an example of a function that is built-in but not defined here, because it is
 * less commonly used. To invoke it, use <code>expr("regr_count(yCol, xCol)")</code>.
 * <p>
 * This function APIs usually have methods with <code>Column</code> signature only because it can support not
 * only <code>Column</code> but also other types such as a native string. The other variants currently exist
 * for historical reasons.
 * <p>
 * @groupname udf_funcs UDF functions
 * @groupname agg_funcs Aggregate functions
 * @groupname datetime_funcs Date time functions
 * @groupname sort_funcs Sorting functions
 * @groupname normal_funcs Non-aggregate functions
 * @groupname math_funcs Math functions
 * @groupname misc_funcs Misc functions
 * @groupname window_funcs Window functions
 * @groupname string_funcs String functions
 * @groupname collection_funcs Collection functions
 * @groupname partition_transforms Partition transform functions
 * @groupname Ungrouped Support functions for DataFrames
 * @since 1.3.0
 */
// not preceding
public  class functions {
  /**
   * Aggregate function: returns the number of distinct items in a group.
   * <p>
   * An alias of <code>count_distinct</code>, and it is encouraged to use <code>count_distinct</code> directly.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param expr (undocumented)
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column countDistinct (org.apache.spark.sql.Column expr, org.apache.spark.sql.Column... exprs)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the number of distinct items in a group.
   * <p>
   * An alias of <code>count_distinct</code>, and it is encouraged to use <code>count_distinct</code> directly.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param columnName (undocumented)
   * @param columnNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column countDistinct (java.lang.String columnName, java.lang.String... columnNames)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the number of distinct items in a group.
   * <p>
   * @group agg_funcs
   * @since 3.2.0
   * @param expr (undocumented)
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column count_distinct (org.apache.spark.sql.Column expr, org.apache.spark.sql.Column... exprs)  { throw new RuntimeException(); }
  /**
   * Creates a new array column. The input columns must all have the same data type.
   * <p>
   * @group normal_funcs
   * @since 1.4.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array (org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Creates a new array column. The input columns must all have the same data type.
   * <p>
   * @group normal_funcs
   * @since 1.4.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array (java.lang.String colName, java.lang.String... colNames)  { throw new RuntimeException(); }
  /**
   * Creates a new map column. The input columns must be grouped as key-value pairs, e.g.
   * (key1, value1, key2, value2, ...). The key columns must all have the same data type, and can't
   * be null. The value columns must all have the same data type.
   * <p>
   * @group normal_funcs
   * @since 2.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column map (org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Returns the first column that is not null, or null if all inputs are null.
   * <p>
   * For example, <code>coalesce(a, b, c)</code> will return a if a is not null,
   * or b if a is null and b is not null, or c if both a and b are null but c is not null.
   * <p>
   * @group normal_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column coalesce (org.apache.spark.sql.Column... e)  { throw new RuntimeException(); }
  /**
   * Creates a new struct column.
   * If the input column is a column in a <code>DataFrame</code>, or a derived column expression
   * that is named (i.e. aliased), its name would be retained as the StructField's name,
   * otherwise, the newly generated StructField's name would be auto generated as
   * <code>col</code> with a suffix <code>index + 1</code>, i.e. col1, col2, col3, ...
   * <p>
   * @group normal_funcs
   * @since 1.4.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column struct (org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Creates a new struct column that composes multiple input columns.
   * <p>
   * @group normal_funcs
   * @since 1.4.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column struct (java.lang.String colName, java.lang.String... colNames)  { throw new RuntimeException(); }
  /**
   * Returns the greatest value of the list of values, skipping null values.
   * This function takes at least 2 parameters. It will return null iff all parameters are null.
   * <p>
   * @group normal_funcs
   * @since 1.5.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column greatest (org.apache.spark.sql.Column... exprs)  { throw new RuntimeException(); }
  /**
   * Returns the greatest value of the list of column names, skipping null values.
   * This function takes at least 2 parameters. It will return null iff all parameters are null.
   * <p>
   * @group normal_funcs
   * @since 1.5.0
   * @param columnName (undocumented)
   * @param columnNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column greatest (java.lang.String columnName, java.lang.String... columnNames)  { throw new RuntimeException(); }
  /**
   * Returns the least value of the list of values, skipping null values.
   * This function takes at least 2 parameters. It will return null iff all parameters are null.
   * <p>
   * @group normal_funcs
   * @since 1.5.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column least (org.apache.spark.sql.Column... exprs)  { throw new RuntimeException(); }
  /**
   * Returns the least value of the list of column names, skipping null values.
   * This function takes at least 2 parameters. It will return null iff all parameters are null.
   * <p>
   * @group normal_funcs
   * @since 1.5.0
   * @param columnName (undocumented)
   * @param columnNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column least (java.lang.String columnName, java.lang.String... columnNames)  { throw new RuntimeException(); }
  /**
   * Calculates the hash code of given columns, and returns the result as an int column.
   * <p>
   * @group misc_funcs
   * @since 2.0.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column hash (org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Calculates the hash code of given columns using the 64-bit
   * variant of the xxHash algorithm, and returns the result as a long
   * column.
   * <p>
   * @group misc_funcs
   * @since 3.0.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column xxhash64 (org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Concatenates multiple input string columns together into a single string column,
   * using the given separator.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param sep (undocumented)
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column concat_ws (java.lang.String sep, org.apache.spark.sql.Column... exprs)  { throw new RuntimeException(); }
  /**
   * Formats the arguments in printf-style and returns the result as a string column.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param format (undocumented)
   * @param arguments (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column format_string (java.lang.String format, org.apache.spark.sql.Column... arguments)  { throw new RuntimeException(); }
  /**
   * Concatenates multiple input columns together into a single column.
   * The function works with strings, binary and compatible array columns.
   * <p>
   * @group collection_funcs
   * @since 1.5.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column concat (org.apache.spark.sql.Column... exprs)  { throw new RuntimeException(); }
  /**
   * Creates a new row for a json column according to the given field names.
   * <p>
   * @group collection_funcs
   * @since 1.6.0
   * @param json (undocumented)
   * @param fields (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column json_tuple (org.apache.spark.sql.Column json, java.lang.String... fields)  { throw new RuntimeException(); }
  /**
   * Returns a merged array of structs in which the N-th struct contains all N-th values of input
   * arrays.
   * @group collection_funcs
   * @since 2.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column arrays_zip (org.apache.spark.sql.Column... e)  { throw new RuntimeException(); }
  /**
   * Returns the union of all the given maps.
   * @group collection_funcs
   * @since 2.4.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column map_concat (org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Call an user-defined function.
   * <p>
   * @group udf_funcs
   * @since 1.5.0
   * @param udfName (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column callUDF (java.lang.String udfName, org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Call an user-defined function.
   * Example:
   * <pre><code>
   *  import org.apache.spark.sql._
   *
   *  val df = Seq(("id1", 1), ("id2", 4), ("id3", 5)).toDF("id", "value")
   *  val spark = df.sparkSession
   *  spark.udf.register("simpleUDF", (v: Int) =&gt; v * v)
   *  df.select($"id", call_udf("simpleUDF", $"value"))
   * </code></pre>
   * <p>
   * @group udf_funcs
   * @since 3.2.0
   * @param udfName (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column call_udf (java.lang.String udfName, org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Returns a {@link Column} based on the given column name.
   * <p>
   * @group normal_funcs
   * @since 1.3.0
   * @param colName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column col (java.lang.String colName)  { throw new RuntimeException(); }
  /**
   * Returns a {@link Column} based on the given column name. Alias of {@link col}.
   * <p>
   * @group normal_funcs
   * @since 1.3.0
   * @param colName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column column (java.lang.String colName)  { throw new RuntimeException(); }
  /**
   * Creates a {@link Column} of literal value.
   * <p>
   * The passed in object is returned directly if it is already a {@link Column}.
   * If the object is a Scala Symbol, it is converted into a {@link Column} also.
   * Otherwise, a new {@link Column} is created to represent the literal value.
   * <p>
   * @group normal_funcs
   * @since 1.3.0
   * @param literal (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column lit (Object literal)  { throw new RuntimeException(); }
  /**
   * Creates a {@link Column} of literal value.
   * <p>
   * An alias of <code>typedlit</code>, and it is encouraged to use <code>typedlit</code> directly.
   * <p>
   * @group normal_funcs
   * @since 2.2.0
   * @param literal (undocumented)
   * @param evidence$1 (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> org.apache.spark.sql.Column typedLit (T literal, scala.reflect.api.TypeTags.TypeTag<T> evidence$1)  { throw new RuntimeException(); }
  /**
   * Creates a {@link Column} of literal value.
   * <p>
   * The passed in object is returned directly if it is already a {@link Column}.
   * If the object is a Scala Symbol, it is converted into a {@link Column} also.
   * Otherwise, a new {@link Column} is created to represent the literal value.
   * The difference between this function and {@link lit} is that this function
   * can handle parameterized scala types e.g.: List, Seq and Map.
   * <p>
   * @group normal_funcs
   * @since 3.2.0
   * @param literal (undocumented)
   * @param evidence$2 (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> org.apache.spark.sql.Column typedlit (T literal, scala.reflect.api.TypeTags.TypeTag<T> evidence$2)  { throw new RuntimeException(); }
  /**
   * Returns a sort expression based on ascending order of the column.
   * <pre><code>
   *   df.sort(asc("dept"), desc("age"))
   * </code></pre>
   * <p>
   * @group sort_funcs
   * @since 1.3.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column asc (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Returns a sort expression based on ascending order of the column,
   * and null values return before non-null values.
   * <pre><code>
   *   df.sort(asc_nulls_first("dept"), desc("age"))
   * </code></pre>
   * <p>
   * @group sort_funcs
   * @since 2.1.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column asc_nulls_first (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Returns a sort expression based on ascending order of the column,
   * and null values appear after non-null values.
   * <pre><code>
   *   df.sort(asc_nulls_last("dept"), desc("age"))
   * </code></pre>
   * <p>
   * @group sort_funcs
   * @since 2.1.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column asc_nulls_last (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Returns a sort expression based on the descending order of the column.
   * <pre><code>
   *   df.sort(asc("dept"), desc("age"))
   * </code></pre>
   * <p>
   * @group sort_funcs
   * @since 1.3.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column desc (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Returns a sort expression based on the descending order of the column,
   * and null values appear before non-null values.
   * <pre><code>
   *   df.sort(asc("dept"), desc_nulls_first("age"))
   * </code></pre>
   * <p>
   * @group sort_funcs
   * @since 2.1.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column desc_nulls_first (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Returns a sort expression based on the descending order of the column,
   * and null values appear after non-null values.
   * <pre><code>
   *   df.sort(asc("dept"), desc_nulls_last("age"))
   * </code></pre>
   * <p>
   * @group sort_funcs
   * @since 2.1.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column desc_nulls_last (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * @group agg_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use approx_count_distinct. Since 2.1.0. 
   */
  static public  org.apache.spark.sql.Column approxCountDistinct (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @group agg_funcs
   * @since 1.3.0
   * @param columnName (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use approx_count_distinct. Since 2.1.0. 
   */
  static public  org.apache.spark.sql.Column approxCountDistinct (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * @group agg_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @param rsd (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use approx_count_distinct. Since 2.1.0. 
   */
  static public  org.apache.spark.sql.Column approxCountDistinct (org.apache.spark.sql.Column e, double rsd)  { throw new RuntimeException(); }
  /**
   * @group agg_funcs
   * @since 1.3.0
   * @param columnName (undocumented)
   * @param rsd (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use approx_count_distinct. Since 2.1.0. 
   */
  static public  org.apache.spark.sql.Column approxCountDistinct (java.lang.String columnName, double rsd)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the approximate number of distinct items in a group.
   * <p>
   * @group agg_funcs
   * @since 2.1.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column approx_count_distinct (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the approximate number of distinct items in a group.
   * <p>
   * @group agg_funcs
   * @since 2.1.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column approx_count_distinct (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the approximate number of distinct items in a group.
   * <p>
   * @param rsd maximum relative standard deviation allowed (default = 0.05)
   * <p>
   * @group agg_funcs
   * @since 2.1.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column approx_count_distinct (org.apache.spark.sql.Column e, double rsd)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the approximate number of distinct items in a group.
   * <p>
   * @param rsd maximum relative standard deviation allowed (default = 0.05)
   * <p>
   * @group agg_funcs
   * @since 2.1.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column approx_count_distinct (java.lang.String columnName, double rsd)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the average of the values in a group.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column avg (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the average of the values in a group.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column avg (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns a list of objects with duplicates.
   * <p>
   * @note The function is non-deterministic because the order of collected results depends
   * on the order of the rows which may be non-deterministic after a shuffle.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column collect_list (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns a list of objects with duplicates.
   * <p>
   * @note The function is non-deterministic because the order of collected results depends
   * on the order of the rows which may be non-deterministic after a shuffle.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column collect_list (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns a set of objects with duplicate elements eliminated.
   * <p>
   * @note The function is non-deterministic because the order of collected results depends
   * on the order of the rows which may be non-deterministic after a shuffle.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column collect_set (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns a set of objects with duplicate elements eliminated.
   * <p>
   * @note The function is non-deterministic because the order of collected results depends
   * on the order of the rows which may be non-deterministic after a shuffle.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column collect_set (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the Pearson Correlation Coefficient for two columns.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param column1 (undocumented)
   * @param column2 (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column corr (org.apache.spark.sql.Column column1, org.apache.spark.sql.Column column2)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the Pearson Correlation Coefficient for two columns.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param columnName1 (undocumented)
   * @param columnName2 (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column corr (java.lang.String columnName1, java.lang.String columnName2)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the number of items in a group.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column count (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the number of items in a group.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.TypedColumn<java.lang.Object, java.lang.Object> count (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the number of distinct items in a group.
   * <p>
   * An alias of <code>count_distinct</code>, and it is encouraged to use <code>count_distinct</code> directly.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param expr (undocumented)
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column countDistinct (org.apache.spark.sql.Column expr, scala.collection.Seq<org.apache.spark.sql.Column> exprs)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the number of distinct items in a group.
   * <p>
   * An alias of <code>count_distinct</code>, and it is encouraged to use <code>count_distinct</code> directly.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param columnName (undocumented)
   * @param columnNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column countDistinct (java.lang.String columnName, scala.collection.Seq<java.lang.String> columnNames)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the number of distinct items in a group.
   * <p>
   * @group agg_funcs
   * @since 3.2.0
   * @param expr (undocumented)
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column count_distinct (org.apache.spark.sql.Column expr, scala.collection.Seq<org.apache.spark.sql.Column> exprs)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the population covariance for two columns.
   * <p>
   * @group agg_funcs
   * @since 2.0.0
   * @param column1 (undocumented)
   * @param column2 (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column covar_pop (org.apache.spark.sql.Column column1, org.apache.spark.sql.Column column2)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the population covariance for two columns.
   * <p>
   * @group agg_funcs
   * @since 2.0.0
   * @param columnName1 (undocumented)
   * @param columnName2 (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column covar_pop (java.lang.String columnName1, java.lang.String columnName2)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the sample covariance for two columns.
   * <p>
   * @group agg_funcs
   * @since 2.0.0
   * @param column1 (undocumented)
   * @param column2 (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column covar_samp (org.apache.spark.sql.Column column1, org.apache.spark.sql.Column column2)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the sample covariance for two columns.
   * <p>
   * @group agg_funcs
   * @since 2.0.0
   * @param columnName1 (undocumented)
   * @param columnName2 (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column covar_samp (java.lang.String columnName1, java.lang.String columnName2)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the first value in a group.
   * <p>
   * The function by default returns the first values it sees. It will return the first non-null
   * value it sees when ignoreNulls is set to true. If all values are null, then null is returned.
   * <p>
   * @note The function is non-deterministic because its results depends on the order of the rows
   * which may be non-deterministic after a shuffle.
   * <p>
   * @group agg_funcs
   * @since 2.0.0
   * @param e (undocumented)
   * @param ignoreNulls (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column first (org.apache.spark.sql.Column e, boolean ignoreNulls)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the first value of a column in a group.
   * <p>
   * The function by default returns the first values it sees. It will return the first non-null
   * value it sees when ignoreNulls is set to true. If all values are null, then null is returned.
   * <p>
   * @note The function is non-deterministic because its results depends on the order of the rows
   * which may be non-deterministic after a shuffle.
   * <p>
   * @group agg_funcs
   * @since 2.0.0
   * @param columnName (undocumented)
   * @param ignoreNulls (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column first (java.lang.String columnName, boolean ignoreNulls)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the first value in a group.
   * <p>
   * The function by default returns the first values it sees. It will return the first non-null
   * value it sees when ignoreNulls is set to true. If all values are null, then null is returned.
   * <p>
   * @note The function is non-deterministic because its results depends on the order of the rows
   * which may be non-deterministic after a shuffle.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column first (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the first value of a column in a group.
   * <p>
   * The function by default returns the first values it sees. It will return the first non-null
   * value it sees when ignoreNulls is set to true. If all values are null, then null is returned.
   * <p>
   * @note The function is non-deterministic because its results depends on the order of the rows
   * which may be non-deterministic after a shuffle.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column first (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: indicates whether a specified column in a GROUP BY list is aggregated
   * or not, returns 1 for aggregated or 0 for not aggregated in the result set.
   * <p>
   * @group agg_funcs
   * @since 2.0.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column grouping (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: indicates whether a specified column in a GROUP BY list is aggregated
   * or not, returns 1 for aggregated or 0 for not aggregated in the result set.
   * <p>
   * @group agg_funcs
   * @since 2.0.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column grouping (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the level of grouping, equals to
   * <p>
   * <pre><code>
   *   (grouping(c1) &lt;&lt;; (n-1)) + (grouping(c2) &lt;&lt;; (n-2)) + ... + grouping(cn)
   * </code></pre>
   * <p>
   * @note The list of columns should match with grouping columns exactly, or empty (means all the
   * grouping columns).
   * <p>
   * @group agg_funcs
   * @since 2.0.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column grouping_id (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the level of grouping, equals to
   * <p>
   * <pre><code>
   *   (grouping(c1) &lt;&lt;; (n-1)) + (grouping(c2) &lt;&lt;; (n-2)) + ... + grouping(cn)
   * </code></pre>
   * <p>
   * @note The list of columns should match with grouping columns exactly.
   * <p>
   * @group agg_funcs
   * @since 2.0.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column grouping_id (java.lang.String colName, scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the kurtosis of the values in a group.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column kurtosis (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the kurtosis of the values in a group.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column kurtosis (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the last value in a group.
   * <p>
   * The function by default returns the last values it sees. It will return the last non-null
   * value it sees when ignoreNulls is set to true. If all values are null, then null is returned.
   * <p>
   * @note The function is non-deterministic because its results depends on the order of the rows
   * which may be non-deterministic after a shuffle.
   * <p>
   * @group agg_funcs
   * @since 2.0.0
   * @param e (undocumented)
   * @param ignoreNulls (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column last (org.apache.spark.sql.Column e, boolean ignoreNulls)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the last value of the column in a group.
   * <p>
   * The function by default returns the last values it sees. It will return the last non-null
   * value it sees when ignoreNulls is set to true. If all values are null, then null is returned.
   * <p>
   * @note The function is non-deterministic because its results depends on the order of the rows
   * which may be non-deterministic after a shuffle.
   * <p>
   * @group agg_funcs
   * @since 2.0.0
   * @param columnName (undocumented)
   * @param ignoreNulls (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column last (java.lang.String columnName, boolean ignoreNulls)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the last value in a group.
   * <p>
   * The function by default returns the last values it sees. It will return the last non-null
   * value it sees when ignoreNulls is set to true. If all values are null, then null is returned.
   * <p>
   * @note The function is non-deterministic because its results depends on the order of the rows
   * which may be non-deterministic after a shuffle.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column last (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the last value of the column in a group.
   * <p>
   * The function by default returns the last values it sees. It will return the last non-null
   * value it sees when ignoreNulls is set to true. If all values are null, then null is returned.
   * <p>
   * @note The function is non-deterministic because its results depends on the order of the rows
   * which may be non-deterministic after a shuffle.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column last (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the maximum value of the expression in a group.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column max (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the maximum value of the column in a group.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column max (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the average of the values in a group.
   * Alias for avg.
   * <p>
   * @group agg_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column mean (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the average of the values in a group.
   * Alias for avg.
   * <p>
   * @group agg_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column mean (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the minimum value of the expression in a group.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column min (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the minimum value of the column in a group.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column min (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the approximate <code>percentile</code> of the numeric column <code>col</code> which
   * is the smallest value in the ordered <code>col</code> values (sorted from least to greatest) such that
   * no more than <code>percentage</code> of <code>col</code> values is less than the value or equal to that value.
   * <p>
   * If percentage is an array, each value must be between 0.0 and 1.0.
   * If it is a single floating point value, it must be between 0.0 and 1.0.
   * <p>
   * The accuracy parameter is a positive numeric literal
   * which controls approximation accuracy at the cost of memory.
   * Higher value of accuracy yields better accuracy, 1.0/accuracy
   * is the relative error of the approximation.
   * <p>
   * @group agg_funcs
   * @since 3.1.0
   * @param e (undocumented)
   * @param percentage (undocumented)
   * @param accuracy (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column percentile_approx (org.apache.spark.sql.Column e, org.apache.spark.sql.Column percentage, org.apache.spark.sql.Column accuracy)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the product of all numerical elements in a group.
   * <p>
   * @group agg_funcs
   * @since 3.2.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column product (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the skewness of the values in a group.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column skewness (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the skewness of the values in a group.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column skewness (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: alias for <code>stddev_samp</code>.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column stddev (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: alias for <code>stddev_samp</code>.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column stddev (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the sample standard deviation of
   * the expression in a group.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column stddev_samp (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the sample standard deviation of
   * the expression in a group.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column stddev_samp (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the population standard deviation of
   * the expression in a group.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column stddev_pop (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the population standard deviation of
   * the expression in a group.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column stddev_pop (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the sum of all values in the expression.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column sum (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the sum of all values in the given column.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column sum (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the sum of distinct values in the expression.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use sum_distinct. Since 3.2.0. 
   */
  static public  org.apache.spark.sql.Column sumDistinct (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the sum of distinct values in the expression.
   * <p>
   * @group agg_funcs
   * @since 1.3.0
   * @param columnName (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use sum_distinct. Since 3.2.0. 
   */
  static public  org.apache.spark.sql.Column sumDistinct (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the sum of distinct values in the expression.
   * <p>
   * @group agg_funcs
   * @since 3.2.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column sum_distinct (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: alias for <code>var_samp</code>.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column variance (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: alias for <code>var_samp</code>.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column variance (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the unbiased variance of the values in a group.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column var_samp (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the unbiased variance of the values in a group.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column var_samp (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the population variance of the values in a group.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column var_pop (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Aggregate function: returns the population variance of the values in a group.
   * <p>
   * @group agg_funcs
   * @since 1.6.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column var_pop (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Window function: returns the cumulative distribution of values within a window partition,
   * i.e. the fraction of rows that are below the current row.
   * <p>
   * <pre><code>
   *   N = total number of rows in the partition
   *   cumeDist(x) = number of values before (and including) x / N
   * </code></pre>
   * <p>
   * @group window_funcs
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column cume_dist ()  { throw new RuntimeException(); }
  /**
   * Window function: returns the rank of rows within a window partition, without any gaps.
   * <p>
   * The difference between rank and dense_rank is that denseRank leaves no gaps in ranking
   * sequence when there are ties. That is, if you were ranking a competition using dense_rank
   * and had three people tie for second place, you would say that all three were in second
   * place and that the next person came in third. Rank would give me sequential numbers, making
   * the person that came in third place (after the ties) would register as coming in fifth.
   * <p>
   * This is equivalent to the DENSE_RANK function in SQL.
   * <p>
   * @group window_funcs
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column dense_rank ()  { throw new RuntimeException(); }
  /**
   * Window function: returns the value that is <code>offset</code> rows before the current row, and
   * <code>null</code> if there is less than <code>offset</code> rows before the current row. For example,
   * an <code>offset</code> of one will return the previous row at any given point in the window partition.
   * <p>
   * This is equivalent to the LAG function in SQL.
   * <p>
   * @group window_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @param offset (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column lag (org.apache.spark.sql.Column e, int offset)  { throw new RuntimeException(); }
  /**
   * Window function: returns the value that is <code>offset</code> rows before the current row, and
   * <code>null</code> if there is less than <code>offset</code> rows before the current row. For example,
   * an <code>offset</code> of one will return the previous row at any given point in the window partition.
   * <p>
   * This is equivalent to the LAG function in SQL.
   * <p>
   * @group window_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @param offset (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column lag (java.lang.String columnName, int offset)  { throw new RuntimeException(); }
  /**
   * Window function: returns the value that is <code>offset</code> rows before the current row, and
   * <code>defaultValue</code> if there is less than <code>offset</code> rows before the current row. For example,
   * an <code>offset</code> of one will return the previous row at any given point in the window partition.
   * <p>
   * This is equivalent to the LAG function in SQL.
   * <p>
   * @group window_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @param offset (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column lag (java.lang.String columnName, int offset, Object defaultValue)  { throw new RuntimeException(); }
  /**
   * Window function: returns the value that is <code>offset</code> rows before the current row, and
   * <code>defaultValue</code> if there is less than <code>offset</code> rows before the current row. For example,
   * an <code>offset</code> of one will return the previous row at any given point in the window partition.
   * <p>
   * This is equivalent to the LAG function in SQL.
   * <p>
   * @group window_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @param offset (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column lag (org.apache.spark.sql.Column e, int offset, Object defaultValue)  { throw new RuntimeException(); }
  /**
   * Window function: returns the value that is <code>offset</code> rows before the current row, and
   * <code>defaultValue</code> if there is less than <code>offset</code> rows before the current row. <code>ignoreNulls</code>
   * determines whether null values of row are included in or eliminated from the calculation.
   * For example, an <code>offset</code> of one will return the previous row at any given point in the
   * window partition.
   * <p>
   * This is equivalent to the LAG function in SQL.
   * <p>
   * @group window_funcs
   * @since 3.2.0
   * @param e (undocumented)
   * @param offset (undocumented)
   * @param defaultValue (undocumented)
   * @param ignoreNulls (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column lag (org.apache.spark.sql.Column e, int offset, Object defaultValue, boolean ignoreNulls)  { throw new RuntimeException(); }
  /**
   * Window function: returns the value that is <code>offset</code> rows after the current row, and
   * <code>null</code> if there is less than <code>offset</code> rows after the current row. For example,
   * an <code>offset</code> of one will return the next row at any given point in the window partition.
   * <p>
   * This is equivalent to the LEAD function in SQL.
   * <p>
   * @group window_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @param offset (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column lead (java.lang.String columnName, int offset)  { throw new RuntimeException(); }
  /**
   * Window function: returns the value that is <code>offset</code> rows after the current row, and
   * <code>null</code> if there is less than <code>offset</code> rows after the current row. For example,
   * an <code>offset</code> of one will return the next row at any given point in the window partition.
   * <p>
   * This is equivalent to the LEAD function in SQL.
   * <p>
   * @group window_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @param offset (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column lead (org.apache.spark.sql.Column e, int offset)  { throw new RuntimeException(); }
  /**
   * Window function: returns the value that is <code>offset</code> rows after the current row, and
   * <code>defaultValue</code> if there is less than <code>offset</code> rows after the current row. For example,
   * an <code>offset</code> of one will return the next row at any given point in the window partition.
   * <p>
   * This is equivalent to the LEAD function in SQL.
   * <p>
   * @group window_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @param offset (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column lead (java.lang.String columnName, int offset, Object defaultValue)  { throw new RuntimeException(); }
  /**
   * Window function: returns the value that is <code>offset</code> rows after the current row, and
   * <code>defaultValue</code> if there is less than <code>offset</code> rows after the current row. For example,
   * an <code>offset</code> of one will return the next row at any given point in the window partition.
   * <p>
   * This is equivalent to the LEAD function in SQL.
   * <p>
   * @group window_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @param offset (undocumented)
   * @param defaultValue (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column lead (org.apache.spark.sql.Column e, int offset, Object defaultValue)  { throw new RuntimeException(); }
  /**
   * Window function: returns the value that is <code>offset</code> rows after the current row, and
   * <code>defaultValue</code> if there is less than <code>offset</code> rows after the current row. <code>ignoreNulls</code>
   * determines whether null values of row are included in or eliminated from the calculation.
   * The default value of <code>ignoreNulls</code> is false. For example, an <code>offset</code> of one will return
   * the next row at any given point in the window partition.
   * <p>
   * This is equivalent to the LEAD function in SQL.
   * <p>
   * @group window_funcs
   * @since 3.2.0
   * @param e (undocumented)
   * @param offset (undocumented)
   * @param defaultValue (undocumented)
   * @param ignoreNulls (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column lead (org.apache.spark.sql.Column e, int offset, Object defaultValue, boolean ignoreNulls)  { throw new RuntimeException(); }
  /**
   * Window function: returns the value that is the <code>offset</code>th row of the window frame
   * (counting from 1), and <code>null</code> if the size of window frame is less than <code>offset</code> rows.
   * <p>
   * It will return the <code>offset</code>th non-null value it sees when ignoreNulls is set to true.
   * If all values are null, then null is returned.
   * <p>
   * This is equivalent to the nth_value function in SQL.
   * <p>
   * @group window_funcs
   * @since 3.1.0
   * @param e (undocumented)
   * @param offset (undocumented)
   * @param ignoreNulls (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column nth_value (org.apache.spark.sql.Column e, int offset, boolean ignoreNulls)  { throw new RuntimeException(); }
  /**
   * Window function: returns the value that is the <code>offset</code>th row of the window frame
   * (counting from 1), and <code>null</code> if the size of window frame is less than <code>offset</code> rows.
   * <p>
   * This is equivalent to the nth_value function in SQL.
   * <p>
   * @group window_funcs
   * @since 3.1.0
   * @param e (undocumented)
   * @param offset (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column nth_value (org.apache.spark.sql.Column e, int offset)  { throw new RuntimeException(); }
  /**
   * Window function: returns the ntile group id (from 1 to <code>n</code> inclusive) in an ordered window
   * partition. For example, if <code>n</code> is 4, the first quarter of the rows will get value 1, the second
   * quarter will get 2, the third quarter will get 3, and the last quarter will get 4.
   * <p>
   * This is equivalent to the NTILE function in SQL.
   * <p>
   * @group window_funcs
   * @since 1.4.0
   * @param n (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column ntile (int n)  { throw new RuntimeException(); }
  /**
   * Window function: returns the relative rank (i.e. percentile) of rows within a window partition.
   * <p>
   * This is computed by:
   * <pre><code>
   *   (rank of row in its partition - 1) / (number of rows in the partition - 1)
   * </code></pre>
   * <p>
   * This is equivalent to the PERCENT_RANK function in SQL.
   * <p>
   * @group window_funcs
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column percent_rank ()  { throw new RuntimeException(); }
  /**
   * Window function: returns the rank of rows within a window partition.
   * <p>
   * The difference between rank and dense_rank is that dense_rank leaves no gaps in ranking
   * sequence when there are ties. That is, if you were ranking a competition using dense_rank
   * and had three people tie for second place, you would say that all three were in second
   * place and that the next person came in third. Rank would give me sequential numbers, making
   * the person that came in third place (after the ties) would register as coming in fifth.
   * <p>
   * This is equivalent to the RANK function in SQL.
   * <p>
   * @group window_funcs
   * @since 1.4.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column rank ()  { throw new RuntimeException(); }
  /**
   * Window function: returns a sequential number starting at 1 within a window partition.
   * <p>
   * @group window_funcs
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column row_number ()  { throw new RuntimeException(); }
  /**
   * Creates a new array column. The input columns must all have the same data type.
   * <p>
   * @group normal_funcs
   * @since 1.4.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Creates a new array column. The input columns must all have the same data type.
   * <p>
   * @group normal_funcs
   * @since 1.4.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array (java.lang.String colName, scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
  /**
   * Creates a new map column. The input columns must be grouped as key-value pairs, e.g.
   * (key1, value1, key2, value2, ...). The key columns must all have the same data type, and can't
   * be null. The value columns must all have the same data type.
   * <p>
   * @group normal_funcs
   * @since 2.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column map (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Creates a new map column. The array in the first column is used for keys. The array in the
   * second column is used for values. All elements in the array for key should not be null.
   * <p>
   * @group normal_funcs
   * @since 2.4
   * @param keys (undocumented)
   * @param values (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column map_from_arrays (org.apache.spark.sql.Column keys, org.apache.spark.sql.Column values)  { throw new RuntimeException(); }
  /**
   * Marks a DataFrame as small enough for use in broadcast joins.
   * <p>
   * The following example marks the right DataFrame for broadcast hash join using <code>joinKey</code>.
   * <pre><code>
   *   // left and right are DataFrames
   *   left.join(broadcast(right), "joinKey")
   * </code></pre>
   * <p>
   * @group normal_funcs
   * @since 1.5.0
   * @param df (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> org.apache.spark.sql.Dataset<T> broadcast (org.apache.spark.sql.Dataset<T> df)  { throw new RuntimeException(); }
  /**
   * Returns the first column that is not null, or null if all inputs are null.
   * <p>
   * For example, <code>coalesce(a, b, c)</code> will return a if a is not null,
   * or b if a is null and b is not null, or c if both a and b are null but c is not null.
   * <p>
   * @group normal_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column coalesce (scala.collection.Seq<org.apache.spark.sql.Column> e)  { throw new RuntimeException(); }
  /**
   * Creates a string column for the file name of the current Spark task.
   * <p>
   * @group normal_funcs
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column input_file_name ()  { throw new RuntimeException(); }
  /**
   * Return true iff the column is NaN.
   * <p>
   * @group normal_funcs
   * @since 1.6.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column isnan (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Return true iff the column is null.
   * <p>
   * @group normal_funcs
   * @since 1.6.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column isnull (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * A column expression that generates monotonically increasing 64-bit integers.
   * <p>
   * The generated ID is guaranteed to be monotonically increasing and unique, but not consecutive.
   * The current implementation puts the partition ID in the upper 31 bits, and the record number
   * within each partition in the lower 33 bits. The assumption is that the data frame has
   * less than 1 billion partitions, and each partition has less than 8 billion records.
   * <p>
   * As an example, consider a <code>DataFrame</code> with two partitions, each with 3 records.
   * This expression would return the following IDs:
   * <p>
   * <pre><code>
   * 0, 1, 2, 8589934592 (1L &lt;&lt; 33), 8589934593, 8589934594.
   * </code></pre>
   * <p>
   * @group normal_funcs
   * @since 1.4.0
   * @return (undocumented)
   *
   * @deprecated Use monotonically_increasing_id(). Since 2.0.0. 
   */
  static public  org.apache.spark.sql.Column monotonicallyIncreasingId ()  { throw new RuntimeException(); }
  /**
   * A column expression that generates monotonically increasing 64-bit integers.
   * <p>
   * The generated ID is guaranteed to be monotonically increasing and unique, but not consecutive.
   * The current implementation puts the partition ID in the upper 31 bits, and the record number
   * within each partition in the lower 33 bits. The assumption is that the data frame has
   * less than 1 billion partitions, and each partition has less than 8 billion records.
   * <p>
   * As an example, consider a <code>DataFrame</code> with two partitions, each with 3 records.
   * This expression would return the following IDs:
   * <p>
   * <pre><code>
   * 0, 1, 2, 8589934592 (1L &lt;&lt; 33), 8589934593, 8589934594.
   * </code></pre>
   * <p>
   * @group normal_funcs
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column monotonically_increasing_id ()  { throw new RuntimeException(); }
  /**
   * Returns col1 if it is not NaN, or col2 if col1 is NaN.
   * <p>
   * Both inputs should be floating point columns (DoubleType or FloatType).
   * <p>
   * @group normal_funcs
   * @since 1.5.0
   * @param col1 (undocumented)
   * @param col2 (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column nanvl (org.apache.spark.sql.Column col1, org.apache.spark.sql.Column col2)  { throw new RuntimeException(); }
  /**
   * Unary minus, i.e. negate the expression.
   * <pre><code>
   *   // Select the amount column and negates all values.
   *   // Scala:
   *   df.select( -df("amount") )
   *
   *   // Java:
   *   df.select( negate(df.col("amount")) );
   * </code></pre>
   * <p>
   * @group normal_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column negate (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Inversion of boolean expression, i.e. NOT.
   * <pre><code>
   *   // Scala: select rows that are not active (isActive === false)
   *   df.filter( !df("isActive") )
   *
   *   // Java:
   *   df.filter( not(df.col("isActive")) );
   * </code></pre>
   * <p>
   * @group normal_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column not (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Generate a random column with independent and identically distributed (i.i.d.) samples
   * uniformly distributed in [0.0, 1.0).
   * <p>
   * @note The function is non-deterministic in general case.
   * <p>
   * @group normal_funcs
   * @since 1.4.0
   * @param seed (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column rand (long seed)  { throw new RuntimeException(); }
  /**
   * Generate a random column with independent and identically distributed (i.i.d.) samples
   * uniformly distributed in [0.0, 1.0).
   * <p>
   * @note The function is non-deterministic in general case.
   * <p>
   * @group normal_funcs
   * @since 1.4.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column rand ()  { throw new RuntimeException(); }
  /**
   * Generate a column with independent and identically distributed (i.i.d.) samples from
   * the standard normal distribution.
   * <p>
   * @note The function is non-deterministic in general case.
   * <p>
   * @group normal_funcs
   * @since 1.4.0
   * @param seed (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column randn (long seed)  { throw new RuntimeException(); }
  /**
   * Generate a column with independent and identically distributed (i.i.d.) samples from
   * the standard normal distribution.
   * <p>
   * @note The function is non-deterministic in general case.
   * <p>
   * @group normal_funcs
   * @since 1.4.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column randn ()  { throw new RuntimeException(); }
  /**
   * Partition ID.
   * <p>
   * @note This is non-deterministic because it depends on data partitioning and task scheduling.
   * <p>
   * @group normal_funcs
   * @since 1.6.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column spark_partition_id ()  { throw new RuntimeException(); }
  /**
   * Computes the square root of the specified float value.
   * <p>
   * @group math_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column sqrt (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Computes the square root of the specified float value.
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param colName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column sqrt (java.lang.String colName)  { throw new RuntimeException(); }
  /**
   * Creates a new struct column.
   * If the input column is a column in a <code>DataFrame</code>, or a derived column expression
   * that is named (i.e. aliased), its name would be retained as the StructField's name,
   * otherwise, the newly generated StructField's name would be auto generated as
   * <code>col</code> with a suffix <code>index + 1</code>, i.e. col1, col2, col3, ...
   * <p>
   * @group normal_funcs
   * @since 1.4.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column struct (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Creates a new struct column that composes multiple input columns.
   * <p>
   * @group normal_funcs
   * @since 1.4.0
   * @param colName (undocumented)
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column struct (java.lang.String colName, scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
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
   * @group normal_funcs
   * @since 1.4.0
   * @param condition (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column when (org.apache.spark.sql.Column condition, Object value)  { throw new RuntimeException(); }
  /**
   * Computes bitwise NOT (~) of a number.
   * <p>
   * @group normal_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use bitwise_not. Since 3.2.0. 
   */
  static public  org.apache.spark.sql.Column bitwiseNOT (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Computes bitwise NOT (~) of a number.
   * <p>
   * @group normal_funcs
   * @since 3.2.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column bitwise_not (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Parses the expression string into the column that it represents, similar to
   * {@link Dataset#selectExpr}.
   * <pre><code>
   *   // get the number of words of each length
   *   df.groupBy(expr("length(word)")).count()
   * </code></pre>
   * <p>
   * @group normal_funcs
   * @param expr (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column expr (java.lang.String expr)  { throw new RuntimeException(); }
  /**
   * Computes the absolute value of a numeric value.
   * <p>
   * @group math_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column abs (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @return inverse cosine of <code>e</code> in radians, as if computed by <code>java.lang.Math.acos</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column acos (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @return inverse cosine of <code>columnName</code>, as if computed by <code>java.lang.Math.acos</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   */
  static public  org.apache.spark.sql.Column acos (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * @return inverse hyperbolic cosine of <code>e</code>
   * <p>
   * @group math_funcs
   * @since 3.1.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column acosh (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @return inverse hyperbolic cosine of <code>columnName</code>
   * <p>
   * @group math_funcs
   * @since 3.1.0
   * @param columnName (undocumented)
   */
  static public  org.apache.spark.sql.Column acosh (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * @return inverse sine of <code>e</code> in radians, as if computed by <code>java.lang.Math.asin</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column asin (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @return inverse sine of <code>columnName</code>, as if computed by <code>java.lang.Math.asin</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   */
  static public  org.apache.spark.sql.Column asin (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * @return inverse hyperbolic sine of <code>e</code>
   * <p>
   * @group math_funcs
   * @since 3.1.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column asinh (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @return inverse hyperbolic sine of <code>columnName</code>
   * <p>
   * @group math_funcs
   * @since 3.1.0
   * @param columnName (undocumented)
   */
  static public  org.apache.spark.sql.Column asinh (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * @return inverse tangent of <code>e</code> as if computed by <code>java.lang.Math.atan</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column atan (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @return inverse tangent of <code>columnName</code>, as if computed by <code>java.lang.Math.atan</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   */
  static public  org.apache.spark.sql.Column atan (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * @param y coordinate on y-axis
   * @param x coordinate on x-axis
   * @return the <i>theta</i> component of the point
   *         (<i>r</i>, <i>theta</i>)
   *         in polar coordinates that corresponds to the point
   *         (<i>x</i>, <i>y</i>) in Cartesian coordinates,
   *         as if computed by <code>java.lang.Math.atan2</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column atan2 (org.apache.spark.sql.Column y, org.apache.spark.sql.Column x)  { throw new RuntimeException(); }
  /**
   * @param y coordinate on y-axis
   * @param xName coordinate on x-axis
   * @return the <i>theta</i> component of the point
   *         (<i>r</i>, <i>theta</i>)
   *         in polar coordinates that corresponds to the point
   *         (<i>x</i>, <i>y</i>) in Cartesian coordinates,
   *         as if computed by <code>java.lang.Math.atan2</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column atan2 (org.apache.spark.sql.Column y, java.lang.String xName)  { throw new RuntimeException(); }
  /**
   * @param yName coordinate on y-axis
   * @param x coordinate on x-axis
   * @return the <i>theta</i> component of the point
   *         (<i>r</i>, <i>theta</i>)
   *         in polar coordinates that corresponds to the point
   *         (<i>x</i>, <i>y</i>) in Cartesian coordinates,
   *         as if computed by <code>java.lang.Math.atan2</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column atan2 (java.lang.String yName, org.apache.spark.sql.Column x)  { throw new RuntimeException(); }
  /**
   * @param yName coordinate on y-axis
   * @param xName coordinate on x-axis
   * @return the <i>theta</i> component of the point
   *         (<i>r</i>, <i>theta</i>)
   *         in polar coordinates that corresponds to the point
   *         (<i>x</i>, <i>y</i>) in Cartesian coordinates,
   *         as if computed by <code>java.lang.Math.atan2</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column atan2 (java.lang.String yName, java.lang.String xName)  { throw new RuntimeException(); }
  /**
   * @param y coordinate on y-axis
   * @param xValue coordinate on x-axis
   * @return the <i>theta</i> component of the point
   *         (<i>r</i>, <i>theta</i>)
   *         in polar coordinates that corresponds to the point
   *         (<i>x</i>, <i>y</i>) in Cartesian coordinates,
   *         as if computed by <code>java.lang.Math.atan2</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column atan2 (org.apache.spark.sql.Column y, double xValue)  { throw new RuntimeException(); }
  /**
   * @param yName coordinate on y-axis
   * @param xValue coordinate on x-axis
   * @return the <i>theta</i> component of the point
   *         (<i>r</i>, <i>theta</i>)
   *         in polar coordinates that corresponds to the point
   *         (<i>x</i>, <i>y</i>) in Cartesian coordinates,
   *         as if computed by <code>java.lang.Math.atan2</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column atan2 (java.lang.String yName, double xValue)  { throw new RuntimeException(); }
  /**
   * @param yValue coordinate on y-axis
   * @param x coordinate on x-axis
   * @return the <i>theta</i> component of the point
   *         (<i>r</i>, <i>theta</i>)
   *         in polar coordinates that corresponds to the point
   *         (<i>x</i>, <i>y</i>) in Cartesian coordinates,
   *         as if computed by <code>java.lang.Math.atan2</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column atan2 (double yValue, org.apache.spark.sql.Column x)  { throw new RuntimeException(); }
  /**
   * @param yValue coordinate on y-axis
   * @param xName coordinate on x-axis
   * @return the <i>theta</i> component of the point
   *         (<i>r</i>, <i>theta</i>)
   *         in polar coordinates that corresponds to the point
   *         (<i>x</i>, <i>y</i>) in Cartesian coordinates,
   *         as if computed by <code>java.lang.Math.atan2</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column atan2 (double yValue, java.lang.String xName)  { throw new RuntimeException(); }
  /**
   * @return inverse hyperbolic tangent of <code>e</code>
   * <p>
   * @group math_funcs
   * @since 3.1.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column atanh (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @return inverse hyperbolic tangent of <code>columnName</code>
   * <p>
   * @group math_funcs
   * @since 3.1.0
   * @param columnName (undocumented)
   */
  static public  org.apache.spark.sql.Column atanh (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * An expression that returns the string representation of the binary value of the given long
   * column. For example, bin("12") returns "1100".
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column bin (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * An expression that returns the string representation of the binary value of the given long
   * column. For example, bin("12") returns "1100".
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column bin (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Computes the cube-root of the given value.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column cbrt (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Computes the cube-root of the given column.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column cbrt (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Computes the ceiling of the given value.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column ceil (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Computes the ceiling of the given column.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column ceil (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Convert a number in a string column from one base to another.
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param num (undocumented)
   * @param fromBase (undocumented)
   * @param toBase (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column conv (org.apache.spark.sql.Column num, int fromBase, int toBase)  { throw new RuntimeException(); }
  /**
   * @param e angle in radians
   * @return cosine of the angle, as if computed by <code>java.lang.Math.cos</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column cos (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @param columnName angle in radians
   * @return cosine of the angle, as if computed by <code>java.lang.Math.cos</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column cos (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * @param e hyperbolic angle
   * @return hyperbolic cosine of the angle, as if computed by <code>java.lang.Math.cosh</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column cosh (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @param columnName hyperbolic angle
   * @return hyperbolic cosine of the angle, as if computed by <code>java.lang.Math.cosh</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column cosh (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Computes the exponential of the given value.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column exp (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Computes the exponential of the given column.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column exp (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Computes the exponential of the given value minus one.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column expm1 (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Computes the exponential of the given column minus one.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column expm1 (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Computes the factorial of the given value.
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column factorial (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Computes the floor of the given value.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column floor (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Computes the floor of the given column.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column floor (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Returns the greatest value of the list of values, skipping null values.
   * This function takes at least 2 parameters. It will return null iff all parameters are null.
   * <p>
   * @group normal_funcs
   * @since 1.5.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column greatest (scala.collection.Seq<org.apache.spark.sql.Column> exprs)  { throw new RuntimeException(); }
  /**
   * Returns the greatest value of the list of column names, skipping null values.
   * This function takes at least 2 parameters. It will return null iff all parameters are null.
   * <p>
   * @group normal_funcs
   * @since 1.5.0
   * @param columnName (undocumented)
   * @param columnNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column greatest (java.lang.String columnName, scala.collection.Seq<java.lang.String> columnNames)  { throw new RuntimeException(); }
  /**
   * Computes hex value of the given column.
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param column (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column hex (org.apache.spark.sql.Column column)  { throw new RuntimeException(); }
  /**
   * Inverse of hex. Interprets each pair of characters as a hexadecimal number
   * and converts to the byte representation of number.
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param column (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column unhex (org.apache.spark.sql.Column column)  { throw new RuntimeException(); }
  /**
   * Computes <code>sqrt(a^2^ + b^2^)</code> without intermediate overflow or underflow.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param l (undocumented)
   * @param r (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column hypot (org.apache.spark.sql.Column l, org.apache.spark.sql.Column r)  { throw new RuntimeException(); }
  /**
   * Computes <code>sqrt(a^2^ + b^2^)</code> without intermediate overflow or underflow.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param l (undocumented)
   * @param rightName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column hypot (org.apache.spark.sql.Column l, java.lang.String rightName)  { throw new RuntimeException(); }
  /**
   * Computes <code>sqrt(a^2^ + b^2^)</code> without intermediate overflow or underflow.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param leftName (undocumented)
   * @param r (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column hypot (java.lang.String leftName, org.apache.spark.sql.Column r)  { throw new RuntimeException(); }
  /**
   * Computes <code>sqrt(a^2^ + b^2^)</code> without intermediate overflow or underflow.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param leftName (undocumented)
   * @param rightName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column hypot (java.lang.String leftName, java.lang.String rightName)  { throw new RuntimeException(); }
  /**
   * Computes <code>sqrt(a^2^ + b^2^)</code> without intermediate overflow or underflow.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param l (undocumented)
   * @param r (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column hypot (org.apache.spark.sql.Column l, double r)  { throw new RuntimeException(); }
  /**
   * Computes <code>sqrt(a^2^ + b^2^)</code> without intermediate overflow or underflow.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param leftName (undocumented)
   * @param r (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column hypot (java.lang.String leftName, double r)  { throw new RuntimeException(); }
  /**
   * Computes <code>sqrt(a^2^ + b^2^)</code> without intermediate overflow or underflow.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param l (undocumented)
   * @param r (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column hypot (double l, org.apache.spark.sql.Column r)  { throw new RuntimeException(); }
  /**
   * Computes <code>sqrt(a^2^ + b^2^)</code> without intermediate overflow or underflow.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param l (undocumented)
   * @param rightName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column hypot (double l, java.lang.String rightName)  { throw new RuntimeException(); }
  /**
   * Returns the least value of the list of values, skipping null values.
   * This function takes at least 2 parameters. It will return null iff all parameters are null.
   * <p>
   * @group normal_funcs
   * @since 1.5.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column least (scala.collection.Seq<org.apache.spark.sql.Column> exprs)  { throw new RuntimeException(); }
  /**
   * Returns the least value of the list of column names, skipping null values.
   * This function takes at least 2 parameters. It will return null iff all parameters are null.
   * <p>
   * @group normal_funcs
   * @since 1.5.0
   * @param columnName (undocumented)
   * @param columnNames (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column least (java.lang.String columnName, scala.collection.Seq<java.lang.String> columnNames)  { throw new RuntimeException(); }
  /**
   * Computes the natural logarithm of the given value.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column log (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Computes the natural logarithm of the given column.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column log (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Returns the first argument-base logarithm of the second argument.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param base (undocumented)
   * @param a (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column log (double base, org.apache.spark.sql.Column a)  { throw new RuntimeException(); }
  /**
   * Returns the first argument-base logarithm of the second argument.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param base (undocumented)
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column log (double base, java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Computes the logarithm of the given value in base 10.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column log10 (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Computes the logarithm of the given value in base 10.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column log10 (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Computes the natural logarithm of the given value plus one.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column log1p (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Computes the natural logarithm of the given column plus one.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column log1p (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Computes the logarithm of the given column in base 2.
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param expr (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column log2 (org.apache.spark.sql.Column expr)  { throw new RuntimeException(); }
  /**
   * Computes the logarithm of the given value in base 2.
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column log2 (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Returns the value of the first argument raised to the power of the second argument.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param l (undocumented)
   * @param r (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column pow (org.apache.spark.sql.Column l, org.apache.spark.sql.Column r)  { throw new RuntimeException(); }
  /**
   * Returns the value of the first argument raised to the power of the second argument.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param l (undocumented)
   * @param rightName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column pow (org.apache.spark.sql.Column l, java.lang.String rightName)  { throw new RuntimeException(); }
  /**
   * Returns the value of the first argument raised to the power of the second argument.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param leftName (undocumented)
   * @param r (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column pow (java.lang.String leftName, org.apache.spark.sql.Column r)  { throw new RuntimeException(); }
  /**
   * Returns the value of the first argument raised to the power of the second argument.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param leftName (undocumented)
   * @param rightName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column pow (java.lang.String leftName, java.lang.String rightName)  { throw new RuntimeException(); }
  /**
   * Returns the value of the first argument raised to the power of the second argument.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param l (undocumented)
   * @param r (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column pow (org.apache.spark.sql.Column l, double r)  { throw new RuntimeException(); }
  /**
   * Returns the value of the first argument raised to the power of the second argument.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param leftName (undocumented)
   * @param r (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column pow (java.lang.String leftName, double r)  { throw new RuntimeException(); }
  /**
   * Returns the value of the first argument raised to the power of the second argument.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param l (undocumented)
   * @param r (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column pow (double l, org.apache.spark.sql.Column r)  { throw new RuntimeException(); }
  /**
   * Returns the value of the first argument raised to the power of the second argument.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param l (undocumented)
   * @param rightName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column pow (double l, java.lang.String rightName)  { throw new RuntimeException(); }
  /**
   * Returns the positive value of dividend mod divisor.
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param dividend (undocumented)
   * @param divisor (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column pmod (org.apache.spark.sql.Column dividend, org.apache.spark.sql.Column divisor)  { throw new RuntimeException(); }
  /**
   * Returns the double value that is closest in value to the argument and
   * is equal to a mathematical integer.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column rint (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Returns the double value that is closest in value to the argument and
   * is equal to a mathematical integer.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column rint (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Returns the value of the column <code>e</code> rounded to 0 decimal places with HALF_UP round mode.
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column round (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Round the value of <code>e</code> to <code>scale</code> decimal places with HALF_UP round mode
   * if <code>scale</code> is greater than or equal to 0 or at integral part when <code>scale</code> is less than 0.
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @param scale (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column round (org.apache.spark.sql.Column e, int scale)  { throw new RuntimeException(); }
  /**
   * Returns the value of the column <code>e</code> rounded to 0 decimal places with HALF_EVEN round mode.
   * <p>
   * @group math_funcs
   * @since 2.0.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column bround (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Round the value of <code>e</code> to <code>scale</code> decimal places with HALF_EVEN round mode
   * if <code>scale</code> is greater than or equal to 0 or at integral part when <code>scale</code> is less than 0.
   * <p>
   * @group math_funcs
   * @since 2.0.0
   * @param e (undocumented)
   * @param scale (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column bround (org.apache.spark.sql.Column e, int scale)  { throw new RuntimeException(); }
  /**
   * Shift the given value numBits left. If the given value is a long value, this function
   * will return a long value else it will return an integer value.
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @param numBits (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use shiftleft. Since 3.2.0. 
   */
  static public  org.apache.spark.sql.Column shiftLeft (org.apache.spark.sql.Column e, int numBits)  { throw new RuntimeException(); }
  /**
   * Shift the given value numBits left. If the given value is a long value, this function
   * will return a long value else it will return an integer value.
   * <p>
   * @group math_funcs
   * @since 3.2.0
   * @param e (undocumented)
   * @param numBits (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column shiftleft (org.apache.spark.sql.Column e, int numBits)  { throw new RuntimeException(); }
  /**
   * (Signed) shift the given value numBits right. If the given value is a long value, it will
   * return a long value else it will return an integer value.
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @param numBits (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use shiftright. Since 3.2.0. 
   */
  static public  org.apache.spark.sql.Column shiftRight (org.apache.spark.sql.Column e, int numBits)  { throw new RuntimeException(); }
  /**
   * (Signed) shift the given value numBits right. If the given value is a long value, it will
   * return a long value else it will return an integer value.
   * <p>
   * @group math_funcs
   * @since 3.2.0
   * @param e (undocumented)
   * @param numBits (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column shiftright (org.apache.spark.sql.Column e, int numBits)  { throw new RuntimeException(); }
  /**
   * Unsigned shift the given value numBits right. If the given value is a long value,
   * it will return a long value else it will return an integer value.
   * <p>
   * @group math_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @param numBits (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use shiftrightunsigned. Since 3.2.0. 
   */
  static public  org.apache.spark.sql.Column shiftRightUnsigned (org.apache.spark.sql.Column e, int numBits)  { throw new RuntimeException(); }
  /**
   * Unsigned shift the given value numBits right. If the given value is a long value,
   * it will return a long value else it will return an integer value.
   * <p>
   * @group math_funcs
   * @since 3.2.0
   * @param e (undocumented)
   * @param numBits (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column shiftrightunsigned (org.apache.spark.sql.Column e, int numBits)  { throw new RuntimeException(); }
  /**
   * Computes the signum of the given value.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column signum (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Computes the signum of the given column.
   * <p>
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column signum (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * @param e angle in radians
   * @return sine of the angle, as if computed by <code>java.lang.Math.sin</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column sin (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @param columnName angle in radians
   * @return sine of the angle, as if computed by <code>java.lang.Math.sin</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column sin (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * @param e hyperbolic angle
   * @return hyperbolic sine of the given value, as if computed by <code>java.lang.Math.sinh</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column sinh (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @param columnName hyperbolic angle
   * @return hyperbolic sine of the given value, as if computed by <code>java.lang.Math.sinh</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column sinh (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * @param e angle in radians
   * @return tangent of the given value, as if computed by <code>java.lang.Math.tan</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column tan (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @param columnName angle in radians
   * @return tangent of the given value, as if computed by <code>java.lang.Math.tan</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column tan (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * @param e hyperbolic angle
   * @return hyperbolic tangent of the given value, as if computed by <code>java.lang.Math.tanh</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column tanh (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @param columnName hyperbolic angle
   * @return hyperbolic tangent of the given value, as if computed by <code>java.lang.Math.tanh</code>
   * <p>
   * @group math_funcs
   * @since 1.4.0
   */
  static public  org.apache.spark.sql.Column tanh (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use degrees. Since 2.1.0. 
   */
  static public  org.apache.spark.sql.Column toDegrees (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use degrees. Since 2.1.0. 
   */
  static public  org.apache.spark.sql.Column toDegrees (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Converts an angle measured in radians to an approximately equivalent angle measured in degrees.
   * <p>
   * @param e angle in radians
   * @return angle in degrees, as if computed by <code>java.lang.Math.toDegrees</code>
   * <p>
   * @group math_funcs
   * @since 2.1.0
   */
  static public  org.apache.spark.sql.Column degrees (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Converts an angle measured in radians to an approximately equivalent angle measured in degrees.
   * <p>
   * @param columnName angle in radians
   * @return angle in degrees, as if computed by <code>java.lang.Math.toDegrees</code>
   * <p>
   * @group math_funcs
   * @since 2.1.0
   */
  static public  org.apache.spark.sql.Column degrees (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * @group math_funcs
   * @since 1.4.0
   * @param e (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use radians. Since 2.1.0. 
   */
  static public  org.apache.spark.sql.Column toRadians (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * @group math_funcs
   * @since 1.4.0
   * @param columnName (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use radians. Since 2.1.0. 
   */
  static public  org.apache.spark.sql.Column toRadians (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Converts an angle measured in degrees to an approximately equivalent angle measured in radians.
   * <p>
   * @param e angle in degrees
   * @return angle in radians, as if computed by <code>java.lang.Math.toRadians</code>
   * <p>
   * @group math_funcs
   * @since 2.1.0
   */
  static public  org.apache.spark.sql.Column radians (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Converts an angle measured in degrees to an approximately equivalent angle measured in radians.
   * <p>
   * @param columnName angle in degrees
   * @return angle in radians, as if computed by <code>java.lang.Math.toRadians</code>
   * <p>
   * @group math_funcs
   * @since 2.1.0
   */
  static public  org.apache.spark.sql.Column radians (java.lang.String columnName)  { throw new RuntimeException(); }
  /**
   * Calculates the MD5 digest of a binary column and returns the value
   * as a 32 character hex string.
   * <p>
   * @group misc_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column md5 (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Calculates the SHA-1 digest of a binary column and returns the value
   * as a 40 character hex string.
   * <p>
   * @group misc_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column sha1 (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Calculates the SHA-2 family of hash functions of a binary column and
   * returns the value as a hex string.
   * <p>
   * @param e column to compute SHA-2 on.
   * @param numBits one of 224, 256, 384, or 512.
   * <p>
   * @group misc_funcs
   * @since 1.5.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column sha2 (org.apache.spark.sql.Column e, int numBits)  { throw new RuntimeException(); }
  /**
   * Calculates the cyclic redundancy check value  (CRC32) of a binary column and
   * returns the value as a bigint.
   * <p>
   * @group misc_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column crc32 (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Calculates the hash code of given columns, and returns the result as an int column.
   * <p>
   * @group misc_funcs
   * @since 2.0.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column hash (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Calculates the hash code of given columns using the 64-bit
   * variant of the xxHash algorithm, and returns the result as a long
   * column.
   * <p>
   * @group misc_funcs
   * @since 3.0.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column xxhash64 (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Returns null if the condition is true, and throws an exception otherwise.
   * <p>
   * @group misc_funcs
   * @since 3.1.0
   * @param c (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column assert_true (org.apache.spark.sql.Column c)  { throw new RuntimeException(); }
  /**
   * Returns null if the condition is true; throws an exception with the error message otherwise.
   * <p>
   * @group misc_funcs
   * @since 3.1.0
   * @param c (undocumented)
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column assert_true (org.apache.spark.sql.Column c, org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Throws an exception with the provided error message.
   * <p>
   * @group misc_funcs
   * @since 3.1.0
   * @param c (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column raise_error (org.apache.spark.sql.Column c)  { throw new RuntimeException(); }
  /**
   * Computes the numeric value of the first character of the string column, and returns the
   * result as an int column.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column ascii (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Computes the BASE64 encoding of a binary column and returns it as a string column.
   * This is the reverse of unbase64.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column base64 (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Concatenates multiple input string columns together into a single string column,
   * using the given separator.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param sep (undocumented)
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column concat_ws (java.lang.String sep, scala.collection.Seq<org.apache.spark.sql.Column> exprs)  { throw new RuntimeException(); }
  /**
   * Computes the first argument into a string from a binary using the provided character set
   * (one of 'US-ASCII', 'ISO-8859-1', 'UTF-8', 'UTF-16BE', 'UTF-16LE', 'UTF-16').
   * If either argument is null, the result will also be null.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param value (undocumented)
   * @param charset (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column decode (org.apache.spark.sql.Column value, java.lang.String charset)  { throw new RuntimeException(); }
  /**
   * Computes the first argument into a binary from a string using the provided character set
   * (one of 'US-ASCII', 'ISO-8859-1', 'UTF-8', 'UTF-16BE', 'UTF-16LE', 'UTF-16').
   * If either argument is null, the result will also be null.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param value (undocumented)
   * @param charset (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column encode (org.apache.spark.sql.Column value, java.lang.String charset)  { throw new RuntimeException(); }
  /**
   * Formats numeric column x to a format like '#,###,###.##', rounded to d decimal places
   * with HALF_EVEN round mode, and returns the result as a string column.
   * <p>
   * If d is 0, the result has no decimal point or fractional part.
   * If d is less than 0, the result will be null.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param x (undocumented)
   * @param d (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column format_number (org.apache.spark.sql.Column x, int d)  { throw new RuntimeException(); }
  /**
   * Formats the arguments in printf-style and returns the result as a string column.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param format (undocumented)
   * @param arguments (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column format_string (java.lang.String format, scala.collection.Seq<org.apache.spark.sql.Column> arguments)  { throw new RuntimeException(); }
  /**
   * Returns a new string column by converting the first letter of each word to uppercase.
   * Words are delimited by whitespace.
   * <p>
   * For example, "hello world" will become "Hello World".
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column initcap (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Locate the position of the first occurrence of substr column in the given string.
   * Returns null if either of the arguments are null.
   * <p>
   * @note The position is not zero based, but 1 based index. Returns 0 if substr
   * could not be found in str.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param str (undocumented)
   * @param substring (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column instr (org.apache.spark.sql.Column str, java.lang.String substring)  { throw new RuntimeException(); }
  /**
   * Computes the character length of a given string or number of bytes of a binary string.
   * The length of character strings include the trailing spaces. The length of binary strings
   * includes binary zeros.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column length (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Converts a string column to lower case.
   * <p>
   * @group string_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column lower (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Computes the Levenshtein distance of the two given string columns.
   * @group string_funcs
   * @since 1.5.0
   * @param l (undocumented)
   * @param r (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column levenshtein (org.apache.spark.sql.Column l, org.apache.spark.sql.Column r)  { throw new RuntimeException(); }
  /**
   * Locate the position of the first occurrence of substr.
   * <p>
   * @note The position is not zero based, but 1 based index. Returns 0 if substr
   * could not be found in str.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param substr (undocumented)
   * @param str (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column locate (java.lang.String substr, org.apache.spark.sql.Column str)  { throw new RuntimeException(); }
  /**
   * Locate the position of the first occurrence of substr in a string column, after position pos.
   * <p>
   * @note The position is not zero based, but 1 based index. returns 0 if substr
   * could not be found in str.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param substr (undocumented)
   * @param str (undocumented)
   * @param pos (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column locate (java.lang.String substr, org.apache.spark.sql.Column str, int pos)  { throw new RuntimeException(); }
  /**
   * Left-pad the string column with pad to a length of len. If the string column is longer
   * than len, the return value is shortened to len characters.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param str (undocumented)
   * @param len (undocumented)
   * @param pad (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column lpad (org.apache.spark.sql.Column str, int len, java.lang.String pad)  { throw new RuntimeException(); }
  /**
   * Trim the spaces from left end for the specified string value.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column ltrim (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Trim the specified character string from left end for the specified string column.
   * @group string_funcs
   * @since 2.3.0
   * @param e (undocumented)
   * @param trimString (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column ltrim (org.apache.spark.sql.Column e, java.lang.String trimString)  { throw new RuntimeException(); }
  /**
   * Extract a specific group matched by a Java regex, from the specified string column.
   * If the regex did not match, or the specified group did not match, an empty string is returned.
   * if the specified group index exceeds the group count of regex, an IllegalArgumentException
   * will be thrown.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @param exp (undocumented)
   * @param groupIdx (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column regexp_extract (org.apache.spark.sql.Column e, java.lang.String exp, int groupIdx)  { throw new RuntimeException(); }
  /**
   * Replace all substrings of the specified string value that match regexp with rep.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @param pattern (undocumented)
   * @param replacement (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column regexp_replace (org.apache.spark.sql.Column e, java.lang.String pattern, java.lang.String replacement)  { throw new RuntimeException(); }
  /**
   * Replace all substrings of the specified string value that match regexp with rep.
   * <p>
   * @group string_funcs
   * @since 2.1.0
   * @param e (undocumented)
   * @param pattern (undocumented)
   * @param replacement (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column regexp_replace (org.apache.spark.sql.Column e, org.apache.spark.sql.Column pattern, org.apache.spark.sql.Column replacement)  { throw new RuntimeException(); }
  /**
   * Decodes a BASE64 encoded string column and returns it as a binary column.
   * This is the reverse of base64.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column unbase64 (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Right-pad the string column with pad to a length of len. If the string column is longer
   * than len, the return value is shortened to len characters.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param str (undocumented)
   * @param len (undocumented)
   * @param pad (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column rpad (org.apache.spark.sql.Column str, int len, java.lang.String pad)  { throw new RuntimeException(); }
  /**
   * Repeats a string column n times, and returns it as a new string column.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param str (undocumented)
   * @param n (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column repeat (org.apache.spark.sql.Column str, int n)  { throw new RuntimeException(); }
  /**
   * Trim the spaces from right end for the specified string value.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column rtrim (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Trim the specified character string from right end for the specified string column.
   * @group string_funcs
   * @since 2.3.0
   * @param e (undocumented)
   * @param trimString (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column rtrim (org.apache.spark.sql.Column e, java.lang.String trimString)  { throw new RuntimeException(); }
  /**
   * Returns the soundex code for the specified expression.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column soundex (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Splits str around matches of the given pattern.
   * <p>
   * @param str a string expression to split
   * @param pattern a string representing a regular expression. The regex string should be
   *                a Java regular expression.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column split (org.apache.spark.sql.Column str, java.lang.String pattern)  { throw new RuntimeException(); }
  /**
   * Splits str around matches of the given pattern.
   * <p>
   * @param str a string expression to split
   * @param pattern a string representing a regular expression. The regex string should be
   *                a Java regular expression.
   * @param limit an integer expression which controls the number of times the regex is applied.
   *        <ul>
   *          <li>limit greater than 0: The resulting array's length will not be more than limit,
   *          and the resulting array's last entry will contain all input beyond the last
   *          matched regex.</li>
   *          <li>limit less than or equal to 0: <code>regex</code> will be applied as many times as
   *          possible, and the resulting array can be of any size.</li>
   *        </ul>
   * <p>
   * @group string_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column split (org.apache.spark.sql.Column str, java.lang.String pattern, int limit)  { throw new RuntimeException(); }
  /**
   * Substring starts at <code>pos</code> and is of length <code>len</code> when str is String type or
   * returns the slice of byte array that starts at <code>pos</code> in byte and is of length <code>len</code>
   * when str is Binary type
   * <p>
   * @note The position is not zero based, but 1 based index.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param str (undocumented)
   * @param pos (undocumented)
   * @param len (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column substring (org.apache.spark.sql.Column str, int pos, int len)  { throw new RuntimeException(); }
  /**
   * Returns the substring from string str before count occurrences of the delimiter delim.
   * If count is positive, everything the left of the final delimiter (counting from left) is
   * returned. If count is negative, every to the right of the final delimiter (counting from the
   * right) is returned. substring_index performs a case-sensitive match when searching for delim.
   * <p>
   * @group string_funcs
   * @param str (undocumented)
   * @param delim (undocumented)
   * @param count (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column substring_index (org.apache.spark.sql.Column str, java.lang.String delim, int count)  { throw new RuntimeException(); }
  /**
   * Overlay the specified portion of <code>src</code> with <code>replace</code>,
   *  starting from byte position <code>pos</code> of <code>src</code> and proceeding for <code>len</code> bytes.
   * <p>
   * @group string_funcs
   * @since 3.0.0
   * @param src (undocumented)
   * @param replace (undocumented)
   * @param pos (undocumented)
   * @param len (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column overlay (org.apache.spark.sql.Column src, org.apache.spark.sql.Column replace, org.apache.spark.sql.Column pos, org.apache.spark.sql.Column len)  { throw new RuntimeException(); }
  /**
   * Overlay the specified portion of <code>src</code> with <code>replace</code>,
   *  starting from byte position <code>pos</code> of <code>src</code>.
   * <p>
   * @group string_funcs
   * @since 3.0.0
   * @param src (undocumented)
   * @param replace (undocumented)
   * @param pos (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column overlay (org.apache.spark.sql.Column src, org.apache.spark.sql.Column replace, org.apache.spark.sql.Column pos)  { throw new RuntimeException(); }
  /**
   * Translate any character in the src by a character in replaceString.
   * The characters in replaceString correspond to the characters in matchingString.
   * The translate will happen when any character in the string matches the character
   * in the <code>matchingString</code>.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param src (undocumented)
   * @param matchingString (undocumented)
   * @param replaceString (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column translate (org.apache.spark.sql.Column src, java.lang.String matchingString, java.lang.String replaceString)  { throw new RuntimeException(); }
  /**
   * Trim the spaces from both ends for the specified string column.
   * <p>
   * @group string_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column trim (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Trim the specified character from both ends for the specified string column.
   * @group string_funcs
   * @since 2.3.0
   * @param e (undocumented)
   * @param trimString (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column trim (org.apache.spark.sql.Column e, java.lang.String trimString)  { throw new RuntimeException(); }
  /**
   * Converts a string column to upper case.
   * <p>
   * @group string_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column upper (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Creates a datetime interval
   * <p>
   * @param years Number of years
   * @param months Number of months
   * @param weeks Number of weeks
   * @param days Number of days
   * @param hours Number of hours
   * @param mins Number of mins
   * @param secs Number of secs
   * @return A datetime interval
   * @group datetime_funcs
   * @since 3.2.0
   */
  static public  org.apache.spark.sql.Column make_interval (org.apache.spark.sql.Column years, org.apache.spark.sql.Column months, org.apache.spark.sql.Column weeks, org.apache.spark.sql.Column days, org.apache.spark.sql.Column hours, org.apache.spark.sql.Column mins, org.apache.spark.sql.Column secs)  { throw new RuntimeException(); }
  /**
   * Returns the date that is <code>numMonths</code> after <code>startDate</code>.
   * <p>
   * @param startDate A date, timestamp or string. If a string, the data must be in a format that
   *                  can be cast to a date, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param numMonths The number of months to add to <code>startDate</code>, can be negative to subtract months
   * @return A date, or null if <code>startDate</code> was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column add_months (org.apache.spark.sql.Column startDate, int numMonths)  { throw new RuntimeException(); }
  /**
   * Returns the date that is <code>numMonths</code> after <code>startDate</code>.
   * <p>
   * @param startDate A date, timestamp or string. If a string, the data must be in a format that
   *                  can be cast to a date, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param numMonths A column of the number of months to add to <code>startDate</code>, can be negative to
   *                  subtract months
   * @return A date, or null if <code>startDate</code> was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 3.0.0
   */
  static public  org.apache.spark.sql.Column add_months (org.apache.spark.sql.Column startDate, org.apache.spark.sql.Column numMonths)  { throw new RuntimeException(); }
  /**
   * Returns the current date at the start of query evaluation as a date column.
   * All calls of current_date within the same query return the same value.
   * <p>
   * @group datetime_funcs
   * @since 1.5.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column current_date ()  { throw new RuntimeException(); }
  /**
   * Returns the current timestamp at the start of query evaluation as a timestamp column.
   * All calls of current_timestamp within the same query return the same value.
   * <p>
   * @group datetime_funcs
   * @since 1.5.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column current_timestamp ()  { throw new RuntimeException(); }
  /**
   * Converts a date/timestamp/string to a value of string in the format specified by the date
   * format given by the second argument.
   * <p>
   * See <a href="https://spark.apache.org/docs/latest/sql-ref-datetime-pattern.html">
   *   Datetime Patterns</a>
   * for valid date and time format patterns
   * <p>
   * @param dateExpr A date, timestamp or string. If a string, the data must be in a format that
   *                 can be cast to a timestamp, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param format A pattern <code>dd.MM.yyyy</code> would return a string like <code>18.03.1993</code>
   * @return A string, or null if <code>dateExpr</code> was a string that could not be cast to a timestamp
   * @note Use specialized functions like {@link year} whenever possible as they benefit from a
   * specialized implementation.
   * @throws IllegalArgumentException if the <code>format</code> pattern is invalid
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column date_format (org.apache.spark.sql.Column dateExpr, java.lang.String format)  { throw new RuntimeException(); }
  /**
   * Returns the date that is <code>days</code> days after <code>start</code>
   * <p>
   * @param start A date, timestamp or string. If a string, the data must be in a format that
   *              can be cast to a date, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param days  The number of days to add to <code>start</code>, can be negative to subtract days
   * @return A date, or null if <code>start</code> was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column date_add (org.apache.spark.sql.Column start, int days)  { throw new RuntimeException(); }
  /**
   * Returns the date that is <code>days</code> days after <code>start</code>
   * <p>
   * @param start A date, timestamp or string. If a string, the data must be in a format that
   *              can be cast to a date, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param days  A column of the number of days to add to <code>start</code>, can be negative to subtract days
   * @return A date, or null if <code>start</code> was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 3.0.0
   */
  static public  org.apache.spark.sql.Column date_add (org.apache.spark.sql.Column start, org.apache.spark.sql.Column days)  { throw new RuntimeException(); }
  /**
   * Returns the date that is <code>days</code> days before <code>start</code>
   * <p>
   * @param start A date, timestamp or string. If a string, the data must be in a format that
   *              can be cast to a date, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param days  The number of days to subtract from <code>start</code>, can be negative to add days
   * @return A date, or null if <code>start</code> was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column date_sub (org.apache.spark.sql.Column start, int days)  { throw new RuntimeException(); }
  /**
   * Returns the date that is <code>days</code> days before <code>start</code>
   * <p>
   * @param start A date, timestamp or string. If a string, the data must be in a format that
   *              can be cast to a date, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param days  A column of the number of days to subtract from <code>start</code>, can be negative to add
   *              days
   * @return A date, or null if <code>start</code> was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 3.0.0
   */
  static public  org.apache.spark.sql.Column date_sub (org.apache.spark.sql.Column start, org.apache.spark.sql.Column days)  { throw new RuntimeException(); }
  /**
   * Returns the number of days from <code>start</code> to <code>end</code>.
   * <p>
   * Only considers the date part of the input. For example:
   * <pre><code>
   * dateddiff("2018-01-10 00:00:00", "2018-01-09 23:59:59")
   * // returns 1
   * </code></pre>
   * <p>
   * @param end A date, timestamp or string. If a string, the data must be in a format that
   *            can be cast to a date, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param start A date, timestamp or string. If a string, the data must be in a format that
   *              can be cast to a date, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @return An integer, or null if either <code>end</code> or <code>start</code> were strings that could not be cast to
   *         a date. Negative if <code>end</code> is before <code>start</code>
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column datediff (org.apache.spark.sql.Column end, org.apache.spark.sql.Column start)  { throw new RuntimeException(); }
  /**
   * Extracts the year as an integer from a given date/timestamp/string.
   * @return An integer, or null if the input was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 1.5.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column year (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Extracts the quarter as an integer from a given date/timestamp/string.
   * @return An integer, or null if the input was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 1.5.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column quarter (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Extracts the month as an integer from a given date/timestamp/string.
   * @return An integer, or null if the input was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 1.5.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column month (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Extracts the day of the week as an integer from a given date/timestamp/string.
   * Ranges from 1 for a Sunday through to 7 for a Saturday
   * @return An integer, or null if the input was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 2.3.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column dayofweek (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Extracts the day of the month as an integer from a given date/timestamp/string.
   * @return An integer, or null if the input was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 1.5.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column dayofmonth (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Extracts the day of the year as an integer from a given date/timestamp/string.
   * @return An integer, or null if the input was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 1.5.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column dayofyear (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Extracts the hours as an integer from a given date/timestamp/string.
   * @return An integer, or null if the input was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 1.5.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column hour (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Returns the last day of the month which the given date belongs to.
   * For example, input "2015-07-27" returns "2015-07-31" since July 31 is the last day of the
   * month in July 2015.
   * <p>
   * @param e A date, timestamp or string. If a string, the data must be in a format that can be
   *          cast to a date, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @return A date, or null if the input was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column last_day (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Extracts the minutes as an integer from a given date/timestamp/string.
   * @return An integer, or null if the input was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 1.5.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column minute (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Returns number of months between dates <code>start</code> and <code>end</code>.
   * <p>
   * A whole number is returned if both inputs have the same day of month or both are the last day
   * of their respective months. Otherwise, the difference is calculated assuming 31 days per month.
   * <p>
   * For example:
   * <pre><code>
   * months_between("2017-11-14", "2017-07-14")  // returns 4.0
   * months_between("2017-01-01", "2017-01-10")  // returns 0.29032258
   * months_between("2017-06-01", "2017-06-16 12:00:00")  // returns -0.5
   * </code></pre>
   * <p>
   * @param end   A date, timestamp or string. If a string, the data must be in a format that can
   *              be cast to a timestamp, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param start A date, timestamp or string. If a string, the data must be in a format that can
   *              cast to a timestamp, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @return A double, or null if either <code>end</code> or <code>start</code> were strings that could not be cast to a
   *         timestamp. Negative if <code>end</code> is before <code>start</code>
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column months_between (org.apache.spark.sql.Column end, org.apache.spark.sql.Column start)  { throw new RuntimeException(); }
  /**
   * Returns number of months between dates <code>end</code> and <code>start</code>. If <code>roundOff</code> is set to true, the
   * result is rounded off to 8 digits; it is not rounded otherwise.
   * @group datetime_funcs
   * @since 2.4.0
   * @param end (undocumented)
   * @param start (undocumented)
   * @param roundOff (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column months_between (org.apache.spark.sql.Column end, org.apache.spark.sql.Column start, boolean roundOff)  { throw new RuntimeException(); }
  /**
   * Returns the first date which is later than the value of the <code>date</code> column that is on the
   * specified day of the week.
   * <p>
   * For example, <code>next_day('2015-07-27', "Sunday")</code> returns 2015-08-02 because that is the first
   * Sunday after 2015-07-27.
   * <p>
   * @param date      A date, timestamp or string. If a string, the data must be in a format that
   *                  can be cast to a date, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param dayOfWeek Case insensitive, and accepts: "Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun"
   * @return A date, or null if <code>date</code> was a string that could not be cast to a date or if
   *         <code>dayOfWeek</code> was an invalid value
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column next_day (org.apache.spark.sql.Column date, java.lang.String dayOfWeek)  { throw new RuntimeException(); }
  /**
   * Returns the first date which is later than the value of the <code>date</code> column that is on the
   * specified day of the week.
   * <p>
   * For example, <code>next_day('2015-07-27', "Sunday")</code> returns 2015-08-02 because that is the first
   * Sunday after 2015-07-27.
   * <p>
   * @param date      A date, timestamp or string. If a string, the data must be in a format that
   *                  can be cast to a date, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param dayOfWeek A column of the day of week. Case insensitive, and accepts: "Mon", "Tue",
   *                  "Wed", "Thu", "Fri", "Sat", "Sun"
   * @return A date, or null if <code>date</code> was a string that could not be cast to a date or if
   *         <code>dayOfWeek</code> was an invalid value
   * @group datetime_funcs
   * @since 3.2.0
   */
  static public  org.apache.spark.sql.Column next_day (org.apache.spark.sql.Column date, org.apache.spark.sql.Column dayOfWeek)  { throw new RuntimeException(); }
  /**
   * Extracts the seconds as an integer from a given date/timestamp/string.
   * @return An integer, or null if the input was a string that could not be cast to a timestamp
   * @group datetime_funcs
   * @since 1.5.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column second (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Extracts the week number as an integer from a given date/timestamp/string.
   * <p>
   * A week is considered to start on a Monday and week 1 is the first week with more than 3 days,
   * as defined by ISO 8601
   * <p>
   * @return An integer, or null if the input was a string that could not be cast to a date
   * @group datetime_funcs
   * @since 1.5.0
   * @param e (undocumented)
   */
  static public  org.apache.spark.sql.Column weekofyear (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Converts the number of seconds from unix epoch (1970-01-01 00:00:00 UTC) to a string
   * representing the timestamp of that moment in the current system time zone in the
   * yyyy-MM-dd HH:mm:ss format.
   * <p>
   * @param ut A number of a type that is castable to a long, such as string or integer. Can be
   *           negative for timestamps before the unix epoch
   * @return A string, or null if the input was a string that could not be cast to a long
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column from_unixtime (org.apache.spark.sql.Column ut)  { throw new RuntimeException(); }
  /**
   * Converts the number of seconds from unix epoch (1970-01-01 00:00:00 UTC) to a string
   * representing the timestamp of that moment in the current system time zone in the given
   * format.
   * <p>
   * See <a href="https://spark.apache.org/docs/latest/sql-ref-datetime-pattern.html">
   *   Datetime Patterns</a>
   * for valid date and time format patterns
   * <p>
   * @param ut A number of a type that is castable to a long, such as string or integer. Can be
   *           negative for timestamps before the unix epoch
   * @param f  A date time pattern that the input will be formatted to
   * @return A string, or null if <code>ut</code> was a string that could not be cast to a long or <code>f</code> was
   *         an invalid date time pattern
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column from_unixtime (org.apache.spark.sql.Column ut, java.lang.String f)  { throw new RuntimeException(); }
  /**
   * Returns the current Unix timestamp (in seconds) as a long.
   * <p>
   * @note All calls of <code>unix_timestamp</code> within the same query return the same value
   * (i.e. the current timestamp is calculated at the start of query evaluation).
   * <p>
   * @group datetime_funcs
   * @since 1.5.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column unix_timestamp ()  { throw new RuntimeException(); }
  /**
   * Converts time string in format yyyy-MM-dd HH:mm:ss to Unix timestamp (in seconds),
   * using the default timezone and the default locale.
   * <p>
   * @param s A date, timestamp or string. If a string, the data must be in the
   *          <code>yyyy-MM-dd HH:mm:ss</code> format
   * @return A long, or null if the input was a string not of the correct format
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column unix_timestamp (org.apache.spark.sql.Column s)  { throw new RuntimeException(); }
  /**
   * Converts time string with given pattern to Unix timestamp (in seconds).
   * <p>
   * See <a href="https://spark.apache.org/docs/latest/sql-ref-datetime-pattern.html">
   *   Datetime Patterns</a>
   * for valid date and time format patterns
   * <p>
   * @param s A date, timestamp or string. If a string, the data must be in a format that can be
   *          cast to a date, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param p A date time pattern detailing the format of <code>s</code> when <code>s</code> is a string
   * @return A long, or null if <code>s</code> was a string that could not be cast to a date or <code>p</code> was
   *         an invalid format
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column unix_timestamp (org.apache.spark.sql.Column s, java.lang.String p)  { throw new RuntimeException(); }
  /**
   * Converts to a timestamp by casting rules to <code>TimestampType</code>.
   * <p>
   * @param s A date, timestamp or string. If a string, the data must be in a format that can be
   *          cast to a timestamp, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @return A timestamp, or null if the input was a string that could not be cast to a timestamp
   * @group datetime_funcs
   * @since 2.2.0
   */
  static public  org.apache.spark.sql.Column to_timestamp (org.apache.spark.sql.Column s)  { throw new RuntimeException(); }
  /**
   * Converts time string with the given pattern to timestamp.
   * <p>
   * See <a href="https://spark.apache.org/docs/latest/sql-ref-datetime-pattern.html">
   *   Datetime Patterns</a>
   * for valid date and time format patterns
   * <p>
   * @param s   A date, timestamp or string. If a string, the data must be in a format that can be
   *            cast to a timestamp, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param fmt A date time pattern detailing the format of <code>s</code> when <code>s</code> is a string
   * @return A timestamp, or null if <code>s</code> was a string that could not be cast to a timestamp or
   *         <code>fmt</code> was an invalid format
   * @group datetime_funcs
   * @since 2.2.0
   */
  static public  org.apache.spark.sql.Column to_timestamp (org.apache.spark.sql.Column s, java.lang.String fmt)  { throw new RuntimeException(); }
  /**
   * Converts the column into <code>DateType</code> by casting rules to <code>DateType</code>.
   * <p>
   * @group datetime_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column to_date (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Converts the column into a <code>DateType</code> with a specified format
   * <p>
   * See <a href="https://spark.apache.org/docs/latest/sql-ref-datetime-pattern.html">
   *   Datetime Patterns</a>
   * for valid date and time format patterns
   * <p>
   * @param e   A date, timestamp or string. If a string, the data must be in a format that can be
   *            cast to a date, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param fmt A date time pattern detailing the format of <code>e</code> when <code>e</code>is a string
   * @return A date, or null if <code>e</code> was a string that could not be cast to a date or <code>fmt</code> was an
   *         invalid format
   * @group datetime_funcs
   * @since 2.2.0
   */
  static public  org.apache.spark.sql.Column to_date (org.apache.spark.sql.Column e, java.lang.String fmt)  { throw new RuntimeException(); }
  /**
   * Returns date truncated to the unit specified by the format.
   * <p>
   * For example, <code>trunc("2018-11-19 12:01:19", "year")</code> returns 2018-01-01
   * <p>
   * @param date A date, timestamp or string. If a string, the data must be in a format that can be
   *             cast to a date, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param format: 'year', 'yyyy', 'yy' to truncate by year,
   *               or 'month', 'mon', 'mm' to truncate by month
   *               Other options are: 'week', 'quarter'
   * <p>
   * @return A date, or null if <code>date</code> was a string that could not be cast to a date or <code>format</code>
   *         was an invalid value
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column trunc (org.apache.spark.sql.Column date, java.lang.String format)  { throw new RuntimeException(); }
  /**
   * Returns timestamp truncated to the unit specified by the format.
   * <p>
   * For example, <code>date_trunc("year", "2018-11-19 12:01:19")</code> returns 2018-01-01 00:00:00
   * <p>
   * @param format: 'year', 'yyyy', 'yy' to truncate by year,
   *                'month', 'mon', 'mm' to truncate by month,
   *                'day', 'dd' to truncate by day,
   *                Other options are:
   *                'microsecond', 'millisecond', 'second', 'minute', 'hour', 'week', 'quarter'
   * @param timestamp A date, timestamp or string. If a string, the data must be in a format that
   *                  can be cast to a timestamp, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @return A timestamp, or null if <code>timestamp</code> was a string that could not be cast to a timestamp
   *         or <code>format</code> was an invalid value
   * @group datetime_funcs
   * @since 2.3.0
   */
  static public  org.apache.spark.sql.Column date_trunc (java.lang.String format, org.apache.spark.sql.Column timestamp)  { throw new RuntimeException(); }
  /**
   * Given a timestamp like '2017-07-14 02:40:00.0', interprets it as a time in UTC, and renders
   * that time as a timestamp in the given time zone. For example, 'GMT+1' would yield
   * '2017-07-14 03:40:00.0'.
   * <p>
   * @param ts A date, timestamp or string. If a string, the data must be in a format that can be
   *           cast to a timestamp, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param tz A string detailing the time zone ID that the input should be adjusted to. It should
   *           be in the format of either region-based zone IDs or zone offsets. Region IDs must
   *           have the form 'area/city', such as 'America/Los_Angeles'. Zone offsets must be in
   *           the format '(+|-)HH:mm', for example '-08:00' or '+01:00'. Also 'UTC' and 'Z' are
   *           supported as aliases of '+00:00'. Other short names are not recommended to use
   *           because they can be ambiguous.
   * @return A timestamp, or null if <code>ts</code> was a string that could not be cast to a timestamp or
   *         <code>tz</code> was an invalid value
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column from_utc_timestamp (org.apache.spark.sql.Column ts, java.lang.String tz)  { throw new RuntimeException(); }
  /**
   * Given a timestamp like '2017-07-14 02:40:00.0', interprets it as a time in UTC, and renders
   * that time as a timestamp in the given time zone. For example, 'GMT+1' would yield
   * '2017-07-14 03:40:00.0'.
   * @group datetime_funcs
   * @since 2.4.0
   * @param ts (undocumented)
   * @param tz (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column from_utc_timestamp (org.apache.spark.sql.Column ts, org.apache.spark.sql.Column tz)  { throw new RuntimeException(); }
  /**
   * Given a timestamp like '2017-07-14 02:40:00.0', interprets it as a time in the given time
   * zone, and renders that time as a timestamp in UTC. For example, 'GMT+1' would yield
   * '2017-07-14 01:40:00.0'.
   * <p>
   * @param ts A date, timestamp or string. If a string, the data must be in a format that can be
   *           cast to a timestamp, such as <code>yyyy-MM-dd</code> or <code>yyyy-MM-dd HH:mm:ss.SSSS</code>
   * @param tz A string detailing the time zone ID that the input should be adjusted to. It should
   *           be in the format of either region-based zone IDs or zone offsets. Region IDs must
   *           have the form 'area/city', such as 'America/Los_Angeles'. Zone offsets must be in
   *           the format '(+|-)HH:mm', for example '-08:00' or '+01:00'. Also 'UTC' and 'Z' are
   *           supported as aliases of '+00:00'. Other short names are not recommended to use
   *           because they can be ambiguous.
   * @return A timestamp, or null if <code>ts</code> was a string that could not be cast to a timestamp or
   *         <code>tz</code> was an invalid value
   * @group datetime_funcs
   * @since 1.5.0
   */
  static public  org.apache.spark.sql.Column to_utc_timestamp (org.apache.spark.sql.Column ts, java.lang.String tz)  { throw new RuntimeException(); }
  /**
   * Given a timestamp like '2017-07-14 02:40:00.0', interprets it as a time in the given time
   * zone, and renders that time as a timestamp in UTC. For example, 'GMT+1' would yield
   * '2017-07-14 01:40:00.0'.
   * @group datetime_funcs
   * @since 2.4.0
   * @param ts (undocumented)
   * @param tz (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column to_utc_timestamp (org.apache.spark.sql.Column ts, org.apache.spark.sql.Column tz)  { throw new RuntimeException(); }
  /**
   * Bucketize rows into one or more time windows given a timestamp specifying column. Window
   * starts are inclusive but the window ends are exclusive, e.g. 12:05 will be in the window
   * [12:05,12:10) but not in [12:00,12:05). Windows can support microsecond precision. Windows in
   * the order of months are not supported. The following example takes the average stock price for
   * a one minute window every 10 seconds starting 5 seconds after the hour:
   * <p>
   * <pre><code>
   *   val df = ... // schema =&gt; timestamp: TimestampType, stockId: StringType, price: DoubleType
   *   df.groupBy(window($"timestamp", "1 minute", "10 seconds", "5 seconds"), $"stockId")
   *     .agg(mean("price"))
   * </code></pre>
   * <p>
   * The windows will look like:
   * <p>
   * <pre><code>
   *   09:00:05-09:01:05
   *   09:00:15-09:01:15
   *   09:00:25-09:01:25 ...
   * </code></pre>
   * <p>
   * For a streaming query, you may use the function <code>current_timestamp</code> to generate windows on
   * processing time.
   * <p>
   * @param timeColumn The column or the expression to use as the timestamp for windowing by time.
   *                   The time column must be of TimestampType.
   * @param windowDuration A string specifying the width of the window, e.g. <code>10 minutes</code>,
   *                       <code>1 second</code>. Check <code>org.apache.spark.unsafe.types.CalendarInterval</code> for
   *                       valid duration identifiers. Note that the duration is a fixed length of
   *                       time, and does not vary over time according to a calendar. For example,
   *                       <code>1 day</code> always means 86,400,000 milliseconds, not a calendar day.
   * @param slideDuration A string specifying the sliding interval of the window, e.g. <code>1 minute</code>.
   *                      A new window will be generated every <code>slideDuration</code>. Must be less than
   *                      or equal to the <code>windowDuration</code>. Check
   *                      <code>org.apache.spark.unsafe.types.CalendarInterval</code> for valid duration
   *                      identifiers. This duration is likewise absolute, and does not vary
   *                      according to a calendar.
   * @param startTime The offset with respect to 1970-01-01 00:00:00 UTC with which to start
   *                  window intervals. For example, in order to have hourly tumbling windows that
   *                  start 15 minutes past the hour, e.g. 12:15-13:15, 13:15-14:15... provide
   *                  <code>startTime</code> as <code>15 minutes</code>.
   * <p>
   * @group datetime_funcs
   * @since 2.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column window (org.apache.spark.sql.Column timeColumn, java.lang.String windowDuration, java.lang.String slideDuration, java.lang.String startTime)  { throw new RuntimeException(); }
  /**
   * Bucketize rows into one or more time windows given a timestamp specifying column. Window
   * starts are inclusive but the window ends are exclusive, e.g. 12:05 will be in the window
   * [12:05,12:10) but not in [12:00,12:05). Windows can support microsecond precision. Windows in
   * the order of months are not supported. The windows start beginning at 1970-01-01 00:00:00 UTC.
   * The following example takes the average stock price for a one minute window every 10 seconds:
   * <p>
   * <pre><code>
   *   val df = ... // schema =&gt; timestamp: TimestampType, stockId: StringType, price: DoubleType
   *   df.groupBy(window($"timestamp", "1 minute", "10 seconds"), $"stockId")
   *     .agg(mean("price"))
   * </code></pre>
   * <p>
   * The windows will look like:
   * <p>
   * <pre><code>
   *   09:00:00-09:01:00
   *   09:00:10-09:01:10
   *   09:00:20-09:01:20 ...
   * </code></pre>
   * <p>
   * For a streaming query, you may use the function <code>current_timestamp</code> to generate windows on
   * processing time.
   * <p>
   * @param timeColumn The column or the expression to use as the timestamp for windowing by time.
   *                   The time column must be of TimestampType.
   * @param windowDuration A string specifying the width of the window, e.g. <code>10 minutes</code>,
   *                       <code>1 second</code>. Check <code>org.apache.spark.unsafe.types.CalendarInterval</code> for
   *                       valid duration identifiers. Note that the duration is a fixed length of
   *                       time, and does not vary over time according to a calendar. For example,
   *                       <code>1 day</code> always means 86,400,000 milliseconds, not a calendar day.
   * @param slideDuration A string specifying the sliding interval of the window, e.g. <code>1 minute</code>.
   *                      A new window will be generated every <code>slideDuration</code>. Must be less than
   *                      or equal to the <code>windowDuration</code>. Check
   *                      <code>org.apache.spark.unsafe.types.CalendarInterval</code> for valid duration
   *                      identifiers. This duration is likewise absolute, and does not vary
   *                      according to a calendar.
   * <p>
   * @group datetime_funcs
   * @since 2.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column window (org.apache.spark.sql.Column timeColumn, java.lang.String windowDuration, java.lang.String slideDuration)  { throw new RuntimeException(); }
  /**
   * Generates tumbling time windows given a timestamp specifying column. Window
   * starts are inclusive but the window ends are exclusive, e.g. 12:05 will be in the window
   * [12:05,12:10) but not in [12:00,12:05). Windows can support microsecond precision. Windows in
   * the order of months are not supported. The windows start beginning at 1970-01-01 00:00:00 UTC.
   * The following example takes the average stock price for a one minute tumbling window:
   * <p>
   * <pre><code>
   *   val df = ... // schema =&gt; timestamp: TimestampType, stockId: StringType, price: DoubleType
   *   df.groupBy(window($"timestamp", "1 minute"), $"stockId")
   *     .agg(mean("price"))
   * </code></pre>
   * <p>
   * The windows will look like:
   * <p>
   * <pre><code>
   *   09:00:00-09:01:00
   *   09:01:00-09:02:00
   *   09:02:00-09:03:00 ...
   * </code></pre>
   * <p>
   * For a streaming query, you may use the function <code>current_timestamp</code> to generate windows on
   * processing time.
   * <p>
   * @param timeColumn The column or the expression to use as the timestamp for windowing by time.
   *                   The time column must be of TimestampType.
   * @param windowDuration A string specifying the width of the window, e.g. <code>10 minutes</code>,
   *                       <code>1 second</code>. Check <code>org.apache.spark.unsafe.types.CalendarInterval</code> for
   *                       valid duration identifiers.
   * <p>
   * @group datetime_funcs
   * @since 2.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column window (org.apache.spark.sql.Column timeColumn, java.lang.String windowDuration)  { throw new RuntimeException(); }
  /**
   * Creates timestamp from the number of seconds since UTC epoch.
   * @group datetime_funcs
   * @since 3.1.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column timestamp_seconds (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Returns null if the array is null, true if the array contains <code>value</code>, and false otherwise.
   * @group collection_funcs
   * @since 1.5.0
   * @param column (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array_contains (org.apache.spark.sql.Column column, Object value)  { throw new RuntimeException(); }
  /**
   * Returns <code>true</code> if <code>a1</code> and <code>a2</code> have at least one non-null element in common. If not and both
   * the arrays are non-empty and any of them contains a <code>null</code>, it returns <code>null</code>. It returns
   * <code>false</code> otherwise.
   * @group collection_funcs
   * @since 2.4.0
   * @param a1 (undocumented)
   * @param a2 (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column arrays_overlap (org.apache.spark.sql.Column a1, org.apache.spark.sql.Column a2)  { throw new RuntimeException(); }
  /**
   * Returns an array containing all the elements in <code>x</code> from index <code>start</code> (or starting from the
   * end if <code>start</code> is negative) with the specified <code>length</code>.
   * <p>
   * @param x the array column to be sliced
   * @param start the starting index
   * @param length the length of the slice
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column slice (org.apache.spark.sql.Column x, int start, int length)  { throw new RuntimeException(); }
  /**
   * Returns an array containing all the elements in <code>x</code> from index <code>start</code> (or starting from the
   * end if <code>start</code> is negative) with the specified <code>length</code>.
   * <p>
   * @param x the array column to be sliced
   * @param start the starting index
   * @param length the length of the slice
   * <p>
   * @group collection_funcs
   * @since 3.1.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column slice (org.apache.spark.sql.Column x, org.apache.spark.sql.Column start, org.apache.spark.sql.Column length)  { throw new RuntimeException(); }
  /**
   * Concatenates the elements of <code>column</code> using the <code>delimiter</code>. Null values are replaced with
   * <code>nullReplacement</code>.
   * @group collection_funcs
   * @since 2.4.0
   * @param column (undocumented)
   * @param delimiter (undocumented)
   * @param nullReplacement (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array_join (org.apache.spark.sql.Column column, java.lang.String delimiter, java.lang.String nullReplacement)  { throw new RuntimeException(); }
  /**
   * Concatenates the elements of <code>column</code> using the <code>delimiter</code>.
   * @group collection_funcs
   * @since 2.4.0
   * @param column (undocumented)
   * @param delimiter (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array_join (org.apache.spark.sql.Column column, java.lang.String delimiter)  { throw new RuntimeException(); }
  /**
   * Concatenates multiple input columns together into a single column.
   * The function works with strings, binary and compatible array columns.
   * <p>
   * @group collection_funcs
   * @since 1.5.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column concat (scala.collection.Seq<org.apache.spark.sql.Column> exprs)  { throw new RuntimeException(); }
  /**
   * Locates the position of the first occurrence of the value in the given array as long.
   * Returns null if either of the arguments are null.
   * <p>
   * @note The position is not zero based, but 1 based index. Returns 0 if value
   * could not be found in array.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @param column (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array_position (org.apache.spark.sql.Column column, Object value)  { throw new RuntimeException(); }
  /**
   * Returns element of array at given index in value if column is array. Returns value for
   * the given key in value if column is map.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @param column (undocumented)
   * @param value (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column element_at (org.apache.spark.sql.Column column, Object value)  { throw new RuntimeException(); }
  /**
   * Sorts the input array in ascending order. The elements of the input array must be orderable.
   * Null elements will be placed at the end of the returned array.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array_sort (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Remove all elements that equal to element from the given array.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @param column (undocumented)
   * @param element (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array_remove (org.apache.spark.sql.Column column, Object element)  { throw new RuntimeException(); }
  /**
   * Removes duplicate values from the array.
   * @group collection_funcs
   * @since 2.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array_distinct (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Returns an array of the elements in the intersection of the given two arrays,
   * without duplicates.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @param col1 (undocumented)
   * @param col2 (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array_intersect (org.apache.spark.sql.Column col1, org.apache.spark.sql.Column col2)  { throw new RuntimeException(); }
  /**
   * Returns an array of the elements in the union of the given two arrays, without duplicates.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @param col1 (undocumented)
   * @param col2 (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array_union (org.apache.spark.sql.Column col1, org.apache.spark.sql.Column col2)  { throw new RuntimeException(); }
  /**
   * Returns an array of the elements in the first array but not in the second array,
   * without duplicates. The order of elements in the result is not determined
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @param col1 (undocumented)
   * @param col2 (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array_except (org.apache.spark.sql.Column col1, org.apache.spark.sql.Column col2)  { throw new RuntimeException(); }
  /**
   * Returns an array of elements after applying a transformation to each element
   * in the input array.
   * <pre><code>
   *   df.select(transform(col("i"), x =&gt; x + 1))
   * </code></pre>
   * <p>
   * @param column the input array column
   * @param f col =&gt; transformed_col, the lambda function to transform the input column
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column transform (org.apache.spark.sql.Column column, scala.Function1<org.apache.spark.sql.Column, org.apache.spark.sql.Column> f)  { throw new RuntimeException(); }
  /**
   * Returns an array of elements after applying a transformation to each element
   * in the input array.
   * <pre><code>
   *   df.select(transform(col("i"), (x, i) =&gt; x + i))
   * </code></pre>
   * <p>
   * @param column the input array column
   * @param f (col, index) =&gt; transformed_col, the lambda function to filter the input column
   *           given the index. Indices start at 0.
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column transform (org.apache.spark.sql.Column column, scala.Function2<org.apache.spark.sql.Column, org.apache.spark.sql.Column, org.apache.spark.sql.Column> f)  { throw new RuntimeException(); }
  /**
   * Returns whether a predicate holds for one or more elements in the array.
   * <pre><code>
   *   df.select(exists(col("i"), _ % 2 === 0))
   * </code></pre>
   * <p>
   * @param column the input array column
   * @param f col =&gt; predicate, the Boolean predicate to check the input column
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column exists (org.apache.spark.sql.Column column, scala.Function1<org.apache.spark.sql.Column, org.apache.spark.sql.Column> f)  { throw new RuntimeException(); }
  /**
   * Returns whether a predicate holds for every element in the array.
   * <pre><code>
   *   df.select(forall(col("i"), x =&gt; x % 2 === 0))
   * </code></pre>
   * <p>
   * @param column the input array column
   * @param f col =&gt; predicate, the Boolean predicate to check the input column
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column forall (org.apache.spark.sql.Column column, scala.Function1<org.apache.spark.sql.Column, org.apache.spark.sql.Column> f)  { throw new RuntimeException(); }
  /**
   * Returns an array of elements for which a predicate holds in a given array.
   * <pre><code>
   *   df.select(filter(col("s"), x =&gt; x % 2 === 0))
   * </code></pre>
   * <p>
   * @param column the input array column
   * @param f col =&gt; predicate, the Boolean predicate to filter the input column
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column filter (org.apache.spark.sql.Column column, scala.Function1<org.apache.spark.sql.Column, org.apache.spark.sql.Column> f)  { throw new RuntimeException(); }
  /**
   * Returns an array of elements for which a predicate holds in a given array.
   * <pre><code>
   *   df.select(filter(col("s"), (x, i) =&gt; i % 2 === 0))
   * </code></pre>
   * <p>
   * @param column the input array column
   * @param f (col, index) =&gt; predicate, the Boolean predicate to filter the input column
   *           given the index. Indices start at 0.
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column filter (org.apache.spark.sql.Column column, scala.Function2<org.apache.spark.sql.Column, org.apache.spark.sql.Column, org.apache.spark.sql.Column> f)  { throw new RuntimeException(); }
  /**
   * Applies a binary operator to an initial state and all elements in the array,
   * and reduces this to a single state. The final state is converted into the final result
   * by applying a finish function.
   * <pre><code>
   *   df.select(aggregate(col("i"), lit(0), (acc, x) =&gt; acc + x, _ * 10))
   * </code></pre>
   * <p>
   * @param expr the input array column
   * @param initialValue the initial value
   * @param merge (combined_value, input_value) =&gt; combined_value, the merge function to merge
   *              an input value to the combined_value
   * @param finish combined_value =&gt; final_value, the lambda function to convert the combined value
   *               of all inputs to final result
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column aggregate (org.apache.spark.sql.Column expr, org.apache.spark.sql.Column initialValue, scala.Function2<org.apache.spark.sql.Column, org.apache.spark.sql.Column, org.apache.spark.sql.Column> merge, scala.Function1<org.apache.spark.sql.Column, org.apache.spark.sql.Column> finish)  { throw new RuntimeException(); }
  /**
   * Applies a binary operator to an initial state and all elements in the array,
   * and reduces this to a single state.
   * <pre><code>
   *   df.select(aggregate(col("i"), lit(0), (acc, x) =&gt; acc + x))
   * </code></pre>
   * <p>
   * @param expr the input array column
   * @param initialValue the initial value
   * @param merge (combined_value, input_value) =&gt; combined_value, the merge function to merge
   *              an input value to the combined_value
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column aggregate (org.apache.spark.sql.Column expr, org.apache.spark.sql.Column initialValue, scala.Function2<org.apache.spark.sql.Column, org.apache.spark.sql.Column, org.apache.spark.sql.Column> merge)  { throw new RuntimeException(); }
  /**
   * Merge two given arrays, element-wise, into a single array using a function.
   * If one array is shorter, nulls are appended at the end to match the length of the longer
   * array, before applying the function.
   * <pre><code>
   *   df.select(zip_with(df1("val1"), df1("val2"), (x, y) =&gt; x + y))
   * </code></pre>
   * <p>
   * @param left the left input array column
   * @param right the right input array column
   * @param f (lCol, rCol) =&gt; col, the lambda function to merge two input columns into one column
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column zip_with (org.apache.spark.sql.Column left, org.apache.spark.sql.Column right, scala.Function2<org.apache.spark.sql.Column, org.apache.spark.sql.Column, org.apache.spark.sql.Column> f)  { throw new RuntimeException(); }
  /**
   * Applies a function to every key-value pair in a map and returns
   * a map with the results of those applications as the new keys for the pairs.
   * <pre><code>
   *   df.select(transform_keys(col("i"), (k, v) =&gt; k + v))
   * </code></pre>
   * <p>
   * @param expr the input map column
   * @param f (key, value) =&gt; new_key, the lambda function to transform the key of input map column
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column transform_keys (org.apache.spark.sql.Column expr, scala.Function2<org.apache.spark.sql.Column, org.apache.spark.sql.Column, org.apache.spark.sql.Column> f)  { throw new RuntimeException(); }
  /**
   * Applies a function to every key-value pair in a map and returns
   * a map with the results of those applications as the new values for the pairs.
   * <pre><code>
   *   df.select(transform_values(col("i"), (k, v) =&gt; k + v))
   * </code></pre>
   * <p>
   * @param expr the input map column
   * @param f (key, value) =&gt; new_value, the lambda function to transform the value of input map
   *          column
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column transform_values (org.apache.spark.sql.Column expr, scala.Function2<org.apache.spark.sql.Column, org.apache.spark.sql.Column, org.apache.spark.sql.Column> f)  { throw new RuntimeException(); }
  /**
   * Returns a map whose key-value pairs satisfy a predicate.
   * <pre><code>
   *   df.select(map_filter(col("m"), (k, v) =&gt; k * 10 === v))
   * </code></pre>
   * <p>
   * @param expr the input map column
   * @param f (key, value) =&gt; predicate, the Boolean predicate to filter the input map column
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column map_filter (org.apache.spark.sql.Column expr, scala.Function2<org.apache.spark.sql.Column, org.apache.spark.sql.Column, org.apache.spark.sql.Column> f)  { throw new RuntimeException(); }
  /**
   * Merge two given maps, key-wise into a single map using a function.
   * <pre><code>
   *   df.select(map_zip_with(df("m1"), df("m2"), (k, v1, v2) =&gt; k === v1 + v2))
   * </code></pre>
   * <p>
   * @param left the left input map column
   * @param right the right input map column
   * @param f (key, value1, value2) =&gt; new_value, the lambda function to merge the map values
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column map_zip_with (org.apache.spark.sql.Column left, org.apache.spark.sql.Column right, scala.Function3<org.apache.spark.sql.Column, org.apache.spark.sql.Column, org.apache.spark.sql.Column, org.apache.spark.sql.Column> f)  { throw new RuntimeException(); }
  /**
   * Creates a new row for each element in the given array or map column.
   * Uses the default column name <code>col</code> for elements in the array and
   * <code>key</code> and <code>value</code> for elements in the map unless specified otherwise.
   * <p>
   * @group collection_funcs
   * @since 1.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column explode (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Creates a new row for each element in the given array or map column.
   * Uses the default column name <code>col</code> for elements in the array and
   * <code>key</code> and <code>value</code> for elements in the map unless specified otherwise.
   * Unlike explode, if the array/map is null or empty then null is produced.
   * <p>
   * @group collection_funcs
   * @since 2.2.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column explode_outer (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Creates a new row for each element with position in the given array or map column.
   * Uses the default column name <code>pos</code> for position, and <code>col</code> for elements in the array
   * and <code>key</code> and <code>value</code> for elements in the map unless specified otherwise.
   * <p>
   * @group collection_funcs
   * @since 2.1.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column posexplode (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Creates a new row for each element with position in the given array or map column.
   * Uses the default column name <code>pos</code> for position, and <code>col</code> for elements in the array
   * and <code>key</code> and <code>value</code> for elements in the map unless specified otherwise.
   * Unlike posexplode, if the array/map is null or empty then the row (null, null) is produced.
   * <p>
   * @group collection_funcs
   * @since 2.2.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column posexplode_outer (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Extracts json object from a json string based on json path specified, and returns json string
   * of the extracted json object. It will return null if the input json string is invalid.
   * <p>
   * @group collection_funcs
   * @since 1.6.0
   * @param e (undocumented)
   * @param path (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column get_json_object (org.apache.spark.sql.Column e, java.lang.String path)  { throw new RuntimeException(); }
  /**
   * Creates a new row for a json column according to the given field names.
   * <p>
   * @group collection_funcs
   * @since 1.6.0
   * @param json (undocumented)
   * @param fields (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column json_tuple (org.apache.spark.sql.Column json, scala.collection.Seq<java.lang.String> fields)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Parses a column containing a JSON string into a <code>StructType</code> with the
   * specified schema. Returns <code>null</code>, in the case of an unparseable string.
   * <p>
   * @param e a string column containing JSON data.
   * @param schema the schema to use when parsing the json string
   * @param options options to control how the json is parsed. Accepts the same options as the
   *                json data source.
   * <p>
   * @group collection_funcs
   * @since 2.1.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column from_json (org.apache.spark.sql.Column e, org.apache.spark.sql.types.StructType schema, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Parses a column containing a JSON string into a <code>MapType</code> with <code>StringType</code>
   * as keys type, <code>StructType</code> or <code>ArrayType</code> with the specified schema.
   * Returns <code>null</code>, in the case of an unparseable string.
   * <p>
   * @param e a string column containing JSON data.
   * @param schema the schema to use when parsing the json string
   * @param options options to control how the json is parsed. accepts the same options and the
   *                json data source.
   * <p>
   * @group collection_funcs
   * @since 2.2.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column from_json (org.apache.spark.sql.Column e, org.apache.spark.sql.types.DataType schema, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Java-specific) Parses a column containing a JSON string into a <code>StructType</code> with the
   * specified schema. Returns <code>null</code>, in the case of an unparseable string.
   * <p>
   * @param e a string column containing JSON data.
   * @param schema the schema to use when parsing the json string
   * @param options options to control how the json is parsed. accepts the same options and the
   *                json data source.
   * <p>
   * @group collection_funcs
   * @since 2.1.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column from_json (org.apache.spark.sql.Column e, org.apache.spark.sql.types.StructType schema, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Java-specific) Parses a column containing a JSON string into a <code>MapType</code> with <code>StringType</code>
   * as keys type, <code>StructType</code> or <code>ArrayType</code> with the specified schema.
   * Returns <code>null</code>, in the case of an unparseable string.
   * <p>
   * @param e a string column containing JSON data.
   * @param schema the schema to use when parsing the json string
   * @param options options to control how the json is parsed. accepts the same options and the
   *                json data source.
   * <p>
   * @group collection_funcs
   * @since 2.2.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column from_json (org.apache.spark.sql.Column e, org.apache.spark.sql.types.DataType schema, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Parses a column containing a JSON string into a <code>StructType</code> with the specified schema.
   * Returns <code>null</code>, in the case of an unparseable string.
   * <p>
   * @param e a string column containing JSON data.
   * @param schema the schema to use when parsing the json string
   * <p>
   * @group collection_funcs
   * @since 2.1.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column from_json (org.apache.spark.sql.Column e, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Parses a column containing a JSON string into a <code>MapType</code> with <code>StringType</code> as keys type,
   * <code>StructType</code> or <code>ArrayType</code> with the specified schema.
   * Returns <code>null</code>, in the case of an unparseable string.
   * <p>
   * @param e a string column containing JSON data.
   * @param schema the schema to use when parsing the json string
   * <p>
   * @group collection_funcs
   * @since 2.2.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column from_json (org.apache.spark.sql.Column e, org.apache.spark.sql.types.DataType schema)  { throw new RuntimeException(); }
  /**
   * (Java-specific) Parses a column containing a JSON string into a <code>MapType</code> with <code>StringType</code>
   * as keys type, <code>StructType</code> or <code>ArrayType</code> with the specified schema.
   * Returns <code>null</code>, in the case of an unparseable string.
   * <p>
   * @param e a string column containing JSON data.
   * @param schema the schema as a DDL-formatted string.
   * <p>
   * @group collection_funcs
   * @since 2.1.0
   * @param options (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column from_json (org.apache.spark.sql.Column e, java.lang.String schema, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Parses a column containing a JSON string into a <code>MapType</code> with <code>StringType</code>
   * as keys type, <code>StructType</code> or <code>ArrayType</code> with the specified schema.
   * Returns <code>null</code>, in the case of an unparseable string.
   * <p>
   * @param e a string column containing JSON data.
   * @param schema the schema as a DDL-formatted string.
   * <p>
   * @group collection_funcs
   * @since 2.3.0
   * @param options (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column from_json (org.apache.spark.sql.Column e, java.lang.String schema, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Parses a column containing a JSON string into a <code>MapType</code> with <code>StringType</code>
   * as keys type, <code>StructType</code> or <code>ArrayType</code> of <code>StructType</code>s with the specified schema.
   * Returns <code>null</code>, in the case of an unparseable string.
   * <p>
   * @param e a string column containing JSON data.
   * @param schema the schema to use when parsing the json string
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column from_json (org.apache.spark.sql.Column e, org.apache.spark.sql.Column schema)  { throw new RuntimeException(); }
  /**
   * (Java-specific) Parses a column containing a JSON string into a <code>MapType</code> with <code>StringType</code>
   * as keys type, <code>StructType</code> or <code>ArrayType</code> of <code>StructType</code>s with the specified schema.
   * Returns <code>null</code>, in the case of an unparseable string.
   * <p>
   * @param e a string column containing JSON data.
   * @param schema the schema to use when parsing the json string
   * @param options options to control how the json is parsed. accepts the same options and the
   *                json data source.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column from_json (org.apache.spark.sql.Column e, org.apache.spark.sql.Column schema, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Parses a JSON string and infers its schema in DDL format.
   * <p>
   * @param json a JSON string.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column schema_of_json (java.lang.String json)  { throw new RuntimeException(); }
  /**
   * Parses a JSON string and infers its schema in DDL format.
   * <p>
   * @param json a foldable string column containing a JSON string.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column schema_of_json (org.apache.spark.sql.Column json)  { throw new RuntimeException(); }
  /**
   * Parses a JSON string and infers its schema in DDL format using options.
   * <p>
   * @param json a foldable string column containing JSON data.
   * @param options options to control how the json is parsed. accepts the same options and the
   *                json data source. See {@link DataFrameReader#json}.
   * @return a column with string literal containing schema in DDL format.
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   */
  static public  org.apache.spark.sql.Column schema_of_json (org.apache.spark.sql.Column json, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Converts a column containing a <code>StructType</code>, <code>ArrayType</code> or
   * a <code>MapType</code> into a JSON string with the specified schema.
   * Throws an exception, in the case of an unsupported type.
   * <p>
   * @param e a column containing a struct, an array or a map.
   * @param options options to control how the struct column is converted into a json string.
   *                accepts the same options and the json data source.
   *                Additionally the function supports the <code>pretty</code> option which enables
   *                pretty JSON generation.
   * <p>
   * @group collection_funcs
   * @since 2.1.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column to_json (org.apache.spark.sql.Column e, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Java-specific) Converts a column containing a <code>StructType</code>, <code>ArrayType</code> or
   * a <code>MapType</code> into a JSON string with the specified schema.
   * Throws an exception, in the case of an unsupported type.
   * <p>
   * @param e a column containing a struct, an array or a map.
   * @param options options to control how the struct column is converted into a json string.
   *                accepts the same options and the json data source.
   *                Additionally the function supports the <code>pretty</code> option which enables
   *                pretty JSON generation.
   * <p>
   * @group collection_funcs
   * @since 2.1.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column to_json (org.apache.spark.sql.Column e, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Converts a column containing a <code>StructType</code>, <code>ArrayType</code> or
   * a <code>MapType</code> into a JSON string with the specified schema.
   * Throws an exception, in the case of an unsupported type.
   * <p>
   * @param e a column containing a struct, an array or a map.
   * <p>
   * @group collection_funcs
   * @since 2.1.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column to_json (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Returns length of array or map.
   * <p>
   * The function returns null for null input if spark.sql.legacy.sizeOfNull is set to false or
   * spark.sql.ansi.enabled is set to true. Otherwise, the function returns -1 for null input.
   * With the default settings, the function returns -1 for null input.
   * <p>
   * @group collection_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column size (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Sorts the input array for the given column in ascending order,
   * according to the natural ordering of the array elements.
   * Null elements will be placed at the beginning of the returned array.
   * <p>
   * @group collection_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column sort_array (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Sorts the input array for the given column in ascending or descending order,
   * according to the natural ordering of the array elements.
   * Null elements will be placed at the beginning of the returned array in ascending order or
   * at the end of the returned array in descending order.
   * <p>
   * @group collection_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @param asc (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column sort_array (org.apache.spark.sql.Column e, boolean asc)  { throw new RuntimeException(); }
  /**
   * Returns the minimum value in the array.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array_min (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Returns the maximum value in the array.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array_max (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Returns a random permutation of the given array.
   * <p>
   * @note The function is non-deterministic.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column shuffle (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Returns a reversed string or an array with reverse order of elements.
   * @group collection_funcs
   * @since 1.5.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column reverse (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Creates a single array from an array of arrays. If a structure of nested arrays is deeper than
   * two levels, only one level of nesting is removed.
   * @group collection_funcs
   * @since 2.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column flatten (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Generate a sequence of integers from start to stop, incrementing by step.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @param start (undocumented)
   * @param stop (undocumented)
   * @param step (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column sequence (org.apache.spark.sql.Column start, org.apache.spark.sql.Column stop, org.apache.spark.sql.Column step)  { throw new RuntimeException(); }
  /**
   * Generate a sequence of integers from start to stop,
   * incrementing by 1 if start is less than or equal to stop, otherwise -1.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @param start (undocumented)
   * @param stop (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column sequence (org.apache.spark.sql.Column start, org.apache.spark.sql.Column stop)  { throw new RuntimeException(); }
  /**
   * Creates an array containing the left argument repeated the number of times given by the
   * right argument.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @param left (undocumented)
   * @param right (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array_repeat (org.apache.spark.sql.Column left, org.apache.spark.sql.Column right)  { throw new RuntimeException(); }
  /**
   * Creates an array containing the left argument repeated the number of times given by the
   * right argument.
   * <p>
   * @group collection_funcs
   * @since 2.4.0
   * @param e (undocumented)
   * @param count (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column array_repeat (org.apache.spark.sql.Column e, int count)  { throw new RuntimeException(); }
  /**
   * Returns an unordered array containing the keys of the map.
   * @group collection_funcs
   * @since 2.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column map_keys (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Returns an unordered array containing the values of the map.
   * @group collection_funcs
   * @since 2.3.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column map_values (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Returns an unordered array of all entries in the given map.
   * @group collection_funcs
   * @since 3.0.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column map_entries (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Returns a map created from the given array of entries.
   * @group collection_funcs
   * @since 2.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column map_from_entries (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Returns a merged array of structs in which the N-th struct contains all N-th values of input
   * arrays.
   * @group collection_funcs
   * @since 2.4.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column arrays_zip (scala.collection.Seq<org.apache.spark.sql.Column> e)  { throw new RuntimeException(); }
  /**
   * Returns the union of all the given maps.
   * @group collection_funcs
   * @since 2.4.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column map_concat (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Parses a column containing a CSV string into a <code>StructType</code> with the specified schema.
   * Returns <code>null</code>, in the case of an unparseable string.
   * <p>
   * @param e a string column containing CSV data.
   * @param schema the schema to use when parsing the CSV string
   * @param options options to control how the CSV is parsed. accepts the same options and the
   *                CSV data source.
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column from_csv (org.apache.spark.sql.Column e, org.apache.spark.sql.types.StructType schema, scala.collection.immutable.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Java-specific) Parses a column containing a CSV string into a <code>StructType</code>
   * with the specified schema. Returns <code>null</code>, in the case of an unparseable string.
   * <p>
   * @param e a string column containing CSV data.
   * @param schema the schema to use when parsing the CSV string
   * @param options options to control how the CSV is parsed. accepts the same options and the
   *                CSV data source.
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column from_csv (org.apache.spark.sql.Column e, org.apache.spark.sql.Column schema, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Parses a CSV string and infers its schema in DDL format.
   * <p>
   * @param csv a CSV string.
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column schema_of_csv (java.lang.String csv)  { throw new RuntimeException(); }
  /**
   * Parses a CSV string and infers its schema in DDL format.
   * <p>
   * @param csv a foldable string column containing a CSV string.
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column schema_of_csv (org.apache.spark.sql.Column csv)  { throw new RuntimeException(); }
  /**
   * Parses a CSV string and infers its schema in DDL format using options.
   * <p>
   * @param csv a foldable string column containing a CSV string.
   * @param options options to control how the CSV is parsed. accepts the same options and the
   *                json data source. See {@link DataFrameReader#csv}.
   * @return a column with string literal containing schema in DDL format.
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   */
  static public  org.apache.spark.sql.Column schema_of_csv (org.apache.spark.sql.Column csv, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * (Java-specific) Converts a column containing a <code>StructType</code> into a CSV string with
   * the specified schema. Throws an exception, in the case of an unsupported type.
   * <p>
   * @param e a column containing a struct.
   * @param options options to control how the struct column is converted into a CSV string.
   *                It accepts the same options and the json data source.
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column to_csv (org.apache.spark.sql.Column e, java.util.Map<java.lang.String, java.lang.String> options)  { throw new RuntimeException(); }
  /**
   * Converts a column containing a <code>StructType</code> into a CSV string with the specified schema.
   * Throws an exception, in the case of an unsupported type.
   * <p>
   * @param e a column containing a struct.
   * <p>
   * @group collection_funcs
   * @since 3.0.0
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column to_csv (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * A transform for timestamps and dates to partition data into years.
   * <p>
   * @group partition_transforms
   * @since 3.0.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column years (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * A transform for timestamps and dates to partition data into months.
   * <p>
   * @group partition_transforms
   * @since 3.0.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column months (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * A transform for timestamps and dates to partition data into days.
   * <p>
   * @group partition_transforms
   * @since 3.0.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column days (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * A transform for timestamps to partition data into hours.
   * <p>
   * @group partition_transforms
   * @since 3.0.0
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column hours (org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * A transform for any type that partitions by a hash of the input column.
   * <p>
   * @group partition_transforms
   * @since 3.0.0
   * @param numBuckets (undocumented)
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column bucket (org.apache.spark.sql.Column numBuckets, org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * A transform for any type that partitions by a hash of the input column.
   * <p>
   * @group partition_transforms
   * @since 3.0.0
   * @param numBuckets (undocumented)
   * @param e (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column bucket (int numBuckets, org.apache.spark.sql.Column e)  { throw new RuntimeException(); }
  /**
   * Obtains a <code>UserDefinedFunction</code> that wraps the given <code>Aggregator</code>
   * so that it may be used with untyped Data Frames.
   * <pre><code>
   *   val agg = // Aggregator[IN, BUF, OUT]
   *
   *   // declare a UDF based on agg
   *   val aggUDF = udaf(agg)
   *   val aggData = df.agg(aggUDF($"colname"))
   *
   *   // register agg as a named function
   *   spark.udf.register("myAggName", udaf(agg))
   * </code></pre>
   * <p>
   * @tparam IN the aggregator input type
   * @tparam BUF the aggregating buffer type
   * @tparam OUT the finalized output type
   * <p>
   * @param agg the typed Aggregator
   * <p>
   * @return a UserDefinedFunction that can be used as an aggregating expression.
   * <p>
   * @note The input encoder is inferred from the input type IN.
   * @param evidence$3 (undocumented)
   */
  static public <IN extends java.lang.Object, BUF extends java.lang.Object, OUT extends java.lang.Object> org.apache.spark.sql.expressions.UserDefinedFunction udaf (org.apache.spark.sql.expressions.Aggregator<IN, BUF, OUT> agg, scala.reflect.api.TypeTags.TypeTag<IN> evidence$3)  { throw new RuntimeException(); }
  /**
   * Obtains a <code>UserDefinedFunction</code> that wraps the given <code>Aggregator</code>
   * so that it may be used with untyped Data Frames.
   * <pre><code>
   *   Aggregator&lt;IN, BUF, OUT&gt; agg = // custom Aggregator
   *   Encoder&lt;IN&gt; enc = // input encoder
   *
   *   // declare a UDF based on agg
   *   UserDefinedFunction aggUDF = udaf(agg, enc)
   *   DataFrame aggData = df.agg(aggUDF($"colname"))
   *
   *   // register agg as a named function
   *   spark.udf.register("myAggName", udaf(agg, enc))
   * </code></pre>
   * <p>
   * @tparam IN the aggregator input type
   * @tparam BUF the aggregating buffer type
   * @tparam OUT the finalized output type
   * <p>
   * @param agg the typed Aggregator
   * @param inputEncoder a specific input encoder to use
   * <p>
   * @return a UserDefinedFunction that can be used as an aggregating expression
   * <p>
   * @note This overloading takes an explicit input encoder, to support UDAF
   * declarations in Java.
   */
  static public <IN extends java.lang.Object, BUF extends java.lang.Object, OUT extends java.lang.Object> org.apache.spark.sql.expressions.UserDefinedFunction udaf (org.apache.spark.sql.expressions.Aggregator<IN, BUF, OUT> agg, org.apache.spark.sql.Encoder<IN> inputEncoder)  { throw new RuntimeException(); }
  /**
   * Defines a Scala closure of 0 arguments as user-defined function (UDF).
   * The data types are automatically inferred based on the Scala closure's
   * signature. By default the returned UDF is deterministic. To change it to
   * nondeterministic, call the API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 1.3.0
   * @param f (undocumented)
   * @param evidence$4 (undocumented)
   * @return (undocumented)
   */
  static public <RT extends java.lang.Object> org.apache.spark.sql.expressions.UserDefinedFunction udf (scala.Function0<RT> f, scala.reflect.api.TypeTags.TypeTag<RT> evidence$4)  { throw new RuntimeException(); }
  /**
   * Defines a Scala closure of 1 arguments as user-defined function (UDF).
   * The data types are automatically inferred based on the Scala closure's
   * signature. By default the returned UDF is deterministic. To change it to
   * nondeterministic, call the API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 1.3.0
   * @param f (undocumented)
   * @param evidence$5 (undocumented)
   * @param evidence$6 (undocumented)
   * @return (undocumented)
   */
  static public <RT extends java.lang.Object, A1 extends java.lang.Object> org.apache.spark.sql.expressions.UserDefinedFunction udf (scala.Function1<A1, RT> f, scala.reflect.api.TypeTags.TypeTag<RT> evidence$5, scala.reflect.api.TypeTags.TypeTag<A1> evidence$6)  { throw new RuntimeException(); }
  /**
   * Defines a Scala closure of 2 arguments as user-defined function (UDF).
   * The data types are automatically inferred based on the Scala closure's
   * signature. By default the returned UDF is deterministic. To change it to
   * nondeterministic, call the API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 1.3.0
   * @param f (undocumented)
   * @param evidence$7 (undocumented)
   * @param evidence$8 (undocumented)
   * @param evidence$9 (undocumented)
   * @return (undocumented)
   */
  static public <RT extends java.lang.Object, A1 extends java.lang.Object, A2 extends java.lang.Object> org.apache.spark.sql.expressions.UserDefinedFunction udf (scala.Function2<A1, A2, RT> f, scala.reflect.api.TypeTags.TypeTag<RT> evidence$7, scala.reflect.api.TypeTags.TypeTag<A1> evidence$8, scala.reflect.api.TypeTags.TypeTag<A2> evidence$9)  { throw new RuntimeException(); }
  /**
   * Defines a Scala closure of 3 arguments as user-defined function (UDF).
   * The data types are automatically inferred based on the Scala closure's
   * signature. By default the returned UDF is deterministic. To change it to
   * nondeterministic, call the API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 1.3.0
   * @param f (undocumented)
   * @param evidence$10 (undocumented)
   * @param evidence$11 (undocumented)
   * @param evidence$12 (undocumented)
   * @param evidence$13 (undocumented)
   * @return (undocumented)
   */
  static public <RT extends java.lang.Object, A1 extends java.lang.Object, A2 extends java.lang.Object, A3 extends java.lang.Object> org.apache.spark.sql.expressions.UserDefinedFunction udf (scala.Function3<A1, A2, A3, RT> f, scala.reflect.api.TypeTags.TypeTag<RT> evidence$10, scala.reflect.api.TypeTags.TypeTag<A1> evidence$11, scala.reflect.api.TypeTags.TypeTag<A2> evidence$12, scala.reflect.api.TypeTags.TypeTag<A3> evidence$13)  { throw new RuntimeException(); }
  /**
   * Defines a Scala closure of 4 arguments as user-defined function (UDF).
   * The data types are automatically inferred based on the Scala closure's
   * signature. By default the returned UDF is deterministic. To change it to
   * nondeterministic, call the API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 1.3.0
   * @param f (undocumented)
   * @param evidence$14 (undocumented)
   * @param evidence$15 (undocumented)
   * @param evidence$16 (undocumented)
   * @param evidence$17 (undocumented)
   * @param evidence$18 (undocumented)
   * @return (undocumented)
   */
  static public <RT extends java.lang.Object, A1 extends java.lang.Object, A2 extends java.lang.Object, A3 extends java.lang.Object, A4 extends java.lang.Object> org.apache.spark.sql.expressions.UserDefinedFunction udf (scala.Function4<A1, A2, A3, A4, RT> f, scala.reflect.api.TypeTags.TypeTag<RT> evidence$14, scala.reflect.api.TypeTags.TypeTag<A1> evidence$15, scala.reflect.api.TypeTags.TypeTag<A2> evidence$16, scala.reflect.api.TypeTags.TypeTag<A3> evidence$17, scala.reflect.api.TypeTags.TypeTag<A4> evidence$18)  { throw new RuntimeException(); }
  /**
   * Defines a Scala closure of 5 arguments as user-defined function (UDF).
   * The data types are automatically inferred based on the Scala closure's
   * signature. By default the returned UDF is deterministic. To change it to
   * nondeterministic, call the API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 1.3.0
   * @param f (undocumented)
   * @param evidence$19 (undocumented)
   * @param evidence$20 (undocumented)
   * @param evidence$21 (undocumented)
   * @param evidence$22 (undocumented)
   * @param evidence$23 (undocumented)
   * @param evidence$24 (undocumented)
   * @return (undocumented)
   */
  static public <RT extends java.lang.Object, A1 extends java.lang.Object, A2 extends java.lang.Object, A3 extends java.lang.Object, A4 extends java.lang.Object, A5 extends java.lang.Object> org.apache.spark.sql.expressions.UserDefinedFunction udf (scala.Function5<A1, A2, A3, A4, A5, RT> f, scala.reflect.api.TypeTags.TypeTag<RT> evidence$19, scala.reflect.api.TypeTags.TypeTag<A1> evidence$20, scala.reflect.api.TypeTags.TypeTag<A2> evidence$21, scala.reflect.api.TypeTags.TypeTag<A3> evidence$22, scala.reflect.api.TypeTags.TypeTag<A4> evidence$23, scala.reflect.api.TypeTags.TypeTag<A5> evidence$24)  { throw new RuntimeException(); }
  /**
   * Defines a Scala closure of 6 arguments as user-defined function (UDF).
   * The data types are automatically inferred based on the Scala closure's
   * signature. By default the returned UDF is deterministic. To change it to
   * nondeterministic, call the API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 1.3.0
   * @param f (undocumented)
   * @param evidence$25 (undocumented)
   * @param evidence$26 (undocumented)
   * @param evidence$27 (undocumented)
   * @param evidence$28 (undocumented)
   * @param evidence$29 (undocumented)
   * @param evidence$30 (undocumented)
   * @param evidence$31 (undocumented)
   * @return (undocumented)
   */
  static public <RT extends java.lang.Object, A1 extends java.lang.Object, A2 extends java.lang.Object, A3 extends java.lang.Object, A4 extends java.lang.Object, A5 extends java.lang.Object, A6 extends java.lang.Object> org.apache.spark.sql.expressions.UserDefinedFunction udf (scala.Function6<A1, A2, A3, A4, A5, A6, RT> f, scala.reflect.api.TypeTags.TypeTag<RT> evidence$25, scala.reflect.api.TypeTags.TypeTag<A1> evidence$26, scala.reflect.api.TypeTags.TypeTag<A2> evidence$27, scala.reflect.api.TypeTags.TypeTag<A3> evidence$28, scala.reflect.api.TypeTags.TypeTag<A4> evidence$29, scala.reflect.api.TypeTags.TypeTag<A5> evidence$30, scala.reflect.api.TypeTags.TypeTag<A6> evidence$31)  { throw new RuntimeException(); }
  /**
   * Defines a Scala closure of 7 arguments as user-defined function (UDF).
   * The data types are automatically inferred based on the Scala closure's
   * signature. By default the returned UDF is deterministic. To change it to
   * nondeterministic, call the API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 1.3.0
   * @param f (undocumented)
   * @param evidence$32 (undocumented)
   * @param evidence$33 (undocumented)
   * @param evidence$34 (undocumented)
   * @param evidence$35 (undocumented)
   * @param evidence$36 (undocumented)
   * @param evidence$37 (undocumented)
   * @param evidence$38 (undocumented)
   * @param evidence$39 (undocumented)
   * @return (undocumented)
   */
  static public <RT extends java.lang.Object, A1 extends java.lang.Object, A2 extends java.lang.Object, A3 extends java.lang.Object, A4 extends java.lang.Object, A5 extends java.lang.Object, A6 extends java.lang.Object, A7 extends java.lang.Object> org.apache.spark.sql.expressions.UserDefinedFunction udf (scala.Function7<A1, A2, A3, A4, A5, A6, A7, RT> f, scala.reflect.api.TypeTags.TypeTag<RT> evidence$32, scala.reflect.api.TypeTags.TypeTag<A1> evidence$33, scala.reflect.api.TypeTags.TypeTag<A2> evidence$34, scala.reflect.api.TypeTags.TypeTag<A3> evidence$35, scala.reflect.api.TypeTags.TypeTag<A4> evidence$36, scala.reflect.api.TypeTags.TypeTag<A5> evidence$37, scala.reflect.api.TypeTags.TypeTag<A6> evidence$38, scala.reflect.api.TypeTags.TypeTag<A7> evidence$39)  { throw new RuntimeException(); }
  /**
   * Defines a Scala closure of 8 arguments as user-defined function (UDF).
   * The data types are automatically inferred based on the Scala closure's
   * signature. By default the returned UDF is deterministic. To change it to
   * nondeterministic, call the API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 1.3.0
   * @param f (undocumented)
   * @param evidence$40 (undocumented)
   * @param evidence$41 (undocumented)
   * @param evidence$42 (undocumented)
   * @param evidence$43 (undocumented)
   * @param evidence$44 (undocumented)
   * @param evidence$45 (undocumented)
   * @param evidence$46 (undocumented)
   * @param evidence$47 (undocumented)
   * @param evidence$48 (undocumented)
   * @return (undocumented)
   */
  static public <RT extends java.lang.Object, A1 extends java.lang.Object, A2 extends java.lang.Object, A3 extends java.lang.Object, A4 extends java.lang.Object, A5 extends java.lang.Object, A6 extends java.lang.Object, A7 extends java.lang.Object, A8 extends java.lang.Object> org.apache.spark.sql.expressions.UserDefinedFunction udf (scala.Function8<A1, A2, A3, A4, A5, A6, A7, A8, RT> f, scala.reflect.api.TypeTags.TypeTag<RT> evidence$40, scala.reflect.api.TypeTags.TypeTag<A1> evidence$41, scala.reflect.api.TypeTags.TypeTag<A2> evidence$42, scala.reflect.api.TypeTags.TypeTag<A3> evidence$43, scala.reflect.api.TypeTags.TypeTag<A4> evidence$44, scala.reflect.api.TypeTags.TypeTag<A5> evidence$45, scala.reflect.api.TypeTags.TypeTag<A6> evidence$46, scala.reflect.api.TypeTags.TypeTag<A7> evidence$47, scala.reflect.api.TypeTags.TypeTag<A8> evidence$48)  { throw new RuntimeException(); }
  /**
   * Defines a Scala closure of 9 arguments as user-defined function (UDF).
   * The data types are automatically inferred based on the Scala closure's
   * signature. By default the returned UDF is deterministic. To change it to
   * nondeterministic, call the API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 1.3.0
   * @param f (undocumented)
   * @param evidence$49 (undocumented)
   * @param evidence$50 (undocumented)
   * @param evidence$51 (undocumented)
   * @param evidence$52 (undocumented)
   * @param evidence$53 (undocumented)
   * @param evidence$54 (undocumented)
   * @param evidence$55 (undocumented)
   * @param evidence$56 (undocumented)
   * @param evidence$57 (undocumented)
   * @param evidence$58 (undocumented)
   * @return (undocumented)
   */
  static public <RT extends java.lang.Object, A1 extends java.lang.Object, A2 extends java.lang.Object, A3 extends java.lang.Object, A4 extends java.lang.Object, A5 extends java.lang.Object, A6 extends java.lang.Object, A7 extends java.lang.Object, A8 extends java.lang.Object, A9 extends java.lang.Object> org.apache.spark.sql.expressions.UserDefinedFunction udf (scala.Function9<A1, A2, A3, A4, A5, A6, A7, A8, A9, RT> f, scala.reflect.api.TypeTags.TypeTag<RT> evidence$49, scala.reflect.api.TypeTags.TypeTag<A1> evidence$50, scala.reflect.api.TypeTags.TypeTag<A2> evidence$51, scala.reflect.api.TypeTags.TypeTag<A3> evidence$52, scala.reflect.api.TypeTags.TypeTag<A4> evidence$53, scala.reflect.api.TypeTags.TypeTag<A5> evidence$54, scala.reflect.api.TypeTags.TypeTag<A6> evidence$55, scala.reflect.api.TypeTags.TypeTag<A7> evidence$56, scala.reflect.api.TypeTags.TypeTag<A8> evidence$57, scala.reflect.api.TypeTags.TypeTag<A9> evidence$58)  { throw new RuntimeException(); }
  /**
   * Defines a Scala closure of 10 arguments as user-defined function (UDF).
   * The data types are automatically inferred based on the Scala closure's
   * signature. By default the returned UDF is deterministic. To change it to
   * nondeterministic, call the API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 1.3.0
   * @param f (undocumented)
   * @param evidence$59 (undocumented)
   * @param evidence$60 (undocumented)
   * @param evidence$61 (undocumented)
   * @param evidence$62 (undocumented)
   * @param evidence$63 (undocumented)
   * @param evidence$64 (undocumented)
   * @param evidence$65 (undocumented)
   * @param evidence$66 (undocumented)
   * @param evidence$67 (undocumented)
   * @param evidence$68 (undocumented)
   * @param evidence$69 (undocumented)
   * @return (undocumented)
   */
  static public <RT extends java.lang.Object, A1 extends java.lang.Object, A2 extends java.lang.Object, A3 extends java.lang.Object, A4 extends java.lang.Object, A5 extends java.lang.Object, A6 extends java.lang.Object, A7 extends java.lang.Object, A8 extends java.lang.Object, A9 extends java.lang.Object, A10 extends java.lang.Object> org.apache.spark.sql.expressions.UserDefinedFunction udf (scala.Function10<A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, RT> f, scala.reflect.api.TypeTags.TypeTag<RT> evidence$59, scala.reflect.api.TypeTags.TypeTag<A1> evidence$60, scala.reflect.api.TypeTags.TypeTag<A2> evidence$61, scala.reflect.api.TypeTags.TypeTag<A3> evidence$62, scala.reflect.api.TypeTags.TypeTag<A4> evidence$63, scala.reflect.api.TypeTags.TypeTag<A5> evidence$64, scala.reflect.api.TypeTags.TypeTag<A6> evidence$65, scala.reflect.api.TypeTags.TypeTag<A7> evidence$66, scala.reflect.api.TypeTags.TypeTag<A8> evidence$67, scala.reflect.api.TypeTags.TypeTag<A9> evidence$68, scala.reflect.api.TypeTags.TypeTag<A10> evidence$69)  { throw new RuntimeException(); }
  /**
   * Defines a Java UDF0 instance as user-defined function (UDF).
   * The caller must specify the output data type, and there is no automatic input type coercion.
   * By default the returned UDF is deterministic. To change it to nondeterministic, call the
   * API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 2.3.0
   * @param f (undocumented)
   * @param returnType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.UserDefinedFunction udf (org.apache.spark.sql.api.java.UDF0<?> f, org.apache.spark.sql.types.DataType returnType)  { throw new RuntimeException(); }
  /**
   * Defines a Java UDF1 instance as user-defined function (UDF).
   * The caller must specify the output data type, and there is no automatic input type coercion.
   * By default the returned UDF is deterministic. To change it to nondeterministic, call the
   * API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 2.3.0
   * @param f (undocumented)
   * @param returnType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.UserDefinedFunction udf (org.apache.spark.sql.api.java.UDF1<?, ?> f, org.apache.spark.sql.types.DataType returnType)  { throw new RuntimeException(); }
  /**
   * Defines a Java UDF2 instance as user-defined function (UDF).
   * The caller must specify the output data type, and there is no automatic input type coercion.
   * By default the returned UDF is deterministic. To change it to nondeterministic, call the
   * API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 2.3.0
   * @param f (undocumented)
   * @param returnType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.UserDefinedFunction udf (org.apache.spark.sql.api.java.UDF2<?, ?, ?> f, org.apache.spark.sql.types.DataType returnType)  { throw new RuntimeException(); }
  /**
   * Defines a Java UDF3 instance as user-defined function (UDF).
   * The caller must specify the output data type, and there is no automatic input type coercion.
   * By default the returned UDF is deterministic. To change it to nondeterministic, call the
   * API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 2.3.0
   * @param f (undocumented)
   * @param returnType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.UserDefinedFunction udf (org.apache.spark.sql.api.java.UDF3<?, ?, ?, ?> f, org.apache.spark.sql.types.DataType returnType)  { throw new RuntimeException(); }
  /**
   * Defines a Java UDF4 instance as user-defined function (UDF).
   * The caller must specify the output data type, and there is no automatic input type coercion.
   * By default the returned UDF is deterministic. To change it to nondeterministic, call the
   * API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 2.3.0
   * @param f (undocumented)
   * @param returnType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.UserDefinedFunction udf (org.apache.spark.sql.api.java.UDF4<?, ?, ?, ?, ?> f, org.apache.spark.sql.types.DataType returnType)  { throw new RuntimeException(); }
  /**
   * Defines a Java UDF5 instance as user-defined function (UDF).
   * The caller must specify the output data type, and there is no automatic input type coercion.
   * By default the returned UDF is deterministic. To change it to nondeterministic, call the
   * API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 2.3.0
   * @param f (undocumented)
   * @param returnType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.UserDefinedFunction udf (org.apache.spark.sql.api.java.UDF5<?, ?, ?, ?, ?, ?> f, org.apache.spark.sql.types.DataType returnType)  { throw new RuntimeException(); }
  /**
   * Defines a Java UDF6 instance as user-defined function (UDF).
   * The caller must specify the output data type, and there is no automatic input type coercion.
   * By default the returned UDF is deterministic. To change it to nondeterministic, call the
   * API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 2.3.0
   * @param f (undocumented)
   * @param returnType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.UserDefinedFunction udf (org.apache.spark.sql.api.java.UDF6<?, ?, ?, ?, ?, ?, ?> f, org.apache.spark.sql.types.DataType returnType)  { throw new RuntimeException(); }
  /**
   * Defines a Java UDF7 instance as user-defined function (UDF).
   * The caller must specify the output data type, and there is no automatic input type coercion.
   * By default the returned UDF is deterministic. To change it to nondeterministic, call the
   * API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 2.3.0
   * @param f (undocumented)
   * @param returnType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.UserDefinedFunction udf (org.apache.spark.sql.api.java.UDF7<?, ?, ?, ?, ?, ?, ?, ?> f, org.apache.spark.sql.types.DataType returnType)  { throw new RuntimeException(); }
  /**
   * Defines a Java UDF8 instance as user-defined function (UDF).
   * The caller must specify the output data type, and there is no automatic input type coercion.
   * By default the returned UDF is deterministic. To change it to nondeterministic, call the
   * API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 2.3.0
   * @param f (undocumented)
   * @param returnType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.UserDefinedFunction udf (org.apache.spark.sql.api.java.UDF8<?, ?, ?, ?, ?, ?, ?, ?, ?> f, org.apache.spark.sql.types.DataType returnType)  { throw new RuntimeException(); }
  /**
   * Defines a Java UDF9 instance as user-defined function (UDF).
   * The caller must specify the output data type, and there is no automatic input type coercion.
   * By default the returned UDF is deterministic. To change it to nondeterministic, call the
   * API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 2.3.0
   * @param f (undocumented)
   * @param returnType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.UserDefinedFunction udf (org.apache.spark.sql.api.java.UDF9<?, ?, ?, ?, ?, ?, ?, ?, ?, ?> f, org.apache.spark.sql.types.DataType returnType)  { throw new RuntimeException(); }
  /**
   * Defines a Java UDF10 instance as user-defined function (UDF).
   * The caller must specify the output data type, and there is no automatic input type coercion.
   * By default the returned UDF is deterministic. To change it to nondeterministic, call the
   * API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * @group udf_funcs
   * @since 2.3.0
   * @param f (undocumented)
   * @param returnType (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.expressions.UserDefinedFunction udf (org.apache.spark.sql.api.java.UDF10<?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?> f, org.apache.spark.sql.types.DataType returnType)  { throw new RuntimeException(); }
  /**
   * Defines a deterministic user-defined function (UDF) using a Scala closure. For this variant,
   * the caller must specify the output data type, and there is no automatic input type coercion.
   * By default the returned UDF is deterministic. To change it to nondeterministic, call the
   * API <code>UserDefinedFunction.asNondeterministic()</code>.
   * <p>
   * Note that, although the Scala closure can have primitive-type function argument, it doesn't
   * work well with null values. Because the Scala closure is passed in as Any type, there is no
   * type information for the function arguments. Without the type information, Spark may blindly
   * pass null to the Scala closure with primitive-type argument, and the closure will see the
   * default value of the Java type for the null argument, e.g. <code>udf((x: Int) =&gt; x, IntegerType)</code>,
   * the result is 0 for null input.
   * <p>
   * @param f  A closure in Scala
   * @param dataType  The output data type of the UDF
   * <p>
   * @group udf_funcs
   * @since 2.0.0
   * @return (undocumented)
   *
   * @deprecated Scala `udf` method with return type parameter is deprecated. Please use Scala `udf` method without return type parameter. Since 3.0.0. 
   */
  static public  org.apache.spark.sql.expressions.UserDefinedFunction udf (java.lang.Object f, org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
  /**
   * Call an user-defined function.
   * <p>
   * @group udf_funcs
   * @since 1.5.0
   * @param udfName (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   *
   * @deprecated Use call_udf. Since . 
   */
  static public  org.apache.spark.sql.Column callUDF (java.lang.String udfName, scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Call an user-defined function.
   * Example:
   * <pre><code>
   *  import org.apache.spark.sql._
   *
   *  val df = Seq(("id1", 1), ("id2", 4), ("id3", 5)).toDF("id", "value")
   *  val spark = df.sparkSession
   *  spark.udf.register("simpleUDF", (v: Int) =&gt; v * v)
   *  df.select($"id", call_udf("simpleUDF", $"value"))
   * </code></pre>
   * <p>
   * @group udf_funcs
   * @since 3.2.0
   * @param udfName (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  static public  org.apache.spark.sql.Column call_udf (java.lang.String udfName, scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
}
