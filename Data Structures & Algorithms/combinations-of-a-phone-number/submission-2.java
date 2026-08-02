class Solution {
        private static final String[] MAP = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs",
            "tuv", "wxyz"
        };

    public void bt(String digits,int index,StringBuilder current,List<String> result){
        if(index==digits.length()){
            result.add(new String(current));
            return;
        }

        String letters = MAP[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            char ch = letters.charAt(i);
            current.append(ch);
            bt(digits, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }
    public List<String> letterCombinations(String digits) {
        if(digits.isEmpty()){
            return Collections.emptyList();
        }
        List<String> result = new ArrayList<>();
        bt(digits,0,new StringBuilder(),result);
        return result;
    }
}
