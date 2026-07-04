class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        var l = 0
        var r = matrix.size
        while (l < r) {
            val mid = (l + r) / 2
            when {
                matrix[mid][0] == target -> return true
                matrix[mid][0] > target -> r = mid - 1
                else -> l = mid
            }
        }

        val row = l
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
