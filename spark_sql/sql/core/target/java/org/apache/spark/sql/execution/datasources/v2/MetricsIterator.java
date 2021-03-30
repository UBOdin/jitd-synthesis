package org.apache.spark.sql.execution.datasources.v2;
public abstract class MetricsIterator<I extends java.lang.Object> implements scala.collection.Iterator<I> {
  // not preceding
  // TypeTree().setOriginal(TypeBoundsTree(TypeTree(), TypeTree()))
  public   MetricsIterator (scala.collection.Iterator<I> iter)  { throw new RuntimeException(); }
  public  boolean hasNext ()  { throw new RuntimeException(); }
  protected  org.apache.spark.sql.execution.datasources.v2.MetricsHandler metricsHandler ()  { throw new RuntimeException(); }
}
