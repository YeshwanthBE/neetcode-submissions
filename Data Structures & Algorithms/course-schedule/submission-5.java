class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        List<Integer>[] adj = new ArrayList[numCourses];

        for (int i = 0; i < numCourses; i++) {
            adj[i] = new ArrayList<>();
        }

        for(var pr : prerequisites){
            adj[pr[0]].add(pr[1]);
        }

        int[] isVisited = new int[numCourses];
        for(int i=0;i<numCourses;i++){
            if(isVisited[i]==0 && !dfs(adj,i,isVisited)){
                return false;
            }
        }
        return true;
    }

    public boolean dfs(List<Integer>[] adj,int course,int[] isVisited){

        if(isVisited[course] == 1){
            return false;
        }   

        if(isVisited[course] == 2){
            return true;
        }

        isVisited[course] = 1;
        for(var pr : adj[course]){
            if(!dfs(adj,pr,isVisited)){
                return false;
            }
        }
        isVisited[course] = 2;
        return true;
    }
}
