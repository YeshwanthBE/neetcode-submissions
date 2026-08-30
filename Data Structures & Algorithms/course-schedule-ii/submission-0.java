class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        
        List<Integer>[] adj = new ArrayList[numCourses];

        for(int i=0;i<adj.length;i++){
            adj[i] = new ArrayList<>();
        }

        int[] indegrees = new int[numCourses];
        for(var pr : prerequisites){
            adj[pr[1]].add(pr[0]);
            indegrees[pr[0]]++;
        }

        Deque<Integer> queue = new ArrayDeque<>();
        for(int i=0; i<indegrees.length; i++){
            if(indegrees[i] == 0){
                queue.offer(i);
            }
        }
        
        int[] order = new int[numCourses];int k=0;
        while(!queue.isEmpty()){
            int i = queue.poll();   
            order[k++] = i;

            for(var  pr : adj[i]){
                if(--indegrees[pr] == 0){
                    queue.offer(pr);
                }
            }                
        }

        if(numCourses == k){
            return order;
        }
        
        return new int[0];
    }
}
