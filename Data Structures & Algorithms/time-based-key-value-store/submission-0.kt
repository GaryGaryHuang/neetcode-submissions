class TimeMap() {
    private val keyToList = mutableMapOf<String, MutableList<Pair<Int, String>>>()

    fun set(key: String, value: String, timestamp: Int) {
        keyToList.getOrPut(key) { mutableListOf() }.add(Pair(timestamp, value))
    }

    fun get(key: String, timestamp: Int): String {
        val list = keyToList[key] ?: return ""
        var left = 0
        var right = list.size - 1

        var res = ""
        while (left <= right) {
            val mid = (left + right) / 2
            val (time, value) = list[mid]
            if (time > timestamp) {
                right = mid - 1
            } else {
                left = mid + 1
                res = value
            }
        }
        return res
    }
}

/**
All the timestamps of set are strictly increasing.
I would use Map to store a key and its value list.

When `get` is called, find its value list.
If the key does not exist, return "".
If the key exists, return the closest timestamp before timestamp.
*/
