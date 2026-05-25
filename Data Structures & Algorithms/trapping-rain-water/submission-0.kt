class Solution {
    fun trap(height: IntArray): Int {
        var area = 0
        var left = 0
        var right = height.size - 1
        var leftMaxHeight = 0
        var rightMaxHeight = 0
        while (left < right) {
            if (height[left] <= height[right]) {
                leftMaxHeight = max(leftMaxHeight, height[left])
                area += leftMaxHeight - height[left]
                left++
            } else {
                rightMaxHeight = max(rightMaxHeight, height[right])
                area += rightMaxHeight - height[right]
                right--
            }
        }
        return area
    }
}
