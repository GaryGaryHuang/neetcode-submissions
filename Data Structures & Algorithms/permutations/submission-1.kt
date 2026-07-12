class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val res = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()
        val visited = BooleanArray(nums.size)

        fun dfs() {
            if (current.size == nums.size) {
                res.add(current.toList())
                return
            }

            for (i in 0 until nums.size) {
                if (visited[i]) continue
                visited[i] = true
                current.add(nums[i])
                dfs()
                visited[i] = false
                current.removeLast()
            }
        }

        dfs()
        return res
    }
}
