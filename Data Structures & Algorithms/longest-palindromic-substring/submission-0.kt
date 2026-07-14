class Solution {
    fun longestPalindrome(s: String): String {
        var longestRes = ""
        var longest = 0
        for (i in 0 until s.length) {
            //  odd-length
            var l = i
            var r = i
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                if (r - l + 1 > longest) {
                    longestRes = s.substring(l, r + 1)
                    longest = r - l + 1
                }
                l--; r++;
            }

            //  even-length
            l = i
            r = i + 1
            while (l >= 0 && r < s.length && s[l] == s[r]) {
                if (r - l + 1 > longest) {
                    longestRes = s.substring(l, r + 1)
                    longest = r - l + 1
                }
                l--; r++;
            }
        }
        return longestRes
    }
}

/**
a b a b d

A palindrome can be found by expanding around its center.

For an odd-length palindrome, initialize both pointers at the same index.
For example, l = 0 and r = 0. Then move l to the left and r to the right
while the characters are equal.

An even-length palindrome has its center between two adjacent characters.
For example, "abba" is a palindrome with l = 1 and r = 2.
Initialize the pointers at these two indices and expand outward in the same way.

We check every possible center and keep the longest palindrome found.
*/
