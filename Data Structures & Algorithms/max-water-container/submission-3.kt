class Solution {
    fun maxArea(heights: IntArray): Int {
        var maxArea = 0
        var left = 0
        var right = heights.size - 1
        while (left < right) {
            val minHeight = minOf(heights[left], heights[right])
            val area = minHeight * (right - left)
            maxArea = maxOf(maxArea, area)

            if (heights[left] >= heights[right]) right--
            else left++
        }
        return maxArea
    }
}
