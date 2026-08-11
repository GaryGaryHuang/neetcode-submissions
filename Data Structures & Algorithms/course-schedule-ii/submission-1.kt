class Solution {
    fun findOrder(numCourses: Int, prerequisites: Array<IntArray>): IntArray {
        val courseToPreCourses = mutableMapOf<Int, MutableList<Int>>()
        for ((course, preCourse) in prerequisites) {
            courseToPreCourses.getOrPut(course) { mutableListOf() }.add(preCourse)
        }

        val visited = mutableSetOf<Int>()
        fun dfs(course: Int): List<Int> {
            if (course in visited) return emptyList()
            if (course !in courseToPreCourses) return listOf(course)

            visited.add(course)
            val paths = mutableListOf<Int>()
            for (preCourse in courseToPreCourses[course]!!) {
                val path = dfs(preCourse)
                if (path.isEmpty()) return emptyList()
                paths.addAll(path)
            }
            visited.remove(course)
            paths.add(course)
            courseToPreCourses.remove(course)
            return paths
        }

        val isFinish = mutableSetOf<Int>()
        val res = mutableListOf<Int>()
        for (i in 0 until numCourses) {
            if (i in isFinish) continue
            
            val path = dfs(i)
            if (path.isEmpty()) return intArrayOf()
            
            res.addAll(path)
            isFinish.addAll(path)
        }
        return res.toIntArray()
    }
}
