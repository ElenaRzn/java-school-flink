name := "java-school-flink"

version := "0.1"

scalaVersion := "2.12.4"

lazy val flinkVersion = "1.8.0"

libraryDependencies ++= Seq(
  "org.apache.flink" %% "flink-scala" % flinkVersion % Provided,
  "org.apache.flink" %% "flink-clients" % flinkVersion % Provided,
  "org.apache.flink" %% "flink-streaming-scala" % flinkVersion % Provided

)