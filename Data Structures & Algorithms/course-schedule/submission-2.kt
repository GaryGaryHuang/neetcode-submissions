class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val nodeToEdges = mutableMapOf<Int, MutableList<Int>>()
        for (p in prerequisites) {
            nodeToEdges.getOrPut(p[0]) { mutableListOf() }.add(p[1])
        }

        val visited = mutableSetOf<Int>()
        val isFinish = BooleanArray(numCourses)
        fun dfs(course: Int): Boolean {
            if (course in visited) return false
            if (isFinish[course] || course !in nodeToEdges) {
                isFinish[course] = true
                return true
            }

            visited.add(course)
            for (preCourse in nodeToEdges[course]!!) {
                if (!dfs(preCourse)) return false
            }
            isFinish[course] = true
            visited.remove(course)
            return true
        }

        for (i in 0 until numCourses) {
            if (!dfs(i)) return false
        }
        return true
    }
}
