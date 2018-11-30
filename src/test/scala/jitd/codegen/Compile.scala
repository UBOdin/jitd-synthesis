package jitd.codegen

import java.io.File
import java.io.FileWriter
import scala.sys.process._
import scala.collection.mutable.ListBuffer

object Compile {

  def apply(render: Render): String =
  {
    val file = File.createTempFile("jitd-test-",".cpp");
    val out = new FileWriter(file)
    out.write(render())
    out.write("\n\nint main(int argc, char **argv){ \n  std::cout << \"TEST SUCCESSFUL!\";\n  return 0;\n }")
    out.close()

    val gccOutput = ListBuffer[String]()
    val logger = ProcessLogger(
      line => { gccOutput += line; },
      line => { gccOutput += line; }
    )

    val command = Seq(
      "g++", 
      "-I", "src/cpp/include",
      file.toString
    )

    if((command ! logger) == 0) {
      Seq("./a.out") ! logger
    }
    return gccOutput.mkString("\n")
  }

}