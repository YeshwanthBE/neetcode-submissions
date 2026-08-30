class Solution {
    public boolean validTree(int n, int[][] edges) {

        if(edges.length != n-1){
            return false;
        }

        List<Integer>[] adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }

        for(var node : edges){
            adj[node[0]].add(node[1]);
            adj[node[1]].add(node[0]);  
        }

        boolean[] isVisited = new boolean[n];
        dfs(adj,0,isVisited);
        for(var isV : isVisited){
            if(!isV){
                return false;
            }
        }
        
        return true;
    }

    public void dfs(List<Integer>[] adj,int node,boolean[] isVisited){
        isVisited[node] = true;

        for(var n : adj[node]){
            if(isVisited[n]){
                continue;
            }
            dfs(adj,n,isVisited);
        }
    }
}
