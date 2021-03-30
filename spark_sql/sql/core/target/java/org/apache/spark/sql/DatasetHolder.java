package org.apache.spark.sql;
/**
 * A container for a {@link Dataset}, used for implicit conversions in Scala.
 * <p>
 * To use this, import implicit conversions in SQL:
 * <pre><code>
 *   val spark: SparkSession = ...
 *   import spark.implicits._
 * </code></pre>
 * <p>
 * @since 1.6.0
 */
public  class DatasetHolder<T extends java.lang.Object> implements scala.Product, scala.Serializable {
  // not preceding
     DatasetHolder (org.apache.spark.sql.Dataset<T> ds)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Dataset<T> toDS ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> toDF ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Dataset<org.apache.spark.sql.Row> toDF (scala.collection.Seq<java.lang.String> colNames)  { throw new RuntimeException(); }
}
