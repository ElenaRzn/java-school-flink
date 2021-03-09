package ru.rzn.sbt.javaschool

import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

case class WordWithCount(word: String, count: Long)

object FileBasedStreamingExample extends App {

  import org.apache.flink.api.scala.createTypeInformation
  val env = StreamExecutionEnvironment.createLocalEnvironment(1)

  val text = env.readTextFile("src/main/resources/ru.rzn.sbt.javaschool/word_count.txt")
  text.print()


  // TODO реализуйте Words Count задачу - подсчитайте количество вхождений каждого слова в DataStream.
  //  Используйте case class WordWithCount
  val counts = text
    .flatMap(_.split("\\s"))
    .map(WordWithCount(_, 1))
    .keyBy(_.word)
    .sum("count")

  //TODO раскомментируй меня
  counts.print().setParallelism(1)
  env.execute("File Stream WordCount")

}
