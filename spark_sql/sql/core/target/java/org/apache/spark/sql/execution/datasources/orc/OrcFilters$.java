package org.apache.spark.sql.execution.datasources.orc;
/**
 * Helper object for building ORC <code>SearchArgument</code>s, which are used for ORC predicate push-down.
 * <p>
 * Due to limitation of ORC <code>SearchArgument</code> builder, we had to implement separate checking and
 * conversion passes through the Filter to make sure we only convert predicates that are known
 * to be convertible.
 * <p>
 * An ORC <code>SearchArgument</code> must be built in one pass using a single builder.  For example, you can't
 * build <code>a = 1</code> and <code>b = 2</code> first, and then combine them into <code>a = 1 AND b = 2</code>.  This is quite
 * different from the cases in Spark SQL or Parquet, where complex filters can be easily built using
 * existing simpler ones.
 * <p>
 * The annoying part is that, <code>SearchArgument</code> builder methods like <code>startAnd()</code>, <code>startOr()</code>, and
 * <code>startNot()</code> mutate internal state of the builder instance.  This forces us to translate all
 * convertible filters with a single builder instance. However, if we try to translate a filter
 * before checking whether it can be converted or not, we may end up with a builder whose internal
 * state is inconsistent in the case of an inconvertible filter.
 * <p>
 * For example, to convert an <code>And</code> filter with builder <code>b</code>, we call <code>b.startAnd()</code> first, and then
 * try to convert its children.  Say we convert <code>left</code> child successfully, but find that <code>right</code>
 * child is inconvertible.  Alas, <code>b.startAnd()</code> call can't be rolled back, and <code>b</code> is inconsistent
 * now.
 * <p>
 * The workaround employed here is to trim the Spark filters before trying to convert them. This
 * way, we can only do the actual conversion on the part of the Filter that is known to be
 * convertible.
 * <p>
 * P.S.: Hive seems to use <code>SearchArgument</code> together with <code>ExprNodeGenericFuncDesc</code> only.  Usage of
 * builder methods mentioned above can only be found in test code, where all tested filters are
 * known to be convertible.
 */
public  class OrcFilters$ implements org.apache.spark.sql.execution.datasources.orc.OrcFiltersBase {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final OrcFilters$ MODULE$ = null;
  public  org.apache.spark.sql.execution.datasources.orc.OrcFiltersBase.OrcPrimitiveField$ OrcPrimitiveField ()  { throw new RuntimeException(); }
  public   OrcFilters$ ()  { throw new RuntimeException(); }
  /**
   * Create ORC filter as a SearchArgument instance.
   * @param schema (undocumented)
   * @param filters (undocumented)
   * @return (undocumented)
   */
  public  scala.Option<org.apache.hadoop.hive.ql.io.sarg.SearchArgument> createFilter (org.apache.spark.sql.types.StructType schema, scala.collection.Seq<org.apache.spark.sql.sources.Filter> filters)  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.sources.Filter> convertibleFilters (scala.collection.immutable.Map<java.lang.String, org.apache.spark.sql.execution.datasources.orc.OrcFiltersBase.OrcPrimitiveField> dataTypeMap, scala.collection.Seq<org.apache.spark.sql.sources.Filter> filters)  { throw new RuntimeException(); }
  /**
   * Get PredicateLeafType which is corresponding to the given DataType.
   * @param dataType (undocumented)
   * @return (undocumented)
   */
  public  org.apache.hadoop.hive.ql.io.sarg.PredicateLeaf.Type getPredicateLeafType (org.apache.spark.sql.types.DataType dataType)  { throw new RuntimeException(); }
}
