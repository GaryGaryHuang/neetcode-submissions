class Solution {
    fun canFinish(numCourses: Int, prerequisites: Array<IntArray>): Boolean {
        val pres = IntArray(numCourses) { -1 }
        for (p in prerequisites) {
            pres[p[0]] = p[1]
        }

        val visited = mutableSetOf<Int>()
        val isFinish = BooleanArray(numCourses)
        fun dfs(course: Int): Boolean {
            if (course in visited) return false
            if (isFinish[course] || pres[course] == -1) {
                isFinish[course] = true
                return true
            }

            visited.add(course)
            isFinish[course] = dfs(pres[course])
            visited.remove(course)
            return isFinish[course]
        }

        for (i in 0 until numCourses) {
            if (!dfs(i)) return false
        }
        return true
    }
}
