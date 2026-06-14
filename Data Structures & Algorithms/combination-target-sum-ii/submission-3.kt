class Solution {
    fun combinationSum2(candidates: IntArray, target: Int): List<List<Int>> {
        val n = candidates.size
        val res = mutableListOf<List<Int>>()

        fun dfs(list: MutableList<Int>, start: Int, remain: Int) {
            if (remain == 0) {
                res.add(list.toList())
                return
            }

            for (i in start until n) {
                if (candidates[i] > remain) break
                if (i > start && candidates[i] == candidates[i - 1]) continue

                list.add(candidates[i])
                dfs(list, i + 1, remain - candidates[i])
                list.removeLast()
            }
        }

        candidates.sort()
        dfs(mutableListOf(), 0, target)
        return res
    }
}

/**
Sort the array.
Each element can only be used once.
If the current element is used, the next candidate will be the next one.
*/
