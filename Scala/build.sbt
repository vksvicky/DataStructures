ThisBuild / version := "0.1.0-SNAPSHOT"

ThisBuild / scalaVersion := "3.3.4"

lazy val root = (project in file("."))
  .settings(
    name := "DataStructures in Scala"
  )


libraryDependencies ++= {
  val scalatestVersion = "3.2.19"
  val scalacticVersion = "3.2.19"
  val scalatestCucumberVersion = "8.25.1"
  val cucmberJavaVersion = "7.20.1"
  val mockitoScalaVersion = "1.17.37"

  Seq(
    "org.scalatest" %% "scalatest" % scalatestVersion % Test,
    "org.scalactic" %% "scalactic" % scalacticVersion % Test,
    "io.cucumber" % "cucumber-scala_3" % scalatestCucumberVersion % Test,
    "io.cucumber" % "cucumber-java" % cucmberJavaVersion % Test,
//    "org.mockito" % "mockito-scala_2.13" % mockitoScalaVersion % Test
  )
}
