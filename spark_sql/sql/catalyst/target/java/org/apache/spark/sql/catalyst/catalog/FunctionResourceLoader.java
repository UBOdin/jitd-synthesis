package org.apache.spark.sql.catalyst.catalog;
/**
 * A simple trait representing a class that can be used to load resources used by
 * a function. Because only a SQLContext can load resources, we create this trait
 * to avoid of explicitly passing SQLContext around.
 */
public  interface FunctionResourceLoader {
  public  void loadResource (org.apache.spark.sql.catalyst.catalog.FunctionResource resource)  ;
}
