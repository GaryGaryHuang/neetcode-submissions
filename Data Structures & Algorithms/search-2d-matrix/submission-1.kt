class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        val row = findRow(matrix, target)
        if (row !in 0 until matrix.size) return false

        val array = matrix[row]
        var l = 0
        var r = array.size - 1
        while (l <= r) {
            val mid = (l + r) / 2
            when {
                array[mid] == target -> return true
                array[mid] < target -> l = mid + 1
                else -> r = mid - 1
            }
        }
        return false
    }

    private fun findRow(matrix: Array<IntArray>, target: Int): Int {
        var res = -1
        var l = 0
        var r = matrix.size - 1
        while (l <= r) {
            val mid = (l + r) / 2
            when {
                matrix[mid][0] == target -> {
                    res = mid
                    break
                }
                matrix[mid][0] > target -> {
                    r = mid - 1
                }
                else -> {
                    res = mid
                    l = mid + 1
                }
            }
        }
        return res
    }
}

/**
Each row in the matrix is sorted in non-decreasing order, 
so check whether the target falls within each row’s range. 
If so, use binary search to find the target.
*/
