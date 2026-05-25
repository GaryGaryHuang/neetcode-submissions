class Solution {
    fun maxProfit(prices: IntArray): Int {
        var pre = 0
        var profit = 0
        for (i in 1 until prices.size) {
            if (prices[i] <= prices[pre]) {
                pre = i
            } else {
                profit = maxOf(profit, prices[i] - prices[pre])
            }
        }
        return profit
    }
}

/**
Buy at the first day.
If the next day is lower than the previous day, drop the previous one and buy again at this day.
If the next day is higher than the previous day, sell and record it.
If the later still higher than the previous day, keep selling and recording.
If the next day is lower than the previous one again, we can restart this process.
**/
