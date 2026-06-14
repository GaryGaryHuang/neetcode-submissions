class Twitter {
    private val userToFollowees = mutableMapOf<Int, MutableSet<Int>>()
    private val userToPosts = mutableMapOf<Int, PriorityQueue<Int>>()

    fun postTweet(userId: Int, tweetId: Int) {
        val heap = userToPosts.getOrPut(userId) { PriorityQueue() }
        heap.offer(tweetId)
        if (heap.size > 10) heap.poll()
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val res = PriorityQueue<Int>()
        res.addAll(userToPosts[userId] ?: emptyList())

        val followees = userToFollowees[userId] ?: setOf()
        for (f in followees) {
            res.addAll(userToPosts[f] ?: emptyList())
        }

        while (res.size > 10) {
            res.poll()
        }

        return res.toList().sortedDescending()
    }

    fun follow(followerId: Int, followeeId: Int) {
        val followees = userToFollowees.getOrPut(followerId) { mutableSetOf() }
        followees.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        val followees = userToFollowees.getOrPut(followerId) { mutableSetOf() }
        followees.remove(followeeId)
    }
}

/**
Use Map<followerId, Set<followeeId>> to track followees 
and Map<userId, MaxHeap<tweetId>> to track each user's posts.
*/
