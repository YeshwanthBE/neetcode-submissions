class Twitter {

    int time = 0;
    class Tweet{
        int id;
        int userId;
        long postedTime;

        Tweet(int id, int userId, long postedTime){
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
    
    public List<Integer> getNewsFeed(int userId) {
        
        Set<Integer> followees = followerIdVsfolloweeId.getOrDefault(userId,new HashSet<>());
        followees.add(userId);
        Queue<Tweet> minHeap = new PriorityQueue<>((a,b)->Long.compare(a.postedTime,b.postedTime));
        for(var followeeId : followees){
            for(var tweet : userIdVsTweets.getOrDefault(followeeId,new ArrayList<>())){
                minHeap.offer(tweet);
                if(minHeap.size()>10){
                    minHeap.poll();
                }
            }
        }

        ArrayDeque<Integer> resultTweets = new ArrayDeque<>();
        while(!minHeap.isEmpty()){
            System.out.println(minHeap.peek().id);
            resultTweets.addFirst(minHeap.poll().id);
        }

        return new ArrayList<>(resultTweets);
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
