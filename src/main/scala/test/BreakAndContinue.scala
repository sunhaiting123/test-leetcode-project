package test
import scala.util.control.Breaks.{break, breakable}
/**
  *
  * @description: ${description}
  * @author: sunhaiting
  * @create: 2020-02-18 15:52
  **/
object BreakAndContinue {
  def main(args: Array[String]): Unit = {
    breakable(
      for(i<-0 until 10) {
        println("break:",i)
        if(i==5){
          break()
        }
      }
    )
  }


  for(i<-0 until 10){
    breakable{
      if(i==3||i==6) {
        break
      }
      println("continue:",i)
    }
    println(i)
  }
}
