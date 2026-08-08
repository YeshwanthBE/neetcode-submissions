class Solution {

    public int dfs(int i,int j,int[][]grid){
        
        if(grid[i][j]==0){
            return 0;
        }

        grid[i][j]=0;

        int area = 1;

        if(i>0 && grid[i-1][j] == 1){
            area += dfs(i-1,j,grid);
        }

        if(j>0 && grid[i][j-1] == 1){
            area += dfs(i,j-1,grid);
        }

        if(i<grid.length-1 && grid[i+1][j] == 1){
            area += dfs(i+1,j,grid);
        }

        if(j<grid[0].length-1 && grid[i][j+1] == 1){
            area += dfs(i,j+1,grid);
        }

        return area;
    }

    public int maxAreaOfIsland(int[][] grid) {
        int maxArea =0;
        for(int i =0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 1){
                    maxArea = Math.max(maxArea,dfs(i,j,grid));
                }
            }
        }
        return maxArea;
    }
}
