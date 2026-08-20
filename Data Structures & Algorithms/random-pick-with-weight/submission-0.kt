class Solution(private val w: IntArray) {
    private val array = IntArray(w.size)

    init {
        var prefix = 0
        for (i in 0 until w.size) {
            prefix += w[i]
            array[i] = prefix
        }
    }

    fun pickIndex(): Int {
        val target = Random.Default.nextInt(1, array.last() + 1)

        var left = 0
        var right = array.size
        while (left < right) {
            val mid = left + (right - left) / 2
            if (array[mid] >= target) {
                right = mid
            } else {
                left = mid + 1
            }
        }
        return left
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * var obj = Solution(w)
 * var param_1 = obj.pickIndex()
 */
