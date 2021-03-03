package ru.rzn.sbt.javaschool

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

case class WordWithCount(word: String, count: Long)

object FileBasedStreamingExample extends App {

  import org.apache.flink.api.scala.createTypeInformation
  val env = StreamExecutionEnvironment.createLocalEnvironment(1)

  //TODO прочитайте DataStream из файла "word_count.txt"
  //val text =


  // TODO реализуйте Words Count задачу - подсчитайте количество вхождений каждого слова в DataStream.
  //  Используйте case class WordWithCount
  //val counts =

  //TODO раскомментируй меня
  //counts.print().setParallelism(1)
  env.execute("File Stream WordCount")

}
