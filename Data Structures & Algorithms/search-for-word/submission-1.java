class Solution {

    public boolean et(char[][] board,int x,int y,String targetWord,StringBuilder word,boolean[][] visited){
        if(targetWord.equals(word.toString())){
            return true;
        }
        if(targetWord.length() == word.length() || x<0 || y< 0 
        || x==board.length ||y == board[0].length || visited[x][y]){
            return false;
        }
        
        word.append(board[x][y]);visited[x][y]=true;
        if(et(board,x+1,y,targetWord,word,visited)){
            return true;
        };
        if(et(board,x,y+1,targetWord,word,visited)){
            return true;
        };
        if(et(board,x-1,y,targetWord,word,visited)){
            return true;
        };
        if(et(board,x,y-1,targetWord,word,visited)){
            return true;
        };
        word.deleteCharAt(word.length()-1);visited[x][y]=false;

        return false;
    }

    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                if(et(board,i,j,word,new StringBuilder(),new boolean[board.length][board[0].length])){
                    return true;
                }
            }
        }
        return false;
    }
}
