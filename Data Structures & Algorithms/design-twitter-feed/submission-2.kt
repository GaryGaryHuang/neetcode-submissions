class Twitter {
    private val userToFollowees = mutableMapOf<Int, MutableSet<Int>>()
    private val userToPosts = mutableMapOf<Int, TreeSet<Tweet>>()

    fun postTweet(userId: Int, tweetId: Int) {
        val heap = userToPosts.getOrPut(userId) { TreeSet(compareBy { it.time }) }
        heap.add(Tweet.create(tweetId))
        if (heap.size > 10) heap.pollFirst()
    }

    fun getNewsFeed(userId: Int): List<Int> {
        val followees = userToFollowees[userId] ?: mutableSetOf<Int>()
        followees.add(userId)

        val res = TreeSet<Tweet>(compareBy { it.time })
        for (f in followees) {
            res.addAll(userToPosts[f] ?: continue)
        }

        while (res.size > 10) {
            res.pollFirst()
        }

        return res.toList().map { it.id }.reversed()
    }

    fun follow(followerId: Int, followeeId: Int) {
        val followees = userToFollowees.getOrPut(followerId) { mutableSetOf() }
        followees.add(followeeId)
    }

    fun unfollow(followerId: Int, followeeId: Int) {
        val followees = userToFollowees[followerId] ?: return
        followees.remove(followeeId)
    }

    private data class Tweet(val time: Int, val id: Int) {
        companion object {
            private var time = 0

            fun create(id: Int): Tweet {
                val post = Tweet(time, id)
                time++
                return post
            }
        }
    }
}

/**
Use Map<followerId, Set<followeeId>> to track followees 
and Map<userId, MaxHeap<tweetId>> to track each user's posts.
*/
