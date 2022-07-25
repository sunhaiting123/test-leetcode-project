package secondary.array

import scala.collection.mutable
import scala.collection.mutable.ListBuffer

/**
  *
  * @description: 49. 字母异位词分组
  *               给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
  * @author: sunhaiting
  * @create: 2020-03-15 20:43
  **/
object FortyNineGroupAnagrams {
  def main(args: Array[String]): Unit = {

    val s: Array[String] = Array("eat", "tea", "tan", "ate", "nat", "bat")
    val list = groupAnagrams(s)
    println(list.map(_.toBuffer).toBuffer)

  }

  /**
    *对字符串中的字符进行排序
    * @param strs
    * @return
    */
  def groupAnagrams(strs: Array[String]): List[List[String]] = {

    val map = new mutable.HashMap[String, ListBuffer[String]]()
    for (i <- 0 until strs.length) {
      val c: Array[Char] = strs(i).toCharArray
      val sorted = c.sorted.mkString("")
      if (!map.contains(sorted)) {
        map.put(sorted, new ListBuffer[String])
      }
      val value: ListBuffer[String] = map.getOrElse(sorted, null)
      value.append(strs(i))
    }
    map.values.map(_.toList).toList
  }

  /**
    * 统计字符出现的次数
    * @param strs
    * @return
    */
  def groupAnagrams2(strs: Array[String]): List[List[String]] = {

    val map = new mutable.HashMap[String, ListBuffer[String]]()
    for (i <- 0 until strs.length) {
      val count = new Array[Int](26)
      for (c <- strs(i).toCharArray) count(c - 'a') = count(c - 'a') + 1
      val key = count.mkString("")
      if (!map.contains(key)) {
        map.put(key, new ListBuffer[String])
      }
      map.getOrElse(key, new ListBuffer[String]).append(strs(i))
    }
    map.values.map(_.toList).toList
  }
}
