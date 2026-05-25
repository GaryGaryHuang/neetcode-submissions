class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val counts = IntArray(2001)
        for (num in nums) {
            counts[num+1000]++
        }

        //  number, count
        val list = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until counts.size) {
            list.add(Pair(i - 1000, counts[i]))
        }

        list.sortByDescending { it.second }

        val res = IntArray(k)
        repeat(k) { i ->
            res[i] = list[i].first
        }
        return res
    }
}

/**
I wnat to record the count of every number. 
Then I can sort this count array so that I can get the top K.
Why I choose to use sort, because the max k is only 2001, this is pretty small.
Before I sort the array, I need to convert it structure to Pair 
so that I can remember its number.
**/
