import Dependencies._

ThisBuild / scalaVersion := "2.13.1"
ThisBuild / version := "0.1.0-SNAPSHOT"
ThisBuild / organization := "io.azanin"
ThisBuild / organizationName := "azanin"

lazy val root = (project in file("."))
  .settings(
    name := "minpath-triangle",
    addCompilerPlugin(kindProjector),
    addCompilerPlugin(betterMonadicFor),
    scalafmtOnCompile := true,
    libraryDependencies ++=
      Seq(catsEffect, scalaTest % Test)
  )
