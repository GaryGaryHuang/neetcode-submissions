class Solution {
    fun trap(height: IntArray): Int {
        var res = 0
        var leftMaxHeight = 0
        var rightMaxHeight = 0
        var left = 0
        var right = height.size - 1
        while (left < right) {
            if (height[left] <= height[right]) {
                res += (leftMaxHeight - height[left]).coerceAtLeast(0)
                leftMaxHeight = maxOf(leftMaxHeight, height[left])
                left++
            } else {
                res += (rightMaxHeight - height[right]).coerceAtLeast(0)
                rightMaxHeight = maxOf(rightMaxHeight, height[right])
                right--
            }
        }
        return res
    }
}
