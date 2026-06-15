class Solution {
    public boolean isValidSudoku(char[][] board) {
        boolean[][] rowCheck = new boolean[9][9];
        boolean[][] colCheck = new boolean[9][9];
        boolean[][] gridCheck = new boolean[9][9];
        for(int i=0;i<9;i++){
            for(int j=0;j<9;j++){
                if(board[i][j] == '.'){
                    continue;
                }
                int ch = board[i][j]-'0';--ch;
                
                if(rowCheck[i][ch]){
                    return false;
                }  
                rowCheck[i][ch] = true;

                if(colCheck[ch][j]){
                    return false;
                }
                colCheck[ch][j] = true;

                int gridNum = ((i/3)*3)+j/3;
                if(gridCheck[gridNum][ch]){
                    return false;
                }
                gridCheck[gridNum][ch] = true;
            }
        }
        return true;
    }
}
