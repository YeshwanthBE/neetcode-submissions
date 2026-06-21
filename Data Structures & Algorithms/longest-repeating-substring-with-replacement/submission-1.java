class Solution {
    public int characterReplacement(String s, int k) {
        int i=0,j=0,maxFreq=0,maxLen=0;
        int[] charFreq = new int[26];
        while(j<s.length()){

            int ascii = s.charAt(j) - 'A';
            maxFreq = Math.max(maxFreq, ++charFreq[ascii]);

            while(j-i+1 - maxFreq > k){
                --charFreq[s.charAt(i) - 'A'];
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
            j++;
        }

        return maxLen;
    }
}
