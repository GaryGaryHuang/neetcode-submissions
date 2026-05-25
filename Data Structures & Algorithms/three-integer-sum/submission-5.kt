class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val n = nums.size
        val sorted = nums.sorted()
        val res = mutableListOf<List<Int>>()

        for (i in 0 until n) {
            if (sorted[i] > 0) break
            if (i > 0 && sorted[i] == sorted[i - 1]) continue

            val target = 0 - sorted[i]
            var left = i + 1
            var right = n - 1
            while (left < right) {
                when {
                    (sorted[left] + sorted[right] == target) -> {
                        res.add(listOf(sorted[i], sorted[left], sorted[right]))
                        left++
                        right--
                        while (left < right && sorted[left] == sorted[left - 1]) left++
                    }

                    (sorted[left] + sorted[right] > target) -> {
                        right--
                    }

                    else -> {
                        left++
                    }
                }
            }
        }

        return res
    }
}
