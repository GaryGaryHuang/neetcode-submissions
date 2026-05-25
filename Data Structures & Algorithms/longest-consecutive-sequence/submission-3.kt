class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val set = nums.toSet()
        var maxLength = 0
        for (num in set) {
            if ((num - 1) in set) continue
            var endNum = num + 1
            while (endNum in set) endNum++
            maxLength = maxOf(maxLength, endNum - num)
        }
        return maxLength
    }
}

/**
Convert nums to a Set.
Them, iterate throught num and check whether num - 1 exists or not.
If num - 1 does not exist, this means this num is head.
If it exists, we can pass this num because we need to start from its head.
If we find the head, we just keep finding the contiguous nums until the num is not in the set.

Convert nums to a set. 
Then iterate through the numbers and check whether num - 1 exists. 
If it does not, this number is the start of a sequence. 
If it does, skip it because the sequence should be counted from its head. 
Once a head is found, 
keep extending the sequence until the next number is no longer in the set.
*/
