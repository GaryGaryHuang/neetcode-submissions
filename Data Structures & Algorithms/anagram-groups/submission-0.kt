class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        // 1. convert every string into a String and put it into a map
        // The map's type is <String, MutableList<String>>
        val map = mutableMapOf<String, MutableList<String>>()
        for (str in strs) {
            val array = IntArray(26)
            for (c in str) {
                array[c - 'a']++
            }

            var key = ""
            for (i in array) {
                key = "$key-$i"
            }

            map.getOrPut(key) { mutableListOf<String>() }.add(str)
        }

        val res = mutableListOf<List<String>>()
        for (list in map.values) {
            res.add(list)
        }
        return res
    }
}


/**
I want to check every char in each string, and put it count in an array.
If the length of the array is 1000 and each element's length is 100
, the the complexity is 1000 * 100 * 26.
After compute every string, we can get a key by its array.
I can flat its elementsm like this 1-0-0-0-1-3-4-2-1..., so I can get a key by faltten it.
**/
