name := "scalafmt-rules"
version := "1.0.0"
organization := "datenwissenschaften"
sbtPlugin := true
scalaVersion := "2.12.17"

publishTo := Some("GitHub Package Registry".at("https://maven.pkg.github.com/datenwissenschaften/scalafmt-rules"))

credentials += Credentials(
  "GitHub Package Registry",
  "maven.pkg.github.com",
  "datenwissenschaften",
  System.getenv("GITHUB_TOKEN")
)

licenses := Seq("Apache-2.0" -> url("http://www.apache.org/licenses/LICENSE-2.0"))
homepage := Some(url("https://github.com/datenwissenschaften/scalafmt-rules"))
scmInfo := Some(
  ScmInfo(
    url("https://github.com/datenwissenschaften/scalafmt-rules"),
    "scm:git@github.com:datenwissenschaften/scalafmt-rules.git"
  )
)
developers := List(
  Developer(
    id = "datenwissenschaften",
    name = "Martin",
    email = "martin.franke@datenwissenschaften.com",
    url = url("https://www.datenwissenschaften.com")
  )
)
