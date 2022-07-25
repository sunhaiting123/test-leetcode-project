package simple

/**
  *
  * @description: 121.给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
  *               如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
  *               注意你不能在买入股票前卖出股票。
  * @author: sunhaiting
  * @create: 2019-11-19 19:50
  **/
object OnehundredAndTwentyOneMaxProfit {
  def main(args: Array[String]): Unit = {
    val list = Array[Int](7, 1, 5, 3, 6, 4)
    val i = maxProfit(list)
    println(i)
    val j = maxProfit2(list)
    println(j)
  }


  /** 时间复杂度：O(n2)。循环运行 n(n−1)/2​ 次。
    * 空间复杂度：O(1)。只使用了两个变量。
    *
    * 我们需要找出给定数组中两个数字之间的最大差值（即，最大利润）。
    * 此外，第二个数字（卖出价格）必须大于第一个数字（买入价格）。
    *
    * 形式上，对于每组 i 和 j（其中 j>i）我们需要找出 max⁡(prices[j]−prices[i])
    */
  /**
    * 示例 1:
    *
    * 输入: [7,1,5,3,6,4]
    * 输出: 5
    * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
    * 注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
    * 示例 2:
    *
    * 输入: [7,6,4,3,1]
    * 输出: 0
    * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
    *
    * @param prices
    * @return
    */
  def maxProfit(prices: Array[Int]): Int = {
    var maxprofit = 0
    for (i <- 0 until prices.length) {
      for (j <- i until prices.length) {
        val profit = prices(j) - prices(i)
        if (profit > maxprofit) {
          maxprofit = profit
        }
      }
    }
    maxprofit
  }

  /**
    * 我们需要找到最小的谷之后的最大的峰。
    * 我们可以维持两个变量——minprice 和 maxprofit，它们分别对应迄今为止所得到的最小的谷值和最大的利润
    * （卖出价格与最低价格之间的最大差值）。
    *
    *
    * 时间复杂度：O(n)，只需要遍历一次。
    * 空间复杂度：O(1)，只使用了两个变量。
    *
    * @param prices
    * @return
    */
  def maxProfit2(prices: Array[Int]): Int = {
    var min = Int.MaxValue
    var maxprofit = 0
    for (i <- 0 until prices.length) {

      if (prices(i) < min) {
        min = prices(i)
      } else if (prices(i) - min > maxprofit) {
        maxprofit = prices(i) - min
      }
    }
    maxprofit
  }
}
