class Solution {
    fun leastInterval(tasks: CharArray, n: Int): Int {
        val counts = IntArray(26)
        val coolTime = IntArray(26)

        val treeSet = TreeSet<Int>(compareByDescending{ counts[it] })
        for (t in tasks) {
            val index = t - 'A'
            counts[index]++
            treeSet.add(index)
        }

        var time = 0
        while (treeSet.isNotEmpty()) {
            time++
            for (i in 0 until treeSet.size) {
                val value = treeSet.elementAt(i)
                if (coolTime[value] > time) continue
                
                counts[value]--
                coolTime[value] = time + (n + 1)
                if (counts[value] == 0) treeSet.remove(value)

                break
            }
        }
        return time
    }
}

/**
The identical tasks cannot execute consecutively. 
My strategy is to execute the most frequent character first, 
since it has the longest cooldown time.
*/
