package simple.num

import scala.collection.JavaConverters._

/**
  *
  * @description: ${description}
  * @author: sunhaiting
  * @create: 2020-02-17 18:19
  **/
object FourHundredAndTwelveFizzBuzz {
  def main(args: Array[String]): Unit = {
    val strings = fizzBuzz2(15)
    println(strings.toBuffer)

  }

  /**
    * 每个选项都做一次判断
    *
    * @param n
    * @return
    */
  def fizzBuzz(n: Int): List[String] = {
    val list = new java.util.ArrayList[String]()
    for (i <- 1 to n) {
      if (i % 3 == 0 && i % 5 == 0) {
        list.add("FizzBuzz")
      } else if (i % 3 == 0) {
        list.add("Fizz")
      } else if (i % 5 == 0) {
        list.add("Buzz")
      } else {
        list.add(i.toString)
      }
    }

    import scala.collection.JavaConverters._

    list.asScala.toList
  }

  /**
    *
    * @param n
    * @return
    */
  def fizzBuzz2(n: Int): List[String] = {
    val list = new java.util.ArrayList[String]()
    for (i <- 1 to n) {
      var str = ""
      if (i % 3 == 0) {
        str = str + "Fizz"
      }
      if (i % 5 == 0) {
        str = str + "Buzz"
      }
      if (str == "") {
        str = str + i.toString
      }
      list.add(str)
    }
    list.asScala.toList
  }

}
