package org.apache.spark.sql.catalyst;
/**
 * Trait for getting the active SQLConf.
 */
public  interface SQLConfHelper {
  /**
   * The active config object within the current scope.
   * See {@link SQLConf.get} for more information.
   * @return (undocumented)
   */
  public  org.apache.spark.sql.internal.SQLConf conf ()  ;
}
