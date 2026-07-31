class Solution {

    public boolean et(char[][] board,int x,int y,String targetWord,int index){
        if(targetWord.length() == index){
            return true;
        }
        if(x<0 || y< 0 
        || x==board.length ||y == board[0].length || targetWord.charAt(index) != board[x][y]){
            return false;
        }
        
        char temp = board[x][y];
        board[x][y]='#';

        boolean result = et(board,x+1,y,targetWord,index+1) 
                         || et(board,x,y+1,targetWord,index+1) 
                         || et(board,x-1,y,targetWord,index+1) 
                         || et(board,x,y-1,targetWord,index+1);
                         
        board[x][y]=temp;

        return result;
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(et(board,i,j,word,0)){
                    return true;
                }
            }
        }
        return false;
    }
}
