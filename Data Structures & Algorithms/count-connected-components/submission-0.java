class Solution {
    public int countComponents(int n, int[][] edges) {
        List<Integer>[] adj = new ArrayList[n];

        for(int i=0;i<n;i++){
            adj[i] = new ArrayList<>();
        }
        for(var node : edges){
            adj[node[0]].add(node[1]);
            adj[node[1]].add(node[0]);
        }

        boolean[] isVisited = new boolean[n];
        int k=0;
        for(int i=0;i<n;i++){
            if(isVisited[i]){
                continue;
            }
            dfs(adj,i,isVisited);
            k++;
        }

        return k;
    }

    public void dfs(List<Integer>[]adj, int node, boolean[] isVisited){
        if(isVisited[node]){
            return;
        }
        isVisited[node] = true;
        for(var n : adj[node]){
            dfs(adj,n,isVisited);
        }
    }
}