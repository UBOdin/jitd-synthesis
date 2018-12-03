package jitd.codegen

import java.io.File
import java.io.FileWriter
import scala.sys.process._
import scala.collection.mutable.ListBuffer

object Compile {

  def apply(render: Render, main: String = "src/cpp/source/compile_test.cpp"): String =
  {
    val bodyFile = new File("target/jitd_test.cpp")
    val body = new FileWriter(bodyFile)
    body.write(render.body("jitd_test.hpp"))
    body.close()

    val headerFile = new File("target/jitd_test.hpp")//File.createTempFile("jitd-test-",".cpp");
    val header = new FileWriter(headerFile)
    header.write(render.header())
    header.close()



    val gccOutput = ListBuffer[String]()
    val logger = ProcessLogger(
      line => { gccOutput += line; },
      line => { gccOutput += line; }
    )

    val command = Seq(
      "g++", 
      "-o", "jitd_test",
      "-I", "src/cpp/include",
      "-I", "target",
      bodyFile.toString, main
    )

    if((command ! logger) == 0) {
      Seq("./jitd_test") ! logger
    }
    return gccOutput.mkString("\n")
  }

}