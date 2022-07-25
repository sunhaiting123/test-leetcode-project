package simple.string

/**
  *
  * @description: $383. 赎金信
  *               给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
  *               判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
  *               如果可以构成，返回 true ；否则返回 false。
  * @author: sunhaiting
  * @create: 2020-01-19 17:52
  **/
object ThreeHundredAndEightyThreeCanConstruct {

  def main(args: Array[String]): Unit = {

    val bool = canConstruct("aa", "acb")
    println(bool)
  }

  /**
    *
    * @param ransomNote
    * @param magazine
    * @return
    */
  def canConstruct(ransomNote: String, magazine: String): Boolean = {
    val bucket = new Array[Int](26)
    var flag = true
    for (i <- 0 until magazine.length) {
      bucket(magazine.charAt(i) - 'a') = bucket(magazine.charAt(i) - 'a') + 1
    }

    for (i <- 0 until ransomNote.length ; if(flag)) {
      bucket(ransomNote(i) - 'a') = bucket(ransomNote(i) - 'a') - 1
      if (bucket(ransomNote(i) - 'a') < 0) {
        flag = false
      }
    }
    flag
  }
}
