import sbtrelease.ReleasePlugin._
import sbtrelease.ReleasePlugin.ReleaseKeys._
import sbtrelease.ReleaseStateTransformations._
import com.typesafe.sbt.pgp.PgpKeys._

javacOptions ++= {
  if (System.getProperty("rt.path") != null)  Seq("-source", "1.6", "-target", "1.6", "-bootclasspath", System.getProperty("rt.path"))
  else                                        Seq()
}

releaseSettings

publishArtifactsAction := PgpKeys.publishSigned.value

ReleaseKeys.crossBuild := true
