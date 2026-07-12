class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        nums.sort()

        val set = mutableListOf<List<Int>>()
        val current = mutableListOf<Int>()
        fun dfs(start: Int, sum: Int) {
            if (sum == target) {
                set.add(current.toList())
                return
            }

            for (i in start until nums.size) {
                if (sum > target) {
                    break
                }

                current.add(nums[i])
                dfs(i, sum + nums[i])
                current.removeLast()
            }
        }

        dfs(0, 0)
        return set
    }
}
