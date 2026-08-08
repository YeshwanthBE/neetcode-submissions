class Solution {
    public int numIslands(char[][] grid) {
        Deque<Integer> stack1 =  new ArrayDeque<>();
        Deque<Integer> stack2 =  new ArrayDeque<>();
        int numIslands=0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
               
                if(grid[i][j]=='0'){
                    continue;
                }

                numIslands++;

                stack1.push(i);stack2.push(j);

                while(!stack1.isEmpty()){
                    int m = stack1.pop();
                    int n = stack2.pop();

                    if(m<0 || n<0 || m>=grid.length || n >=grid[0].length || grid[m][n]=='0'){
                        continue;
                    }

                    grid[m][n]='0';

                    stack1.push(m+1);stack2.push(n);
                    stack1.push(m);stack2.push(n+1);
                    stack1.push(m-1);stack2.push(n);
                    stack1.push(m);stack2.push(n-1);
                    
                }
            }
        }

        return numIslands;
    }
}
