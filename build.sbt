import sbt._
import Keys._
import sbtassembly.AssemblyPlugin.autoImport._

name := """akka-microservice"""
version := "1.0"
scalaVersion := "2.12.6"
val akkaVersion = "2.5.14"

val sprayVersion = "1.3.4"
resolvers += "spray" at "http://repo.spray.io/"

libraryDependencies ++= Seq(
    "com.typesafe.akka" %% "akka-actor" % akkaVersion,
    "com.typesafe.akka" %% "akka-slf4j" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster-metrics" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster-sharding" % akkaVersion,
    "com.typesafe.akka" %% "akka-remote" % akkaVersion,
    "com.typesafe.akka" %% "akka-cluster-tools" % akkaVersion,
    "com.orbitz.consul" % "consul-client" % "0.13.3",
//    "io.spray" %% "spray-can" % sprayVersion,
//    "io.spray" %% "spray-routing" % sprayVersion,
//    "io.spray" %% "spray-client" % sprayVersion,
//    "io.spray" %% "spray-json" % "1.3.2",
    "com.typesafe" % "config" % "1.3.1",
    "ch.qos.logback" % "logback-classic" % "1.1.7",
    "com.typesafe.scala-logging" %% "scala-logging" % "3.5.0",
    "org.scalatest" %% "scalatest" % "3.0.0" % "test",
    "com.typesafe.akka" %% "akka-testkit" % akkaVersion % "test",
//    "io.spray" %% "spray-testkit" % sprayVersion % "test"
)

mainClass in assembly := Some(s"com.sap1ens.MicroServiceSystem")
assemblyJarName in assembly := "microservice-fat-jar.jar"

lazy val logback = "ch.qos.logback" % "logback-classic" % "1.1.2"


test in assembly := {}

javaOptions in Test := Seq("-Dconfig.resource=testing.conf")

fork := true
