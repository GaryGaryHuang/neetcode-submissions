class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val cars = position.indices
            .map { position[it] to (target - position[it]).toDouble() / speed[it] }
            .sortedByDescending { it.first }

        val stack = ArrayDeque<Double>()

        for ((_, time) in cars) {
            if (stack.isEmpty() || time > stack.last()) {
                stack.addLast(time)
            }
        }

        return stack.size
    }
}
