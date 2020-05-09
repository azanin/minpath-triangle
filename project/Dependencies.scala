import sbt._

object Dependencies {
  val catsEffectV          = "2.1.3"
  val scalaTestV           = "3.1.1"
  val catsEffectScalaTestV = "0.4.0"

  val kindProjectorV    = "0.11.0"
  val betterMonadicForV = "0.3.1"

  lazy val kindProjector    = "org.typelevel" %% "kind-projector"     % kindProjectorV cross CrossVersion.full
  lazy val betterMonadicFor = "com.olegpy"    %% "better-monadic-for" % betterMonadicForV

  lazy val scalaTest           = "org.scalatest"  %% "scalatest"                     % scalaTestV
  lazy val catsEffect          = "org.typelevel"  %% "cats-effect"                   % catsEffectV
  lazy val catsEffectScalaTest = "com.codecommit" %% "cats-effect-testing-scalatest" % catsEffectScalaTestV
}
