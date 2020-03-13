package jitd

import java.io._
import org.rogach.scallop._
import scala.sys.process._

import jitd.typecheck._

object JITDGen {

  def write(path: File, content: String)
  {
    val out = new FileWriter(path)
    out.write(content)
    out.close()
  }


  def main(args: Array[String])
  {
    // Parse arguments (see the bottom of this file)
    val conf = new JITDGenConfig(args)
    conf.verify()

    val outputDir       = new File(conf.outputDirectory())
    val bodyFilename    = s"${conf.outputFile()}.cpp"
    val bodyFile        = new File(outputDir, bodyFilename)
    val headerFilename  = s"${conf.outputFile()}.hpp"
    val headerFile      = new File(outputDir, headerFilename)

    // Load a JITD specification.  For now, this is
    // hard-coded to the KeyValueJITD in jitd.example.
    // Eventually, this should come from a spec file.
    val spec = 
      jitd.example.KeyValueJITD.definition

    if(conf.dump()){ System.out.println(spec.toString); }

    // Render is the root of the C++ code generation 
    // process. 
    val render = new jitd.codegen.Render(spec)

    // Actually generate and write out the C++ files.
    System.out.println("Rendering...")
    try { 
      write(headerFile, render.header())
      write(bodyFile,   render.body(headerFilename))
    } catch { 
      case e:Exception => 
        System.err.println(e.toString)
        System.exit(-1)
    }
    System.out.println("         ...done")

    // If we don't want to compile, we're done
    if(!conf.compile()){ return }

    // Compile!
    val logger = ProcessLogger(
      line => { System.out.println(line); },
      line => { System.err.println(line); }
    )

    val compile = Seq(
      "g++", 
      "-pthread",
      "-std=c++11",
      "-o", conf.target()
    ) ++ (
      if(conf.debugSymbols()) { Seq("-g") } else { Seq() } 
    )++(
      conf.debugModes.get.toSeq.flatten.map { mode =>
        Debug.fromString(mode) match {
          case None => throw new RuntimeException("Invalid Debug Mode "+mode); 
          case Some(x) => "-D "+Debug.aspectMacro(x)
        }
      }
    )++
    Seq(
      "-I", "src/main/cpp/include",
      "-I", "target",
      bodyFile.toString, 
      //"-I/home/csgrad/dbalakri/tbbsrc/tbb-tbb_2020/include -Wl,-rpath,/home/csgrad/dbalakri/tbbsrc/tbb-tbb_2020/build/linux_intel64_gcc_cc5.4.0_libc2.23_kernel4.4.0_release -L/home/csgrad/dbalakri/tbbsrc/tbb-tbb_2020/build/linux_intel64_gcc_cc5.4.0_libc2.23_kernel4.4.0_release",
      "-ltbb",
      conf.main()
    )

    System.out.println("Compiling...")
    if((compile ! logger) != 0){
      System.err.println("Error in compiling")
      return
    }
    System.out.println("         ...done")

    if(!conf.run()){ return }

    val run:Seq[String] = Seq("./"+conf.target()) ++ conf.otherArgs()

    System.out.println("Running...")
    if((run ! logger) != 0){
      System.err.println("Error in running")
      return
    }
    System.out.println("       ...done")
  }

}

class JITDGenConfig(arguments: Seq[String]) extends ScallopConf(arguments)
{
  val outputDirectory = opt[String]("dir",
    descr = "Directory to dump generated files",
    default = Some("target")
  )

  val outputFile = opt[String]("out",
    descr = "Base name used to generate the JITD .hpp and .cpp files",
    default = Some("jitd_test")
  )

  val dump = toggle("dump",
    descrYes = "Echo out the selected policy",
    default = Some(false)
  )

  val typecheck = toggle("typecheck",
    descrYes = "Typecheck everything before dumping out",
    default = Some(false)
  )

  val compile = toggle("compile",
    descrYes = "Also compile the generated code",
    default = Some(true)
  )

  val debugSymbols = toggle("debug",
    descrYes = "Enable debug symbols when compiling (requires --compile)",
    default = Some(true)
  )

  val main = opt[String]("main", 
    descr = "Specify the main file for compilation (requires --compile)",
    default = Some("src/main/cpp/source/jitd_tester.cpp")
  )

  val target = opt[String]("bin",
    descr = "Specify the binary target for compilation (requires --compile)",
    default = Some("jitd_test")
  )

  val debugModes = opt[List[String]]("DEBUG", 
    descr = "Enable the specified debug modes ("+Debug.values.mkString(", ")+")",
    default = Some(List[String]())
  )

  val run = toggle("run",
    descrYes = "Also run the compiled target (requires --compile)",
    default = Some(false)
  )

  val otherArgs = trailArg[List[String]](required = false, default = Some(List()))
}