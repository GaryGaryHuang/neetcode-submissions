class Solution {
    fun exist(board: Array<CharArray>, word: String): Boolean {
        val row = board.size
        val column = board[0].size
        val used = Array(row) { BooleanArray(column) }

        fun find(index: Int, r: Int, c: Int): Boolean {
            if (index == word.length) return true
            if (r !in 0 until row || c !in 0 until column) return false
            if (word[index] != board[r][c] || used[r][c]) return false

            used[r][c] = true

            val isFind = find(index + 1, r + 1, c) || 
                find(index + 1, r - 1, c) ||
                find(index + 1, r, c + 1) ||
                find(index + 1, r, c - 1)

            used[r][c] = false

            return isFind
        }

        for (r in 0 until row) {
            for (c in 0 until column) {
                if (find(0, r, c)) return true
            }
        }
        return false
    }
}

/**
Try each cell that matches the first char of the word. 
After finding the first letter, explore its neighbors to find the remaining letters. 
Since a cell cannot be used twice, we need a boolean array to track which cells have been used.
*/
