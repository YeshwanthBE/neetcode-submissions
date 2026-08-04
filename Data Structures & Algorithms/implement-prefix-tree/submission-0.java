class PrefixTree {
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    TrieNode trie;
    public PrefixTree() {
         trie = new TrieNode();
    }

    public int getASCII(char ch){
        return ch>'Z' ? ch - 'a' : ch - 'A';
    }

    public void insert(String word) {
        TrieNode trie1 = trie;
        for(var ch :word.toCharArray()){
            if(trie1.children[getASCII(ch)] == null){
                trie1.children[getASCII(ch)]=new TrieNode();
            }
            trie1=trie1.children[getASCII(ch)];
        }
        trie1.isWord = true;
    }

    public boolean search(String word) {
        TrieNode trie1 = trie;
        for(var ch :word.toCharArray()){
            if(trie1.children[getASCII(ch)] == null){
                return false;
            }
            trie1=trie1.children[getASCII(ch)];
        }
        return trie1.isWord;
    }

    public boolean startsWith(String prefix) {
        TrieNode trie1 = trie;
        for(var ch :prefix.toCharArray()){
            if(trie1.children[getASCII(ch)] == null){
                return false;
            }
            trie1=trie1.children[getASCII(ch)];
        }
        return true;
    }
}
