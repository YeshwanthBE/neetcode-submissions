class Solution {

    Set<Integer> cols = new HashSet<>();
    Set<Integer> dia1 = new HashSet<>();
    Set<Integer> dia2 = new HashSet<>();

    public void bt(char[][] board,int row,List<List<String>> chess){

        if(row==board.length){
            List<String> cb = new ArrayList<>();
            for(var r : board){
                cb.add(new String(r));
            }
            chess.add(cb);
            return;
        }

        for(int col=0;col<board.length;col++){
            if(cols.contains(col) ||
            dia1.contains(row-col) ||
            dia2.contains(row+col)){
                continue;
            }


            board[row][col]='Q';
            cols.add(col);
            dia1.add(row-col);
            dia2.add(row+col);
            
            bt(board,row+1,chess);
            
            board[row][col]='.';
            cols.remove(col);
            dia1.remove(row-col);
            dia2.remove(row+col);
            
        }
    }


    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        for(var row : board){
            Arrays.fill(row,'.');
        }
        List<List<String>> resultList = new ArrayList<>();
        bt(board,0,resultList);
        return resultList;
    }
}
