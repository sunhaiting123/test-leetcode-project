package simple.num

import java.util

/**
  *
  * @description: 299. 猜数字游戏
  *               你正在和你的朋友玩 猜数字（Bulls and Cows）游戏：你写下一个数字让你的朋友猜。每次他猜测后，你给他一个提示，告诉他有多少位数字和确切位置都猜对了（称为“Bulls”, 公牛），有多少位数字猜对了但是位置不对（称为“Cows”, 奶牛）。你的朋友将会根据提示继续猜，直到猜出秘密数字。
  *               请写出一个根据秘密数字和朋友的猜测数返回提示的函数，用 A 表示公牛，用 B 表示奶牛。
  *               请注意秘密数字和朋友的猜测数都可能含有重复数字。
  * @author: sunhaiting
  * @create: 2020-01-14 16:31
  **/
object TwoHundredAndNinetyNineGetHint {
  def main(args: Array[String]): Unit = {

    val secret = "1807"
    val guess = "7810"
    val str = getHint2(secret, guess)
    println(str)

    val arrS = new Array[Int](10)
    arrS(0) = 1
    println(arrS.toBuffer)
    arrS(0) = arrS(0) + 1
    println(arrS.toBuffer)
  }

  /**
    * 输入: secret = "1807", guess = "7810"
    * 输出: "1A3B"
    * 解释: 1 公牛和 3 奶牛。公牛是 8，奶牛是 0, 1 和 7。
    *
    * 定义一个list,存guess和secret不是公牛的guess值，
    * 定义map,存存guess和secret不是公牛的secret元素以及出现的次数
    *
    * @param secret
    * @param guess
    * @return
    */
  def getHint(secret: String, guess: String): String = {
    var acount = 0
    var bcount = 0
    val list = new util.ArrayList[Char]()
    val map = new util.HashMap[Char, Int]()
    for (i <- 0 until secret.length) {
      val secretTemp = secret.charAt(i)
      val guessTemp = guess.charAt(i)
      if (secretTemp == guessTemp) {
        acount = acount + 1
      } else {
        list.add(guessTemp)
        if (map.containsKey(secretTemp)) {
          map.put(secretTemp, map.get(secretTemp) + 1)
        } else {
          map.put(secretTemp, 1)
        }
      }
    }
    for (i <- 0 until list.size()) {
      if (map.containsKey(list.get(i))) {
        bcount = bcount + 1
        map.put(list.get(i), map.get(list.get(i)) - 1)
        if (map.get(list.get(i)) == 0) {
          map.remove(list.get(i))
        }
      }
    }
    acount + "A" + bcount + "B"
  }


  /**
    * 定义两个长度为10的数组，如果对应元素相同，则给acount加1，
    * 如果对应元素不相同，则数组对应的位置加1，最后取两个数组相同位置的最小和给bcount即为公牛
    *
    * @param secret
    * @param guess
    * @return
    */
  def getHint2(secret: String, guess: String): String = {
    var acount = 0
    var bcount = 0
    val arrS = new Array[Int](10)
    val arrG = new Array[Int](10)
    for (i <- 0 until secret.length) {
      val secretTemp = secret.charAt(i)
      val guessTemp = guess.charAt(i)
      if (secretTemp == guessTemp) {
        acount = acount + 1
      } else {
        arrG(guessTemp - '0') = arrG(guessTemp - '0') + 1
        arrS(secretTemp - '0') = arrS(secretTemp - '0') + 1
      }
    }
    for (i <- 0 until 10) {
      bcount = bcount + Math.min(arrG(i), arrS(i))
    }
    acount + "A" + bcount + "B"
  }
}
