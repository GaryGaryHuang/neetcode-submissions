class Solution {
    fun nextGreaterElement(nums1: IntArray, nums2: IntArray): IntArray {
        val numToIndex = mutableMapOf<Int, Int>()

        val arrayDeque = ArrayDeque<Int>()
        for (i in 0 until nums2.size) {
            val num = nums2[i]
            while (arrayDeque.isNotEmpty() && num > nums2[arrayDeque.last()]) {
                val prev = arrayDeque.removeLast()
                numToIndex[nums2[prev]] = num
            }
            arrayDeque.addLast(i)
        }

        val res = IntArray(nums1.size)
        for (i in 0 until res.size) {
            val num = nums1[i]
            res[i] = numToIndex[num] ?: -1
        }
        return res
    }
}
