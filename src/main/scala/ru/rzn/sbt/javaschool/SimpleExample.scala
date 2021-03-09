package ru.rzn.sbt.javaschool
import org.apache.flink.api.common.typeinfo.TypeInformation
import org.apache.flink.streaming.api.scala.StreamExecutionEnvironment

/**
 * В параметрах запуска не забудьте указать "Include dependencies with "Provided" scope"
 */
object SimpleExample extends App {

  implicit val stringMapTypeInformation: TypeInformation[String] = TypeInformation.of(classOf[String])
  implicit val intMapTypeInformation: TypeInformation[Int] = TypeInformation.of(classOf[Int])

  // запуск исполняемого окружения
  val env = StreamExecutionEnvironment.createLocalEnvironment(1)

  //  получение данных из источника: кафка, файл, колелкция и т.д.
  val source = env.fromElements("1", "2", "3", "4", "5")

  // TODO напишите код обработки данных, который умножает входное число на 10 и фильтрует только четные
  val data = source.map(_.toInt)
    .map(_*10)
    .filter(_%2 == 0)

  // запись результатов: кафка, файл, консоль и т.д.
  data.print()

  // запуск потока
  env.execute("My First Flink Job")


}
