class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val res = IntArray(nums.size) { 1 }

        var product = nums[0]
        for (i in 1 until nums.size) {
            res[i] = product
            product *= nums[i]
        }

        product = nums.last()
        for (i in nums.size - 2 downTo 0) {
            res[i] *= product
            product *= nums[i]
        }

        return res
    }
}

/**
[a, b, c, d, e]
a: b * c * d * e
b: a * c * d * e
c: a * b * d * e
d: a * b * c * e
e: a * b * c * d

For a, the answer is the product of all elements to its right.
For e, the answer is the product of all elements to its left.
For c, the answer is the product of all elements to its left and right.

When traversing from left to right, start at the first element and stop at the last to compute e.
Then traverse from right to left, start at the last element and stop at the first to compute a.

Given an array nums of size n, create an array of size n initialized to 1.
As I visit each index, update the running product so far.
*/