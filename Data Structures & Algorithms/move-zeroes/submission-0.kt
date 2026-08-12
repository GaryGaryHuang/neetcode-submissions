class Solution {
    fun moveZeroes(nums: IntArray) {
        var zeroCount = 0
        var zeroIndex = -1
        var nonZeroIndex = 0
        
        while (nonZeroIndex < nums.size) {
            val num = nums[nonZeroIndex]
            if (num == 0) {
                if (zeroIndex == -1) zeroIndex = nonZeroIndex
                zeroCount++ 
            } else {
                if (zeroIndex != -1) {
                    nums[zeroIndex] = nums[nonZeroIndex]
                    zeroIndex++
                }
            }
            nonZeroIndex++
        }

        if (zeroCount > 0) {
            repeat(zeroCount) {
                nums[nums.size - 1 - it] = 0
            }
        }
    }
}
