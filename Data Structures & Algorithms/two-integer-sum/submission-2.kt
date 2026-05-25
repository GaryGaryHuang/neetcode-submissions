class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, IntArray>();
        for (i in 0 until nums.size) {
            val num = nums[i]
            val array = map.getOrPut(num) { IntArray(2) { nums.size } }
            if (i < array[0]) {
                if (array[0] != nums.size) array[1] = array[0]
                array[0] = i
            } else if (i < array[1]) {
                array[1] = i
            }
        }

        val res = IntArray(2) { nums.size }
        for ((num, array) in map) {
            val pair = target - num
            val pairArray = map[pair] ?: continue

            val index1 = array[0]
            val index2 = if (num == pair) pairArray[1] else pairArray[0]
            if (index2 == nums.size) continue

            val minIndex = minOf(index1, index2)
            val maxIndex = maxOf(index1, index2)

            if (minIndex < res[0]) {
                res[0] = minIndex
                res[1] = maxIndex
            }
        }
        return res
    }
}