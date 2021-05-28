name := "my_dumb_scala"

version := "0.1"

scalaVersion := "2.11.7"

val sparkVersion = "2.3.0"

mainClass := Some("DumbSparkTest")

resolvers ++= Seq(
  "apache-snapshots" at "https://repository.apache.org/snapshots/",
)

libraryDependencies ++= Seq(
  "org.apache.spark" %% "spark-core" % sparkVersion,
  "org.apache.spark" %% "spark-sql" %sparkVersion
)
