class WordDictionary {

    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    TrieNode trie ;

    public WordDictionary() {
        trie = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode trie1 = trie;
        for(var ch :word.toCharArray()){
            if(trie1.children[ ch - 'a'] == null){
                trie1.children[ ch - 'a']=new TrieNode();
            }
            trie1=trie1.children[ ch - 'a'];
        }
        trie1.isWord = true;
    }

    public boolean s(String word,int index,TrieNode trie1){

        if(trie1 == null){
            return false;
        }

        if(index == word.length()){
            return trie1.isWord;
        }

        char ch = word.charAt(index);

        if(ch == '.'){
            for(var node : trie1.children){
                if(s(word,index+1,node)){
                    return true;
                }
            }
        }
        else{
            if(trie1.children[ch-'a'] != null){
                return s(word,index+1,trie1.children[ch-'a']);
            }
        }
        return false;
    }

    public boolean search(String word) {
        
        return s(word,0,trie);
    }
}
