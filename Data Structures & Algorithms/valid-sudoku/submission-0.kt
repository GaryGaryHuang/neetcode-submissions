class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        //  check rows
        for (r in 0 until 9) {
            val set = mutableSetOf<Char>()
            for (c in 0 until 9) {
                val num = board[r][c]
                if (num == '.') continue
                if (!set.add(num)) return false
            }
        }

        //  check columns
        for (c in 0 until 9) {
            val set = mutableSetOf<Char>()
            for (r in 0 until 9) {
                val num = board[r][c]
                if (num == '.') continue
                if (!set.add(num)) return false
            }
        }

        for (i in 0 until 3) {
            for (j in 0 until 3) {
                val set = mutableSetOf<Char>()
                repeat(3) { k ->
                    repeat(3) { l ->
                        val num = board[i * 3 + k][j * 3 + l];
                        if (num != '.' && !set.add(num)) return false
                    }
                }
            }
        }

        return true
    }
}

//  Store each number in rows in every the specific row's column's `set`.
//  If set return false, it means the number is duplicate.

//  Store each number in columns in every the specidifc columns's row's `set`.
//  If set return false, it means the number is duplicate.

//  Check every blocks whether there are duplicate numbers or not.
