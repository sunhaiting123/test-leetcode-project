package test

import java.util
import java.util.regex.Matcher

import scala.collection.mutable.ListBuffer
import scala.util.matching.Regex


/**
  *
  * @description: ${description}
  * @author: sunhaiting
  * @create: 2019-11-18 16:38
  **/
object Test {
  def main(args: Array[String]): Unit = {

//    val arr = Array(2,3,4,1)
//    val sorted = arr.sorted
//    println(arr.toBuffer)
//    println(sorted.toBuffer)

    val regex: Regex = new Regex("[a-z,A-Z]")
    val s ="abdcASC234"
    val str: String = regex.findAllIn(s).mkString("")
    println(str)


    val ans = new Array[Int](26)
    println(ans.toBuffer)


    val b = new ListBuffer[Int]()
    b.append(1)
    println(b)
    //    val stack = new util.Stack[Int]()
    //    stack.push(1)
    //    stack.push(2)
    //    stack.push(3)
    //    val s1 = stack.pop()
    //    println(s1)


//    for (i <- 0 until 12) {
//      for (j <- 0 until 60) {
//        val s = Integer.bitCount(i) + Integer.bitCount(j)
//        //        println("￥￥￥"+s)
//        //        println("====="+Integer.bitCount(i * 64 + j))
//        println(s == Integer.bitCount(i * 64 + j))
//      }
//    }
//
//    val map: Map[String, String] = Map(("a", "b"))
//
//    val arr = Array(1, 2, 3, 4, 5)
//    val ddd = arr.map(x => {
//      x + 1
//    })

//    import scala.util.control.Breaks._
//    for(i<-0 until 10){
//      breakable{
//        if(i==3||i==6) {
//          break
//        }
//        println(i)
//      }
//    }
//

    //
    //
    //    val lists = List(1, 2, 3, 4, 5, 6, 11, 12, 14)
    //    //用圆括号需要加分号，老版本写法
    //    val s = for (list <- lists; if (list % 2 == 0)) yield list
    //    println(s.toBuffer)
    //    //用花括号不需要加分号
    //    val s2 = for {list <- lists if (list % 2 == 0)} yield list
    //    println(s2.toBuffer)
    //    //d前面不需要添加val
    //    for {list <- lists
    //         d = list.toDouble} println(d)
    //
    //    val optionLists: List[Option[Int]] =List(Some(1),None,Some(2),None,Some(3),Some(4))
    //    for {optionList <- optionLists
    //    //None值不会抛异常，也将返回None
    //         d = optionList.filter(x =>x%2==0)
    //    } println(d)
    //    for {Some(optionList) <- optionLists
    //         //None值不会抛异常，也将返回None
    //         d = Some(optionList).filter(x =>x%2==0)
    //    } println("=====",d)


    //lazy
    //    lazy val lz =1
    //    val lz2 =lz+1
    //    println(lz2)

    //    val arr = new util.ArrayList[Int](5)
    ////    arr.add(2,3)
    //    println(arr.size())
    //
    //
    //    val x =0.21*0.65+0.68*0.15+0.11*0.12
    //    println(x)


  }
}
