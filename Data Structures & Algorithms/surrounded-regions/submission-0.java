class Solution {

    public Deque<int[]> traverseBorder(char[][]board, char conditionalVal,boolean[][] isVisited){
        Deque<int[]> queue = new ArrayDeque<>();
        int rows=board.length,cols=board[0].length;

        for(int i=0;i<rows;i++){
            if(board[i][0] == conditionalVal){
                queue.offer(new int[]{i,0});
                isVisited[i][0]=true;
            }
            if(board[i][cols-1] == conditionalVal){
                queue.offer(new int[]{i,cols-1});
                isVisited[i][cols-1]=true;
            }
        }

        for(int j=1;j<cols-1;j++){
            if(board[0][j] == conditionalVal){
                queue.offer(new int[]{0,j});
                isVisited[0][j]=true;
            }
            if(board[rows-1][j] == conditionalVal){
                queue.offer(new int[]{rows-1,j});
                isVisited[rows-1][j]=true;
            }
        }

        return queue;
    }
    public void bfs(Deque<int[]> queue,char[][] board,boolean[][] isVisited){
        int[][] directions = {{1, 0},{-1, 0},{0, 1},{0, -1}};

        int rows=isVisited.length,cols=isVisited[0].length;
        
        while(!queue.isEmpty()){
            int[] curDir = queue.poll();
            for(var dir : directions){
                int nr = curDir[0]+dir[0];
                int nc = curDir[1]+dir[1];

                if(nr < 0 || nc < 0 || nr == rows || nc == cols){
                    continue;
                }

                if(isVisited[nr][nc] || board[nr][nc] == 'X'){
                    continue;
                }

                isVisited[nr][nc] = true;
                queue.offer(new int[]{nr,nc});
            }
        }
    }
    public void solve(char[][] board) {
        int rows=board.length,cols=board[0].length;
        boolean[][] isVisited = new boolean[rows][cols];
        Deque<int[]> queue = traverseBorder(board,'O',isVisited);
        bfs(queue,board,isVisited);

        for(int i=0;i<rows;i++){
            for(int j=0;j<cols;j++){
                if(!isVisited[i][j] && board[i][j] == 'O'){
                    board[i][j]='X';
                }
            }
        }
    }
}
