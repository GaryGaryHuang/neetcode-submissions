class Solution {
    fun carFleet(target: Int, position: IntArray, speed: IntArray): Int {
        val posToSpeed = mutableListOf<Pair<Int, Int>>()
        for (i in 0 until position.size) {
            posToSpeed.add(Pair(position[i], speed[i]))
        }
        posToSpeed.sortBy { it.first }

        val times: List<Double> = posToSpeed.map {
            (target - it.first) / (it.second.toDouble())
        } 

        var index = position.size - 1
        var firstCarTime = 0.0
        var fleet = 0
        while (index >= 0) {
            firstCarTime = times[index]
            fleet++

            var behind = index - 1
            while (behind >= 0 && times[behind] <= times[index]) {
                behind--
            }

            index = behind
        }
        return fleet
    }
}

/**
The behind car cannot pass through the front car,
so they arrive step by step.
But the behind car could arrive at the same time as the front car,
if its speed is high enough.

I have target, position, and speed,
so I can know how long every car takes to arrive at the destination.

The position array does not look sorted, so I need to sort it first.
After sorting the positions, I want to compute every car's remaining time.
The remaining time means how long this car needs to arrive at the destination.

[3, 2, 1] -> This means every car arrives at a different fleet.
[3, 3, 1] -> This means the car behind the index 2 also arrives at the same time when index 2 arrives.
*/
