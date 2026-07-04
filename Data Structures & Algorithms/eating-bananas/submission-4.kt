class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {

        fun canFinish(quantity: Int): Boolean {
            var hour = 0
            for (banana in piles) {
                hour += (banana / quantity)
                if (banana % quantity != 0) hour++
                if (hour > h) break 
            }
            return hour <= h
        }

        var l = 1
        var r = 1000000000
        var minimum = 1
        while (l <= r) {
            val mid = (l + r) / 2
            if (canFinish(mid)) {
                minimum = mid
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return minimum
    }
}

/**
You may decide your bananas-per-hour eating rate of k.
Koko needs to eat at least 1 banana to at most 1,000,000,000 each hour.
Because banana is in the range of 1 to 1,000,000,000.
I can check every banana quantity that Koko has to eat each hour,
and find the minimum quantity that fits the h hour.
*/
