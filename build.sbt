import scala.sys.process._

name := "jitd-synthesis"
version := "0.1"
organization := "edu.buffalo.cse.odin"
scalaVersion := "2.11.11"

dependencyOverrides += "org.scala-lang" % "scala-library" % scalaVersion.value

scalacOptions ++= Seq(
  "-feature"
)

fork := true


resolvers += "MimirDB" at "http://maven.mimirdb.info/"
resolvers ++= Seq("snapshots", "releases").map(Resolver.sonatypeRepo)

watchSources ++= Seq((baseDirectory in ThisBuild).value / "src/main/twirl")
watchSources ++= Seq((baseDirectory in ThisBuild).value / "src/main/cpp")

libraryDependencies ++= Seq(
  ////////////////////// Command-Line Interface Utilities //////////////////////
  "org.rogach"                    %%  "scallop"                  % "0.9.5",

  ////////////////////// Dev Tools -- Logging, Testing, etc... //////////////////////
  "com.typesafe.scala-logging"    %%  "scala-logging-slf4j"      % "2.1.2",
  "ch.qos.logback"                %   "logback-classic"          % "1.1.7",
  "org.specs2"                    %%  "specs2-core"              % "3.8.4" % "test",
  "org.specs2"                    %%  "specs2-matcher-extra"     % "3.8.4" % "test",
  "org.specs2"                    %%  "specs2-junit"             % "3.8.4" % "test",
  
  //////////////////////// Data Munging Tools //////////////////////
  "com.github.nscala-time"        %%  "nscala-time"              % "1.2.0",
)

// Support for templates through scala play twirl
// https://github.com/playframework/twirl
lazy val root = (project in file(".")).enablePlugins(SbtTwirl)


////// Publishing Metadata //////
// use `sbt publish make-pom` to generate 
// a publishable jar artifact and its POM metadata

publishMavenStyle := true

pomExtra := <url>https://odin.cse.buffalo.edu/research/astral/index.html</url>
  <licenses>
    <license>
      <name>Apache License 2.0</name>
      <url>http://www.apache.org/licenses/</url>
      <distribution>repo</distribution>
    </license>
  </licenses>
  <scm>
    <url>git@github.com:ubodin/jitd-synthesis.git</url>
    <connection>scm:git:git@github.com:ubodin/jitd-synthesis.git</connection>
  </scm>

/////// Publishing Options ////////
// use `sbt publish` to update the package in 
// your own local ivy cache
publishTo := Some(Resolver.file("file",  new File(Path.userHome.absolutePath+"/.m2/repository")))

