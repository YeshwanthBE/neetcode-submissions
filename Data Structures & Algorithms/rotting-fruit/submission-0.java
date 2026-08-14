class Solution {

    public boolean makeRot(int[][]grid , int i,int j){
        if(i<0 || j<0 || i==grid.length || j==grid[0].length || grid[i][j] != 1){
            return false;
        }

        grid[i][j] = 2;
        return true;
    }

    public int helper(int grid[][], Deque<int[]> queue,int fresh){
        int t =0;
        while(!queue.isEmpty()){
            int size =queue.size();
            boolean rotted = false;
            for(int k=0;k<size;k++){
                int[] index = queue.poll();
                int i=index[0],j=index[1];

                if(makeRot(grid,i+1,j)){
                    queue.offer(new int[]{i+1,j});
                    fresh--;rotted = true;
                }
                if(makeRot(grid,i,j+1)){
                    queue.offer(new int[]{i,j+1});
                    fresh--;rotted = true;
                }
                if(makeRot(grid,i-1,j)){
                    queue.offer(new int[]{i-1,j});
                    fresh--;rotted = true;
                }
                if(makeRot(grid,i,j-1)){
                    queue.offer(new int[]{i,j-1});
                    fresh--;rotted = true;
                }
            }
            if(rotted){
                t++;
            }
        }
        return fresh == 0 ? t : -1;
    }

    public int orangesRotting(int[][] grid) {

        Deque<int[]> queue = new ArrayDeque<>();

        int fresh =0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j] ==1){
                    fresh++;
                }
            }
        }
        
        return helper(grid,queue,fresh);
    }
}
