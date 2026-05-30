class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var left = 0
        var right = matrix.size - 1
        var targetRow = 0
        while (left <= right) {
            val mid = (left + right) / 2
            when {
                matrix[mid][0] == target -> return true
                matrix[mid][0] > target -> {
                    right = mid - 1
                    targetRow = mid - 1
                }
                else -> {
                    left = mid + 1
                    targetRow = mid
                }
            }
        }

        left = 0
        right = matrix[targetRow].size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            when {
                matrix[targetRow][mid] == target -> return true
                matrix[targetRow][mid] > target -> right = mid - 1
                else -> left = mid + 1
            }
        }

        return false
    }
}

/**
Each row is sorted in non-decreasing order, 
so use binary search to find the row that likely contains the target. 
Then search for the target within that row.
*/
