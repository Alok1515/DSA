class Twitter {

    private static int timestamp = 0;

    // Tweet node
    private class Tweet {
        int id;
        int time;
        Tweet next;

        Tweet(int id) {
            this.id = id;
            this.time = timestamp++;
            this.next = null;
        }
    }

    // user -> tweet head
    private Map<Integer, Tweet> tweetMap;

    // user -> followees set
    private Map<Integer, Set<Integer>> followMap;

    public Twitter() {
        tweetMap = new HashMap<>();
        followMap = new HashMap<>();
    }

    // Post a tweet
    public void postTweet(int userId, int tweetId) {
        Tweet newTweet = new Tweet(tweetId);

        // Insert at head
        newTweet.next = tweetMap.get(userId);
        tweetMap.put(userId, newTweet);
    }

    // Get 10 most recent tweets
    public List<Integer> getNewsFeed(int userId) {

        PriorityQueue<Tweet> maxHeap =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        // User should follow themselves implicitly
        followMap.putIfAbsent(userId, new HashSet<>());
        followMap.get(userId).add(userId);

        // Add tweets of user + followees
        for (int followee : followMap.get(userId)) {
            Tweet head = tweetMap.get(followee);
            if (head != null) {
                maxHeap.add(head);
            }
        }

        List<Integer> result = new ArrayList<>();

        // Extract top 10 tweets
        while (!maxHeap.isEmpty() && result.size() < 10) {
            Tweet curr = maxHeap.poll();
            result.add(curr.id);

            if (curr.next != null) {
                maxHeap.add(curr.next);
            }
        }

        return result;
    }

    // Follow
    public void follow(int followerId, int followeeId) {
        followMap.putIfAbsent(followerId, new HashSet<>());
        followMap.get(followerId).add(followeeId);
    }

    // Unfollow
    public void unfollow(int followerId, int followeeId) {

        if (!followMap.containsKey(followerId) || followeeId == followerId)
            return;

        followMap.get(followerId).remove(followeeId);
    }
}
