class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {

        fun canFinish(quantity: Int): Boolean {
            var howManyHours = 0
            for (i in piles) {
                howManyHours += ((i + quantity - 1) / quantity)
            }
            return howManyHours <= h
        }

        var left = 1
        var right = piles.max()
        var atLeast = right
        while (left <= right) {
            val mid = (left + right) / 2
            if (canFinish(mid)) {
                atLeast = mid
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return atLeast
    }
}

/**
Each hour I can eat the quantity of banana from 1 to the max quantity of piles.
I can check every quantity so that I can know which k is the most smallest one.
I can use binary search to help me reduce the test times.
*/
