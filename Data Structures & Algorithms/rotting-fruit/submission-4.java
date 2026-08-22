class Solution {
    public int orangesRotting(int[][] grid) {
        Deque<int[]> queue = new ArrayDeque<>();

        int freshFruit=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]==2){
                    queue.push(new int[]{i,j});
                }
                else if(grid[i][j]==1){
                    freshFruit++;
                }
            }
        }

        if(freshFruit==0){
            return 0;
        }

        int time=0;
        while(!queue.isEmpty()){
            int size = queue.size();
            boolean isRottenFruit = false;
            for(int k=0;k<size;k++){
                int[] idx = queue.poll();
                int i=idx[0],j=idx[1];

                if(i>0 && grid[i-1][j]==1){
                    grid[i-1][j]=2;
                    queue.offer(new int[]{i-1,j});
                    freshFruit--;isRottenFruit=true;
                }

                if(j>0 && grid[i][j-1]==1){
                    grid[i][j-1]=2;
                    queue.offer(new int[]{i,j-1});
                    freshFruit--;isRottenFruit=true;
                }

                if(i<grid.length-1 && grid[i+1][j]==1){
                    grid[i+1][j]=2;
                    queue.offer(new int[]{i+1,j});
                    freshFruit--;isRottenFruit=true;
                }

                if(j<grid[0].length-1 && grid[i][j+1]==1){
                    grid[i][j+1]=2;
                    queue.offer(new int[]{i,j+1});
                    freshFruit--;isRottenFruit=true;
                }
            }

            // if(isRottenFruit){
                time++;
            // }
            
        }
    
        return freshFruit==0?time-1:-1;
    }
}
