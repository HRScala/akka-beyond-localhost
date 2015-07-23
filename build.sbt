organization := "org.hrscala"
name := "akka-beyond-localhost"

scalaVersion := "2.11.7"
scalacOptions := Seq(
  "-deprecation",
  "-encoding", "UTF-8",
  "-feature",
  "-language:_",
  "-unchecked"
)

libraryDependencies += "com.typesafe.akka" %% "akka-remote" % "2.3.12"

EclipseKeys.createSrc := EclipseCreateSrc.Default + EclipseCreateSrc.Resource
EclipseKeys.eclipseOutput := Some(".target")

// can't resolve right now :/
// Revolver.settings
