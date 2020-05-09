import Dependencies._

ThisBuild / scalaVersion := "2.13.1"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "io.azanin"
ThisBuild / organizationName := "azanin"

lazy val root = (project in file("."))
  .settings(
    name := "suprnation",
    addCompilerPlugin(kindProjector),
    addCompilerPlugin(betterMonadicFor),
    scalafmtOnCompile := true,
    libraryDependencies ++=
      Seq(catsEffect, catsEffectScalaTest % Test, scalaTest % Test)
  )
