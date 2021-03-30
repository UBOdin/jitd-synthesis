package org.apache.spark.sql.catalyst.expressions;
public  class SchemaPruning$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final SchemaPruning$ MODULE$ = null;
  public   SchemaPruning$ ()  { throw new RuntimeException(); }
  /**
   * Filters the schema by the requested fields. For example, if the schema is struct<a:int, b:int>,
   * and given requested field are "a", the field "b" is pruned in the returned schema.
   * Note that schema field ordering at original schema is still preserved in pruned schema.
   * @param dataSchema (undocumented)
   * @param requestedRootFields (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.types.StructType pruneDataSchema (org.apache.spark.sql.types.StructType dataSchema, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SchemaPruning.RootField> requestedRootFields)  { throw new RuntimeException(); }
  /**
   * Returns the set of fields from projection and filtering predicates that the query plan needs.
   * @param projects (undocumented)
   * @param filters (undocumented)
   * @return (undocumented)
   */
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.SchemaPruning.RootField> identifyRootFields (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.NamedExpression> projects, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> filters)  { throw new RuntimeException(); }
}
