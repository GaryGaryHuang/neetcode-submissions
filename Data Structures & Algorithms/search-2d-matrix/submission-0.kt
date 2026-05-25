class Solution {
    fun searchMatrix(matrix: Array<IntArray>, target: Int): Boolean {
        for (r in 0 until matrix.size) {
            val array = matrix[r]
            if (target !in array.first()..array.last()) continue

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
        }
        return false
    }
}

/**
Each row in the matrix is sorted in non-decreasing order, 
so check whether the target falls within each row’s range. 
If so, use binary search to find the target.
*/
