class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        var maxArea = 0
        val arrayDeque = ArrayDeque<Pair<Int, Int>>()
        for (i in 0..heights.size) {
            val height = if (i < heights.size) heights[i] else 0
            var startIndex = i
            while (arrayDeque.isNotEmpty() && arrayDeque.last().second > height) {
                val (preIndex, preHeight) = arrayDeque.removeLast()
                val area = preHeight * (i - preIndex)
                maxArea = maxOf(maxArea, area)
                startIndex = preIndex
            }
            arrayDeque.add(Pair(startIndex, height))
        }
        return maxArea
    }
}

/**
An area is limited by the shorter bar.
If a new bar is lower than the previous one, 
the previous height is no longer needed because the height is constrained by the shorter bar.

I would put the bars step by step.
When I encounter this case, I pop the taller bar.
Since the heights are increasing, I need to add a virtual bar at the end so I can compute the remaining area.
*/
