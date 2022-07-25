package simple

import java.util

/**
  *
  * @description: 20.给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
  * @author: sunhaiting
  * @create: 2019-11-07 16:13
  **/
object TwentyIsValid {
  def main(args: Array[String]): Unit = {
    val map = new util.HashMap[Character, Character]() {
      {
        put('{', '}')
        put('[', ']')
        put('(', ')')
      }
    }

    val map2 = Map('{' -> '}', '[' -> ']', '(' -> ')')
    println(map)
    println(map2)

    val s = "{[]}"
    val result = isValid(s)
    println(result)
  }

  /**
    * 输入: "([)]"
    * 输出: false
    *
    * 输入: "{[]}"
    * 输出: true
    *
    * @param s
    * @return
    */
  def isValid(s: String): Boolean = {

    val map = new util.HashMap[Character, Character]() {
      {
        put('}', '{')
        put(']', '[')
        put(')', '(')
      }
    }
    var flag = false
    var bool = true
    // Initialize a stack to be used in the algorithm.
    val stack = new util.Stack[Character]()

    var i = 0
    while (i < s.length && bool) {
      val c = s.charAt(i)
      // If the current character is a closing bracket.
      if (map.containsKey(c)) {
        var topElement: Character = '#'
        // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
        if (!stack.empty()) {
          topElement = stack.pop()
        }
        // If the mapping for this bracket doesn't match the stack's top element, return false.
        if (topElement != map.get(c)) {
          bool = false
        }
      } else {
        stack.push(c)
      }
      i = i + 1
    }
    // If the stack still contains elements, then it is an invalid expression.
    if (stack.isEmpty()) {
      flag = true
    }
    flag
  }
}



