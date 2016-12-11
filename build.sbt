name := """workshop-intro-to-scala"""

version := "1.0.0"

lazy val root = (project in file(".")).enablePlugins(PlayScala)

scalaVersion := "2.11.8"

libraryDependencies ++= Seq(
  ws, // Include thr web services library
  "org.julienrf" % "play-json-derived-codecs_2.11" % "3.3", // For hassle-free polymorphic Json
  "org.scalatestplus.play" %% "scalatestplus-play" % "1.5.1"    % Test
)
