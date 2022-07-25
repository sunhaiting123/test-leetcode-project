package simple


/**
  *
  * @description: 122.给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
  *               设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）
  * @author: sunhaiting
  * @create: 2019-11-19 20:16
  **/
object OnehundredAndTwentyTwoMaxProfit2 {
  def main(args: Array[String]): Unit = {
    val list = Array[Int](7, 1, 5, 3, 6, 4)
    val i = maxProfit(list)
    val s = maxProfit2(list)
    println(s)
  }

  /** 输入: [7,1,5,3,6,4]
    * 输出: 7
    * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5-1 = 4 。
    * 随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6-3 = 3 。
    *
    * @param prices
    * @return
    */
  def maxProfit(prices: Array[Int]): Int = {
    var maxProfit = 0
    for (i <- 1 until prices.length) {
      if (prices(i) > prices(i - 1)) {
        maxProfit += prices(i) - prices(i - 1)
      }
    }
    maxProfit
  }

  def maxProfit2(prices: Array[Int]): Int = {

    var maxProfit = 0
    var i = 0
    var valley = prices(0)
    var peak = prices(0)
    while (i < prices.length - 1) {
      while (i < prices.length - 1 && prices(i) >= prices(i + 1)) {
        i = i + 1
      }
      valley = prices(i)
      while (i < prices.length - 1 && prices(i) <= prices(i + 1)) {
        i = i + 1
      }
      peak = prices(i)
      maxProfit += peak - valley
    }
    maxProfit
  }


  //  public int maxProfit(int[] prices) {
  //    int i = 0;
  //    int valley = prices[0];
  //    int peak = prices[0];
  //    int maxprofit = 0;
  //    while (i < prices.length - 1) {
  //      while (i < prices.length - 1 && prices[i] >= prices[i + 1])
  //        i++;
  //      valley = prices[i];
  //      while (i < prices.length - 1 && prices[i] <= prices[i + 1])
  //        i++;
  //      peak = prices[i];
  //      maxprofit += peak - valley;
  //    }
  //    return maxprofit;
  //  }


}
