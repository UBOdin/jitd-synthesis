package org.apache.spark.sql.execution.datasources;
/**
 * A class implementing this trait is basically a collection of parameters that are necessary
 * for instantiating a (derived type of) {@link WriteTaskStatsTracker} on all executors and then
 * process the statistics produced by them (e.g. save them to memory/disk, issue warnings, etc).
 * It is therefore important that such an objects is {@link Serializable}, as it will be sent
 * from the driver to all executors.
 */
public  interface WriteJobStatsTracker extends scala.Serializable {
  /**
   * Instantiates a {@link WriteTaskStatsTracker}, based on (non-transient) members of this class.
   * To be called by executors.
   * @return A {@link WriteTaskStatsTracker} instance to be used for computing stats during a write task
   */
  public  org.apache.spark.sql.execution.datasources.WriteTaskStatsTracker newTaskInstance ()  ;
  /**
   * Process the given collection of stats computed during this job.
   * E.g. aggregate them, write them to memory / disk, issue warnings, whatever.
   * @param stats One {@link WriteTaskStats} object from each successful write task.
   * @note The type of @param <code>stats</code> is too generic. These classes should probably be parametrized:
   *   WriteTaskStatsTracker[S <: WriteTaskStats]
   *   WriteJobStatsTracker[S <: WriteTaskStats, T <: WriteTaskStatsTracker[S}
   * and this would then be:
   *   def processStats(stats: Seq[S]): Unit
   * but then we wouldn't be able to have a Seq[WriteJobStatsTracker] due to type
   * co-/contra-variance considerations. Instead, you may feel free to just cast <code>stats</code>
   * to the expected derived type when implementing this method in a derived class.
   * The framework will make sure to call this with the right arguments.
   */
  public  void processStats (scala.collection.Seq<org.apache.spark.sql.execution.datasources.WriteTaskStats> stats)  ;
}
