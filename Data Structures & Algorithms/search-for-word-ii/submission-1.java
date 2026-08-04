class Solution {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word;
    }

    TrieNode trie = new TrieNode();

    public void insert(String word) {
        TrieNode trie1 = trie;
        for(var ch :word.toCharArray()){
            if(trie1.children[ch - 'a'] == null){
                trie1.children[ch - 'a']=new TrieNode();
            }
            trie1=trie1.children[ch - 'a'];
        }
        trie1.word = word;
    }

    public void bt(char[][]board ,TrieNode node, int i,int j,List<String> result){
       if(i<0 || j<0 || i==board.length || j==board[0].length){
            return; 
       }
        char ch = board[i][j];
        if(ch == '#'){
            return;
        }
        node = node.children[ch-'a'];

        if(node ==null){
            return;
        }

        if(node.word != null){
            result.add(node.word);
            node.word=null;
        }

        board[i][j]='#';
        bt(board,node,i+1,j,result);
        bt(board,node,i,j+1,result);
        bt(board,node,i-1,j,result);
        bt(board,node,i,j-1,result);
        board[i][j]=ch;
         
    }

    public List<String> findWords(char[][] board, String[] words) {
       for(var str : words){
            insert(str);
        }
        List<String> result = new ArrayList<>();
        for(int i=0;i<board.length;i++){
            for(int j=0;j<board[0].length;j++){
                bt(board,trie,i,j,result);
            }
        }
        return result;
    }
}
