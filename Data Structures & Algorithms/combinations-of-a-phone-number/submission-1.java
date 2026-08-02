class Solution {
    public char[] getMappedLetters(int digit) {
    switch (digit) {
        case 2: return new char[]{'a', 'b', 'c'};case 3: return new char[]{'d', 'e', 'f'};
        case 4: return new char[]{'g', 'h', 'i'};case 5: return new char[]{'j', 'k', 'l'};
        case 6: return new char[]{'m', 'n', 'o'};case 7: return new char[]{'p', 'q', 'r', 's'};
        case 8: return new char[]{'t', 'u', 'v'};case 9: return new char[]{'w', 'x', 'y', 'z'};
        default: return new char[0];
    }
}

    public char[][] getMappedStrings(String digits){
        char[][] result = new char[digits.length()][4];
        int i=0;
        for(var ch : digits.toCharArray()){
            result[i++]=getMappedLetters(ch-'0');
        }
        return result;
    }

    public void bt(char[][] mappedStrings,int index,StringBuilder current,List<String> result){
        if(index==mappedStrings.length){
            result.add(new String(current));
            return;
        }

        for(var ch : mappedStrings[index]){
            if(ch == ' '){
                continue;
            }
            current.append(ch);
            bt(mappedStrings,index+1,current,result);
            current.deleteCharAt(current.length()-1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return Collections.emptyList();
        }
        char[][] mappedStrings = getMappedStrings(digits);
        List<String> result = new ArrayList<>();
        bt(mappedStrings,0,new StringBuilder(),result);
        return result;
    }
}
