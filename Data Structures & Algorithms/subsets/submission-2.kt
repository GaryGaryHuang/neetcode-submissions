class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val set = mutableListOf<List<Int>>()

        val current = mutableListOf<Int>()
        fun dfs(start: Int) {
            set.add(current.toList())
            if (start == nums.size) {
                return
            }

            for (i in start until nums.size) {
                current.add(nums[i])
                dfs(i + 1)
                current.removeLast()
            }
        }

        dfs(0)
        return set
    }
}
