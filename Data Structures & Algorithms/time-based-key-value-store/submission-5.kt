class TimeMap() {
    private val keyToValues = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        keyToValues.getOrPut(key) { mutableListOf() }.add(Pair(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        val values = keyToValues[key] ?: return ""
        var left = 0
        var right = values.size - 1
        var ans = -1
        while (left <= right) {
            val mid = (left + right) / 2
            if (values[mid].first > timestamp) right = mid - 1
            else {
                ans = mid
                left = mid + 1
            }
        }
        return if (ans == -1) "" else values[ans].second
    }
}
