class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        val rows = Array(9) { mutableSetOf<Char>() }
        val columns = Array(9) { mutableSetOf<Char>() }
        val boxes = Array(9) { mutableSetOf<Char>() }
        for (r in 0 until 9) {
            for (c in 0 until 9) {
                val num = board[r][c]
                if (num == '.') continue

                if (!rows[r].add(num)) return false
                if (!columns[c].add(num)) return false

                val boxIndex = 3 * (r / 3) + (c / 3)
                if (!boxes[boxIndex].add(num)) return false
            }
        }
        return true
    }
}
