package simple

import java.util

/**
  *
  * @description: 28.给定一个 haystack 字符串和一个 needle 字符串，
  *               在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。
  *               如果不存在，则返回  -1。
  * @author: sunhaiting
  * @create: 2019-11-07 20:34
  **/
object TwentyEightStrStr {
  def main(args: Array[String]): Unit = {

    val haystack = "heeeello"
    val needle = "ll"
    val i = strStr(haystack, needle)
    println(i)

    val next = new util.ArrayList[Int]()
//    next.add(0)

    val j = KMP(haystack, needle, next)
    println(j)

  }

  /**
    * 输入: haystack = "hello", needle = "ll"
    * 输出: 2
    *
    * @param str1
    * @param str2
    * @return
    */
  def strStr(str1: String, str2: String): Int = {
    var flag = true
    var result = 0
    val length1 = str1.length
    val length2 = str2.length
    var i = 0
    while (i < length1 - length2 && flag) {
      val substr1 = str1.substring(i, i + length2)
      if (substr1 == str2) {
        result = i
        flag = false
      }
      i = i + 1
    }
    result
  }


  /* 在 S 中找到 P 第一次出现的位置 */
  def KMP(S: String, P: String, next: java.util.ArrayList[Int]): Int = {
    var result = 0
    var i = 0; // S 的下标
    var j = 0; // P 的下标
    val s_len = S.length
    val p_len = P.length

    while (i < s_len && j < p_len) {
      if (j == -1 || S(i) == P(j)) // P 的第一个字符不匹配或 S[i] == P[j]
      {
        i = i + 1
        j = j + 1
      }
      else {
        j = next.get(j) // 当前字符匹配失败，进行跳转
      }
    }

    if (j == p_len) {
      // 匹配成功
      result = i - j
    } else {
      result = -1
    }
    result
  }


//  class Solution {
//    public:
//      vector<int> getnext(string str)
//    {
//      int len=str.size();
//      vector<int> next;
//      next.push_back(-1);//next数组初值为-1
//      int j=0,k=-1;
//      while(j<len-1)
//      {
//        if(k==-1||str[j]==str[k])//str[j]后缀 str[k]前缀
//        {
//          j++;
//          k++;
//          next.push_back(k);
//        }
//        else
//        {
//          k=next[k];
//        }
//      }
//      return next;
//    }
//    int strStr(string haystack, string needle) {
//      if(needle.empty())
//        return 0;
//
//      int i=0;//源串
//      int j=0;//子串
//      int len1=haystack.size();
//      int len2=needle.size();
//      vector<int> next;
//      next=getnext(needle);
//      while((i<len1)&&(j<len2))
//      {
//        if((j==-1)||(haystack[i]==needle[j]))
//        {
//          i++;
//          j++;
//        }
//        else
//        {
//          j=next[j];//获取下一次匹配的位置
//        }
//      }
//      if(j==len2)
//        return i-j;
//
//      return -1;
//    }
//  };


}

