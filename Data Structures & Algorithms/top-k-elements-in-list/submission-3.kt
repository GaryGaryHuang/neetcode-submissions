class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = mutableMapOf<Int, Int>()
        for (num in nums) {
            map[num] = (map[num] ?: 0) + 1
        }

        val array = Array(nums.size + 1) { mutableListOf<Int>() }
        for ((key, value) in map) {
            array[value].add(key)
        }

        val res = IntArray(k)
        var resIndex = 0
        for (i in array.size - 1 downTo 0) {
            for (num in array[i]) {
                res[resIndex++] = num
                if (resIndex >= k) return res
            }
        }
        return res
    }
}
