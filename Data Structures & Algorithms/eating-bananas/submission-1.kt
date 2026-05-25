class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var res = -1
        var l = 1
        var r = piles.max()
        while (l <= r) {
            val mid = (l + r) / 2
            if (canFinish(piles, h, mid)) {
                res = mid
                r = mid - 1
            } else {
                l = mid + 1
            }
        }
        return res
    }

    private fun canFinish(piles: IntArray, target: Int, rate: Int): Boolean {
        val rateF = rate.toDouble()
        var hour = 0
        for (p in piles) {
            hour += (ceil(p / rateF)).toInt()
        }
        return hour <= target
    }
}

/**
Each hour I need to eat at least one pile of banana.
Each hour I also can eat the max num of the banana in piles.
Because this quantity means I can finish every pile of banana at once.
But I need to find the minimum k.
*/
