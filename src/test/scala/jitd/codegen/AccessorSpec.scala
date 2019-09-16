package jitd.codegen

import scala.sys.process._
import scala.collection.mutable.ListBuffer
import java.io.ByteArrayInputStream

import org.specs2.mutable._
import org.specs2.specification._

import jitd.example.KeyValueJITD

class AccessorSpec extends Specification with BeforeAll {

  val render = Render(KeyValueJITD.definition, debug = false)
  val target = "./test_accessor"

  def beforeAll = {
    print(Compile(
      render, 
      main = "src/main/cpp/source/jitd_tester.cpp", 
      compile_target = target
    ))
  }

  def test_get(build: Seq[String], gets:Seq[(Int, Boolean)]) =
  {
    val lines = Seq("build")++build++Seq("Return")++gets.map { i => s"get ${i._1}" }
    val ops = new ByteArrayInputStream((lines.mkString("\n")+"\n").getBytes("UTF-8")) 
    val cmd = Seq(target, "-ni", "-")
    val output = ListBuffer[String]()
    val logger = ProcessLogger(
      line => { output += line; },
      line => { output += line; }
    )
    (cmd #< ops) ! logger

    val GetResult = "Get ([0-9]+): (Success|Failed)".r
    val result = output.toSeq.map { 
      case GetResult(i, "Success") => Some(Integer.parseInt(i) -> true)
      case GetResult(i, "Failed") => Some(Integer.parseInt(i) -> false)
      case GetResult(i, r) => println("Odd: "+r); None
      case x => None
    }.flatten

    result.toSeq must contain(exactly(gets:_*))
  }

  "The Key Value JITD should" >> {

    "Allow access to Arrays" >> {
      test_get(Seq(
        "Array explicit 1 2 3 4 5"
      ), Seq(
        4 -> true, 
        8 -> false, 
        1 -> true,
        5 -> true,
        6 -> false
      ))
    }
    "Allow access to Sorted Arrays" >> {
      test_get(Seq(
        "SortedArray explicit 1 2 3 4 5"
      ), Seq(
        4 -> true, 
        8 -> false, 
        1 -> true,
        5 -> true,
        6 -> false
      ))
    }
    "Allow access to Concat Nodes" >> {
      test_get(Seq(
        "Array explicit 1 2 3",
        "Array explicit 4 5 6",
        "Concat"
      ), Seq(
        4 -> true, 
        8 -> false, 
        1 -> true,
        3 -> true,
        5 -> true,
        6 -> true,
        7 -> false
      ))
    }
    "Allow access to BTree Nodes" >> {
      test_get(Seq(
        "Array explicit 1 2 3",
        "Array explicit 4 5 6",
        "BTree 4"
      ), Seq(
        4 -> true, 
        8 -> false, 
        1 -> true,
        3 -> true,
        5 -> true,
        6 -> true,
        7 -> false
      ))
    }
  }

}