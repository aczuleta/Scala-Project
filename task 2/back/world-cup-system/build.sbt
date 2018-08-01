enablePlugins(JavaServerAppPackaging)

name := "world-cup-system"

version := "0.1"

organization := "uniandes"

scalaVersion := "2.12.2"

resolvers ++= Seq("Typesafe Repository" at "http://repo.typesafe.com/typesafe/releases/",
                  Resolver.bintrayRepo("hseeberger", "maven"))

libraryDependencies ++= {
  val AkkaVersion = "2.4.18"
  val AkkaHttpVersion = "10.0.6"
  val Json4sVersion = "3.5.2"
  Seq(
    "com.typesafe.akka" %% "akka-slf4j"      % AkkaVersion,
    "com.typesafe.akka" %% "akka-http" % AkkaHttpVersion,
    "ch.qos.logback" % "logback-classic" % "1.2.3",
    "org.json4s"        %% "json4s-native"   % Json4sVersion,
    "org.json4s"        %% "json4s-ext"      % Json4sVersion,
    "de.heikoseeberger" %% "akka-http-json4s" % "1.16.0",
    "com.typesafe.slick" %% "slick" % "3.2.0",
    "org.slf4j" % "slf4j-nop" % "1.6.4",
    "com.typesafe.slick" %% "slick-hikaricp" % "3.2.0",
    "mysql" % "mysql-connector-java" % "5.1.38",
    "io.getquill" %% "quill-async-mysql" % "2.5.4",
    "io.getquill" %% "quill-jdbc" % "2.5.4"
  )
}

// Assembly settings
mainClass in Global := Some("com.aczuleta.teams.prediction.system.Main")

assemblyJarName in assembly := "world-cup-server.jar"
