class Solution {
    fun maxArea(heights: IntArray): Int {
        var res = 0
        var left = 0
        var right = heights.lastIndex
        while (left < right) {
            println("$left $right")
            val min = minOf(heights[left], heights[right])
            val area = min * (right - left)
            res = maxOf(res, area)
            if (heights[left] > heights[right]) right--
            else left++
        }
        return res
    }
}

/**
Use two pointer.
If the left is higher than the right, next action is moving the shorter one.
**/