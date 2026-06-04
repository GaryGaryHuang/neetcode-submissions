class Solution {
    fun largestRectangleArea(heights: IntArray): Int {
        val n = heights.size

        //  index, height
        var maxArea = 0
        val arrayDeque = ArrayDeque<Pair<Int, Int>>()
        for (i in 0 until n) {
            var theMostLeft = i
            while (arrayDeque.isNotEmpty() && heights[i] < arrayDeque.last().second) {
                val (prev, prevH) = arrayDeque.removeLast()
                val area = prevH * (i - prev)
                maxArea = maxOf(maxArea, area)
                theMostLeft = prev
            }
            arrayDeque.add(Pair(theMostLeft, heights[i]))
        }

        while (arrayDeque.isNotEmpty()) {
            val (prev, prevH) = arrayDeque.removeLast()
            val area = prevH * (n - prev)
            maxArea = maxOf(maxArea, area)
        }

        return maxArea
    }
}

/**
A bar’s height limits the next bar. 
If a new bar is lower than the previous one, 
remove the previous bar and push the new one onto the array. 

The current height is the height of the last bar. 

When a bar is removed, calculate its area using its height and a width equal to the current index - its index.
*/