class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val courseToPreCourses = mutableMapOf<Int, MutableList<Int>>()
        for ((course, preCourse) in prerequisites) {
            courseToPreCourses.getOrPut(course) { mutableListOf() }.add(preCourse)
        }

        val hasFinished = mutableSetOf<Int>()
        val visited = mutableSetOf<Int>()
        fun dfs(course: Int): List<Int> {
            if (course in visited) return emptyList()
            if (course !in courseToPreCourses) {
                hasFinished.add(course)
                return listOf(course)
            }

            visited.add(course)
            val paths = mutableListOf<Int>()
            for (preCourse in courseToPreCourses[course]!!) {
                if (preCourse in hasFinished) continue

                val path = dfs(preCourse)
                if (path.isEmpty()) return emptyList()
                paths.addAll(path)
            }

            visited.remove(course)
            courseToPreCourses.remove(course)

            hasFinished.add(course)
            paths.add(course)
            return paths
        }

        val res = mutableListOf<Int>()
        for (i in 0 until numCourses) {
            if (i in hasFinished) continue

            val path = dfs(i)
            if (path.isEmpty()) return intArrayOf()
            
            res.addAll(path)
        }
        return res.toIntArray()
    }
}
