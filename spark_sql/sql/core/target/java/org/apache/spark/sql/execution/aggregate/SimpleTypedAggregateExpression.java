package org.apache.spark.sql.execution.aggregate;
public  class SimpleTypedAggregateExpression extends org.apache.spark.sql.catalyst.expressions.aggregate.DeclarativeAggregate implements org.apache.spark.sql.execution.aggregate.TypedAggregateExpression, org.apache.spark.sql.catalyst.expressions.NonSQLExpression, scala.Product, scala.Serializable {
  static public abstract  R apply (T1 v1, T2 v2, T3 v3, T4 v4, T5 v5, T6 v6, T7 v7, T8 v8, T9 v9, T10 v10, T11 v11)  ;
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.expressions.Aggregator<java.lang.Object, java.lang.Object, java.lang.Object> aggregator ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> inputDeserializer ()  { throw new RuntimeException(); }
  public  scala.Option<java.lang.Class<?>> inputClass ()  { throw new RuntimeException(); }
  public  scala.Option<org.apache.spark.sql.types.StructType> inputSchema ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> bufferSerializer ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggBufferAttributes ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.Expression bufferDeserializer ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> outputSerializer ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType outputExternalType ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.types.DataType dataType ()  { throw new RuntimeException(); }
  public  boolean nullable ()  { throw new RuntimeException(); }
  // not preceding
  public   SimpleTypedAggregateExpression (org.apache.spark.sql.expressions.Aggregator<java.lang.Object, java.lang.Object, java.lang.Object> aggregator, scala.Option<org.apache.spark.sql.catalyst.expressions.Expression> inputDeserializer, scala.Option<java.lang.Class<?>> inputClass, scala.Option<org.apache.spark.sql.types.StructType> inputSchema, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> bufferSerializer, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.AttributeReference> aggBufferAttributes, org.apache.spark.sql.catalyst.expressions.Expression bufferDeserializer, scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> outputSerializer, org.apache.spark.sql.types.DataType outputExternalType, org.apache.spark.sql.types.DataType dataType, boolean nullable)  { throw new RuntimeException(); }
  // not preceding
  public  boolean deterministic ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> children ()  { throw new RuntimeException(); }
  // not preceding
  public  boolean resolved ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.catalyst.expressions.AttributeSet references ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> initialValues ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> updateExpressions ()  { throw new RuntimeException(); }
  // not preceding
  public  scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> mergeExpressions ()  { throw new RuntimeException(); }
  // not preceding
  public  org.apache.spark.sql.catalyst.expressions.Expression evaluateExpression ()  { throw new RuntimeException(); }
  public  org.apache.spark.sql.execution.aggregate.TypedAggregateExpression withInputInfo (org.apache.spark.sql.catalyst.expressions.Expression deser, java.lang.Class<?> cls, org.apache.spark.sql.types.StructType schema)  { throw new RuntimeException(); }
}
