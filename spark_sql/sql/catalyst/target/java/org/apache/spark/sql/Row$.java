package org.apache.spark.sql;
/**
 * @since 1.3.0
 */
public  class Row$ implements scala.Serializable {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Row$ MODULE$ = null;
  public   Row$ ()  { throw new RuntimeException(); }
  /**
   * This method can be used to extract fields from a {@link Row} object in a pattern match. Example:
   * <pre><code>
   * import org.apache.spark.sql._
   *
   * val pairs = sql("SELECT key, value FROM src").rdd.map {
   *   case Row(key: Int, value: String) =&gt;
   *     key -&gt; value
   * }
   * </code></pre>
   * @param row (undocumented)
   * @return (undocumented)
   */
  public  scala.Some<scala.collection.Seq<java.lang.Object>> unapplySeq (org.apache.spark.sql.Row row)  { throw new RuntimeException(); }
  /**
   * This method can be used to construct a {@link Row} with the given values.
   * @param values (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Row apply (scala.collection.Seq<java.lang.Object> values)  { throw new RuntimeException(); }
  /**
   * This method can be used to construct a {@link Row} from a <code>Seq</code> of values.
   * @param values (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.Row fromSeq (scala.collection.Seq<java.lang.Object> values)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.Row fromTuple (scala.Product tuple)  { throw new RuntimeException(); }
  /**
   * Merge multiple rows into a single row, one after another.
   * @param rows (undocumented)
   * @return (undocumented)
   *
   * @deprecated This method is deprecated and will be removed in future versions. Since 3.0.0. 
   */
  public  org.apache.spark.sql.Row merge (scala.collection.Seq<org.apache.spark.sql.Row> rows)  { throw new RuntimeException(); }
  /** Returns an empty row. */
  public  org.apache.spark.sql.Row empty ()  { throw new RuntimeException(); }
}
