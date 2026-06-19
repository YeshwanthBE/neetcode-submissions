class Solution {
    public int lengthOfLongestSubstring(String s) {
        int maxLen = 0;
        Map<Character,Integer> charVsIdx = new HashMap();
        int left =0;
        for(int right=0;right<s.length();right++){
            char ch = s.charAt(right);
            int prevIndex = charVsIdx.getOrDefault(ch,-1);
            if(prevIndex != -1){
                left = Math.max(left,prevIndex +1);
            }
            maxLen = Math.max(maxLen,right-left+1);
            charVsIdx.put(ch,right);
        }
        return maxLen;
    }
}
