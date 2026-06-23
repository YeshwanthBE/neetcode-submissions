class Solution {

    public int getAlphaASCII(char ch){
        return ch > 'Z' ? ch -'a' + 26 : ch - 'A';
    }

    public int[] getCharFreq(String s){
        int[] charFreq = new int[52];
        
        for(var ch : s.toCharArray()){
            ++charFreq[getAlphaASCII(ch)];
        }
        
        return charFreq;
    }

    public String minWindow(String s, String t) {

        if(s.length() < t.length()){
            return "";
        }

        int[] charFreq2 = getCharFreq(t);
        int[] charFreq1 = new int[52]; int matches = 0;

        int resultStartIndex = 0,resultEndIndex = 1001;

        for(int i=0,j=0; j<s.length();){
            int charASCII = getAlphaASCII(s.charAt(j));
            ++charFreq1[charASCII];
            if(charFreq1[charASCII] == charFreq2[charASCII]){
                    matches+=charFreq1[charASCII];
            }

            while(matches == t.length()){
                if(resultEndIndex-resultStartIndex > j- i){
                    resultStartIndex = i;
                    resultEndIndex = j;
                }
                charASCII = getAlphaASCII(s.charAt(i));
                if(charFreq1[charASCII] == charFreq2[charASCII]){
                    matches-=charFreq1[charASCII];
                }
                --charFreq1[charASCII];
                i++;
                
            }
            j++;
        }


        return resultEndIndex == 1001 ? "" : s.substring(resultStartIndex,resultEndIndex+1);
    }
}
