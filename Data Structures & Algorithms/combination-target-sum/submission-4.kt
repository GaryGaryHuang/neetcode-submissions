class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        fun dfs(current: MutableList<Int>, remain: Int, start: Int) {
            if (remain == 0) {
                res.add(current.toList())
                return
            }
            if (start == nums.size || nums[start] > remain) return

            for (i in start until nums.size) {
                if (nums[i] > remain) break
                
                current.add(nums[i])
                dfs(current, remain - nums[i], i)
                current.removeLast()
            }
        }

        nums.sort()
        dfs(mutableListOf(), target, 0)
        return res
    }
}

/**
First, sort nums. 
If the start number is greater than the target, return.
Otherwise, iterate through all nums, add each number step by step, 
and call the function again using target minus the current sum.
*/
