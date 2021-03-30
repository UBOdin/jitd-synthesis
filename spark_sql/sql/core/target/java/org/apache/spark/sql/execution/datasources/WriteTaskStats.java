package org.apache.spark.sql.execution.datasources;
/**
 * To be implemented by classes that represent data statistics collected during a Write Task.
 * It is important that instances of this type are {@link Serializable}, as they will be gathered
 * on the driver from all executors.
 */
public  interface WriteTaskStats extends scala.Serializable {
}
