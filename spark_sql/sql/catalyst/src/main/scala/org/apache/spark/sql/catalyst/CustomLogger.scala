/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.spark.sql.catalyst

import scala.collection.mutable.Set
import scala.collection.mutable.Stack
class myBuffer {
  var counter: Long = 0;
}
object CustomLogger {

  var stateExecuteStack = Stack[String]()
  var stateStack = Stack[String]()
  var rewriteBufferStack = Stack[myBuffer]()
  // var searchBufferStack = Stack[myBuffer]()

  var mostRecentStamp: Long = 0

  var runningSearchTime: Long = 0
  var runningRewriteTime: Long = 0
  var runningExecutionTime: Long = 0

  var execRunningSearchTime: Long = 0
  var noExecRunningSearchTime: Long = 0
  var execRunningRewriteTime: Long = 0
  var noExecRunningRewriteTime: Long = 0
  // var runningSearchTimeEffective: Long = 0
  // var runningSearchTimeInEffective: Long = 0
  var runningRewriteTimeEffective: Long = 0
  var runningRewriteTimeInEffective: Long = 0

  var allRulesSet: Set[String] = Set()
  var effectiveRuleSet: Set[String] = Set()

  def assertNumbers(descriptor: String): Unit =
  {
    // scalastyle:off
    var calculatedBucketRewriteTime = runningRewriteTimeEffective + runningRewriteTimeInEffective
    if (execRunningRewriteTime != calculatedBucketRewriteTime)
    {
      throw new RuntimeException("Bucketed-rewrite Mismatch execRunningRewrite")
    }
    if (runningRewriteTime != (calculatedBucketRewriteTime + noExecRunningRewriteTime))
    {
      throw new RuntimeException("Running-Rewrite Mismatch Segregated Rewrites")
    }
    if (runningSearchTime != (execRunningSearchTime + noExecRunningSearchTime))
    {
      throw new RuntimeException("Running-Search Mismatch Segregated Search")
    }

    var totalRunTime = runningExecutionTime + runningSearchTime + runningRewriteTime
    var totalCalculatedRunTime = runningExecutionTime + noExecRunningSearchTime + execRunningSearchTime +
                                noExecRunningRewriteTime + runningRewriteTimeEffective + runningRewriteTimeInEffective
    
    if (totalRunTime != totalCalculatedRunTime)
    {
      throw new RuntimeException("Mismatch in run times")
    }
    // scalastyle:on
  }
  def ASTSize(descriptor: String, optimizedPlanSize: Integer, analyzedPlanSize: Integer): Unit =
  {
    // scalastyle:off
    println(s"$descriptor: Analyzed Plan Size : $analyzedPlanSize")
    println(s"$descriptor: Optimized Plan Size : $optimizedPlanSize")
    // scalastyle:on
  }
  def printTotalTiming(descriptor: String): Unit =
  {
    // scalastyle:off
    var runningSearchTimeSec = runningSearchTime/1000000000.0
    var noExecRunningSearchTimeSec = noExecRunningSearchTime/1000000000.0
    var execRunningSearchTimeSec = execRunningSearchTime/1000000000.0

    var runningRewriteTimeSec = runningRewriteTime/1000000000.0
    var noExecRunningRewriteTimeSec = noExecRunningRewriteTime/1000000000.0
    var execRunningRewriteTimeSec = execRunningRewriteTime/1000000000.0
    var runningRewriteTimeEffectiveSec = runningRewriteTimeEffective/1000000000.0
    var runningRewriteTimeInEffectiveSec = runningRewriteTimeInEffective/1000000000.0

    var runningExecutionTimeSec = runningExecutionTime/1000000000.0
    
    var runningDenominator = (runningSearchTime + runningRewriteTime)
    var runningCalculatedDenominator = runningSearchTime + runningRewriteTimeEffective + runningRewriteTimeInEffective
    var fractionSpentSearch = runningSearchTime.toDouble/runningDenominator.toDouble
    var percentSpentSearch = fractionSpentSearch * 100
    var fractionCalcSpentSearch = runningSearchTime.toDouble/runningCalculatedDenominator.toDouble
    var percentCalcSpentSearch = fractionCalcSpentSearch * 100
    
    var TotalRunTimeSec = runningExecutionTimeSec + runningSearchTimeSec + runningRewriteTimeSec
    var TotalCalculatedRunTime = runningExecutionTimeSec + noExecRunningSearchTimeSec + execRunningSearchTimeSec +
                                noExecRunningRewriteTimeSec + runningRewriteTimeEffectiveSec + runningRewriteTimeInEffectiveSec
    println("------------------------------")                            
    println(s"$descriptor: Total Time in Search Phase that has an exec $execRunningSearchTime ns or $execRunningSearchTimeSec sec")
    println(s"$descriptor: Total Time in Search Phase that doesn't have an exec $noExecRunningSearchTime ns or $noExecRunningSearchTimeSec sec")
    println(s"$descriptor: Total Time in Search Phase $runningSearchTime ns or $runningSearchTimeSec sec")
    
    println("------------------------------")
    println(s"$descriptor: Total Time in Rewrite Phase that has an exec and can be bucketed $execRunningRewriteTime ns or $execRunningRewriteTimeSec sec")
    println(s"$descriptor: Total Time in Rewrite Phase Effective $runningRewriteTimeEffective ns or $runningRewriteTimeEffectiveSec sec")
    println(s"$descriptor: Total Time in Rewrite Phase InEffective $runningRewriteTimeInEffective ns or $runningRewriteTimeInEffectiveSec sec")
    println(s"$descriptor: Total Time in Rewrite Phase that doesn't have an exec $noExecRunningRewriteTime ns or $noExecRunningRewriteTimeSec sec")
    println(s"$descriptor: Total Time in Rewrite Phase $runningRewriteTime ns or $runningRewriteTimeSec sec")
    
    println("------------------------------")
    println(s"$descriptor: Total Time in Execution Phase $runningExecutionTime ns or $runningExecutionTimeSec sec")
    
    println("------------------------------")
    println(s"$descriptor: Fraction Time spent in Search(Total Time in Search/(Total Time in Search + Total Time in Rewrite)) $fractionSpentSearch or percentage $percentSpentSearch")
    println(s"$descriptor: Fraction Time spent in Search(Total Time in Search/(Total Time in Search + Total Time in Effective and InEffective Rewrite)) $fractionCalcSpentSearch or percentage $percentCalcSpentSearch")
    println("------------------------------")
    println(s"$descriptor: TotalRunTime (Execution + Search + Rewrite) is $TotalRunTimeSec sec")
    // scalastyle:on

  }
  def logAllRulesAsSet(ruleName: String): Unit = {
    allRulesSet += ruleName
  }

  def logEffectiveRulesAsSet(ruleName: String): Unit = {
    effectiveRuleSet += ruleName
  }

  def printAllRulesSet(descriptor: String): Unit =
  {
    // scalastyle:off
    println(s"$descriptor: Effective Rules $effectiveRuleSet")
    println(s"$descriptor: All Rules $allRulesSet")
    // println(s"$descriptor: $batchSet")
    // scalastyle:on
  }
  def onEnterTime(state: String, time: Long): Unit =
  {

    if (!stateStack.isEmpty)
    {
      if (stateStack.top contains "Transform")
      {
        // Should this be System.nantom()???
        val diff = (time - mostRecentStamp)
        runningSearchTime += diff
        // Code that takes care of total run time
        if (!stateExecuteStack.isEmpty)
        {
          execRunningSearchTime += diff
        }
        else
        {
          noExecRunningSearchTime += diff
        }
        // The search time is to be buffered.
        // searchBufferStack.top.counter += diff
      }
      if (stateStack.top contains "Match")
      {
        // Should this be System.nantom()???
        val diff = (time - mostRecentStamp)
        runningRewriteTime += diff
        if (!stateExecuteStack.isEmpty)
        {
        // Code that takes care of total run time
          execRunningRewriteTime += diff
          // The rewrite time is to be buffered.
          rewriteBufferStack.top.counter += diff
        }
        else
        {
          noExecRunningRewriteTime += diff
        }
      }
      if (stateStack.top contains "Execute")
      {
        // Should this be System.nantom()???
        val diff = (time - mostRecentStamp)
        // Code that takes care of total run time
        runningExecutionTime += diff
      }
    }
    // Comes here regardless of if this is the first call or recursion
    // Should this be System.nantom()???
    stateStack.push(state)
    mostRecentStamp = time
  }
  def onExitTime(state: String, time: Long): Unit =
  {
    if (stateStack.isEmpty)
    {
      throw new RuntimeException(s"The state stack is empty on exiting $state")
    }
    // Assertion that we see the state as expected.
    assert(stateStack.top contains state,
      s"State Stack top and $state donot Match! Assertion Failed")
    if (stateStack.top contains "Transform")
    {
      // Should this be System.nantom()???
      val diff = (time - mostRecentStamp)
      runningSearchTime += diff
      if (!stateExecuteStack.isEmpty)
      {
          // Code that takes care of total run time
          execRunningSearchTime += diff
      }
      else
      {
        noExecRunningSearchTime += diff
      }
      // The search time is to be buffered.
      // searchBufferStack.top.counter += diff
    }
    if (stateStack.top contains "Match")
    {
      // Should this be System.nantom()???
      val diff = (time - mostRecentStamp)
      runningRewriteTime += diff
      if (!stateExecuteStack.isEmpty)
      {
        // Code that takes care of total run time
        execRunningRewriteTime += diff
        // The rewrite time is to be buffered.
        rewriteBufferStack.top.counter += diff
      }
      else
      {
        noExecRunningRewriteTime += diff
      }
    }
    if (stateStack.top contains "Execute")
    {
      // Should this be System.nantom()???
      val diff = (time - mostRecentStamp)
      // Code that takes care of total run time
      runningExecutionTime += diff
    }
    mostRecentStamp = time
    stateStack.pop
  }
  def logTransformTime[F](
  descriptor: String,
  context: String = "",
  log: (String => Unit) =
  // scalastyle:off
  println(_)
  // scalastyle:on
  )(anonFunc: => F): F = {
    // Entering a Transform
    // scalastyle:off
    // if ((descriptor contains "ResolveRelations") || (descriptor contains "ResolveTempViews"))
    // {
    // println(s"$descriptor Entering Transform")
    // }
    // scalastyle:on
    onEnterTime("Transform", System.nanoTime())

    // looking for rewrites
    val anonFuncRet = anonFunc

    // Exiting a Transform
    // scalastyle:off
    // if ((descriptor contains "ResolveRelations") || (descriptor contains "ResolveTempViews"))
    // {
    // println(s"$descriptor Exiting Transform")
    // }
    // scalastyle:on
    onExitTime("Transform", System.nanoTime())
    anonFuncRet
  }

  def logMatchTime[F](
  descriptor: String,
  unAffected: Boolean,
  context: String = "",
  log: (String => Unit) =
  // scalastyle:off
  println(_)
  // scalastyle:on
  )(anonFunc: => F): F = {
    // Entering a Match
    // scalastyle:off
    // if ((descriptor contains "ResolveRelations") || (descriptor contains "ResolveTempViews"))
    // {
    // println(s"$descriptor Entering Match")
    // }
    // scalastyle:on
    onEnterTime("Match", System.nanoTime())

    // Applying the rewrite
    val anonFuncRet = anonFunc

    // Exiting a Match
    // scalastyle:off
     // if ((descriptor contains "ResolveRelations") || (descriptor contains "ResolveTempViews"))
     // { 
     // println(s"$descriptor Exiting Match")
     // }
    // scalastyle:on
    onExitTime("Match", System.nanoTime())
    anonFuncRet
  }
  def pushCounterStacks(descriptor: String): Unit =
  {
    // scalastyle:off
    // println("Pushing into Into Rewrite Butter a new Counter")
    // scalastyle:on
    // searchBufferStack.push(new myBuffer())
    rewriteBufferStack.push(new myBuffer())
  }
  def popCounterStacks(ruleEffectFromExecute: Boolean, descriptor: String): Unit =
  {

    if (ruleEffectFromExecute == true)
    {
       // scalastyle:off
      // println("Rewrite was effective so will update and pop")
       // scalastyle:on
      runningRewriteTimeEffective += rewriteBufferStack.top.counter
      rewriteBufferStack.pop
    }
    else
    {
      // scalastyle:off
      // println("Rewrite was Ineffective so will update and pop")
       // scalastyle:on
      runningRewriteTimeInEffective += rewriteBufferStack.top.counter
      rewriteBufferStack.pop
    }
  }
  def logExecutionTime[F](
  descriptor: String,
  context: String = "",
  log: (String => Unit) =
  // scalastyle:off
  println(_)
  // scalastyle:on
  )(anonFunc: => F): F = {
    // Entering a Batch
    // scalastyle:off
    // println(s"$descriptor Entering Rule Executor")
    // scalastyle:on
    stateExecuteStack.push("Execute")
    onEnterTime("Execute", System.nanoTime())

    // Applying the rewrite
    val anonFuncRet = anonFunc

    // Exiting a Match
    // scalastyle:off
    // println(s"$descriptor Exiting Rule Executor")
    // scalastyle:on
    onExitTime("Execute", System.nanoTime())
    stateExecuteStack.pop
    anonFuncRet
  }
}