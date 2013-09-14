import sbt._

object Dependencies {

  val scalatest = "org.scalatest" %% "scalatest" % "1.9.1"
  val junit = "junit" % "junit" % "4.11"
  //val dispatch = "net.databinder.dispatch" %% "dispatch-core" % "0.11.0"
  val json4sNative = "org.json4s" %% "json4s-native" % "3.2.5"
  val poi = "org.apache.poi" % "poi" % "3.9"

  val appDependencies = Seq(
    scalatest % "test",
    junit % "test",
    //dispatch
    json4sNative,
    poi
  )

}