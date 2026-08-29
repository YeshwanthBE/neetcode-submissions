class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
        for(int i=0;i<numCourses;i++){
            adj[i]=new ArrayList<>();
        }

        int[] inDegrees = new int[numCourses];
        for(var pr : prerequisites){
            adj[pr[1]].add(pr[0]);
            inDegrees[pr[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0;i<numCourses;i++){
            if(inDegrees[i]==0){
                queue.offer(i);
            }
        }

        int completedCourse = 0;
        while(!queue.isEmpty()){
            int course = queue.poll();
            completedCourse++;

            for(var pr : adj[course]){
                inDegrees[pr]--;
                if(inDegrees[pr]==0){
                    queue.offer(pr);
                }
            }
        }

        return completedCourse == numCourses;
    }
}
