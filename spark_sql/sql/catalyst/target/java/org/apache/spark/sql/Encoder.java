package org.apache.spark.sql;
/**
 * Used to convert a JVM object of type <code>T</code> to and from the internal Spark SQL representation.
 * <p>
 * == Scala ==
 * Encoders are generally created automatically through implicits from a <code>SparkSession</code>, or can be
 * explicitly created by calling static methods on {@link Encoders}.
 * <p>
 * <pre><code>
 *   import spark.implicits._
 *
 *   val ds = Seq(1, 2, 3).toDS() // implicitly provided (spark.implicits.newIntEncoder)
 * </code></pre>
 * <p>
 * == Java ==
 * Encoders are specified by calling static methods on {@link Encoders}.
 * <p>
 * <pre><code>
 *   List&lt;String&gt; data = Arrays.asList("abc", "abc", "xyz");
 *   Dataset&lt;String&gt; ds = context.createDataset(data, Encoders.STRING());
 * </code></pre>
 * <p>
 * Encoders can be composed into tuples:
 * <p>
 * <pre><code>
 *   Encoder&lt;Tuple2&lt;Integer, String&gt;&gt; encoder2 = Encoders.tuple(Encoders.INT(), Encoders.STRING());
 *   List&lt;Tuple2&lt;Integer, String&gt;&gt; data2 = Arrays.asList(new scala.Tuple2(1, "a");
 *   Dataset&lt;Tuple2&lt;Integer, String&gt;&gt; ds2 = context.createDataset(data2, encoder2);
 * </code></pre>
 * <p>
 * Or constructed from Java Beans:
 * <p>
 * <pre><code>
 *   Encoders.bean(MyClass.class);
 * </code></pre>
 * <p>
 * == Implementation ==
 *  - Encoders should be thread-safe.
 * <p>
 * @since 1.6.0
 */
public  interface Encoder<T extends java.lang.Object> extends scala.Serializable {
  /**
   * A ClassTag that can be used to construct an Array to contain a collection of <code>T</code>.
   * @return (undocumented)
   */
  public  scala.reflect.ClassTag<T> clsTag ()  ;
  /** Returns the schema of encoding this type of object as a Row. */
  public  org.apache.spark.sql.types.StructType schema ()  ;
}
