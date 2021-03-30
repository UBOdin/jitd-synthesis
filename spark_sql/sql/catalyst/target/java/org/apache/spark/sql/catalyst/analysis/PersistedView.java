package org.apache.spark.sql.catalyst.analysis;
/**
 * PersistedView means cross-session persisted views. Persisted views stay until they are
 * explicitly dropped by user command. It's always tied to a database, default to the current
 * database if not specified.
 * <p>
 * Note that, Existing persisted view with the same name are not visible to the current session
 * while the local temporary view exists, unless the view name is qualified by database.
 */
public  class PersistedView {
  static public  java.lang.String toString ()  { throw new RuntimeException(); }
}
