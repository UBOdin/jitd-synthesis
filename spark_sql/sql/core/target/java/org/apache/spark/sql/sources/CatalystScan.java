package org.apache.spark.sql.sources;
/**
 * ::Experimental::
 * An interface for experimenting with a more direct connection to the query planner.  Compared to
 * {@link PrunedFilteredScan}, this operator receives the raw expressions from the
 * <code>org.apache.spark.sql.catalyst.plans.logical.LogicalPlan</code>.  Unlike the other APIs this
 * interface is NOT designed to be binary compatible across releases and thus should only be used
 * for experimentation.
 * <p>
 * @since 1.3.0
 */
public  interface CatalystScan {
  public  org.apache.spark.rdd.RDD<org.apache.spark.sql.Row> buildScan (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Attribute> requiredColumns, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> filters)  ;
}
