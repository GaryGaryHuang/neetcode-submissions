class Twitter {
    private val userToTweets = mutableMapOf<Int, ArrayDeque<Tweet>>()
    private val userToFollowees = mutableMapOf<Int, MutableSet<Int>>()
    private var timstamp = 0L

    fun postTweet(userId: Int, tweetId: Int) {
        userToTweets.getOrPut(userId) { ArrayDeque()}.apply {
            add(Tweet(tweetId, timstamp++))
            if (size > 10) removeFirst()
        }
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val pq = PriorityQueue<Tweet>(compareByDescending { it.timestamp })
        userToTweets.get(userId)?.let { pq.addAll(it) }
        userToFollowees.get(userId)?.forEach { followeeId ->
            if (followeeId == userId) return@forEach
            userToTweets.get(followeeId)?.let { pq.addAll(it) }
        }
        
        val res = mutableListOf<Int>()
        while (pq.isNotEmpty() && res.size < 10) {
            res.add(pq.poll().id)
        }
        return res
    }

    fun follow(followerId: Int, followeeId: Int) {
        userToFollowees.getOrPut(followerId) { mutableSetOf() }.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        userToFollowees.get(followerId)?.remove(followeeId)
    }
}

data class Tweet(val id: Int, val timestamp: Long)
