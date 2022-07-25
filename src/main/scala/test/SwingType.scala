package test

/**
  *
  * @description: scala隐式转换
  *               隐式视图方式
  *
  *               1.如果表达式不符合编译器要求的类型，编译器就会在作用域范围内查找能够使之符合要求的隐式视图。
  *               如例2，当要传一个整数类型给要求是字符串类型参数的方法时，在作用域里就必须存在Int => String的隐式视图
  *
  *               2.给定一个选择e.t，如果e的类型里并没有成员t，则编译器会查找能应用到e类型并且返回类型包含成员t的隐式视图。如例1
  * @author: sunhaiting
  * @create: 2020-04-21 10:08
  **/

//隐式转换调用类中本不存在的方法
class SwingType {
  def wantLearned(sw: String) = println("兔子已经学会了" + sw)
}

object swimming {
  implicit def learningType(s: AminalType) = new SwingType
}


class AminalType

object AminalType extends App {

  import test.swimming._

  val rabbit = new AminalType
  rabbit.wantLearned("breaststroke") //蛙泳
}


//隐式转换为目标类型：把一种类型自动转换到另一种类型
//object View {
//
//  def foo(msg: String) = println(msg)
//
//  //定义一个转换函数给编译器将int自动转换成String
//  implicit def intToStr(i: Int) = i.toString
//
//
//  def main(args: Array[String]): Unit = {
//    //foo中的1默认转成string类型
//    foo(13333433)
//  }
//}



