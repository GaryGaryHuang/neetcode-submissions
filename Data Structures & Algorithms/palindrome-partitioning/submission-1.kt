class Solution {
    fun partition(s: String): List<List<String>> {
        val res = mutableListOf<List<String>>()
        val current = mutableListOf<String>()

        fun dfs(start: Int) {
            if (start == s.length) {
                res.add(current.toList())
                return
            }

            for (i in start until s.length) {
                val substring = s.substring(start, i + 1)
                if (!isParlindrome(substring)) continue
                current.add(substring)
                dfs(i + 1)
                current.removeLast()
            }
        }

        dfs(0)
        return res
    }

    private fun isParlindrome(s: String): Boolean {
        var l = 0
        var r = s.length - 1
        while (l < r) {
            if (s[l] != s[r]) return false
            l++; r--;
        }
        return true
    }
}

/**
 * Every single character is a palindrome.
 *
 * Starting from the first character, I use DFS to try different partitions.
 * For "aab", the first partition is "a", followed by "a" and "b", which
 * produces ["a", "a", "b"].
 *
 * I then backtrack and try the substring "aa". Since it is a palindrome, I
 * continue DFS with the remaining substring "b", producing ["aa", "b"].
 *
 * Finally, I try "aab", but it is not a palindrome, so I discard this path.
 */
