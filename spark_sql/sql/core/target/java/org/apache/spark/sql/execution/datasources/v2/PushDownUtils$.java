package org.apache.spark.sql.execution.datasources.v2;
public  class PushDownUtils$ implements org.apache.spark.sql.catalyst.expressions.PredicateHelper {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final PushDownUtils$ MODULE$ = null;
  public   PushDownUtils$ ()  { throw new RuntimeException(); }
  /**
   * Pushes down filters to the data source reader
   * <p>
   * @return pushed filter and post-scan filters.
   * @param scanBuilder (undocumented)
   * @param filters (undocumented)
   */
  public  scala.Tuple2<scala.collection.Seq<org.apache.spark.sql.sources.Filter>, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression>> pushFilters (org.apache.spark.sql.connector.read.ScanBuilder scanBuilder, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> filters)  { throw new RuntimeException(); }
  /**
   * Applies column pruning to the data source, w.r.t. the references of the given expressions.
   * <p>
   * @return the <code>Scan</code> instance (since column pruning is the last step of operator pushdown),
   *         and new output attributes after column pruning.
   * @param scanBuilder (undocumented)
   * @param relation (undocumented)
   * @param projects (undocumented)
   * @param filters (undocumented)
   */
  public  scala.Tuple2<org.apache.spark.sql.connector.read.Scan, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference>> pruneColumns (org.apache.spark.sql.connector.read.ScanBuilder scanBuilder, org.apache.spark.sql.execution.datasources.v2.DataSourceV2Relation relation, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> projects, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> filters)  { throw new RuntimeException(); }
}
