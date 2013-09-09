import sbt._

object Dependencies {

  val scalatest = "org.scalatest" %% "scalatest" % "1.9.1"
  val junit = "junit" % "junit" % "4.11"

  val poi = "org.apache.poi" % "poi" % "3.9"

  val appDependencies = Seq(
    scalatest % "test",
    junit % "test",
    poi
  )

}