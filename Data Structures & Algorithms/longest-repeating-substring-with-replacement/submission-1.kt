class Solution {
    fun characterReplacement(s: String, k: Int): Int {
        var res = 0
        for (c in 'A'..'Z') {
            res = maxOf(res, replace(s, c, k))
        }
        return res
    }

    private fun replace(s: String, c: Char, k: Int): Int {
        var res = 0
        
        var left = 0
        var right = 0
        var remain = k
        while (right < s.length) {
            if (s[right] != c) remain--
            right++
            while (remain < 0 && left < right) {
                if (s[left] != c) remain++
                left++
            }
            res = maxOf(res, right - left)
        }

        return res
    }
}

/**
Input contains only uppercase English letters, 
so I can try every character that appears in it.

When I replace a character, I need to save its index 
so I can restore it later and replace newly encountered characters.

The earlier replacing letter should be removed earlier as well.
**/