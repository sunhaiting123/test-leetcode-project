package simple

/**
  *
  * @description: 38.报数序列是一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
  *               1.     1
  *               2.     11
  *               3.     21
  *               4.     1211
  *               5.     111221
  * @author: sunhaiting
  * @create: 2019-11-08 17:15
  **/
object ThirtyEightCountAndSay {
  def main(args: Array[String]): Unit = {
    val str = countAndSay(5)
    println(str)
  }

  def countAndSay(n: Int): String = {
    var str = "1"

    for (i <- 2 to n) {
      var pre = str.charAt(0)
      val builder = new StringBuilder()
      var count = 1
      for (j <- 1 until str.length) {
        val c = str.charAt(j)
        if (c == pre) {
          count = count + 1
        } else {
          builder.append(count).append(pre)
          pre = c
          count = 1
        }
      }
      builder.append(count).append(pre)
      str = builder.toString()
    }
    str
  }


//  public static String countAndSay(int n) {
//    String str = "1";
//    for (int i = 2; i <= n; i++) {
//      StringBuilder builder = new StringBuilder();
//      char pre = str.charAt(0);
//      int count = 1;
//      for (int j = 1; j < str.length(); j++) {
//        char c = str.charAt(j);
//        if (c == pre) {
//          count++;
//        } else {
//          builder.append(count).append(pre);
//          pre = c;
//          count = 1;
//        }
//      }
//      builder.append(count).append(pre);
//      str = builder.toString();
//    }
//
//    return str;
//  }
}
