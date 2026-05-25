class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        for (r in 0 until board.size) {
            val set = mutableSetOf<Char>()
            for (c in 0 until board[0].size) {
                if (board[r][c] == '.') continue
                if (!set.add(board[r][c])) return false
            }
        }

        for (c in 0 until board.size) {
            val set = mutableSetOf<Char>()
            for (r in 0 until board[0].size) {
                if (board[r][c] == '.') continue
                if (!set.add(board[r][c])) return false
            }
        }

        //  boxes check
        for (i in 0..8) {
            val set = mutableSetOf<Char>()
            for (r in 0..2) {
                for (c in 0..2) {
                    val c = board[((i / 3) * 3) + r][((i % 3) * 3) + c]
                    if (c == '.') continue
                    if (!set.add(c)) return false
                }
            }
        }

        return true
    }
}
