class Solution {
    fun maxArea(heights: IntArray): Int {
        var left = 0
        var right = heights.size - 1
        var res = 0
        while (left < right) {
            val area = min(heights[left], heights[right]) * (right - left)
            res = maxOf(res, area)

            if (heights[left] <= heights[right]) left++
            else right--
        }
        return res
    }
}
