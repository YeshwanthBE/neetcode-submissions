class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        for(int i=0;i<s.length();i++){
            Set<Character> charSet = new HashSet();
            int curLen = 0;
            for(int j=i;j<s.length();j++){
                if(!charSet.add(s.charAt(j))){
                    break;
                }
                ++curLen;
            }
            maxLen = Math.max(maxLen,curLen);
        }
        return maxLen;
    }
}
