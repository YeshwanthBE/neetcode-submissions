class Solution {

    public int getLowerCaseAlphaASCII(char ch){
        return ch - 'a';
    }

    public int[] getCharFreq(String s){
        int[] charFreq = new int[26];
        
        for(var ch : s.toCharArray()){
            ++charFreq[getLowerCaseAlphaASCII(ch)];
        }
        
        return charFreq;
    }
    public boolean checkInclusion(String s1, String s2) {

        if(s1.length()>s2.length()){
            return false;
        }
        
        int[] charFreq1 = getCharFreq(s1);

        int winSize = s1.length();

        int[] charFreq2 = getCharFreq(s2.substring(0,winSize));

        int matches=0;
        for(int i=0;i<26;i++){
            if(charFreq2[i]==charFreq1[i]){
                matches++; 
            }
        }
        
        for(int i=0,j=winSize;j<s2.length();i++,j++){
            if(matches == 26){
                return true;
            }

            int startASCII = getLowerCaseAlphaASCII(s2.charAt(i));
            if(charFreq2[startASCII] == charFreq1[startASCII]){
                matches--;
            }
            --charFreq2[startASCII];
            if(charFreq2[startASCII] == charFreq1[startASCII]){
                matches++;
            }
            
            int endASCII = getLowerCaseAlphaASCII(s2.charAt(j));
            if(charFreq2[endASCII] == charFreq1[endASCII]){
                matches--;
            }
            ++charFreq2[endASCII];
            if(charFreq2[endASCII] == charFreq1[endASCII]){
                matches++;
            }
            
        }
        return matches == 26;
    }
}
