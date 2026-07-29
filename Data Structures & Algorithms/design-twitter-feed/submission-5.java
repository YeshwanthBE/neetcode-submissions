class Twitter {

    int time = 0;
    class Tweet{
        int id;
        int userId;
        int postedTime;

        Tweet(int id, int userId, int postedTime){
            this.id = id;
            this.userId = userId;
            this.postedTime = postedTime;
        }
    }
    

    Map<Integer,List<Tweet>> userIdVsTweets;
    Map<Integer,HashSet<Integer>> followerIdVsfolloweeId;

    public Twitter() {
        userIdVsTweets = new HashMap<>();
        followerIdVsfolloweeId = new HashMap<>();
    }
    
    public void postTweet(int userId, int tweetId) {
        List<Tweet> tweetsIds = userIdVsTweets.computeIfAbsent(userId,id->new ArrayList<>());
        tweetsIds.add(new Tweet(tweetId,userId,time++));
    }

    class Node {
        int userId;
        int index;
        Tweet tweet;

        Node(int userId, int index, Tweet tweet) {
            this.userId = userId;
            this.index = index;
            this.tweet = tweet;
        }
    }
    
    public List<Integer> getNewsFeed(int userId) {
        
        Set<Integer> followees = new HashSet<>(followerIdVsfolloweeId.getOrDefault(userId,new HashSet()));
        followees.add(userId);

        PriorityQueue<Node> maxHeap = new PriorityQueue<>((a, b) -> b.tweet.postedTime - a.tweet.postedTime);

        for (int followeeId : followees) {
            List<Tweet> tweets = userIdVsTweets.get(followeeId);
            if (tweets != null && !tweets.isEmpty()) {
                int last = tweets.size() - 1;
                maxHeap.offer(new Node(followeeId, last, tweets.get(last)));
            }
        }

        List<Integer> resultTweets = new ArrayList<>();
        while(!maxHeap.isEmpty() && resultTweets.size() < 10){
            Node node = maxHeap.poll();
            resultTweets.add(node.tweet.id);
            if(node.index>0){
                int prev = node.index - 1;
                List<Tweet> tweets = userIdVsTweets.get(node.userId);
                maxHeap.offer(new Node(
                        node.userId,
                        prev,
                        tweets.get(prev)
                ));
            }
        }

        return resultTweets;
    }
    
    public void follow(int followerId, int followeeId) {
        Set<Integer> followeesIds = followerIdVsfolloweeId.computeIfAbsent(followerId,id->new HashSet<>());
        followeesIds.add(followeeId);
    }
    
    public void unfollow(int followerId, int followeeId) {
        Set<Integer> followeesIds = followerIdVsfolloweeId.computeIfAbsent(followerId,id->new HashSet<>());
        followeesIds.remove(followeeId);
    }
}
