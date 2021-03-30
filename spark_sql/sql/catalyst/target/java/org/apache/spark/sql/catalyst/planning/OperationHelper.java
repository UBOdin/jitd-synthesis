package org.apache.spark.sql.catalyst.planning;
public  interface OperationHelper {
  public  org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.expressions.Expression> collectAliases (scala.collection.Seq<org.apache.spark.sql.catalyst.expressions.Expression> fields)  ;
  public  org.apache.spark.sql.catalyst.expressions.Expression substitute (org.apache.spark.sql.catalyst.expressions.AttributeMap<org.apache.spark.sql.catalyst.expressions.Expression> aliases, org.apache.spark.sql.catalyst.expressions.Expression expr)  ;
}
