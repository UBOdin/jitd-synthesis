package org.apache.spark.sql.execution.python;
/**
 * Base functionality for plans which execute grouped python udfs.
 */
public  class PandasGroupUtils {
  /**
   * passes the data to the python runner and coverts the resulting
   * columnarbatch into internal rows.
   * @param data (undocumented)
   * @param output (undocumented)
   * @param runner (undocumented)
   * @return (undocumented)
   */
  static public <T extends java.lang.Object> scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> executePython (scala.collection.Iterator<T> data, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> output, org.apache.spark.api.python.BasePythonRunner<T, org.apache.spark.sql.vectorized.ColumnarBatch> runner)  { throw new RuntimeException(); }
  /**
   * groups according to grouping attributes and then projects into the deduplicated schema
   * @param input (undocumented)
   * @param groupingAttributes (undocumented)
   * @param inputSchema (undocumented)
   * @param dedupSchema (undocumented)
   * @return (undocumented)
   */
  static public  scala.collection.Iterator<scala.Tuple2<org.apache.spark.sql.catalyst.InternalRow, scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow>>> groupAndProject (scala.collection.Iterator<org.apache.spark.sql.catalyst.InternalRow> input, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> inputSchema, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> dedupSchema)  { throw new RuntimeException(); }
  /**
   * Returns a the deduplicated attributes of the spark plan and the arg offsets of the
   * keys and values.
   * <p>
   * The deduplicated attributes are needed because the spark plan may contain an attribute
   * twice; once in the key and once in the value.  For any such attribute we need to
   * deduplicate.
   * <p>
   * The arg offsets are used to distinguish grouping grouping attributes and data attributes
   * as following:
   * <p>
   * argOffsets[0] is the length of the argOffsets array
   * <p>
   * argOffsets[1] is the length of grouping attribute
   * argOffsets[2 .. argOffsets[0]+2] is the arg offsets for grouping attributes
   * <p>
   * argOffsets[argOffsets[0]+2 .. ] is the arg offsets for data attributes
   * @param child (undocumented)
   * @param groupingAttributes (undocumented)
   * @return (undocumented)
   */
  static public  scala.Tuple2<scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute>, int[]> resolveArgOffsets (org.apache.spark.sql.execution.SparkPlan child, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> groupingAttributes)  { throw new RuntimeException(); }
}
