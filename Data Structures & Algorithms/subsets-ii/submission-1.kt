class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        nums.sort()
        val res = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()

        fun dfs(start: Int) {
            res.add(current.toList())

            for (i in start until nums.size) {
                if (i > start && nums[i] == nums[i - 1]) continue
                current.add(nums[i])
                dfs(i + 1)
                current.removeLast()
            }
        }

        dfs(0)
        return res
    }
}
