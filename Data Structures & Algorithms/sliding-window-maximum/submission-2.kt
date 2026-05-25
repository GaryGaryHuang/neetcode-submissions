class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val res = IntArray(nums.size - k + 1)
        val arrayDeque = ArrayDeque<Int>()
        for (i in 0 until nums.size) {
            while (arrayDeque.isNotEmpty() && arrayDeque.first() <= i - k) {
                arrayDeque.removeFirst()
            }

            while (arrayDeque.isNotEmpty() && nums[arrayDeque.last()] < nums[i]) {
                arrayDeque.removeLast()
            }

            arrayDeque.addLast(i)

            val putIndex = i - k + 1
            if (putIndex >= 0) {
                res[putIndex] = nums[arrayDeque.first()]
            }
        }
        return res
    }
}
