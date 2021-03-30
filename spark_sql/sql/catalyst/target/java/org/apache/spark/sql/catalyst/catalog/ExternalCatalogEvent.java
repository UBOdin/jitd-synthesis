package org.apache.spark.sql.catalyst.catalog;
/**
 * Event emitted by the external catalog when it is modified. Events are either fired before or
 * after the modification (the event should document this).
 */
public  interface ExternalCatalogEvent extends org.apache.spark.scheduler.SparkListenerEvent {
}
