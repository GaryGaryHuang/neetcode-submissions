class Solution {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val res = IntArray(nums.size - k + 1)
        val arrayDeque = ArrayDeque<Int>()
        for (right in 0 until nums.size) {
            while (arrayDeque.isNotEmpty() && right - k + 1 > arrayDeque.first()) {
                arrayDeque.removeFirst()
            }

            while (arrayDeque.isNotEmpty() && nums[arrayDeque.last()] <= nums[right]) {
                arrayDeque.removeLast()
            }

            arrayDeque.addLast(right)

            if (right - k + 1 >= 0) res[right - k + 1] = nums[arrayDeque.first()]
        }
        return res
    }
}
