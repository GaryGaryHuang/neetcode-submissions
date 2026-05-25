class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val numToFre = mutableMapOf<Int, Int>()
        for (num in nums) {
            numToFre[num] = (numToFre[num] ?: 0) + 1
        }

        val freArray = Array(nums.size + 1) { mutableListOf<Int>() }
        for ((num, fre) in numToFre) {
            freArray[fre].add(num)
        }

        val res = IntArray(k)
        var resIndex = 0
        for (i in freArray.size - 1 downTo 0) {
            for (num in freArray[i]) {
                res[resIndex] = num
                resIndex++
                if (resIndex == k) return res
            }
        }
        return res
    }
}

/**
Put the number and its frequency in a Map<Int, Int>. 
Since each frequency ranges from 1 to nums.size, 
I can create an Array of size nums.size + 1 
and place all map entries into it. 
Then I iterate through the array from end to start 
to collect the k most frequent elements.
*/