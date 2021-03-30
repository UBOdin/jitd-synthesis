package org.apache.spark.sql.catalyst.plans.logical;
/** A trait used for logical plan nodes that create or replace V2 table definitions. */
public  interface V2CreateTablePlan {
  public  scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> partitioning ()  ;
  public  org.apache.spark.sql.connector.catalog.Identifier tableName ()  ;
  public  org.apache.spark.sql.types.StructType tableSchema ()  ;
  /**
   * Creates a copy of this node with the new partitioning transforms. This method is used to
   * rewrite the partition transforms normalized according to the table schema.
   * @param rewritten (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.plans.logical.V2CreateTablePlan withPartitioning (scala.collection.Seq<org.apache.spark.sql.connector.expressions.Transform> rewritten)  ;
}
