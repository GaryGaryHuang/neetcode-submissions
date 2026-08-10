class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val courseToPres = mutableMapOf<Int, MutableList<Int>>()
        for ((course, preCourse) in prerequisites) {
            courseToPres.getOrPut(course) { mutableListOf() }.add(preCourse)
        }

        val visited = mutableSetOf<Int>()
        fun dfs(course: Int): Boolean {
            if (course in visited) return false
            if (course !in courseToPres) return true

            visited.add(course)
            for (preCourse in courseToPres[course]!!) {
                if (!dfs(preCourse)) return false
            }
            visited.remove(course)
            courseToPres.remove(course)
            return true
        }

        for (i in 0 until numCourses) {
            if (!dfs(i)) return false
        }
        return true
    }
}
