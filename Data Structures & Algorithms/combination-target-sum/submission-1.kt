class Solution {
    fun combinationSum(nums: IntArray, target: Int): List<List<Int>> {
        val res = mutableListOf<List<Int>>()

        fun dfs(current: MutableList<Int>, remain: Int, start: Int) {
            if (remain == 0) {
                res.add(current.toList())
                return
            }
            if (nums.first() > remain) return   

            for (i in start until nums.size) {
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
Sort nums at first.
if the first number is greater than the target, then return empty list.
otherwise iterator all the nums, put the num step by step and 
call the function again but use target - the current sum
*/
