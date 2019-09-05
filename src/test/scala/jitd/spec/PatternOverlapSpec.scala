package jitd.spec

import org.specs2.mutable._
import org.specs2.specification._

import jitd.example.KeyValueJITD

class PatternOverlapSpec extends Specification {

  val definition = KeyValueJITD.definition
  val patterns: Seq[(String, MatchPattern)] = 
    definition.transforms.map { xform => xform.name -> xform.from }

  def matches(outputStructure: MatchPattern): Seq[(String, Seq[PatternOverlap])] =
  {
    patterns.map { 
      case (xform, matcher) => xform -> Pattern.overlap(outputStructure, matcher, definition.nodes)
    }
  }

  def matchingTransforms(outputStructure: MatchPattern): Set[String] =
  {
    matches(outputStructure).filter { _._2.size > 0 }
                            .map { hit => hit._2.map { 
                                    case AncestorOverlap(i) => hit._1 + "@" + (0 until i).map { Seq("..") }.mkString("/")
                                    case ComponentOverlap(Seq()) => hit._1 + "@."
                                    case ComponentOverlap(path) => hit._1 + "@" + path.mkString("/")
                                  } 
                            }
                            .flatten
                            .toSet
  }

  sequential
  "The Key Value JITD should" >> {

    "Match Insertions Correctly" >> {
      val insertRewrite = definition.mutators.find { _.name.equals("insert") }
                                             .get
                                             .rewrite.toMatchPattern

      matchingTransforms(insertRewrite) must contain(exactly(
        "SortArray@rhs",
        "CrackArray@rhs",
        "PushDownAndCrack@."
      ))
    }
//Do a match deletes correctly!!
    "Match Overlap Correctly" >> {
      val PivotRightPattern = definition.transforms.find { _.name.equals("PivotRight") }
                                                   .get
                                                   .from
      val CrackRewritePattern = definition.transforms.find { _.name.equals("CrackArray") }
                                                     .get
                                                     .to.toMatchPattern
      Pattern.overlap(CrackRewritePattern, PivotRightPattern, definition.nodes) must contain(
        exactly(AncestorOverlap(1):PatternOverlap)
      )
    }

    "Match Cracking Outputs Correctly" >> {
      val crackRewrite = definition.transforms.find { _.name.equals("CrackArray") }
                                              .get
                                              .to.toMatchPattern

      matchingTransforms(crackRewrite) must contain(exactly(
        "SortArray@lhs",
        "SortArray@rhs",
        "CrackArray@lhs",
        "CrackArray@rhs",
        "PivotLeft@..",
        "PivotRight@..",
        "PushDownAndCrack@.."
      ))

    }

  }

}