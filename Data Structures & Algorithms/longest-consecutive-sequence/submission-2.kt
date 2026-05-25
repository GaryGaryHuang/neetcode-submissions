class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        var res = 0
        for (num in set) {
            if ((num - 1) in set) continue

            var next = num + 1
            while (next in set) next++

            res = maxOf(res, next - num)
        }
        return res
    }
}
