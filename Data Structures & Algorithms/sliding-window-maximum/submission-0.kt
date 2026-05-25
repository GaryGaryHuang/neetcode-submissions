class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val res = IntArray(nums.size - k + 1)
        var resIdx = 0

        val numToCount = mutableMapOf<Int, Int>()
        val treeSet = TreeSet<Int>()
        var left = 0; var right = 0
        while (right < nums.size) {
            val cur = nums[right]
            numToCount[cur] = (numToCount[cur] ?: 0) + 1
            treeSet.add(cur)

            var len = right - left + 1
            if (len > k) {
                val first = nums[left]
                val count = numToCount[first]!! - 1
                numToCount[first] = count
                if (count == 0) treeSet.remove(first)
                left++
                len--
            }

            if (len == k) {
                res[resIdx] = treeSet.last()
                resIdx++
            }

            right++
        }
        return res
    }
}

/**
I need to know the maximum number in each move. 
I want to use a heap so I don't have to iterate every time. 
I also want to use a TreeSet because it makes removing elements easy. 
In addition, I need a map to store the frequency of each element.
*/