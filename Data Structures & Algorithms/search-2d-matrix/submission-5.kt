class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var l = 0
        var r = matrix.size - 1
        var row = 0
        while (l <= r) {
            val mid = (l + r) / 2
            when {
                matrix[mid][0] == target -> return true
                matrix[mid][0] > target -> r = mid - 1
                else -> {
                    row = l
                    l = mid + 1
                }
            }
        }

        l = 0
        r = matrix[row].size - 1
        while (l <= r) {
            val mid = (l + r) / 2
            when {
                matrix[row][mid] == target -> return true
                matrix[row][mid] > target -> r = mid - 1
                else -> l = mid + 1
            }
        }
        return false
    }
}

/**
Based on the two conditions in the question, 
I can determine which row may contain the target. 
Once the row is identified, 
I can then determine which column the target is.
*/
