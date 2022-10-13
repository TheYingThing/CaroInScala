name := "CaroInScala"

version := "0.1"

scalaVersion := "2.13.10"

libraryDependencies += "org.scalactic" %% "scalactic" % "3.2.14"

libraryDependencies += "org.scalatest" %% "scalatest" % "3.2.14" % "test"

libraryDependencies += "org.scala-lang.modules" %% "scala-swing" % "3.0.0"

libraryDependencies += "com.google.inject" % "guice" % "5.1.0"

libraryDependencies += "net.codingwell" %% "scala-guice" % "5.1.0"

libraryDependencies += "com.typesafe.play" %% "play-json" % "2.9.3"

libraryDependencies += "org.scala-lang.modules" %% "scala-xml" % "2.1.0"

resolvers += Resolver.url("scoverage-bintray", url("https://dl.bintray.com/sksamuel/sbt-plugins/"))(Resolver.ivyStylePatterns)
