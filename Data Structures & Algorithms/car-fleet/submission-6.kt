class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val n = position.size

        //  <Position, time>
        val posToTime = mutableListOf<Pair<Int, Double>>()
        for (i in 0 until n) {
            val time = (target - position[i]) / (speed[i].toDouble())
            posToTime.add(Pair(position[i], time))
        }
        posToTime.sortBy { it.first }

        val times = posToTime.map { it.second }

        var fleets = 0
        var i = n - 1
        while (i >= 0) {
            var j = i - 1
            while (j >= 0 && times[j] <= times[i]) j--

            fleets++
            i = j
        }

        return fleets
    }
}

/**
We know the cars' positions and speeds, 
so we can estimate when they will reach the destination.
Fomula: (target - position) / speed
This value represents how many units of time 
a car needs to reach the destination.

> A car can not pass another car ahead of it. 

We start with the car closest to the target.
If a car behind it has a smaller or equal time value,
it means the car behind can catch up to the car in front.
*/
