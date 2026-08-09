class Solution {

    public void islandsAndTreasure(int[][] grid) {

        Queue<int[]> queue = new ArrayDeque<>();
        for(int i=0; i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 0){
                    queue.offer(new int[]{i,j});
                }
            }
        }


        int[][]directions = {{1,0},{0,1},{-1,0},{0,-1}};

        while(!queue.isEmpty()){
            int[] cur = queue.poll();

            

            for(var dir : directions){
                int i=cur[0]+dir[0],j=cur[1]+dir[1];

                if(i<0 || j<0 || i==grid.length || j==grid[0].length){
                    continue;
                }

                if(grid[i][j]==Integer.MAX_VALUE){
                    grid[i][j]=grid[cur[0]][cur[1]]+1;
                    queue.offer(new int[]{i,j});
                }
            }
        }
    }
}
