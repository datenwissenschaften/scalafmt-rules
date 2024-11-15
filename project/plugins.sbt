resolvers += Resolver.sonatypeRepo("releases")
resolvers ++= Seq(
  "Nexus Releases".at("https://nexus.datenwissenschaften.com/repository/maven-releases/"),
  "Nexus Snapshots".at("https://nexus.datenwissenschaften.com/repository/maven-snapshots/"),
  "Maven Central".at("https://repo1.maven.org/maven2")
)

addSbtPlugin("ch.epfl.scala" % "sbt-scalafix" % "0.11.1")
addSbtPlugin("com.eed3si9n" % "sbt-projectmatrix" % "0.9.2")
addSbtPlugin("com.eed3si9n" % "sbt-buildinfo" % "0.11.0")
addSbtPlugin("org.scalameta" % "sbt-scalafmt" % "2.5.2")
addSbtPlugin("nl.gn0s1s" % "sbt-dotenv" % "3.0.0")
addSbtPlugin("org.scoverage" % "sbt-scoverage" % "2.0.12")

addDependencyTreePlugin
