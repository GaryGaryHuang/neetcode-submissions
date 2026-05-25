class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val size = nums.size
        val res = IntArray(size) { 1 }

        //  Left to right
        var current = 1
        for (i in 1 until size) {
            current *= nums[i - 1]
            res[i] = current
        }
    
        current = 1
        for (i in size - 2 downTo 0) {
            current *= nums[i + 1]
            res[i] *= current
        }

        return res
    }
}

// Every element's value is all other elements's product.
// I can product each element from left to right exlude the current item.
// Then, do the same thing again from right to left.
