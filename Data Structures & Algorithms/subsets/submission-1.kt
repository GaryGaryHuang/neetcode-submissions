class Solution {
    fun subsets(nums: IntArray): List<List<Int>> {
        val subsets = mutableListOf<List<Int>>()

        fun backtracking(subset: MutableList<Int>, start: Int) {
            subsets.add(subset.toList())
            if (start == nums.size) return
            for (i in start until nums.size) {
                subset.add(nums[i])
                backtracking(subset, i + 1)
                subset.removeLast()
            }
        }

        backtracking(mutableListOf(), 0)
        return subsets
    }
}
