package simple

/**
  *
  * @description: 205. 同构字符串
  * @author: sunhaiting
  * @create: 2019-11-26 19:32
  **/
object TwohundredAndFiveIsIsomorphic {
  def main(args: Array[String]): Unit = {
    val s = "paser"
    val t = "title"
    val bool = isIsomorphic2(s, t) && isIsomorphic2(t,s)
    println(bool)

  }

  /**
    * 输入: s = "paper", t = "title"
    * 输出: true
    * 使用字符串第一次出现的位置来判断
    *
    * @param s
    * @param t
    * @return
    */
  def isIsomorphic(s: String, t: String): Boolean = {
    var flag = true
    val ch1 = s.toCharArray
    val ch2 = t.toCharArray
    for (i <- 0 until ch1.length) {
      //indexOf:返回第一次出现的指定子字符串在此字符串中的索引
      if (s.indexOf(ch1(i)) != t.indexOf(ch2(i))) {
        flag = false
      }
    }
    flag
  }

  /**
    * hashMap方法
    * 我们需要验证 s - > t 和 t -> s 两个方向。如果验证一个方向，是不可以的。
    * 举个例子，s = ab, t = cc，如果单看 s -> t ，那么 a -> c, b -> c 是没有问题的。
    * 必须再验证 t -> s，此时，c -> a, c -> b，一个字母对应了多个字母，所以不是同构的。
    *
    *
    * @param s
    * @param t
    * @return
    */
  def isIsomorphic2(s: String, t: String): Boolean = {
    isIsomorphicHelper(s,t) && isIsomorphic2(t,s)
  }



  def isIsomorphicHelper(s: String, t: String): Boolean = {
    val map = new java.util.HashMap[Char, Char]()
    var flag = true
    var i = 0
    while (i < s.length && flag) {
      val s1: Char = s.charAt(i)
      val t1: Char = t.charAt(i)
      if (map.containsKey(s1)) {
        if (map.get(s1) != t1) {
          flag = false
        }
      } else {
        map.put(s1, t1)
      }
      i = i + 1
    }
    flag
  }
}
