class Solution {
    fun partition(s: String): List<List<String>> {
        val res = mutableListOf<List<String>>()

        val path = mutableListOf<String>()
        fun dfs(start: Int) {
            if (start == s.length) {
                res.add(path.toList())
                return
            }

            for (end in start until s.length) {
                val str = s.substring(start, end + 1)
                if (!isPalindrome(str)) continue

                path.add(str)
                dfs(end + 1)
                path.removeLast()
            }
        }

        dfs(0)
        return res
    }

    private fun isPalindrome(str: String): Boolean {
        var l = 0
        var r = str.length - 1
        while (l < r) {
            if (str[l] != str[r]) return false
            l++
            r--
        }
        return true
    }
}
