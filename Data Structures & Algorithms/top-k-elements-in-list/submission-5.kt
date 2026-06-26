class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val numToFreq = mutableMapOf<Int, Int>()
        for (num in nums) {
            numToFreq[num] = (numToFreq[num] ?: 0) + 1
        }

        val freqArray = Array(nums.size + 1) { mutableListOf<Int>() }
        for ((num, freq) in numToFreq) {
            freqArray[freq].add(num)
        }

        val topKArray = IntArray(k)
        var count = 0
        for (i in freqArray.size - 1 downTo 1) {
            for (j in freqArray[i]) {
                topKArray[count] = j
                count++
                if (count == k) break
            }
            if (count == k) break
        }
        return topKArray
    }
}

/**
Given the array size is n.
When all nums are the same, the top one is this number.
When all nums are unique, the answer is equal to the size n.

Given an array, record all possible frequencies of nums.
This array size is n.

First, count the frequency of each num and put it in a map.
Then iterate over all pairs in the map and put the corresponding frequency in the frequency array.

The question is to find the top k nums, so we iterate the frequency array from the end to the start.
*/