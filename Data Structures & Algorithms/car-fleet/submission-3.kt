class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val n = position.size
        val times = mutableListOf<Pair<Int, Float>>()
        for (i in 0 until n) {
            val time = (target - position[i]).toFloat() / speed[i]
            times.add(Pair(position[i], time))
        }
        times.sortByDescending { it.first }

        var fleet = 0
        var lastFleetTime = 0f
        for ((_, time) in times) {
            if (time > lastFleetTime) {
                fleet++
                lastFleetTime = time
            }
        }
        return fleet 
    }
}

/**
First, compute each car's time to reach the target:
time = (target - position) / speed.

Then sort cars by position in descending order, 
so we process cars from closest to the target to farthest.

While scanning from front to back, 
maintain the arrival time of the current front fleet.

If the current car's time is less than or equal to the front fleet's time, 
it will catch up to that fleet before or exactly at the target, so it becomes part of the same fleet.

If the current car's time is greater than the front fleet's time, 
it cannot catch up, so it forms a new fleet.
*/
