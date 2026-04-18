class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val numToIndex = mutableMapOf<Int, Int>()
        for (i in 0 until nums.size) {
            numToIndex[nums[i]] = i
        }

        var a = nums.size
        var b = nums.size
        for ((num, index) in numToIndex) {
            val x = target - num
            if (x !in numToIndex) {
                continue
            }

            val indexY = numToIndex[x]!!
            val minIndex = min(index, indexY)
            if (minIndex >= a) {
                continue
            }
            
            a = minIndex
            b = max(index, indexY)
        }

        return intArrayOf(a, b)
    }
}

// I store each number and its index in a map. 
// Since the constraints guarantee a solution, I check each number and determine whether target - num exists.