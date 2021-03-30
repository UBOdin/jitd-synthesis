package org.apache.spark.sql.hive;
  class HiveSessionCatalog extends org.apache.spark.sql.catalyst.catalog.SessionCatalog {
  // not preceding
  public   HiveSessionCatalog (scala.Function0<org.apache.spark.sql.catalyst.catalog.ExternalCatalog> externalCatalogBuilder, scala.Function0<org.apache.spark.sql.catalyst.catalog.GlobalTempViewManager> globalTempViewManagerBuilder, org.apache.spark.sql.hive.HiveMetastoreCatalog metastoreCatalog, org.apache.spark.sql.catalyst.analysis.FunctionRegistry functionRegistry, org.apache.hadoop.conf.Configuration hadoopConf, org.apache.spark.sql.catalyst.parser.ParserInterface parser, org.apache.spark.sql.catalyst.catalog.FunctionResourceLoader functionResourceLoader)  { throw new RuntimeException(); }
  public  boolean functionExists (org.apache.spark.sql.catalyst.FunctionIdentifier name)  { throw new RuntimeException(); }
  public  boolean isPersistentFunction (org.apache.spark.sql.catalyst.FunctionIdentifier name)  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression lookupFunction (org.apache.spark.sql.catalyst.FunctionIdentifier name, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children)  { throw new RuntimeException(); }
  /**
   * Constructs a {@link Expression} based on the provided class that represents a function.
   * <p>
   * This performs reflection to decide what type of {@link Expression} to return in the builder.
   * @param name (undocumented)
   * @param clazz (undocumented)
   * @param input (undocumented)
   * @return (undocumented)
   */
  public  org.apache.spark.sql.catalyst.expressions.Expression makeFunctionExpression (java.lang.String name, java.lang.Class<?> clazz, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> input)  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.hive.HiveMetastoreCatalog metastoreCatalog ()  { throw new RuntimeException(); }
}
