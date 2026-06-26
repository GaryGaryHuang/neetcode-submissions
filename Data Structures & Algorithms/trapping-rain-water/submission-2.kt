class Solution {
    fun trap(height: IntArray): Int {
        var totalArea = 0
        var prevLeftHeight = 0
        var prevRightHeight = 0
        var left = 0
        var right = height.size - 1
        while (left <= right) {
            var area = 0
            if (height[left] <= height[right]) {
                // move the left side
                area = prevLeftHeight - height[left]
                prevLeftHeight = maxOf(prevLeftHeight, height[left])
                left++
            } else {
                area = prevRightHeight - height[right]
                prevRightHeight = maxOf(prevRightHeight, height[right])
                right--
            }
            totalArea += area.coerceAtLeast(0)
        }
        return totalArea
    }
}

/**
Put two bars at the two sides.
The higher bar can push the water to the lower bar.
When computing the area, we should move the lower bar.
If we move the higher bar, we don't know whether the lower bar can keep the water inside it.
When we move the bar, we also need to keep the previous bar height at each side.
The current index of water is the previous lower bar height - the current bar height.
*/