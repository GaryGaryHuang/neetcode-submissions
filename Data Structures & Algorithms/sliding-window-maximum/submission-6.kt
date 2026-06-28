class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val res = IntArray(nums.size - k + 1)
        val arrayDeque = ArrayDeque<Int>()
        for (i in 0 until nums.size) {
            while (arrayDeque.isNotEmpty() && arrayDeque.peek() + k <= i) {
                arrayDeque.removeFirst()
            }
            while (arrayDeque.isNotEmpty() && nums[arrayDeque.peek()] <= nums[i]) {
                arrayDeque.removeFirst()
            }
            arrayDeque.addLast(i)
            if (i + 1 >= k) res[i + 1 - k] = nums[arrayDeque.peek()]
        }
        return res
    }
}
