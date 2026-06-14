class Solution {
    fun permute(nums: IntArray): List<List<Int>> {
        val n = nums.size
        val res = mutableListOf<List<Int>>()

        val used = BooleanArray(n)
        fun dfs(list: MutableList<Int>) {
            if (list.size == n) {
                res.add(list.toList())
                return
            }

            for (i in 0 until n) {
                if (used[i]) continue
                list.add(nums[i])
                used[i] = true
                dfs(list)
                list.removeLast()
                used[i] = false
            }
        }

        dfs(mutableListOf())
        return res
    }
}
