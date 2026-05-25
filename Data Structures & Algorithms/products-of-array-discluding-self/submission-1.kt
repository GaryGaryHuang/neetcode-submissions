class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size) { 1 }
        var product = 1
        for (i in 1 until nums.size) {
            product *= nums[i - 1]
            res[i] = product
        }
        product = 1
        for (i in nums.size - 2 downTo 0) {
            product *= nums[i + 1]
            res[i] *= product
        }
        return res
    }
}
