package test

/**
  *
  * @description: 隐式转换--隐式值
  * @author: sunhaiting
  * @create: 2020-04-22 15:38
  **/

object Transfer extends App {
//  def main(args: Array[String]): Unit = {
    implicit val p = "aaa"
    //再次定义隐式转换变量时，会报错
    //所以隐式转换必须满足无歧义规则，在声明隐式参数的类型是最好使用特别的或自定义的数据类型，
    // 不要使用Int,String这些常用类型，避免碰巧匹配
//    implicit  val p1 = "bbb"
    println("=======")
    println(person)

//  }

  def person(implicit name: String) = name


}



