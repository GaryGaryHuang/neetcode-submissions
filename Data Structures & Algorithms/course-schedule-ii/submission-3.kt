class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val courseToPreCourses = mutableMapOf<Int, MutableList<Int>>()
        for ((course, preCourse) in prerequisites) {
            courseToPreCourses.getOrPut(course) { mutableListOf() }.add(preCourse)
        }

        val completed = mutableSetOf<Int>()
        val visited = mutableSetOf<Int>()
        val res = mutableListOf<Int>()
        fun dfs(course: Int): Boolean {
            if (course in visited) return false
            if (course in completed) return true

            visited.add(course)
            for (preCourse in courseToPreCourses[course] ?: emptyList() ) {
                if (!dfs(preCourse)) return false
            }

            visited.remove(course)
            completed.add(course)
            res.add(course)

            return true
        }

        for (i in 0 until numCourses) {
            if (!dfs(i)) return intArrayOf()
        }
        return res.toIntArray()
    }
}
