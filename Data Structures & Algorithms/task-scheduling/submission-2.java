class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(var ch : tasks){
            freq[ch-'A']++;
        }

        int max=0,cntMx=0;
        for(int i=0;i<26;i++){
            if(freq[i]==0){
                continue;
            }
           

            if(freq[i]>max){
                max=freq[i];
                cntMx=0;
            }

            if(freq[i]==max){
                cntMx++;
            }
        }
        return Math.max(tasks.length,(max-1)*(n+1)+cntMx);
    }
}
