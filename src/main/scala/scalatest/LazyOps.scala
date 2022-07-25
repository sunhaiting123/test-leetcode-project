package scalatest

/**
  *
  * @description: lazy修饰
  *               使用lazy关键字修饰变量后，只有在使用该变量时，才会调用其实例化方法。
  *               也就是说在定义property=init()时并不会调用init()方法，
  *               只有在后面的代码中使用变量property时才会调用init()方法。
  * @author: sunhaiting
  * @create: 2019-11-21 12:01
  **/
object LazyOps {

  def init(): String = {
    println("call init()")
    return ""
  }

  def main(args: Array[String]) {
    lazy val property = init(); //使用lazy修饰
    println("after init()")
    println(property)

//    checkY(100)
  }


  def checkY(y: Int) = {
    for {
      x <- Seq(99, 100, 101) }{
      val str = x match {
        case `y` => "found y!"
        case i: Int => "int: "+i
      }
      println(str)
    }
  }

}
