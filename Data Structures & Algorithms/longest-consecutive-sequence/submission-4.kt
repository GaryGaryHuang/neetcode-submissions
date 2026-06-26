class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()

        var longest = 0
        for (num in set) {
            if (num - 1 in set) continue
            var next = num + 1
            while (next in set) next++
            longest = maxOf(longest, next - num)
        }
        return longest
    }
}

/**
[a, b, c, d, e]
Given the sorted array and each element is strictly increased by 1.
It means b = a + 1, c = b + 1,...
The answer is 5.

Given the sorted array and each element is strictly increased by 2.
It means b = a + 1, c = b + 2,...
The answer is 1.

I can put all elements into a set, and then traverse all elements.
I will check whether all its following nums exist in the set or not
so that I can find the continuous nums and get the length.
If the following num does not exist in the set, then stop finding.

Before trying every element in the set, we need to check whether element - 1 exists in the set or not.
Because we want to find the longest, so if element - 1 exists, we skip it.
*/