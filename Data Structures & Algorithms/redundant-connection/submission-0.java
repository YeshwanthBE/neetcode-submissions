class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n+1];

        for(int i=1;i<parent.length;i++){
            parent[i]=i;
        }

        for(var nodes : edges){
            int root1 = find(nodes[0],parent);
            int root2 = find(nodes[1],parent);

            if(root1==root2){
                return nodes;
            }

            parent[root2]=parent[root1];
        } 

        return null;
    }

    public int find(int node,int[] parent){
        if(parent[node] == node){
            return node;
        }

        return parent[node]=find(parent[node],parent);
    }
}
