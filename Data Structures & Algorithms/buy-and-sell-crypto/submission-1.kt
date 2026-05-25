class Solution {
    fun maxProfit(prices: IntArray): Int {
        var left = 0
        var right = 1
        var res = 0
        while (right < prices.size) {
            if (prices[left] >= prices[right]) {
                left = right
                right++
            } else {
                res = max(res, prices[right] - prices[left])
                right++
            }
        }
        return res
    }
}
