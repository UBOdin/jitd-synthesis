package org.apache.spark.sql.catalyst;
/**
 * Encapsulates an identifier that is either a alias name or an identifier that has table
 * name and a qualifier.
 * The SubqueryAlias node keeps track of the qualifier using the information in this structure
 * param:  name - Is an alias name or a table name
 * param:  qualifier - Is a qualifier
 */
public  class AliasIdentifier implements scala.Product, scala.Serializable {
  static public  org.apache.spark.sql.catalyst.AliasIdentifier apply (java.lang.String name)  { throw new RuntimeException(); }
  public  java.lang.String name ()  { throw new RuntimeException(); }
  public  scala.collection.Seq<java.lang.String> qualifier ()  { throw new RuntimeException(); }
  // not preceding
  public   AliasIdentifier (java.lang.String name, scala.collection.Seq<java.lang.String> qualifier)  { throw new RuntimeException(); }
  public   AliasIdentifier (java.lang.String identifier)  { throw new RuntimeException(); }
  public  java.lang.String toString ()  { throw new RuntimeException(); }
}
