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

/*
Test cases:
1. [1,2,3,4], target = 3, array = [0, 1]
2. [1,2,1,2], target = 3, array = [0, 1]
3. [1,1,2,2], target = 3, array = [0, 1]
4. [1,1,1,1], target = 2, array = [0, 1]

If there is exactly one pair of indices i and j that satisfies the condition,
I can reduce the test cases.
So only test case 1 is valid.
But there is one more test case like no.4, [1,1,2,2], target = 2, array = [0,1]

Steps:
1. I can put the number and its index into a map.
2. But I need to consider `[1,1,1,1,1,2,2]` case if there are many identical items.
I only care about the first two min indices.
So, I can use Map<Int, IntArray(2)> data structure to keep the first two min indices.
*/
