package org.apache.spark.sql;
/**
 * A Dataset is a strongly typed collection of domain-specific objects that can be transformed
 * in parallel using functional or relational operations. Each Dataset also has an untyped view
 * called a <code>DataFrame</code>, which is a Dataset of {@link Row}.
 * <p>
 * Operations available on Datasets are divided into transformations and actions. Transformations
 * are the ones that produce new Datasets, and actions are the ones that trigger computation and
 * return results. Example transformations include map, filter, select, and aggregate (<code>groupBy</code>).
 * Example actions count, show, or writing data out to file systems.
 * <p>
 * Datasets are "lazy", i.e. computations are only triggered when an action is invoked. Internally,
 * a Dataset represents a logical plan that describes the computation required to produce the data.
 * When an action is invoked, Spark's query optimizer optimizes the logical plan and generates a
 * physical plan for efficient execution in a parallel and distributed manner. To explore the
 * logical plan as well as optimized physical plan, use the <code>explain</code> function.
 * <p>
 * To efficiently support domain-specific objects, an {@link Encoder} is required. The encoder maps
 * the domain specific type <code>T</code> to Spark's internal type system. For example, given a class <code>Person</code>
 * with two fields, <code>name</code> (string) and <code>age</code> (int), an encoder is used to tell Spark to generate
 * code at runtime to serialize the <code>Person</code> object into a binary structure. This binary structure
 * often has much lower memory footprint as well as are optimized for efficiency in data processing
 * (e.g. in a columnar format). To understand the internal binary representation for data, use the
 * <code>schema</code> function.
 * <p>
 * There are typically two ways to create a Dataset. The most common way is by pointing Spark
 * to some files on storage systems, using the <code>read</code> function available on a <code>SparkSession</code>.
 * <pre><code>
 *   val people = spark.read.parquet("...").as[Person]  // Scala
 *   Dataset&lt;Person&gt; people = spark.read().parquet("...").as(Encoders.bean(Person.class)); // Java
 * </code></pre>
 * <p>
 * Datasets can also be created through transformations available on existing Datasets. For example,
 * the following creates a new Dataset by applying a filter on the existing one:
 * <pre><code>
 *   val names = people.map(_.name)  // in Scala; names is a Dataset[String]
 *   Dataset&lt;String&gt; names = people.map((Person p) -&gt; p.name, Encoders.STRING));
 * </code></pre>
 * <p>
 * Dataset operations can also be untyped, through various domain-specific-language (DSL)
 * functions defined in: Dataset (this class), {@link Column}, and {@link functions}. These operations
 * are very similar to the operations available in the data frame abstraction in R or Python.
 * <p>
 * To select a column from the Dataset, use <code>apply</code> method in Scala and <code>col</code> in Java.
 * <pre><code>
 *   val ageCol = people("age")  // in Scala
 *   Column ageCol = people.col("age"); // in Java
 * </code></pre>
 * <p>
 * Note that the {@link Column} type can also be manipulated through its various functions.
 * <pre><code>
 *   // The following creates a new column that increases everybody's age by 10.
 *   people("age") + 10  // in Scala
 *   people.col("age").plus(10);  // in Java
 * </code></pre>
 * <p>
 * A more concrete example in Scala:
 * <pre><code>
 *   // To create Dataset[Row] using SparkSession
 *   val people = spark.read.parquet("...")
 *   val department = spark.read.parquet("...")
 *
 *   people.filter("age &gt; 30")
 *     .join(department, people("deptId") === department("id"))
 *     .groupBy(department("name"), people("gender"))
 *     .agg(avg(people("salary")), max(people("age")))
 * </code></pre>
 * <p>
 * and in Java:
 * <pre><code>
 *   // To create Dataset&lt;Row&gt; using SparkSession
 *   Dataset&lt;Row&gt; people = spark.read().parquet("...");
 *   Dataset&lt;Row&gt; department = spark.read().parquet("...");
 *
 *   people.filter(people.col("age").gt(30))
 *     .join(department, people.col("deptId").equalTo(department.col("id")))
 *     .groupBy(department.col("name"), people.col("gender"))
 *     .agg(avg(people.col("salary")), max(people.col("age")));
 * </code></pre>
 * <p>
 * @groupname basic Basic Dataset functions
 * @groupname action Actions
 * @groupname untypedrel Untyped transformations
 * @groupname typedrel Typed transformations
 * <p>
 * @since 1.6.0
 */
public  class Dataset<T extends java.lang.Object> implements scala.Serializable {
  static public  java.util.concurrent.atomic.AtomicLong curId ()  { throw new RuntimeException(); }
  static public  java.lang.String DATASET_ID_KEY ()  { throw new RuntimeException(); }
  static public  java.lang.String COL_POS_KEY ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.catalyst.trees.TreeNodeTag<java.lang.Object> DATASET_ID_TAG ()  { throw new RuntimeException(); }
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> ofRows (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan)  { throw new RuntimeException(); }
  /** A variant of ofRows that allows passing in a tracker so we can track query parsing time. */
  static public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> ofRows (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan, org.apache.spark.sql.catalyst.QueryPlanningTracker tracker)  { throw new RuntimeException(); }
  /**
   * Converts this strongly typed collection of data to generic <code>DataFrame</code> with columns renamed.
   * This can be quite convenient in conversion from an RDD of tuples into a <code>DataFrame</code> with
   * meaningful names. For example:
   * <pre><code>
   *   val rdd: RDD[(Int, String)] = ...
   *   rdd.toDF()  // this implicit conversion creates a DataFrame with column name `_1` and `_2`
   *   rdd.toDF("id", "name")  // this creates a DataFrame with column name "id" and "name"
   * </code></pre>
   * <p>
   * @group basic
   * @since 2.0.0
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> toDF (java.lang.String... colNames)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset with each partition sorted by the given expressions.
   * <p>
   * This is the same operation as "SORT BY" in SQL (Hive QL).
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param sortCol (undocumented)
   * @param sortCols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> sortWithinPartitions (java.lang.String sortCol, java.lang.String... sortCols)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset with each partition sorted by the given expressions.
   * <p>
   * This is the same operation as "SORT BY" in SQL (Hive QL).
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param sortExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> sortWithinPartitions (org.apache.spark.sql.Column... sortExprs)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset sorted by the specified column, all in ascending order.
   * <pre><code>
   *   // The following 3 are equivalent
   *   ds.sort("sortcol")
   *   ds.sort($"sortcol")
   *   ds.sort($"sortcol".asc)
   * </code></pre>
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param sortCol (undocumented)
   * @param sortCols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> sort (java.lang.String sortCol, java.lang.String... sortCols)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset sorted by the given expressions. For example:
   * <pre><code>
   *   ds.sort($"col1", $"col2".desc)
   * </code></pre>
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param sortExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> sort (org.apache.spark.sql.Column... sortExprs)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset sorted by the given expressions.
   * This is an alias of the <code>sort</code> function.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param sortCol (undocumented)
   * @param sortCols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> orderBy (java.lang.String sortCol, java.lang.String... sortCols)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset sorted by the given expressions.
   * This is an alias of the <code>sort</code> function.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param sortExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> orderBy (org.apache.spark.sql.Column... sortExprs)  { throw new RuntimeException(); }
  /**
   * Specifies some hint on the current Dataset. As an example, the following code specifies
   * that one of the plan can be broadcasted:
   * <p>
   * <pre><code>
   *   df1.join(df2.hint("broadcast"))
   * </code></pre>
   * <p>
   * @group basic
   * @since 2.2.0
   * @param name (undocumented)
   * @param parameters (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> hint (java.lang.String name, java.lang.Object... parameters)  { throw new RuntimeException(); }
  /**
   * Selects a set of column based expressions.
   * <pre><code>
   *   ds.select($"colA", $"colB" + 1)
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> select (org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Selects a set of columns. This is a variant of <code>select</code> that can only select
   * existing columns using column names (i.e. cannot construct expressions).
   * <p>
   * <pre><code>
   *   // The following two are equivalent:
   *   ds.select("colA", "colB")
   *   ds.select($"colA", $"colB")
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param col (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> select (java.lang.String col, java.lang.String... cols)  { throw new RuntimeException(); }
  /**
   * Selects a set of SQL expressions. This is a variant of <code>select</code> that accepts
   * SQL expressions.
   * <p>
   * <pre><code>
   *   // The following are equivalent:
   *   ds.selectExpr("colA", "colB as newName", "abs(colC)")
   *   ds.select(expr("colA"), expr("colB as newName"), expr("abs(colC)"))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> selectExpr (java.lang.String... exprs)  { throw new RuntimeException(); }
  /**
   * Groups the Dataset using the specified columns, so we can run aggregation on them. See
   * {@link RelationalGroupedDataset} for all the available aggregate functions.
   * <p>
   * <pre><code>
   *   // Compute the average for all numeric columns grouped by department.
   *   ds.groupBy($"department").avg()
   *
   *   // Compute the max age and average salary, grouped by department and gender.
   *   ds.groupBy($"department", $"gender").agg(Map(
   *     "salary" -&gt; "avg",
   *     "age" -&gt; "max"
   *   ))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.RelationalGroupedDataset groupBy (org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Create a multi-dimensional rollup for the current Dataset using the specified columns,
   * so we can run aggregation on them.
   * See {@link RelationalGroupedDataset} for all the available aggregate functions.
   * <p>
   * <pre><code>
   *   // Compute the average for all numeric columns rolled up by department and group.
   *   ds.rollup($"department", $"group").avg()
   *
   *   // Compute the max age and average salary, rolled up by department and gender.
   *   ds.rollup($"department", $"gender").agg(Map(
   *     "salary" -&gt; "avg",
   *     "age" -&gt; "max"
   *   ))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.RelationalGroupedDataset rollup (org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Create a multi-dimensional cube for the current Dataset using the specified columns,
   * so we can run aggregation on them.
   * See {@link RelationalGroupedDataset} for all the available aggregate functions.
   * <p>
   * <pre><code>
   *   // Compute the average for all numeric columns cubed by department and group.
   *   ds.cube($"department", $"group").avg()
   *
   *   // Compute the max age and average salary, cubed by department and gender.
   *   ds.cube($"department", $"gender").agg(Map(
   *     "salary" -&gt; "avg",
   *     "age" -&gt; "max"
   *   ))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.RelationalGroupedDataset cube (org.apache.spark.sql.Column... cols)  { throw new RuntimeException(); }
  /**
   * Groups the Dataset using the specified columns, so that we can run aggregation on them.
   * See {@link RelationalGroupedDataset} for all the available aggregate functions.
   * <p>
   * This is a variant of groupBy that can only group by existing columns using column names
   * (i.e. cannot construct expressions).
   * <p>
   * <pre><code>
   *   // Compute the average for all numeric columns grouped by department.
   *   ds.groupBy("department").avg()
   *
   *   // Compute the max age and average salary, grouped by department and gender.
   *   ds.groupBy($"department", $"gender").agg(Map(
   *     "salary" -&gt; "avg",
   *     "age" -&gt; "max"
   *   ))
   * </code></pre>
   * @group untypedrel
   * @since 2.0.0
   * @param col1 (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.RelationalGroupedDataset groupBy (java.lang.String col1, java.lang.String... cols)  { throw new RuntimeException(); }
  /**
   * Create a multi-dimensional rollup for the current Dataset using the specified columns,
   * so we can run aggregation on them.
   * See {@link RelationalGroupedDataset} for all the available aggregate functions.
   * <p>
   * This is a variant of rollup that can only group by existing columns using column names
   * (i.e. cannot construct expressions).
   * <p>
   * <pre><code>
   *   // Compute the average for all numeric columns rolled up by department and group.
   *   ds.rollup("department", "group").avg()
   *
   *   // Compute the max age and average salary, rolled up by department and gender.
   *   ds.rollup($"department", $"gender").agg(Map(
   *     "salary" -&gt; "avg",
   *     "age" -&gt; "max"
   *   ))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param col1 (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.RelationalGroupedDataset rollup (java.lang.String col1, java.lang.String... cols)  { throw new RuntimeException(); }
  /**
   * Create a multi-dimensional cube for the current Dataset using the specified columns,
   * so we can run aggregation on them.
   * See {@link RelationalGroupedDataset} for all the available aggregate functions.
   * <p>
   * This is a variant of cube that can only group by existing columns using column names
   * (i.e. cannot construct expressions).
   * <p>
   * <pre><code>
   *   // Compute the average for all numeric columns cubed by department and group.
   *   ds.cube("department", "group").avg()
   *
   *   // Compute the max age and average salary, cubed by department and gender.
   *   ds.cube($"department", $"gender").agg(Map(
   *     "salary" -&gt; "avg",
   *     "age" -&gt; "max"
   *   ))
   * </code></pre>
   * @group untypedrel
   * @since 2.0.0
   * @param col1 (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.RelationalGroupedDataset cube (java.lang.String col1, java.lang.String... cols)  { throw new RuntimeException(); }
  /**
   * Aggregates on the entire Dataset without groups.
   * <pre><code>
   *   // ds.agg(...) is a shorthand for ds.groupBy().agg(...)
   *   ds.agg(max($"age"), avg($"salary"))
   *   ds.groupBy().agg(max($"age"), avg($"salary"))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param expr (undocumented)
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> agg (org.apache.spark.sql.Column expr, org.apache.spark.sql.Column... exprs)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset with columns dropped.
   * This is a no-op if schema doesn't contain column name(s).
   * <p>
   * This method can only be used to drop top level columns. the colName string is treated literally
   * without further interpretation.
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> drop (java.lang.String... colNames)  { throw new RuntimeException(); }
  /**
   * Returns a new {@link Dataset} with duplicate rows removed, considering only
   * the subset of columns.
   * <p>
   * For a static batch {@link Dataset}, it just drops duplicate rows. For a streaming {@link Dataset}, it
   * will keep all data across triggers as intermediate state to drop duplicates rows. You can use
   * {@link withWatermark} to limit how late the duplicate data can be and system will accordingly limit
   * the state. In addition, too late data older than watermark will be dropped to avoid any
   * possibility of duplicates.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param col1 (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> dropDuplicates (java.lang.String col1, java.lang.String... cols)  { throw new RuntimeException(); }
  /**
   * Computes basic statistics for numeric and string columns, including count, mean, stddev, min,
   * and max. If no columns are given, this function computes statistics for all numerical or
   * string columns.
   * <p>
   * This function is meant for exploratory data analysis, as we make no guarantee about the
   * backward compatibility of the schema of the resulting Dataset. If you want to
   * programmatically compute summary statistics, use the <code>agg</code> function instead.
   * <p>
   * <pre><code>
   *   ds.describe("age", "height").show()
   *
   *   // output:
   *   // summary age   height
   *   // count   10.0  10.0
   *   // mean    53.3  178.05
   *   // stddev  11.6  15.7
   *   // min     18.0  163.0
   *   // max     92.0  192.0
   * </code></pre>
   * <p>
   * Use {@link summary} for expanded statistics and control over which statistics to compute.
   * <p>
   * @param cols Columns to compute statistics on.
   * <p>
   * @group action
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> describe (java.lang.String... cols)  { throw new RuntimeException(); }
  /**
   * Computes specified statistics for numeric and string columns. Available statistics are:
   * <ul>
   *   <li>count</li>
   *   <li>mean</li>
   *   <li>stddev</li>
   *   <li>min</li>
   *   <li>max</li>
   *   <li>arbitrary approximate percentiles specified as a percentage (e.g. 75%)</li>
   *   <li>count_distinct</li>
   *   <li>approx_count_distinct</li>
   * </ul>
   * <p>
   * If no statistics are given, this function computes count, mean, stddev, min,
   * approximate quartiles (percentiles at 25%, 50%, and 75%), and max.
   * <p>
   * This function is meant for exploratory data analysis, as we make no guarantee about the
   * backward compatibility of the schema of the resulting Dataset. If you want to
   * programmatically compute summary statistics, use the <code>agg</code> function instead.
   * <p>
   * <pre><code>
   *   ds.summary().show()
   *
   *   // output:
   *   // summary age   height
   *   // count   10.0  10.0
   *   // mean    53.3  178.05
   *   // stddev  11.6  15.7
   *   // min     18.0  163.0
   *   // 25%     24.0  176.0
   *   // 50%     24.0  176.0
   *   // 75%     32.0  180.0
   *   // max     92.0  192.0
   * </code></pre>
   * <p>
   * <pre><code>
   *   ds.summary("count", "min", "25%", "75%", "max").show()
   *
   *   // output:
   *   // summary age   height
   *   // count   10.0  10.0
   *   // min     18.0  163.0
   *   // 25%     24.0  176.0
   *   // 75%     32.0  180.0
   *   // max     92.0  192.0
   * </code></pre>
   * <p>
   * To do a summary for specific columns first select them:
   * <p>
   * <pre><code>
   *   ds.select("age", "height").summary().show()
   * </code></pre>
   * <p>
   * Specify statistics to output custom summaries:
   * <p>
   * <pre><code>
   *   ds.summary("count", "count_distinct").show()
   * </code></pre>
   * <p>
   * The distinct count isn't included by default.
   * <p>
   * You can also run approximate distinct counts which are faster:
   * <p>
   * <pre><code>
   *   ds.summary("count", "approx_count_distinct").show()
   * </code></pre>
   * <p>
   * See also {@link describe} for basic statistics.
   * <p>
   * @param statistics Statistics from above list to be computed.
   * <p>
   * @group action
   * @since 2.3.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> summary (java.lang.String... statistics)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset partitioned by the given partitioning expressions into
   * <code>numPartitions</code>. The resulting Dataset is hash partitioned.
   * <p>
   * This is the same operation as "DISTRIBUTE BY" in SQL (Hive QL).
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param numPartitions (undocumented)
   * @param partitionExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> repartition (int numPartitions, org.apache.spark.sql.Column... partitionExprs)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset partitioned by the given partitioning expressions, using
   * <code>spark.sql.shuffle.partitions</code> as number of partitions.
   * The resulting Dataset is hash partitioned.
   * <p>
   * This is the same operation as "DISTRIBUTE BY" in SQL (Hive QL).
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param partitionExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> repartition (org.apache.spark.sql.Column... partitionExprs)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset partitioned by the given partitioning expressions into
   * <code>numPartitions</code>. The resulting Dataset is range partitioned.
   * <p>
   * At least one partition-by expression must be specified.
   * When no explicit sort order is specified, "ascending nulls first" is assumed.
   * Note, the rows are not sorted in each partition of the resulting Dataset.
   * <p>
   * Note that due to performance reasons this method uses sampling to estimate the ranges.
   * Hence, the output may not be consistent, since sampling can return different values.
   * The sample size can be controlled by the config
   * <code>spark.sql.execution.rangeExchange.sampleSizePerPartition</code>.
   * <p>
   * @group typedrel
   * @since 2.3.0
   * @param numPartitions (undocumented)
   * @param partitionExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> repartitionByRange (int numPartitions, org.apache.spark.sql.Column... partitionExprs)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset partitioned by the given partitioning expressions, using
   * <code>spark.sql.shuffle.partitions</code> as number of partitions.
   * The resulting Dataset is range partitioned.
   * <p>
   * At least one partition-by expression must be specified.
   * When no explicit sort order is specified, "ascending nulls first" is assumed.
   * Note, the rows are not sorted in each partition of the resulting Dataset.
   * <p>
   * Note that due to performance reasons this method uses sampling to estimate the ranges.
   * Hence, the output may not be consistent, since sampling can return different values.
   * The sample size can be controlled by the config
   * <code>spark.sql.execution.rangeExchange.sampleSizePerPartition</code>.
   * <p>
   * @group typedrel
   * @since 2.3.0
   * @param partitionExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> repartitionByRange (org.apache.spark.sql.Column... partitionExprs)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.execution.QueryExecution queryExecution ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Encoder<T> encoder ()  { throw new RuntimeException(); }
  // not preceding
     Dataset (org.apache.spark.sql.execution.QueryExecution queryExecution, org.apache.spark.sql.Encoder<T> encoder)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.SparkSession sparkSession ()  { throw new RuntimeException(); }
  public   Dataset (org.apache.spark.sql.SparkSession sparkSession, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan, org.apache.spark.sql.Encoder<T> encoder)  { throw new RuntimeException(); }
  public   Dataset (org.apache.spark.sql.SQLContext sqlContext, org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan, org.apache.spark.sql.Encoder<T> encoder)  { throw new RuntimeException(); }
    org.apache.spark.sql.catalyst.plans.logical.LogicalPlan logicalPlan ()  { throw new RuntimeException(); }
  /**
   * Currently {@link ExpressionEncoder} is the only implementation of {@link Encoder}, here we turn the
   * passed in encoder to {@link ExpressionEncoder} explicitly, and mark it implicit so that we can use
   * it when constructing new Dataset objects that have the same object type (that will be
   * possibly resolved to a different schema).
   * @return (undocumented)
   */
    org.apache.spark.sql.catalyst.encoders.ExpressionEncoder<T> exprEnc ()  { throw new RuntimeException(); }
  public  scala.reflect.ClassTag<T> classTag ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.SQLContext sqlContext ()  { throw new RuntimeException(); }
    org.apache.spark.sql.catalyst.expressions.NamedExpression resolve (java.lang.String colName)  { throw new RuntimeException(); }
    scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> numericColumns ()  { throw new RuntimeException(); }
  /**
   * Get rows represented in Sequence by specific truncate and vertical requirement.
   * <p>
   * @param numRows Number of rows to return
   * @param truncate If set to more than 0, truncates strings to <code>truncate</code> characters and
   *                   all cells will be aligned right.
   * @return (undocumented)
   */
    scala.collection.Seq<scala.collection.Seq<java.lang.String>> getRows (int numRows, int truncate)  { throw new RuntimeException(); }
  /**
   * Compose the string representing rows for output
   * <p>
   * @param _numRows Number of rows to show
   * @param truncate If set to more than 0, truncates strings to <code>truncate</code> characters and
   *                   all cells will be aligned right.
   * @param vertical If set to true, prints output rows vertically (one line per column value).
   * @return (undocumented)
   */
    java.lang.String showString (int _numRows, int truncate, boolean vertical)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
  /**
   * Converts this strongly typed collection of data to generic Dataframe. In contrast to the
   * strongly typed objects that Dataset operations work on, a Dataframe returns generic {@link Row}
   * objects that allow fields to be accessed by ordinal or name.
   * <p>
   * @group basic
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> toDF ()  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset where each record has been mapped on to the specified type. The
   * method used to map columns depend on the type of <code>U</code>:
   * <ul>
   *   <li>When <code>U</code> is a class, fields for the class will be mapped to columns of the same name
   *   (case sensitivity is determined by <code>spark.sql.caseSensitive</code>).</li>
   *   <li>When <code>U</code> is a tuple, the columns will be mapped by ordinal (i.e. the first column will
   *   be assigned to <code>_1</code>).</li>
   *   <li>When <code>U</code> is a primitive type (i.e. String, Int, etc), then the first column of the
   *   <code>DataFrame</code> will be used.</li>
   * </ul>
   * <p>
   * If the schema of the Dataset does not match the desired <code>U</code> type, you can use <code>select</code>
   * along with <code>alias</code> or <code>as</code> to rearrange or rename as required.
   * <p>
   * Note that <code>as[]</code> only changes the view of the data that is passed into typed operations,
   * such as <code>map()</code>, and does not eagerly project away any columns that are not present in
   * the specified class.
   * <p>
   * @group basic
   * @since 1.6.0
   * @param evidence$2 (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.Dataset<U> as (org.apache.spark.sql.Encoder<U> evidence$2)  { throw new RuntimeException(); }
  /**
   * Converts this strongly typed collection of data to generic <code>DataFrame</code> with columns renamed.
   * This can be quite convenient in conversion from an RDD of tuples into a <code>DataFrame</code> with
   * meaningful names. For example:
   * <pre><code>
   *   val rdd: RDD[(Int, String)] = ...
   *   rdd.toDF()  // this implicit conversion creates a DataFrame with column name `_1` and `_2`
   *   rdd.toDF("id", "name")  // this creates a DataFrame with column name "id" and "name"
   * </code></pre>
   * <p>
   * @group basic
   * @since 2.0.0
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> toDF (scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
  /**
   * Returns the schema of this Dataset.
   * <p>
   * @group basic
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType schema ()  { throw new RuntimeException(); }
  /**
   * Prints the schema to the console in a nice tree format.
   * <p>
   * @group basic
   * @since 1.6.0
   */
  public  void printSchema ()  { throw new RuntimeException(); }
  /**
   * Prints the schema up to the given level to the console in a nice tree format.
   * <p>
   * @group basic
   * @since 3.0.0
   * @param level (undocumented)
   */
  public  void printSchema (int level)  { throw new RuntimeException(); }
  /**
   * Prints the plans (logical and physical) with a format specified by a given explain mode.
   * <p>
   * @param mode specifies the expected output format of plans.
   *             <ul>
   *               <li><code>simple</code> Print only a physical plan.</li>
   *               <li><code>extended</code>: Print both logical and physical plans.</li>
   *               <li><code>codegen</code>: Print a physical plan and generated codes if they are
   *                 available.</li>
   *               <li><code>cost</code>: Print a logical plan and statistics if they are available.</li>
   *               <li><code>formatted</code>: Split explain output into two sections: a physical plan outline
   *                 and node details.</li>
   *             </ul>
   * @group basic
   * @since 3.0.0
   */
  public  void explain (java.lang.String mode)  { throw new RuntimeException(); }
  /**
   * Prints the plans (logical and physical) to the console for debugging purposes.
   * <p>
   * @param extended default <code>false</code>. If <code>false</code>, prints only the physical plan.
   * <p>
   * @group basic
   * @since 1.6.0
   */
  public  void explain (boolean extended)  { throw new RuntimeException(); }
  /**
   * Prints the physical plan to the console for debugging purposes.
   * <p>
   * @group basic
   * @since 1.6.0
   */
  public  void explain ()  { throw new RuntimeException(); }
  /**
   * Returns all column names and their data types as an array.
   * <p>
   * @group basic
   * @since 1.6.0
   * @return (undocumented)
   */
  public  scala.Tuple2<java.lang.String, java.lang.String>[] dtypes ()  { throw new RuntimeException(); }
  /**
   * Returns all column names as an array.
   * <p>
   * @group basic
   * @since 1.6.0
   * @return (undocumented)
   */
  public  java.lang.String[] columns ()  { throw new RuntimeException(); }
  /**
   * Returns true if the <code>collect</code> and <code>take</code> methods can be run locally
   * (without any Spark executors).
   * <p>
   * @group basic
   * @since 1.6.0
   * @return (undocumented)
   */
  public  boolean isLocal ()  { throw new RuntimeException(); }
  /**
   * Returns true if the <code>Dataset</code> is empty.
   * <p>
   * @group basic
   * @since 2.4.0
   * @return (undocumented)
   */
  public  boolean isEmpty ()  { throw new RuntimeException(); }
  /**
   * Returns true if this Dataset contains one or more sources that continuously
   * return data as it arrives. A Dataset that reads data from a streaming source
   * must be executed as a <code>StreamingQuery</code> using the <code>start()</code> method in
   * <code>DataStreamWriter</code>. Methods that return a single answer, e.g. <code>count()</code> or
   * <code>collect()</code>, will throw an {@link AnalysisException} when there is a streaming
   * source present.
   * <p>
   * @group streaming
   * @since 2.0.0
   * @return (undocumented)
   */
  public  boolean isStreaming ()  { throw new RuntimeException(); }
  /**
   * Eagerly checkpoint a Dataset and return the new Dataset. Checkpointing can be used to truncate
   * the logical plan of this Dataset, which is especially useful in iterative algorithms where the
   * plan may grow exponentially. It will be saved to files inside the checkpoint
   * directory set with <code>SparkContext#setCheckpointDir</code>.
   * <p>
   * @group basic
   * @since 2.1.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> checkpoint ()  { throw new RuntimeException(); }
  /**
   * Returns a checkpointed version of this Dataset. Checkpointing can be used to truncate the
   * logical plan of this Dataset, which is especially useful in iterative algorithms where the
   * plan may grow exponentially. It will be saved to files inside the checkpoint
   * directory set with <code>SparkContext#setCheckpointDir</code>.
   * <p>
   * @group basic
   * @since 2.1.0
   * @param eager (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> checkpoint (boolean eager)  { throw new RuntimeException(); }
  /**
   * Eagerly locally checkpoints a Dataset and return the new Dataset. Checkpointing can be
   * used to truncate the logical plan of this Dataset, which is especially useful in iterative
   * algorithms where the plan may grow exponentially. Local checkpoints are written to executor
   * storage and despite potentially faster they are unreliable and may compromise job completion.
   * <p>
   * @group basic
   * @since 2.3.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> localCheckpoint ()  { throw new RuntimeException(); }
  /**
   * Locally checkpoints a Dataset and return the new Dataset. Checkpointing can be used to truncate
   * the logical plan of this Dataset, which is especially useful in iterative algorithms where the
   * plan may grow exponentially. Local checkpoints are written to executor storage and despite
   * potentially faster they are unreliable and may compromise job completion.
   * <p>
   * @group basic
   * @since 2.3.0
   * @param eager (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> localCheckpoint (boolean eager)  { throw new RuntimeException(); }
  /**
   * Defines an event time watermark for this {@link Dataset}. A watermark tracks a point in time
   * before which we assume no more late data is going to arrive.
   * <p>
   * Spark will use this watermark for several purposes:
   * <ul>
   *   <li>To know when a given time window aggregation can be finalized and thus can be emitted
   *   when using output modes that do not allow updates.</li>
   *   <li>To minimize the amount of state that we need to keep for on-going aggregations,
   *    <code>mapGroupsWithState</code> and <code>dropDuplicates</code> operators.</li>
   * </ul>
   *  The current watermark is computed by looking at the <code>MAX(eventTime)</code> seen across
   *  all of the partitions in the query minus a user specified <code>delayThreshold</code>.  Due to the cost
   *  of coordinating this value across partitions, the actual watermark used is only guaranteed
   *  to be at least <code>delayThreshold</code> behind the actual event time.  In some cases we may still
   *  process records that arrive more than <code>delayThreshold</code> late.
   * <p>
   * @param eventTime the name of the column that contains the event time of the row.
   * @param delayThreshold the minimum delay to wait to data to arrive late, relative to the latest
   *                       record that has been processed in the form of an interval
   *                       (e.g. "1 minute" or "5 hours"). NOTE: This should not be negative.
   * <p>
   * @group streaming
   * @since 2.1.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> withWatermark (java.lang.String eventTime, java.lang.String delayThreshold)  { throw new RuntimeException(); }
  /**
   * Displays the Dataset in a tabular form. Strings more than 20 characters will be truncated,
   * and all cells will be aligned right. For example:
   * <pre><code>
   *   year  month AVG('Adj Close) MAX('Adj Close)
   *   1980  12    0.503218        0.595103
   *   1981  01    0.523289        0.570307
   *   1982  02    0.436504        0.475256
   *   1983  03    0.410516        0.442194
   *   1984  04    0.450090        0.483521
   * </code></pre>
   * <p>
   * @param numRows Number of rows to show
   * <p>
   * @group action
   * @since 1.6.0
   */
  public  void show (int numRows)  { throw new RuntimeException(); }
  /**
   * Displays the top 20 rows of Dataset in a tabular form. Strings more than 20 characters
   * will be truncated, and all cells will be aligned right.
   * <p>
   * @group action
   * @since 1.6.0
   */
  public  void show ()  { throw new RuntimeException(); }
  /**
   * Displays the top 20 rows of Dataset in a tabular form.
   * <p>
   * @param truncate Whether truncate long strings. If true, strings more than 20 characters will
   *                 be truncated and all cells will be aligned right
   * <p>
   * @group action
   * @since 1.6.0
   */
  public  void show (boolean truncate)  { throw new RuntimeException(); }
  /**
   * Displays the Dataset in a tabular form. For example:
   * <pre><code>
   *   year  month AVG('Adj Close) MAX('Adj Close)
   *   1980  12    0.503218        0.595103
   *   1981  01    0.523289        0.570307
   *   1982  02    0.436504        0.475256
   *   1983  03    0.410516        0.442194
   *   1984  04    0.450090        0.483521
   * </code></pre>
   * @param numRows Number of rows to show
   * @param truncate Whether truncate long strings. If true, strings more than 20 characters will
   *              be truncated and all cells will be aligned right
   * <p>
   * @group action
   * @since 1.6.0
   */
  public  void show (int numRows, boolean truncate)  { throw new RuntimeException(); }
  /**
   * Displays the Dataset in a tabular form. For example:
   * <pre><code>
   *   year  month AVG('Adj Close) MAX('Adj Close)
   *   1980  12    0.503218        0.595103
   *   1981  01    0.523289        0.570307
   *   1982  02    0.436504        0.475256
   *   1983  03    0.410516        0.442194
   *   1984  04    0.450090        0.483521
   * </code></pre>
   * <p>
   * @param numRows Number of rows to show
   * @param truncate If set to more than 0, truncates strings to <code>truncate</code> characters and
   *                    all cells will be aligned right.
   * @group action
   * @since 1.6.0
   */
  public  void show (int numRows, int truncate)  { throw new RuntimeException(); }
  /**
   * Displays the Dataset in a tabular form. For example:
   * <pre><code>
   *   year  month AVG('Adj Close) MAX('Adj Close)
   *   1980  12    0.503218        0.595103
   *   1981  01    0.523289        0.570307
   *   1982  02    0.436504        0.475256
   *   1983  03    0.410516        0.442194
   *   1984  04    0.450090        0.483521
   * </code></pre>
   * <p>
   * If <code>vertical</code> enabled, this command prints output rows vertically (one line per column value)?
   * <p>
   * <pre><code>
   * -RECORD 0-------------------
   *  year            | 1980
   *  month           | 12
   *  AVG('Adj Close) | 0.503218
   *  AVG('Adj Close) | 0.595103
   * -RECORD 1-------------------
   *  year            | 1981
   *  month           | 01
   *  AVG('Adj Close) | 0.523289
   *  AVG('Adj Close) | 0.570307
   * -RECORD 2-------------------
   *  year            | 1982
   *  month           | 02
   *  AVG('Adj Close) | 0.436504
   *  AVG('Adj Close) | 0.475256
   * -RECORD 3-------------------
   *  year            | 1983
   *  month           | 03
   *  AVG('Adj Close) | 0.410516
   *  AVG('Adj Close) | 0.442194
   * -RECORD 4-------------------
   *  year            | 1984
   *  month           | 04
   *  AVG('Adj Close) | 0.450090
   *  AVG('Adj Close) | 0.483521
   * </code></pre>
   * <p>
   * @param numRows Number of rows to show
   * @param truncate If set to more than 0, truncates strings to <code>truncate</code> characters and
   *                    all cells will be aligned right.
   * @param vertical If set to true, prints output rows vertically (one line per column value).
   * @group action
   * @since 2.3.0
   */
  public  void show (int numRows, int truncate, boolean vertical)  { throw new RuntimeException(); }
  /**
   * Returns a {@link DataFrameNaFunctions} for working with missing data.
   * <pre><code>
   *   // Dropping rows containing any null values.
   *   ds.na.drop()
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameNaFunctions na ()  { throw new RuntimeException(); }
  /**
   * Returns a {@link DataFrameStatFunctions} for working statistic functions support.
   * <pre><code>
   *   // Finding frequent items in column with name 'a'.
   *   ds.stat.freqItems(Seq("a"))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameStatFunctions stat ()  { throw new RuntimeException(); }
  /**
   * Join with another <code>DataFrame</code>.
   * <p>
   * Behaves as an INNER JOIN and requires a subsequent join predicate.
   * <p>
   * @param right Right side of the join operation.
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> join (org.apache.spark.sql.Dataset<?> right)  { throw new RuntimeException(); }
  /**
   * Inner equi-join with another <code>DataFrame</code> using the given column.
   * <p>
   * Different from other join functions, the join column will only appear once in the output,
   * i.e. similar to SQL's <code>JOIN USING</code> syntax.
   * <p>
   * <pre><code>
   *   // Joining df1 and df2 using the column "user_id"
   *   df1.join(df2, "user_id")
   * </code></pre>
   * <p>
   * @param right Right side of the join operation.
   * @param usingColumn Name of the column to join on. This column must exist on both sides.
   * <p>
   * @note If you perform a self-join using this function without aliasing the input
   * <code>DataFrame</code>s, you will NOT be able to reference any columns after the join, since
   * there is no way to disambiguate which side of the join you would like to reference.
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> join (org.apache.spark.sql.Dataset<?> right, java.lang.String usingColumn)  { throw new RuntimeException(); }
  /**
   * Inner equi-join with another <code>DataFrame</code> using the given columns.
   * <p>
   * Different from other join functions, the join columns will only appear once in the output,
   * i.e. similar to SQL's <code>JOIN USING</code> syntax.
   * <p>
   * <pre><code>
   *   // Joining df1 and df2 using the columns "user_id" and "user_name"
   *   df1.join(df2, Seq("user_id", "user_name"))
   * </code></pre>
   * <p>
   * @param right Right side of the join operation.
   * @param usingColumns Names of the columns to join on. This columns must exist on both sides.
   * <p>
   * @note If you perform a self-join using this function without aliasing the input
   * <code>DataFrame</code>s, you will NOT be able to reference any columns after the join, since
   * there is no way to disambiguate which side of the join you would like to reference.
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> join (org.apache.spark.sql.Dataset<?> right, scala.collection.Seq<java.lang.String> usingColumns)  { throw new RuntimeException(); }
  /**
   * Equi-join with another <code>DataFrame</code> using the given columns. A cross join with a predicate
   * is specified as an inner join. If you would explicitly like to perform a cross join use the
   * <code>crossJoin</code> method.
   * <p>
   * Different from other join functions, the join columns will only appear once in the output,
   * i.e. similar to SQL's <code>JOIN USING</code> syntax.
   * <p>
   * @param right Right side of the join operation.
   * @param usingColumns Names of the columns to join on. This columns must exist on both sides.
   * @param joinType Type of join to perform. Default <code>inner</code>. Must be one of:
   *                 <code>inner</code>, <code>cross</code>, <code>outer</code>, <code>full</code>, <code>fullouter</code>, <code>full_outer</code>, <code>left</code>,
   *                 <code>leftouter</code>, <code>left_outer</code>, <code>right</code>, <code>rightouter</code>, <code>right_outer</code>,
   *                 <code>semi</code>, <code>leftsemi</code>, <code>left_semi</code>, <code>anti</code>, <code>leftanti</code>, left_anti<code>.</code>
   * <p>
   * @note If you perform a self-join using this function without aliasing the input
   * <code>DataFrame</code>s, you will NOT be able to reference any columns after the join, since
   * there is no way to disambiguate which side of the join you would like to reference.
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> join (org.apache.spark.sql.Dataset<?> right, scala.collection.Seq<java.lang.String> usingColumns, java.lang.String joinType)  { throw new RuntimeException(); }
  /**
   * Inner join with another <code>DataFrame</code>, using the given join expression.
   * <p>
   * <pre><code>
   *   // The following two are equivalent:
   *   df1.join(df2, $"df1Key" === $"df2Key")
   *   df1.join(df2).where($"df1Key" === $"df2Key")
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param right (undocumented)
   * @param joinExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> join (org.apache.spark.sql.Dataset<?> right, org.apache.spark.sql.Column joinExprs)  { throw new RuntimeException(); }
  /**
   * Join with another <code>DataFrame</code>, using the given join expression. The following performs
   * a full outer join between <code>df1</code> and <code>df2</code>.
   * <p>
   * <pre><code>
   *   // Scala:
   *   import org.apache.spark.sql.functions._
   *   df1.join(df2, $"df1Key" === $"df2Key", "outer")
   *
   *   // Java:
   *   import static org.apache.spark.sql.functions.*;
   *   df1.join(df2, col("df1Key").equalTo(col("df2Key")), "outer");
   * </code></pre>
   * <p>
   * @param right Right side of the join.
   * @param joinExprs Join expression.
   * @param joinType Type of join to perform. Default <code>inner</code>. Must be one of:
   *                 <code>inner</code>, <code>cross</code>, <code>outer</code>, <code>full</code>, <code>fullouter</code>, <code>full_outer</code>, <code>left</code>,
   *                 <code>leftouter</code>, <code>left_outer</code>, <code>right</code>, <code>rightouter</code>, <code>right_outer</code>,
   *                 <code>semi</code>, <code>leftsemi</code>, <code>left_semi</code>, <code>anti</code>, <code>leftanti</code>, left_anti<code>.</code>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> join (org.apache.spark.sql.Dataset<?> right, org.apache.spark.sql.Column joinExprs, java.lang.String joinType)  { throw new RuntimeException(); }
  /**
   * Explicit cartesian join with another <code>DataFrame</code>.
   * <p>
   * @param right Right side of the join operation.
   * <p>
   * @note Cartesian joins are very expensive without an extra filter that can be pushed down.
   * <p>
   * @group untypedrel
   * @since 2.1.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> crossJoin (org.apache.spark.sql.Dataset<?> right)  { throw new RuntimeException(); }
  /**
   * Joins this Dataset returning a <code>Tuple2</code> for each pair where <code>condition</code> evaluates to
   * true.
   * <p>
   * This is similar to the relation <code>join</code> function with one important difference in the
   * result schema. Since <code>joinWith</code> preserves objects present on either side of the join, the
   * result schema is similarly nested into a tuple under the column names <code>_1</code> and <code>_2</code>.
   * <p>
   * This type of join can be useful both for preserving type-safety with the original object
   * types as well as working with relational data where either side of the join has column
   * names in common.
   * <p>
   * @param other Right side of the join.
   * @param condition Join expression.
   * @param joinType Type of join to perform. Default <code>inner</code>. Must be one of:
   *                 <code>inner</code>, <code>cross</code>, <code>outer</code>, <code>full</code>, <code>fullouter</code>,<code>full_outer</code>, <code>left</code>,
   *                 <code>leftouter</code>, <code>left_outer</code>, <code>right</code>, <code>rightouter</code>, <code>right_outer</code>.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.Dataset<scala.Tuple2<T, U>> joinWith (org.apache.spark.sql.Dataset<U> other, org.apache.spark.sql.Column condition, java.lang.String joinType)  { throw new RuntimeException(); }
  /**
   * Using inner equi-join to join this Dataset returning a <code>Tuple2</code> for each pair
   * where <code>condition</code> evaluates to true.
   * <p>
   * @param other Right side of the join.
   * @param condition Join expression.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.Dataset<scala.Tuple2<T, U>> joinWith (org.apache.spark.sql.Dataset<U> other, org.apache.spark.sql.Column condition)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset with each partition sorted by the given expressions.
   * <p>
   * This is the same operation as "SORT BY" in SQL (Hive QL).
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param sortCol (undocumented)
   * @param sortCols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> sortWithinPartitions (java.lang.String sortCol, scala.collection.Seq<java.lang.String> sortCols)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset with each partition sorted by the given expressions.
   * <p>
   * This is the same operation as "SORT BY" in SQL (Hive QL).
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param sortExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> sortWithinPartitions (scala.collection.Seq<org.apache.spark.sql.Column> sortExprs)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset sorted by the specified column, all in ascending order.
   * <pre><code>
   *   // The following 3 are equivalent
   *   ds.sort("sortcol")
   *   ds.sort($"sortcol")
   *   ds.sort($"sortcol".asc)
   * </code></pre>
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param sortCol (undocumented)
   * @param sortCols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> sort (java.lang.String sortCol, scala.collection.Seq<java.lang.String> sortCols)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset sorted by the given expressions. For example:
   * <pre><code>
   *   ds.sort($"col1", $"col2".desc)
   * </code></pre>
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param sortExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> sort (scala.collection.Seq<org.apache.spark.sql.Column> sortExprs)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset sorted by the given expressions.
   * This is an alias of the <code>sort</code> function.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param sortCol (undocumented)
   * @param sortCols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> orderBy (java.lang.String sortCol, scala.collection.Seq<java.lang.String> sortCols)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset sorted by the given expressions.
   * This is an alias of the <code>sort</code> function.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param sortExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> orderBy (scala.collection.Seq<org.apache.spark.sql.Column> sortExprs)  { throw new RuntimeException(); }
  /**
   * Selects column based on the column name and returns it as a {@link Column}.
   * <p>
   * @note The column name can also reference to a nested column like <code>a.b</code>.
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param colName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column apply (java.lang.String colName)  { throw new RuntimeException(); }
  /**
   * Specifies some hint on the current Dataset. As an example, the following code specifies
   * that one of the plan can be broadcasted:
   * <p>
   * <pre><code>
   *   df1.join(df2.hint("broadcast"))
   * </code></pre>
   * <p>
   * @group basic
   * @since 2.2.0
   * @param name (undocumented)
   * @param parameters (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> hint (java.lang.String name, scala.collection.Seq<java.lang.Object> parameters)  { throw new RuntimeException(); }
  /**
   * Selects column based on the column name and returns it as a {@link Column}.
   * <p>
   * @note The column name can also reference to a nested column like <code>a.b</code>.
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param colName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column col (java.lang.String colName)  { throw new RuntimeException(); }
  /**
   * Selects column based on the column name specified as a regex and returns it as {@link Column}.
   * @group untypedrel
   * @since 2.3.0
   * @param colName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Column colRegex (java.lang.String colName)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset with an alias set.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param alias (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> as (java.lang.String alias)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Returns a new Dataset with an alias set.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param alias (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> as (scala.Symbol alias)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset with an alias set. Same as <code>as</code>.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param alias (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> alias (java.lang.String alias)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Returns a new Dataset with an alias set. Same as <code>as</code>.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param alias (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> alias (scala.Symbol alias)  { throw new RuntimeException(); }
  /**
   * Selects a set of column based expressions.
   * <pre><code>
   *   ds.select($"colA", $"colB" + 1)
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> select (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Selects a set of columns. This is a variant of <code>select</code> that can only select
   * existing columns using column names (i.e. cannot construct expressions).
   * <p>
   * <pre><code>
   *   // The following two are equivalent:
   *   ds.select("colA", "colB")
   *   ds.select($"colA", $"colB")
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param col (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> select (java.lang.String col, scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /**
   * Selects a set of SQL expressions. This is a variant of <code>select</code> that accepts
   * SQL expressions.
   * <p>
   * <pre><code>
   *   // The following are equivalent:
   *   ds.selectExpr("colA", "colB as newName", "abs(colC)")
   *   ds.select(expr("colA"), expr("colB as newName"), expr("abs(colC)"))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> selectExpr (scala.collection.Seq<java.lang.String> exprs)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset by computing the given {@link Column} expression for each element.
   * <p>
   * <pre><code>
   *   val ds = Seq(1, 2, 3).toDS()
   *   val newDS = ds.select(expr("value + 1").as[Int])
   * </code></pre>
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param c1 (undocumented)
   * @return (undocumented)
   */
  public <U1 extends java.lang.Object> org.apache.spark.sql.Dataset<U1> select (org.apache.spark.sql.TypedColumn<T, U1> c1)  { throw new RuntimeException(); }
  /**
   * Internal helper function for building typed selects that return tuples. For simplicity and
   * code reuse, we do this without the help of the type system and then use helper functions
   * that cast appropriately for the user facing interface.
   * @param columns (undocumented)
   * @return (undocumented)
   */
  protected  org.apache.spark.sql.Dataset<?> selectUntyped (scala.collection.Seq<org.apache.spark.sql.TypedColumn<?, ?>> columns)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset by computing the given {@link Column} expressions for each element.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param c1 (undocumented)
   * @param c2 (undocumented)
   * @return (undocumented)
   */
  public <U1 extends java.lang.Object, U2 extends java.lang.Object> org.apache.spark.sql.Dataset<scala.Tuple2<U1, U2>> select (org.apache.spark.sql.TypedColumn<T, U1> c1, org.apache.spark.sql.TypedColumn<T, U2> c2)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset by computing the given {@link Column} expressions for each element.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param c1 (undocumented)
   * @param c2 (undocumented)
   * @param c3 (undocumented)
   * @return (undocumented)
   */
  public <U1 extends java.lang.Object, U2 extends java.lang.Object, U3 extends java.lang.Object> org.apache.spark.sql.Dataset<scala.Tuple3<U1, U2, U3>> select (org.apache.spark.sql.TypedColumn<T, U1> c1, org.apache.spark.sql.TypedColumn<T, U2> c2, org.apache.spark.sql.TypedColumn<T, U3> c3)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset by computing the given {@link Column} expressions for each element.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param c1 (undocumented)
   * @param c2 (undocumented)
   * @param c3 (undocumented)
   * @param c4 (undocumented)
   * @return (undocumented)
   */
  public <U1 extends java.lang.Object, U2 extends java.lang.Object, U3 extends java.lang.Object, U4 extends java.lang.Object> org.apache.spark.sql.Dataset<scala.Tuple4<U1, U2, U3, U4>> select (org.apache.spark.sql.TypedColumn<T, U1> c1, org.apache.spark.sql.TypedColumn<T, U2> c2, org.apache.spark.sql.TypedColumn<T, U3> c3, org.apache.spark.sql.TypedColumn<T, U4> c4)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset by computing the given {@link Column} expressions for each element.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param c1 (undocumented)
   * @param c2 (undocumented)
   * @param c3 (undocumented)
   * @param c4 (undocumented)
   * @param c5 (undocumented)
   * @return (undocumented)
   */
  public <U1 extends java.lang.Object, U2 extends java.lang.Object, U3 extends java.lang.Object, U4 extends java.lang.Object, U5 extends java.lang.Object> org.apache.spark.sql.Dataset<scala.Tuple5<U1, U2, U3, U4, U5>> select (org.apache.spark.sql.TypedColumn<T, U1> c1, org.apache.spark.sql.TypedColumn<T, U2> c2, org.apache.spark.sql.TypedColumn<T, U3> c3, org.apache.spark.sql.TypedColumn<T, U4> c4, org.apache.spark.sql.TypedColumn<T, U5> c5)  { throw new RuntimeException(); }
  /**
   * Filters rows using the given condition.
   * <pre><code>
   *   // The following are equivalent:
   *   peopleDs.filter($"age" &gt; 15)
   *   peopleDs.where($"age" &gt; 15)
   * </code></pre>
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param condition (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> filter (org.apache.spark.sql.Column condition)  { throw new RuntimeException(); }
  /**
   * Filters rows using the given SQL expression.
   * <pre><code>
   *   peopleDs.filter("age &gt; 15")
   * </code></pre>
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param conditionExpr (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> filter (java.lang.String conditionExpr)  { throw new RuntimeException(); }
  /**
   * Filters rows using the given condition. This is an alias for <code>filter</code>.
   * <pre><code>
   *   // The following are equivalent:
   *   peopleDs.filter($"age" &gt; 15)
   *   peopleDs.where($"age" &gt; 15)
   * </code></pre>
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param condition (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> where (org.apache.spark.sql.Column condition)  { throw new RuntimeException(); }
  /**
   * Filters rows using the given SQL expression.
   * <pre><code>
   *   peopleDs.where("age &gt; 15")
   * </code></pre>
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param conditionExpr (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> where (java.lang.String conditionExpr)  { throw new RuntimeException(); }
  /**
   * Groups the Dataset using the specified columns, so we can run aggregation on them. See
   * {@link RelationalGroupedDataset} for all the available aggregate functions.
   * <p>
   * <pre><code>
   *   // Compute the average for all numeric columns grouped by department.
   *   ds.groupBy($"department").avg()
   *
   *   // Compute the max age and average salary, grouped by department and gender.
   *   ds.groupBy($"department", $"gender").agg(Map(
   *     "salary" -&gt; "avg",
   *     "age" -&gt; "max"
   *   ))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.RelationalGroupedDataset groupBy (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Create a multi-dimensional rollup for the current Dataset using the specified columns,
   * so we can run aggregation on them.
   * See {@link RelationalGroupedDataset} for all the available aggregate functions.
   * <p>
   * <pre><code>
   *   // Compute the average for all numeric columns rolled up by department and group.
   *   ds.rollup($"department", $"group").avg()
   *
   *   // Compute the max age and average salary, rolled up by department and gender.
   *   ds.rollup($"department", $"gender").agg(Map(
   *     "salary" -&gt; "avg",
   *     "age" -&gt; "max"
   *   ))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.RelationalGroupedDataset rollup (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Create a multi-dimensional cube for the current Dataset using the specified columns,
   * so we can run aggregation on them.
   * See {@link RelationalGroupedDataset} for all the available aggregate functions.
   * <p>
   * <pre><code>
   *   // Compute the average for all numeric columns cubed by department and group.
   *   ds.cube($"department", $"group").avg()
   *
   *   // Compute the max age and average salary, cubed by department and gender.
   *   ds.cube($"department", $"gender").agg(Map(
   *     "salary" -&gt; "avg",
   *     "age" -&gt; "max"
   *   ))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.RelationalGroupedDataset cube (scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Groups the Dataset using the specified columns, so that we can run aggregation on them.
   * See {@link RelationalGroupedDataset} for all the available aggregate functions.
   * <p>
   * This is a variant of groupBy that can only group by existing columns using column names
   * (i.e. cannot construct expressions).
   * <p>
   * <pre><code>
   *   // Compute the average for all numeric columns grouped by department.
   *   ds.groupBy("department").avg()
   *
   *   // Compute the max age and average salary, grouped by department and gender.
   *   ds.groupBy($"department", $"gender").agg(Map(
   *     "salary" -&gt; "avg",
   *     "age" -&gt; "max"
   *   ))
   * </code></pre>
   * @group untypedrel
   * @since 2.0.0
   * @param col1 (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.RelationalGroupedDataset groupBy (java.lang.String col1, scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Reduces the elements of this Dataset using the specified binary function. The given <code>func</code>
   * must be commutative and associative or the result may be non-deterministic.
   * <p>
   * @group action
   * @since 1.6.0
   * @param func (undocumented)
   * @return (undocumented)
   */
  public  T reduce (scala.Function2<T, T, T> func)  { throw new RuntimeException(); }
  /**
   * (Java-specific)
   * Reduces the elements of this Dataset using the specified binary function. The given <code>func</code>
   * must be commutative and associative or the result may be non-deterministic.
   * <p>
   * @group action
   * @since 1.6.0
   * @param func (undocumented)
   * @return (undocumented)
   */
  public  T reduce (org.apache.spark.api.java.function.ReduceFunction<T> func)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Returns a {@link KeyValueGroupedDataset} where the data is grouped by the given key <code>func</code>.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param func (undocumented)
   * @param evidence$3 (undocumented)
   * @return (undocumented)
   */
  public <K extends java.lang.Object> org.apache.spark.sql.KeyValueGroupedDataset<K, T> groupByKey (scala.Function1<T, K> func, org.apache.spark.sql.Encoder<K> evidence$3)  { throw new RuntimeException(); }
  /**
   * (Java-specific)
   * Returns a {@link KeyValueGroupedDataset} where the data is grouped by the given key <code>func</code>.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param func (undocumented)
   * @param encoder (undocumented)
   * @return (undocumented)
   */
  public <K extends java.lang.Object> org.apache.spark.sql.KeyValueGroupedDataset<K, T> groupByKey (org.apache.spark.api.java.function.MapFunction<T, K> func, org.apache.spark.sql.Encoder<K> encoder)  { throw new RuntimeException(); }
  /**
   * Create a multi-dimensional rollup for the current Dataset using the specified columns,
   * so we can run aggregation on them.
   * See {@link RelationalGroupedDataset} for all the available aggregate functions.
   * <p>
   * This is a variant of rollup that can only group by existing columns using column names
   * (i.e. cannot construct expressions).
   * <p>
   * <pre><code>
   *   // Compute the average for all numeric columns rolled up by department and group.
   *   ds.rollup("department", "group").avg()
   *
   *   // Compute the max age and average salary, rolled up by department and gender.
   *   ds.rollup($"department", $"gender").agg(Map(
   *     "salary" -&gt; "avg",
   *     "age" -&gt; "max"
   *   ))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param col1 (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.RelationalGroupedDataset rollup (java.lang.String col1, scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /**
   * Create a multi-dimensional cube for the current Dataset using the specified columns,
   * so we can run aggregation on them.
   * See {@link RelationalGroupedDataset} for all the available aggregate functions.
   * <p>
   * This is a variant of cube that can only group by existing columns using column names
   * (i.e. cannot construct expressions).
   * <p>
   * <pre><code>
   *   // Compute the average for all numeric columns cubed by department and group.
   *   ds.cube("department", "group").avg()
   *
   *   // Compute the max age and average salary, cubed by department and gender.
   *   ds.cube($"department", $"gender").agg(Map(
   *     "salary" -&gt; "avg",
   *     "age" -&gt; "max"
   *   ))
   * </code></pre>
   * @group untypedrel
   * @since 2.0.0
   * @param col1 (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.RelationalGroupedDataset cube (java.lang.String col1, scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Aggregates on the entire Dataset without groups.
   * <pre><code>
   *   // ds.agg(...) is a shorthand for ds.groupBy().agg(...)
   *   ds.agg("age" -&gt; "max", "salary" -&gt; "avg")
   *   ds.groupBy().agg("age" -&gt; "max", "salary" -&gt; "avg")
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param aggExpr (undocumented)
   * @param aggExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> agg (scala.Tuple2<java.lang.String, java.lang.String> aggExpr, scala.collection.Seq<scala.Tuple2<java.lang.String, java.lang.String>> aggExprs)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Aggregates on the entire Dataset without groups.
   * <pre><code>
   *   // ds.agg(...) is a shorthand for ds.groupBy().agg(...)
   *   ds.agg(Map("age" -&gt; "max", "salary" -&gt; "avg"))
   *   ds.groupBy().agg(Map("age" -&gt; "max", "salary" -&gt; "avg"))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> agg (scala.collection.immutable.Map<java.lang.String, java.lang.String> exprs)  { throw new RuntimeException(); }
  /**
   * (Java-specific) Aggregates on the entire Dataset without groups.
   * <pre><code>
   *   // ds.agg(...) is a shorthand for ds.groupBy().agg(...)
   *   ds.agg(Map("age" -&gt; "max", "salary" -&gt; "avg"))
   *   ds.groupBy().agg(Map("age" -&gt; "max", "salary" -&gt; "avg"))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> agg (java.util.Map<java.lang.String, java.lang.String> exprs)  { throw new RuntimeException(); }
  /**
   * Aggregates on the entire Dataset without groups.
   * <pre><code>
   *   // ds.agg(...) is a shorthand for ds.groupBy().agg(...)
   *   ds.agg(max($"age"), avg($"salary"))
   *   ds.groupBy().agg(max($"age"), avg($"salary"))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param expr (undocumented)
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> agg (org.apache.spark.sql.Column expr, scala.collection.Seq<org.apache.spark.sql.Column> exprs)  { throw new RuntimeException(); }
  /**
   * Define (named) metrics to observe on the Dataset. This method returns an 'observed' Dataset
   * that returns the same result as the input, with the following guarantees:
   * <ul>
   *   <li>It will compute the defined aggregates (metrics) on all the data that is flowing through
   *   the Dataset at that point.</li>
   *   <li>It will report the value of the defined aggregate columns as soon as we reach a completion
   *   point. A completion point is either the end of a query (batch mode) or the end of a streaming
   *   epoch. The value of the aggregates only reflects the data processed since the previous
   *   completion point.</li>
   * </ul>
   * Please note that continuous execution is currently not supported.
   * <p>
   * The metrics columns must either contain a literal (e.g. lit(42)), or should contain one or
   * more aggregate functions (e.g. sum(a) or sum(a + b) + avg(c) - lit(1)). Expressions that
   * contain references to the input Dataset's columns must always be wrapped in an aggregate
   * function.
   * <p>
   * A user can observe these metrics by either adding
   * {@link org.apache.spark.sql.streaming.StreamingQueryListener} or a
   * {@link org.apache.spark.sql.util.QueryExecutionListener} to the spark session.
   * <p>
   * <pre><code>
   *   // Monitor the metrics using a listener.
   *   spark.streams.addListener(new StreamingQueryListener() {
   *     override def onQueryProgress(event: QueryProgressEvent): Unit = {
   *       event.progress.observedMetrics.asScala.get("my_event").foreach { row =&gt;
   *         // Trigger if the number of errors exceeds 5 percent
   *         val num_rows = row.getAs[Long]("rc")
   *         val num_error_rows = row.getAs[Long]("erc")
   *         val ratio = num_error_rows.toDouble / num_rows
   *         if (ratio &gt; 0.05) {
   *           // Trigger alert
   *         }
   *       }
   *     }
   *     def onQueryStarted(event: QueryStartedEvent): Unit = {}
   *     def onQueryTerminated(event: QueryTerminatedEvent): Unit = {}
   *   })
   *   // Observe row count (rc) and error row count (erc) in the streaming Dataset
   *   val observed_ds = ds.observe("my_event", count(lit(1)).as("rc"), count($"error").as("erc"))
   *   observed_ds.writeStream.format("...").start()
   * </code></pre>
   * <p>
   * @group typedrel
   * @since 3.0.0
   * @param name (undocumented)
   * @param expr (undocumented)
   * @param exprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> observe (java.lang.String name, org.apache.spark.sql.Column expr, scala.collection.Seq<org.apache.spark.sql.Column> exprs)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset by taking the first <code>n</code> rows. The difference between this function
   * and <code>head</code> is that <code>head</code> is an action and returns an array (by triggering query execution)
   * while <code>limit</code> returns a new Dataset.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param n (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> limit (int n)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset containing union of rows in this Dataset and another Dataset.
   * <p>
   * This is equivalent to <code>UNION ALL</code> in SQL. To do a SQL-style set union (that does
   * deduplication of elements), use this function followed by a {@link distinct}.
   * <p>
   * Also as standard in SQL, this function resolves columns by position (not by name):
   * <p>
   * <pre><code>
   *   val df1 = Seq((1, 2, 3)).toDF("col0", "col1", "col2")
   *   val df2 = Seq((4, 5, 6)).toDF("col1", "col2", "col0")
   *   df1.union(df2).show
   *
   *   // output:
   *   // +----+----+----+
   *   // |col0|col1|col2|
   *   // +----+----+----+
   *   // |   1|   2|   3|
   *   // |   4|   5|   6|
   *   // +----+----+----+
   * </code></pre>
   * <p>
   * Notice that the column positions in the schema aren't necessarily matched with the
   * fields in the strongly typed objects in a Dataset. This function resolves columns
   * by their positions in the schema, not the fields in the strongly typed objects. Use
   * {@link unionByName} to resolve columns by field name in the typed objects.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> union (org.apache.spark.sql.Dataset<T> other)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset containing union of rows in this Dataset and another Dataset.
   * This is an alias for <code>union</code>.
   * <p>
   * This is equivalent to <code>UNION ALL</code> in SQL. To do a SQL-style set union (that does
   * deduplication of elements), use this function followed by a {@link distinct}.
   * <p>
   * Also as standard in SQL, this function resolves columns by position (not by name).
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> unionAll (org.apache.spark.sql.Dataset<T> other)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset containing union of rows in this Dataset and another Dataset.
   * <p>
   * This is different from both <code>UNION ALL</code> and <code>UNION DISTINCT</code> in SQL. To do a SQL-style set
   * union (that does deduplication of elements), use this function followed by a {@link distinct}.
   * <p>
   * The difference between this function and {@link union} is that this function
   * resolves columns by name (not by position):
   * <p>
   * <pre><code>
   *   val df1 = Seq((1, 2, 3)).toDF("col0", "col1", "col2")
   *   val df2 = Seq((4, 5, 6)).toDF("col1", "col2", "col0")
   *   df1.unionByName(df2).show
   *
   *   // output:
   *   // +----+----+----+
   *   // |col0|col1|col2|
   *   // +----+----+----+
   *   // |   1|   2|   3|
   *   // |   6|   4|   5|
   *   // +----+----+----+
   * </code></pre>
   * <p>
   * @group typedrel
   * @since 2.3.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> unionByName (org.apache.spark.sql.Dataset<T> other)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset containing union of rows in this Dataset and another Dataset.
   * <p>
   * The difference between this function and {@link union} is that this function
   * resolves columns by name (not by position).
   * <p>
   * When the parameter <code>allowMissingColumns</code> is <code>true</code>, the set of column names
   * in this and other <code>Dataset</code> can differ; missing columns will be filled with null.
   * Further, the missing columns of this <code>Dataset</code> will be added at the end
   * in the schema of the union result:
   * <p>
   * <pre><code>
   *   val df1 = Seq((1, 2, 3)).toDF("col0", "col1", "col2")
   *   val df2 = Seq((4, 5, 6)).toDF("col1", "col0", "col3")
   *   df1.unionByName(df2, true).show
   *
   *   // output: "col3" is missing at left df1 and added at the end of schema.
   *   // +----+----+----+----+
   *   // |col0|col1|col2|col3|
   *   // +----+----+----+----+
   *   // |   1|   2|   3|null|
   *   // |   5|   4|null|   6|
   *   // +----+----+----+----+
   *
   *   df2.unionByName(df1, true).show
   *
   *   // output: "col2" is missing at left df2 and added at the end of schema.
   *   // +----+----+----+----+
   *   // |col1|col0|col3|col2|
   *   // +----+----+----+----+
   *   // |   4|   5|   6|null|
   *   // |   2|   1|null|   3|
   *   // +----+----+----+----+
   * </code></pre>
   * <p>
   * Note that <code>allowMissingColumns</code> supports nested column in struct types. Missing nested columns
   * of struct columns with same name will also be filled with null values. This currently does not
   * support nested columns in array and map types. Note that if there is any missing nested columns
   * to be filled, in order to make consistent schema between two sides of union, the nested fields
   * of structs will be sorted after merging schema.
   * <p>
   * @group typedrel
   * @since 3.1.0
   * @param other (undocumented)
   * @param allowMissingColumns (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> unionByName (org.apache.spark.sql.Dataset<T> other, boolean allowMissingColumns)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset containing rows only in both this Dataset and another Dataset.
   * This is equivalent to <code>INTERSECT</code> in SQL.
   * <p>
   * @note Equality checking is performed directly on the encoded representation of the data
   * and thus is not affected by a custom <code>equals</code> function defined on <code>T</code>.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> intersect (org.apache.spark.sql.Dataset<T> other)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset containing rows only in both this Dataset and another Dataset while
   * preserving the duplicates.
   * This is equivalent to <code>INTERSECT ALL</code> in SQL.
   * <p>
   * @note Equality checking is performed directly on the encoded representation of the data
   * and thus is not affected by a custom <code>equals</code> function defined on <code>T</code>. Also as standard
   * in SQL, this function resolves columns by position (not by name).
   * <p>
   * @group typedrel
   * @since 2.4.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> intersectAll (org.apache.spark.sql.Dataset<T> other)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset containing rows in this Dataset but not in another Dataset.
   * This is equivalent to <code>EXCEPT DISTINCT</code> in SQL.
   * <p>
   * @note Equality checking is performed directly on the encoded representation of the data
   * and thus is not affected by a custom <code>equals</code> function defined on <code>T</code>.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> except (org.apache.spark.sql.Dataset<T> other)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset containing rows in this Dataset but not in another Dataset while
   * preserving the duplicates.
   * This is equivalent to <code>EXCEPT ALL</code> in SQL.
   * <p>
   * @note Equality checking is performed directly on the encoded representation of the data
   * and thus is not affected by a custom <code>equals</code> function defined on <code>T</code>. Also as standard in
   * SQL, this function resolves columns by position (not by name).
   * <p>
   * @group typedrel
   * @since 2.4.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> exceptAll (org.apache.spark.sql.Dataset<T> other)  { throw new RuntimeException(); }
  /**
   * Returns a new {@link Dataset} by sampling a fraction of rows (without replacement),
   * using a user-supplied seed.
   * <p>
   * @param fraction Fraction of rows to generate, range [0.0, 1.0].
   * @param seed Seed for sampling.
   * <p>
   * @note This is NOT guaranteed to provide exactly the fraction of the count
   * of the given {@link Dataset}.
   * <p>
   * @group typedrel
   * @since 2.3.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> sample (double fraction, long seed)  { throw new RuntimeException(); }
  /**
   * Returns a new {@link Dataset} by sampling a fraction of rows (without replacement),
   * using a random seed.
   * <p>
   * @param fraction Fraction of rows to generate, range [0.0, 1.0].
   * <p>
   * @note This is NOT guaranteed to provide exactly the fraction of the count
   * of the given {@link Dataset}.
   * <p>
   * @group typedrel
   * @since 2.3.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> sample (double fraction)  { throw new RuntimeException(); }
  /**
   * Returns a new {@link Dataset} by sampling a fraction of rows, using a user-supplied seed.
   * <p>
   * @param withReplacement Sample with replacement or not.
   * @param fraction Fraction of rows to generate, range [0.0, 1.0].
   * @param seed Seed for sampling.
   * <p>
   * @note This is NOT guaranteed to provide exactly the fraction of the count
   * of the given {@link Dataset}.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> sample (boolean withReplacement, double fraction, long seed)  { throw new RuntimeException(); }
  /**
   * Returns a new {@link Dataset} by sampling a fraction of rows, using a random seed.
   * <p>
   * @param withReplacement Sample with replacement or not.
   * @param fraction Fraction of rows to generate, range [0.0, 1.0].
   * <p>
   * @note This is NOT guaranteed to provide exactly the fraction of the total count
   * of the given {@link Dataset}.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> sample (boolean withReplacement, double fraction)  { throw new RuntimeException(); }
  /**
   * Randomly splits this Dataset with the provided weights.
   * <p>
   * @param weights weights for splits, will be normalized if they don't sum to 1.
   * @param seed Seed for sampling.
   * <p>
   * For Java API, use {@link randomSplitAsList}.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T>[] randomSplit (double[] weights, long seed)  { throw new RuntimeException(); }
  /**
   * Returns a Java list that contains randomly split Dataset with the provided weights.
   * <p>
   * @param weights weights for splits, will be normalized if they don't sum to 1.
   * @param seed Seed for sampling.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @return (undocumented)
   */
  public  java.util.List<org.apache.spark.sql.Dataset<T>> randomSplitAsList (double[] weights, long seed)  { throw new RuntimeException(); }
  /**
   * Randomly splits this Dataset with the provided weights.
   * <p>
   * @param weights weights for splits, will be normalized if they don't sum to 1.
   * @group typedrel
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T>[] randomSplit (double[] weights)  { throw new RuntimeException(); }
  /**
   * Randomly splits this Dataset with the provided weights. Provided for the Python Api.
   * <p>
   * @param weights weights for splits, will be normalized if they don't sum to 1.
   * @param seed Seed for sampling.
   * @return (undocumented)
   */
    org.apache.spark.sql.Dataset<T>[] randomSplit (scala.collection.immutable.List<java.lang.Object> weights, long seed)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Returns a new Dataset where each row has been expanded to zero or more
   * rows by the provided function. This is similar to a <code>LATERAL VIEW</code> in HiveQL. The columns of
   * the input row are implicitly joined with each row that is output by the function.
   * <p>
   * Given that this is deprecated, as an alternative, you can explode columns either using
   * <code>functions.explode()</code> or <code>flatMap()</code>. The following example uses these alternatives to count
   * the number of books that contain a given word:
   * <p>
   * <pre><code>
   *   case class Book(title: String, words: String)
   *   val ds: Dataset[Book]
   *
   *   val allWords = ds.select($"title", explode(split($"words", " ")).as("word"))
   *
   *   val bookCountPerWord = allWords.groupBy("word").agg(count_distinct("title"))
   * </code></pre>
   * <p>
   * Using <code>flatMap()</code> this can similarly be exploded as:
   * <p>
   * <pre><code>
   *   ds.flatMap(_.words.split(" "))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param input (undocumented)
   * @param f (undocumented)
   * @param evidence$4 (undocumented)
   * @return (undocumented)
   *
   * @deprecated use flatMap() or select() with functions.explode() instead. Since 2.0.0. 
   */
  public <A extends scala.Product> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> explode (scala.collection.Seq<org.apache.spark.sql.Column> input, scala.Function1<org.apache.spark.sql.Row, scala.collection.TraversableOnce<A>> f, scala.reflect.api.TypeTags.TypeTag<A> evidence$4)  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Returns a new Dataset where a single column has been expanded to zero
   * or more rows by the provided function. This is similar to a <code>LATERAL VIEW</code> in HiveQL. All
   * columns of the input row are implicitly joined with each value that is output by the function.
   * <p>
   * Given that this is deprecated, as an alternative, you can explode columns either using
   * <code>functions.explode()</code>:
   * <p>
   * <pre><code>
   *   ds.select(explode(split($"words", " ")).as("word"))
   * </code></pre>
   * <p>
   * or <code>flatMap()</code>:
   * <p>
   * <pre><code>
   *   ds.flatMap(_.words.split(" "))
   * </code></pre>
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param inputColumn (undocumented)
   * @param outputColumn (undocumented)
   * @param f (undocumented)
   * @param evidence$5 (undocumented)
   * @return (undocumented)
   *
   * @deprecated use flatMap() or select() with functions.explode() instead. Since 2.0.0. 
   */
  public <A extends java.lang.Object, B extends java.lang.Object> org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> explode (java.lang.String inputColumn, java.lang.String outputColumn, scala.Function1<A, scala.collection.TraversableOnce<B>> f, scala.reflect.api.TypeTags.TypeTag<B> evidence$5)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset by adding a column or replacing the existing column that has
   * the same name.
   * <p>
   * <code>column</code>'s expression must only refer to attributes supplied by this Dataset. It is an
   * error to add a column that refers to some other Dataset.
   * <p>
   * @note this method introduces a projection internally. Therefore, calling it multiple times,
   * for instance, via loops in order to add multiple columns can generate big plans which
   * can cause performance issues and even <code>StackOverflowException</code>. To avoid this,
   * use <code>select</code> with the multiple columns at once.
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param colName (undocumented)
   * @param col (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> withColumn (java.lang.String colName, org.apache.spark.sql.Column col)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset by adding columns or replacing the existing columns that has
   * the same names.
   * @param colNames (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> withColumns (scala.collection.Seq<java.lang.String> colNames, scala.collection.Seq<org.apache.spark.sql.Column> cols)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset by adding columns with metadata.
   * @param colNames (undocumented)
   * @param cols (undocumented)
   * @param metadata (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> withColumns (scala.collection.Seq<java.lang.String> colNames, scala.collection.Seq<org.apache.spark.sql.Column> cols, scala.collection.Seq<org.apache.spark.sql.types.Metadata> metadata)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset by adding a column with metadata.
   * @param colName (undocumented)
   * @param col (undocumented)
   * @param metadata (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> withColumn (java.lang.String colName, org.apache.spark.sql.Column col, org.apache.spark.sql.types.Metadata metadata)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset with a column renamed.
   * This is a no-op if schema doesn't contain existingName.
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param existingName (undocumented)
   * @param newName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> withColumnRenamed (java.lang.String existingName, java.lang.String newName)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset with a column dropped. This is a no-op if schema doesn't contain
   * column name.
   * <p>
   * This method can only be used to drop top level columns. the colName string is treated
   * literally without further interpretation.
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param colName (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> drop (java.lang.String colName)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset with columns dropped.
   * This is a no-op if schema doesn't contain column name(s).
   * <p>
   * This method can only be used to drop top level columns. the colName string is treated literally
   * without further interpretation.
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> drop (scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset with a column dropped.
   * This version of drop accepts a {@link Column} rather than a name.
   * This is a no-op if the Dataset doesn't have a column
   * with an equivalent expression.
   * <p>
   * @group untypedrel
   * @since 2.0.0
   * @param col (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> drop (org.apache.spark.sql.Column col)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset that contains only the unique rows from this Dataset.
   * This is an alias for <code>distinct</code>.
   * <p>
   * For a static batch {@link Dataset}, it just drops duplicate rows. For a streaming {@link Dataset}, it
   * will keep all data across triggers as intermediate state to drop duplicates rows. You can use
   * {@link withWatermark} to limit how late the duplicate data can be and system will accordingly limit
   * the state. In addition, too late data older than watermark will be dropped to avoid any
   * possibility of duplicates.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> dropDuplicates ()  { throw new RuntimeException(); }
  /**
   * (Scala-specific) Returns a new Dataset with duplicate rows removed, considering only
   * the subset of columns.
   * <p>
   * For a static batch {@link Dataset}, it just drops duplicate rows. For a streaming {@link Dataset}, it
   * will keep all data across triggers as intermediate state to drop duplicates rows. You can use
   * {@link withWatermark} to limit how late the duplicate data can be and system will accordingly limit
   * the state. In addition, too late data older than watermark will be dropped to avoid any
   * possibility of duplicates.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> dropDuplicates (scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset with duplicate rows removed, considering only
   * the subset of columns.
   * <p>
   * For a static batch {@link Dataset}, it just drops duplicate rows. For a streaming {@link Dataset}, it
   * will keep all data across triggers as intermediate state to drop duplicates rows. You can use
   * {@link withWatermark} to limit how late the duplicate data can be and system will accordingly limit
   * the state. In addition, too late data older than watermark will be dropped to avoid any
   * possibility of duplicates.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param colNames (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> dropDuplicates (java.lang.String[] colNames)  { throw new RuntimeException(); }
  /**
   * Returns a new {@link Dataset} with duplicate rows removed, considering only
   * the subset of columns.
   * <p>
   * For a static batch {@link Dataset}, it just drops duplicate rows. For a streaming {@link Dataset}, it
   * will keep all data across triggers as intermediate state to drop duplicates rows. You can use
   * {@link withWatermark} to limit how late the duplicate data can be and system will accordingly limit
   * the state. In addition, too late data older than watermark will be dropped to avoid any
   * possibility of duplicates.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param col1 (undocumented)
   * @param cols (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> dropDuplicates (java.lang.String col1, scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /**
   * Computes basic statistics for numeric and string columns, including count, mean, stddev, min,
   * and max. If no columns are given, this function computes statistics for all numerical or
   * string columns.
   * <p>
   * This function is meant for exploratory data analysis, as we make no guarantee about the
   * backward compatibility of the schema of the resulting Dataset. If you want to
   * programmatically compute summary statistics, use the <code>agg</code> function instead.
   * <p>
   * <pre><code>
   *   ds.describe("age", "height").show()
   *
   *   // output:
   *   // summary age   height
   *   // count   10.0  10.0
   *   // mean    53.3  178.05
   *   // stddev  11.6  15.7
   *   // min     18.0  163.0
   *   // max     92.0  192.0
   * </code></pre>
   * <p>
   * Use {@link summary} for expanded statistics and control over which statistics to compute.
   * <p>
   * @param cols Columns to compute statistics on.
   * <p>
   * @group action
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> describe (scala.collection.Seq<java.lang.String> cols)  { throw new RuntimeException(); }
  /**
   * Computes specified statistics for numeric and string columns. Available statistics are:
   * <ul>
   *   <li>count</li>
   *   <li>mean</li>
   *   <li>stddev</li>
   *   <li>min</li>
   *   <li>max</li>
   *   <li>arbitrary approximate percentiles specified as a percentage (e.g. 75%)</li>
   *   <li>count_distinct</li>
   *   <li>approx_count_distinct</li>
   * </ul>
   * <p>
   * If no statistics are given, this function computes count, mean, stddev, min,
   * approximate quartiles (percentiles at 25%, 50%, and 75%), and max.
   * <p>
   * This function is meant for exploratory data analysis, as we make no guarantee about the
   * backward compatibility of the schema of the resulting Dataset. If you want to
   * programmatically compute summary statistics, use the <code>agg</code> function instead.
   * <p>
   * <pre><code>
   *   ds.summary().show()
   *
   *   // output:
   *   // summary age   height
   *   // count   10.0  10.0
   *   // mean    53.3  178.05
   *   // stddev  11.6  15.7
   *   // min     18.0  163.0
   *   // 25%     24.0  176.0
   *   // 50%     24.0  176.0
   *   // 75%     32.0  180.0
   *   // max     92.0  192.0
   * </code></pre>
   * <p>
   * <pre><code>
   *   ds.summary("count", "min", "25%", "75%", "max").show()
   *
   *   // output:
   *   // summary age   height
   *   // count   10.0  10.0
   *   // min     18.0  163.0
   *   // 25%     24.0  176.0
   *   // 75%     32.0  180.0
   *   // max     92.0  192.0
   * </code></pre>
   * <p>
   * To do a summary for specific columns first select them:
   * <p>
   * <pre><code>
   *   ds.select("age", "height").summary().show()
   * </code></pre>
   * <p>
   * Specify statistics to output custom summaries:
   * <p>
   * <pre><code>
   *   ds.summary("count", "count_distinct").show()
   * </code></pre>
   * <p>
   * The distinct count isn't included by default.
   * <p>
   * You can also run approximate distinct counts which are faster:
   * <p>
   * <pre><code>
   *   ds.summary("count", "approx_count_distinct").show()
   * </code></pre>
   * <p>
   * See also {@link describe} for basic statistics.
   * <p>
   * @param statistics Statistics from above list to be computed.
   * <p>
   * @group action
   * @since 2.3.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> summary (scala.collection.Seq<java.lang.String> statistics)  { throw new RuntimeException(); }
  /**
   * Returns the first <code>n</code> rows.
   * <p>
   * @note this method should only be used if the resulting array is expected to be small, as
   * all the data is loaded into the driver's memory.
   * <p>
   * @group action
   * @since 1.6.0
   * @param n (undocumented)
   * @return (undocumented)
   */
  public  java.lang.Object head (int n)  { throw new RuntimeException(); }
  /**
   * Returns the first row.
   * @group action
   * @since 1.6.0
   * @return (undocumented)
   */
  public  T head ()  { throw new RuntimeException(); }
  /**
   * Returns the first row. Alias for head().
   * @group action
   * @since 1.6.0
   * @return (undocumented)
   */
  public  T first ()  { throw new RuntimeException(); }
  /**
   * Concise syntax for chaining custom transformations.
   * <pre><code>
   *   def featurize(ds: Dataset[T]): Dataset[U] = ...
   *
   *   ds
   *     .transform(featurize)
   *     .transform(...)
   * </code></pre>
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param t (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.Dataset<U> transform (scala.Function1<org.apache.spark.sql.Dataset<T>, org.apache.spark.sql.Dataset<U>> t)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Returns a new Dataset that only contains elements where <code>func</code> returns <code>true</code>.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param func (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> filter (scala.Function1<T, java.lang.Object> func)  { throw new RuntimeException(); }
  /**
   * (Java-specific)
   * Returns a new Dataset that only contains elements where <code>func</code> returns <code>true</code>.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param func (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> filter (org.apache.spark.api.java.function.FilterFunction<T> func)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Returns a new Dataset that contains the result of applying <code>func</code> to each element.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param func (undocumented)
   * @param evidence$6 (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.Dataset<U> map (scala.Function1<T, U> func, org.apache.spark.sql.Encoder<U> evidence$6)  { throw new RuntimeException(); }
  /**
   * (Java-specific)
   * Returns a new Dataset that contains the result of applying <code>func</code> to each element.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param func (undocumented)
   * @param encoder (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.Dataset<U> map (org.apache.spark.api.java.function.MapFunction<T, U> func, org.apache.spark.sql.Encoder<U> encoder)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Returns a new Dataset that contains the result of applying <code>func</code> to each partition.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param func (undocumented)
   * @param evidence$7 (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.Dataset<U> mapPartitions (scala.Function1<scala.collection.Iterator<T>, scala.collection.Iterator<U>> func, org.apache.spark.sql.Encoder<U> evidence$7)  { throw new RuntimeException(); }
  /**
   * (Java-specific)
   * Returns a new Dataset that contains the result of applying <code>f</code> to each partition.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param f (undocumented)
   * @param encoder (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.Dataset<U> mapPartitions (org.apache.spark.api.java.function.MapPartitionsFunction<T, U> f, org.apache.spark.sql.Encoder<U> encoder)  { throw new RuntimeException(); }
  /**
   * Returns a new <code>DataFrame</code> that contains the result of applying a serialized R function
   * <code>func</code> to each partition.
   * @param func (undocumented)
   * @param packageNames (undocumented)
   * @param broadcastVars (undocumented)
   * @param schema (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> mapPartitionsInR (byte[] func, byte[] packageNames, org.apache.spark.broadcast.Broadcast<java.lang.Object>[] broadcastVars, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
  /**
   * Applies a Scalar iterator Pandas UDF to each partition. The user-defined function
   * defines a transformation: <code>iter(pandas.DataFrame)</code> -> <code>iter(pandas.DataFrame)</code>.
   * Each partition is each iterator consisting of DataFrames as batches.
   * <p>
   * This function uses Apache Arrow as serialization format between Java executors and Python
   * workers.
   * @param func (undocumented)
   * @return (undocumented)
   */
    org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> mapInPandas (org.apache.spark.sql.catalyst.expressions.PythonUDF func)  { throw new RuntimeException(); }
  /**
   * (Scala-specific)
   * Returns a new Dataset by first applying a function to all elements of this Dataset,
   * and then flattening the results.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param func (undocumented)
   * @param evidence$8 (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.Dataset<U> flatMap (scala.Function1<T, scala.collection.TraversableOnce<U>> func, org.apache.spark.sql.Encoder<U> evidence$8)  { throw new RuntimeException(); }
  /**
   * (Java-specific)
   * Returns a new Dataset by first applying a function to all elements of this Dataset,
   * and then flattening the results.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param f (undocumented)
   * @param encoder (undocumented)
   * @return (undocumented)
   */
  public <U extends java.lang.Object> org.apache.spark.sql.Dataset<U> flatMap (org.apache.spark.api.java.function.FlatMapFunction<T, U> f, org.apache.spark.sql.Encoder<U> encoder)  { throw new RuntimeException(); }
  /**
   * Applies a function <code>f</code> to all rows.
   * <p>
   * @group action
   * @since 1.6.0
   * @param f (undocumented)
   */
  public  void foreach (scala.Function1<T, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  /**
   * (Java-specific)
   * Runs <code>func</code> on each element of this Dataset.
   * <p>
   * @group action
   * @since 1.6.0
   * @param func (undocumented)
   */
  public  void foreach (org.apache.spark.api.java.function.ForeachFunction<T> func)  { throw new RuntimeException(); }
  /**
   * Applies a function <code>f</code> to each partition of this Dataset.
   * <p>
   * @group action
   * @since 1.6.0
   * @param f (undocumented)
   */
  public  void foreachPartition (scala.Function1<scala.collection.Iterator<T>, scala.runtime.BoxedUnit> f)  { throw new RuntimeException(); }
  /**
   * (Java-specific)
   * Runs <code>func</code> on each partition of this Dataset.
   * <p>
   * @group action
   * @since 1.6.0
   * @param func (undocumented)
   */
  public  void foreachPartition (org.apache.spark.api.java.function.ForeachPartitionFunction<T> func)  { throw new RuntimeException(); }
  /**
   * Returns the first <code>n</code> rows in the Dataset.
   * <p>
   * Running take requires moving data into the application's driver process, and doing so with
   * a very large <code>n</code> can crash the driver process with OutOfMemoryError.
   * <p>
   * @group action
   * @since 1.6.0
   * @param n (undocumented)
   * @return (undocumented)
   */
  public  java.lang.Object take (int n)  { throw new RuntimeException(); }
  /**
   * Returns the last <code>n</code> rows in the Dataset.
   * <p>
   * Running tail requires moving data into the application's driver process, and doing so with
   * a very large <code>n</code> can crash the driver process with OutOfMemoryError.
   * <p>
   * @group action
   * @since 3.0.0
   * @param n (undocumented)
   * @return (undocumented)
   */
  public  java.lang.Object tail (int n)  { throw new RuntimeException(); }
  /**
   * Returns the first <code>n</code> rows in the Dataset as a list.
   * <p>
   * Running take requires moving data into the application's driver process, and doing so with
   * a very large <code>n</code> can crash the driver process with OutOfMemoryError.
   * <p>
   * @group action
   * @since 1.6.0
   * @param n (undocumented)
   * @return (undocumented)
   */
  public  java.util.List<T> takeAsList (int n)  { throw new RuntimeException(); }
  /**
   * Returns an array that contains all rows in this Dataset.
   * <p>
   * Running collect requires moving all the data into the application's driver process, and
   * doing so on a very large dataset can crash the driver process with OutOfMemoryError.
   * <p>
   * For Java API, use {@link collectAsList}.
   * <p>
   * @group action
   * @since 1.6.0
   * @return (undocumented)
   */
  public  java.lang.Object collect ()  { throw new RuntimeException(); }
  /**
   * Returns a Java list that contains all rows in this Dataset.
   * <p>
   * Running collect requires moving all the data into the application's driver process, and
   * doing so on a very large dataset can crash the driver process with OutOfMemoryError.
   * <p>
   * @group action
   * @since 1.6.0
   * @return (undocumented)
   */
  public  java.util.List<T> collectAsList ()  { throw new RuntimeException(); }
  /**
   * Returns an iterator that contains all rows in this Dataset.
   * <p>
   * The iterator will consume as much memory as the largest partition in this Dataset.
   * <p>
   * @note this results in multiple Spark jobs, and if the input Dataset is the result
   * of a wide transformation (e.g. join with different partitioners), to avoid
   * recomputing the input Dataset should be cached first.
   * <p>
   * @group action
   * @since 2.0.0
   * @return (undocumented)
   */
  public  java.util.Iterator<T> toLocalIterator ()  { throw new RuntimeException(); }
  /**
   * Returns the number of rows in the Dataset.
   * @group action
   * @since 1.6.0
   * @return (undocumented)
   */
  public  long count ()  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset that has exactly <code>numPartitions</code> partitions.
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param numPartitions (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> repartition (int numPartitions)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset partitioned by the given partitioning expressions into
   * <code>numPartitions</code>. The resulting Dataset is hash partitioned.
   * <p>
   * This is the same operation as "DISTRIBUTE BY" in SQL (Hive QL).
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param numPartitions (undocumented)
   * @param partitionExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> repartition (int numPartitions, scala.collection.Seq<org.apache.spark.sql.Column> partitionExprs)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset partitioned by the given partitioning expressions, using
   * <code>spark.sql.shuffle.partitions</code> as number of partitions.
   * The resulting Dataset is hash partitioned.
   * <p>
   * This is the same operation as "DISTRIBUTE BY" in SQL (Hive QL).
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @param partitionExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> repartition (scala.collection.Seq<org.apache.spark.sql.Column> partitionExprs)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset partitioned by the given partitioning expressions into
   * <code>numPartitions</code>. The resulting Dataset is range partitioned.
   * <p>
   * At least one partition-by expression must be specified.
   * When no explicit sort order is specified, "ascending nulls first" is assumed.
   * Note, the rows are not sorted in each partition of the resulting Dataset.
   * <p>
   * Note that due to performance reasons this method uses sampling to estimate the ranges.
   * Hence, the output may not be consistent, since sampling can return different values.
   * The sample size can be controlled by the config
   * <code>spark.sql.execution.rangeExchange.sampleSizePerPartition</code>.
   * <p>
   * @group typedrel
   * @since 2.3.0
   * @param numPartitions (undocumented)
   * @param partitionExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> repartitionByRange (int numPartitions, scala.collection.Seq<org.apache.spark.sql.Column> partitionExprs)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset partitioned by the given partitioning expressions, using
   * <code>spark.sql.shuffle.partitions</code> as number of partitions.
   * The resulting Dataset is range partitioned.
   * <p>
   * At least one partition-by expression must be specified.
   * When no explicit sort order is specified, "ascending nulls first" is assumed.
   * Note, the rows are not sorted in each partition of the resulting Dataset.
   * <p>
   * Note that due to performance reasons this method uses sampling to estimate the ranges.
   * Hence, the output may not be consistent, since sampling can return different values.
   * The sample size can be controlled by the config
   * <code>spark.sql.execution.rangeExchange.sampleSizePerPartition</code>.
   * <p>
   * @group typedrel
   * @since 2.3.0
   * @param partitionExprs (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> repartitionByRange (scala.collection.Seq<org.apache.spark.sql.Column> partitionExprs)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset that has exactly <code>numPartitions</code> partitions, when the fewer partitions
   * are requested. If a larger number of partitions is requested, it will stay at the current
   * number of partitions. Similar to coalesce defined on an <code>RDD</code>, this operation results in
   * a narrow dependency, e.g. if you go from 1000 partitions to 100 partitions, there will not
   * be a shuffle, instead each of the 100 new partitions will claim 10 of the current partitions.
   * <p>
   * However, if you're doing a drastic coalesce, e.g. to numPartitions = 1,
   * this may result in your computation taking place on fewer nodes than
   * you like (e.g. one node in the case of numPartitions = 1). To avoid this,
   * you can call repartition. This will add a shuffle step, but means the
   * current upstream partitions will be executed in parallel (per whatever
   * the current partitioning is).
   * <p>
   * @group typedrel
   * @since 1.6.0
   * @param numPartitions (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> coalesce (int numPartitions)  { throw new RuntimeException(); }
  /**
   * Returns a new Dataset that contains only the unique rows from this Dataset.
   * This is an alias for <code>dropDuplicates</code>.
   * <p>
   * Note that for a streaming {@link Dataset}, this method returns distinct rows only once
   * regardless of the output mode, which the behavior may not be same with <code>DISTINCT</code> in SQL
   * against streaming {@link Dataset}.
   * <p>
   * @note Equality checking is performed directly on the encoded representation of the data
   * and thus is not affected by a custom <code>equals</code> function defined on <code>T</code>.
   * <p>
   * @group typedrel
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> distinct ()  { throw new RuntimeException(); }
  /**
   * Persist this Dataset with the default storage level (<code>MEMORY_AND_DISK</code>).
   * <p>
   * @group basic
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> persist ()  { throw new RuntimeException(); }
  /**
   * Persist this Dataset with the default storage level (<code>MEMORY_AND_DISK</code>).
   * <p>
   * @group basic
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> cache ()  { throw new RuntimeException(); }
  /**
   * Persist this Dataset with the given storage level.
   * @param newLevel One of: <code>MEMORY_ONLY</code>, <code>MEMORY_AND_DISK</code>, <code>MEMORY_ONLY_SER</code>,
   *                 <code>MEMORY_AND_DISK_SER</code>, <code>DISK_ONLY</code>, <code>MEMORY_ONLY_2</code>,
   *                 <code>MEMORY_AND_DISK_2</code>, etc.
   * <p>
   * @group basic
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> persist (org.apache.spark.storage.StorageLevel newLevel)  { throw new RuntimeException(); }
  /**
   * Get the Dataset's current storage level, or StorageLevel.NONE if not persisted.
   * <p>
   * @group basic
   * @since 2.1.0
   * @return (undocumented)
   */
  public  org.apache.spark.storage.StorageLevel storageLevel ()  { throw new RuntimeException(); }
  /**
   * Mark the Dataset as non-persistent, and remove all blocks for it from memory and disk.
   * This will not un-persist any cached data that is built upon this Dataset.
   * <p>
   * @param blocking Whether to block until all blocks are deleted.
   * <p>
   * @group basic
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> unpersist (boolean blocking)  { throw new RuntimeException(); }
  /**
   * Mark the Dataset as non-persistent, and remove all blocks for it from memory and disk.
   * This will not un-persist any cached data that is built upon this Dataset.
   * <p>
   * @group basic
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<T> unpersist ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.rdd.RDD<T> rdd ()  { throw new RuntimeException(); }
  /**
   * Returns the content of the Dataset as a <code>JavaRDD</code> of <code>T</code>s.
   * @group basic
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.api.java.JavaRDD<T> toJavaRDD ()  { throw new RuntimeException(); }
  /**
   * Returns the content of the Dataset as a <code>JavaRDD</code> of <code>T</code>s.
   * @group basic
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.api.java.JavaRDD<T> javaRDD ()  { throw new RuntimeException(); }
  /**
   * Registers this Dataset as a temporary table using the given name. The lifetime of this
   * temporary table is tied to the {@link SparkSession} that was used to create this Dataset.
   * <p>
   * @group basic
   * @since 1.6.0
   * @param tableName (undocumented)
   *
   * @deprecated Use createOrReplaceTempView(viewName) instead. Since 2.0.0. 
   */
  public  void registerTempTable (java.lang.String tableName)  { throw new RuntimeException(); }
  /**
   * Creates a local temporary view using the given name. The lifetime of this
   * temporary view is tied to the {@link SparkSession} that was used to create this Dataset.
   * <p>
   * Local temporary view is session-scoped. Its lifetime is the lifetime of the session that
   * created it, i.e. it will be automatically dropped when the session terminates. It's not
   * tied to any databases, i.e. we can't use <code>db1.view1</code> to reference a local temporary view.
   * <p>
   * @throws AnalysisException if the view name is invalid or already exists
   * <p>
   * @group basic
   * @since 2.0.0
   * @param viewName (undocumented)
   */
  public  void createTempView (java.lang.String viewName) throws org.apache.spark.sql.AnalysisException { throw new RuntimeException(); }
  /**
   * Creates a local temporary view using the given name. The lifetime of this
   * temporary view is tied to the {@link SparkSession} that was used to create this Dataset.
   * <p>
   * @group basic
   * @since 2.0.0
   * @param viewName (undocumented)
   */
  public  void createOrReplaceTempView (java.lang.String viewName)  { throw new RuntimeException(); }
  /**
   * Creates a global temporary view using the given name. The lifetime of this
   * temporary view is tied to this Spark application.
   * <p>
   * Global temporary view is cross-session. Its lifetime is the lifetime of the Spark application,
   * i.e. it will be automatically dropped when the application terminates. It's tied to a system
   * preserved database <code>global_temp</code>, and we must use the qualified name to refer a global temp
   * view, e.g. <code>SELECT * FROM global_temp.view1</code>.
   * <p>
   * @throws AnalysisException if the view name is invalid or already exists
   * <p>
   * @group basic
   * @since 2.1.0
   * @param viewName (undocumented)
   */
  public  void createGlobalTempView (java.lang.String viewName) throws org.apache.spark.sql.AnalysisException { throw new RuntimeException(); }
  /**
   * Creates or replaces a global temporary view using the given name. The lifetime of this
   * temporary view is tied to this Spark application.
   * <p>
   * Global temporary view is cross-session. Its lifetime is the lifetime of the Spark application,
   * i.e. it will be automatically dropped when the application terminates. It's tied to a system
   * preserved database <code>global_temp</code>, and we must use the qualified name to refer a global temp
   * view, e.g. <code>SELECT * FROM global_temp.view1</code>.
   * <p>
   * @group basic
   * @since 2.2.0
   * @param viewName (undocumented)
   */
  public  void createOrReplaceGlobalTempView (java.lang.String viewName)  { throw new RuntimeException(); }
  /**
   * Interface for saving the content of the non-streaming Dataset out into external storage.
   * <p>
   * @group basic
   * @since 1.6.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameWriter<T> write ()  { throw new RuntimeException(); }
  /**
   * Create a write configuration builder for v2 sources.
   * <p>
   * This builder is used to configure and execute write operations. For example, to append to an
   * existing table, run:
   * <p>
   * <pre><code>
   *   df.writeTo("catalog.db.table").append()
   * </code></pre>
   * <p>
   * This can also be used to create or replace existing tables:
   * <p>
   * <pre><code>
   *   df.writeTo("catalog.db.table").partitionedBy($"col").createOrReplace()
   * </code></pre>
   * <p>
   * @group basic
   * @since 3.0.0
   * @param table (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.DataFrameWriterV2<T> writeTo (java.lang.String table)  { throw new RuntimeException(); }
  /**
   * Interface for saving the content of the streaming Dataset out into external storage.
   * <p>
   * @group basic
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.streaming.DataStreamWriter<T> writeStream ()  { throw new RuntimeException(); }
  /**
   * Returns the content of the Dataset as a Dataset of JSON strings.
   * @since 2.0.0
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Dataset<java.lang.String> toJSON ()  { throw new RuntimeException(); }
  /**
   * Returns a best-effort snapshot of the files that compose this Dataset. This method simply
   * asks each constituent BaseRelation for its respective files and takes the union of all results.
   * Depending on the source relations, this may not find all input files. Duplicates are removed.
   * <p>
   * @group basic
   * @since 2.0.0
   * @return (undocumented)
   */
  public  java.lang.String[] inputFiles ()  { throw new RuntimeException(); }
  /**
   * Returns <code>true</code> when the logical query plans inside both {@link Dataset}s are equal and
   * therefore return same results.
   * <p>
   * @note The equality comparison here is simplified by tolerating the cosmetic differences
   *       such as attribute names.
   * @note This API can compare both {@link Dataset}s very fast but can still return <code>false</code> on
   *       the {@link Dataset} that return the same results, for instance, from different plans. Such
   *       false negative semantic can be useful when caching as an example.
   * @since 3.1.0
   * @param other (undocumented)
   * @return (undocumented)
   */
  public  boolean sameSemantics (org.apache.spark.sql.Dataset<T> other)  { throw new RuntimeException(); }
  /**
   * Returns a <code>hashCode</code> of the logical query plan against this {@link Dataset}.
   * <p>
   * @note Unlike the standard <code>hashCode</code>, the hash is calculated against the query plan
   *       simplified by tolerating the cosmetic differences such as attribute names.
   * @since 3.1.0
   * @return (undocumented)
   */
  public  int semanticHash ()  { throw new RuntimeException(); }
  /**
   * Converts a JavaRDD to a PythonRDD.
   * @return (undocumented)
   */
    org.apache.spark.api.java.JavaRDD<byte[]> javaToPython ()  { throw new RuntimeException(); }
    java.lang.Object[] collectToPython ()  { throw new RuntimeException(); }
    java.lang.Object[] tailToPython (int n)  { throw new RuntimeException(); }
    java.lang.Object[] getRowsToPython (int _numRows, int truncate)  { throw new RuntimeException(); }
  /**
   * Collect a Dataset as Arrow batches and serve stream to SparkR. It sends
   * arrow batches in an ordered manner with buffering. This is inevitable
   * due to missing R API that reads batches from socket directly. See ARROW-4512.
   * Eventually, this code should be deduplicated by <code>collectAsArrowToPython</code>.
   * @return (undocumented)
   */
    java.lang.Object[] collectAsArrowToR ()  { throw new RuntimeException(); }
  /**
   * Collect a Dataset as Arrow batches and serve stream to PySpark. It sends
   * arrow batches in an un-ordered manner without buffering, and then batch order
   * information at the end. The batches should be reordered at Python side.
   * @return (undocumented)
   */
    java.lang.Object[] collectAsArrowToPython ()  { throw new RuntimeException(); }
    java.lang.Object[] toPythonIterator (boolean prefetchPartitions)  { throw new RuntimeException(); }
  /** Convert to an RDD of serialized ArrowRecordBatches. */
    org.apache.spark.rdd.RDD<byte[]> toArrowBatchRdd (org.apache.spark.sql.execution.SparkPlan plan)  { throw new RuntimeException(); }
    org.apache.spark.rdd.RDD<byte[]> toArrowBatchRdd ()  { throw new RuntimeException(); }
}
