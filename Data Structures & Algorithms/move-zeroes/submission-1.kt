class Solution {
    fun moveZeroes(nums: IntArray) {
        var zeroIndex = -1
        var nonZeroIndex = 0
        while (nonZeroIndex < nums.size) {
            val num = nums[nonZeroIndex]
            if (num == 0) {
                if (zeroIndex == -1) zeroIndex = nonZeroIndex
            } else {
                if (zeroIndex != -1) {
                    nums[zeroIndex] = nums[nonZeroIndex]
                    zeroIndex++
                }
            }
            nonZeroIndex++
        }

        if (zeroIndex > -1) {
            for (i in zeroIndex until nums.size) {
                nums[i] = 0
            }
        }
    }
}
