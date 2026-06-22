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

        int windowSize = s1.length();

        int[] charFreq2 = getCharFreq(s2.substring(0,windowSize));
        
        for(int i=0;i<s2.length()-windowSize+1;i++){
            boolean isIncluded = true;
            for(int k=i;k<i+windowSize;k++){
                int ascii = getLowerCaseAlphaASCII(s2.charAt(k));
                if(charFreq2[ascii]!=charFreq1[ascii]){
                    isIncluded = false;
                    break;
                }
            }
            if(isIncluded){
                // System.out.println(i);
                return true;
            }
        
            --charFreq2[getLowerCaseAlphaASCII(s2.charAt(i))];
            if(i+windowSize >= s2.length()){
                break;
            }
            ++charFreq2[getLowerCaseAlphaASCII(s2.charAt(i+windowSize))];
            
        }
        return false;
    }
}
