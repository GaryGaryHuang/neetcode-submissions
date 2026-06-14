class Solution {
    fun subsetsWithDup(nums: IntArray): List<List<Int>> {
        val n = nums.size

        val res = mutableListOf<List<Int>>()
        val path = mutableListOf<Int>()

        fun dfs(start: Int) {
            res.add(path.toList())

            for (i in start until n) {
                if (i > start && nums[i] == nums[i - 1]) continue

                path.add(nums[i])
                dfs(i + 1)
                path.removeLast()
            }
        }

        nums.sort()
        dfs(0)
        return res
    }
}
