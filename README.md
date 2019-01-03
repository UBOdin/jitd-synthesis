
JITD Synthesizer
==================

A simple proof-of-concept for dynamically synthesizing just-in-time data structures.


Requirements
-------------

- [Scala](https://www.scala-lang.org/download/)
- [Scala Build Tool](https://www.scala-sbt.org/download.html)
- G++/Clang++ (or compatible)


Usage
------

To compile or run, use SBT.  Launch sbt:

```
$> cd jitd-synthesis
$> sbt
```

Compile with the `compile` command:
```
sbt:jitd-synthesis> compile
```

Run all test cases with the `test` command, or test only one test case with testOnly and the fully qualified class name.
```
sbt:jitd-synthesis> test
sbt:jitd-synthesis> testOnly jitd.codegen.AccessorSpec
```

Run the generator using `run`.  Use `run --help` to see a list of command-line arguments
```
sbt:jitd-synthesis> run
sbt:jitd-synthesis> run --help
sbt:jitd-synthesis> run --run examples/simple_btree.jitd
```

See some example policy behavior with
```
sbt:jitd-synthesis> run -r examples/simple_reorg_test.jitd
sbt:jitd-synthesis> run -r -DPolicy -- examples/simple_reorg_test.jitd
```
