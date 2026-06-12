class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val freqs = IntArray(26)
        for (t in tasks) freqs[t - 'A']++

        //  value, frequency
        val treeSet = TreeSet<Pair<Int, Int>>(compareByDescending<Pair<Int, Int>> { it.second }
        .thenBy { it.first })
        for (i in 0..25) {
            if (freqs[i] > 0) treeSet.add(Pair(i, freqs[i]))
        }

        val coolTime = IntArray(26)
        var time = 0
        while (treeSet.isNotEmpty()) {
            time++

            var addBack: Pair<Int, Int>? = null
            val iter = treeSet.iterator()
            while (iter.hasNext()) {
                val (value, freq) = iter.next()
                if (coolTime[value] > time) continue

                iter.remove()
                coolTime[value] = time + (n + 1)
                if (freq > 1) addBack = Pair(value, freq - 1)
                break
            }

            addBack?.let{ treeSet.add(it) }
        }
        return time
    }
}

/**
The identical tasks cannot execute consecutively. 
My strategy is to execute the most frequent character first, 
since it has the longest cooldown time.
*/
