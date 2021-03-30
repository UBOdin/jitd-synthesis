package org.apache.spark.sql.connector.catalog;
public  class Catalogs$ {
  /**
   * Static reference to the singleton instance of this Scala object.
   */
  public static final Catalogs$ MODULE$ = null;
  public   Catalogs$ ()  { throw new RuntimeException(); }
  /**
   * Load and configure a catalog by name.
   * <p>
   * This loads, instantiates, and initializes the catalog plugin for each call; it does not cache
   * or reuse instances.
   * <p>
   * @param name a String catalog name
   * @param conf a SQLConf
   * @return an initialized CatalogPlugin
   * @throws CatalogNotFoundException if the plugin class cannot be found
   * @throws org.apache.spark.SparkException           if the plugin class cannot be instantiated
   */
  public  org.apache.spark.sql.connector.catalog.CatalogPlugin load (java.lang.String name, org.apache.spark.sql.internal.SQLConf conf) throws org.apache.spark.sql.connector.catalog.CatalogNotFoundException, org.apache.spark.SparkException { throw new RuntimeException(); }
}
