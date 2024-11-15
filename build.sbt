// Project metadata
ThisBuild / name := "scalafmt-rules"
ThisBuild / version := "1.2.0"
ThisBuild / organization := "datenwissenschaften"
ThisBuild / sbtPlugin := true
ThisBuild / versionScheme := Some("semver-spec")

// Global settings
Global / excludeLintKeys += ThisBuild / name

// Scala version and semanticdb configuration
ThisBuild / scalaVersion := "2.12.17"
ThisBuild / semanticdbEnabled := true
ThisBuild / semanticdbVersion := scalafixSemanticdb.revision

// Add Scala compiler options
ThisBuild / scalacOptions ++= Seq(
  "-Ywarn-unused", // Enables warnings for unused code
  "-Xlint:unused" // Enables detailed linting for unused code (Scala 2.12.2 or above)
)

// Licensing and repository information
ThisBuild / licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
ThisBuild / homepage := Some(url("https://github.com/datenwissenschaften/scalafmt-rules"))
ThisBuild / scmInfo := Some(
  ScmInfo(
    url("https://github.com/datenwissenschaften/scalafmt-rules"),
    "scm:git@github.com:datenwissenschaften/scalafmt-rules.git"
  )
)
ThisBuild / developers := List(
  Developer(
    id = "datenwissenschaften",
    name = "Martin",
    email = "martin.franke@datenwissenschaften.com",
    url = url("https://www.datenwissenschaften.com")
  )
)

// Scalafix configuration
import coursierapi.MavenRepository
ThisBuild / scalafixResolvers += MavenRepository.of("https://nexus.datenwissenschaften.com/repository/maven-releases/")
ThisBuild / scalafixDependencies += "com.datenwissenschaften" %% "scalafix-rules" % "1.1.2"

// Publishing configuration
ThisBuild / publishTo := {
  val nexus = "https://nexus.datenwissenschaften.com/repository/"
  if (version.value.endsWith("SNAPSHOT")) Some("Snapshots".at(nexus + "maven-snapshots/"))
  else Some("Releases".at(nexus + "maven-releases/"))
}
ThisBuild / publishMavenStyle := true
