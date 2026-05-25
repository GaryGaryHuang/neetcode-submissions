class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val res = IntArray(nums.size - k + 1)

        val numToFreq = mutableMapOf<Int, Int>()
        val treeSet = TreeSet<Int>()

        var left = 0
        var right = 0
        while (right < nums.size) {
            numToFreq[nums[right]] = (numToFreq[nums[right]] ?: 0) + 1
            treeSet.add(nums[right])

            if (right - left + 1 > k) {
                numToFreq[nums[left]] = numToFreq[nums[left]]!! - 1
                if (numToFreq[nums[left]] == 0) treeSet.remove(nums[left])
                left++
            }

            if (right + 1 >= k) res[right + 1 - k] = treeSet.last()

            right++
        }
        
        return res
    }
}
