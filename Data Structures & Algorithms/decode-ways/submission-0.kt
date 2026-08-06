class Solution {
    fun numDecodings(s: String): Int {
        if (s[0] == '0') return 0

        val dp = IntArray(s.length)
        dp[0] = 1

        for (i in 1 until s.length) {
            var ways = dp[i - 1]
            if (s[i - 1] in '1'..'2') ways++
            if (ways == dp[i - 1] && s[i] == '0') return 0
            dp[i] = ways
        }
        return dp.last()
    }
}

/**
For each char, there are two ways to convert it into a number: 
consider the current char on its own, or combine it with the previous char.
There is one edge case: 
if the current char is 0, it cannot be converted on its own 
and must be combined with the previous char.
*/
