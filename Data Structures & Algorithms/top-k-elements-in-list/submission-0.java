class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] freq = new int[2001];
        for(var i : nums){
          freq[i+1000]++;
        }
        List<Integer>[] freqVsNum = new ArrayList[nums.length+1];
        for(int i = 0; i<freq.length; i++){
          if(freq[i] == 0){
            continue;
          }
          List<Integer> numList = freqVsNum[freq[i]];
          if(numList == null){
            numList = new ArrayList<>();
          }
          numList.add(i-1000);
          freqVsNum[freq[i]] = numList;
        }
        int[] result = new int[k];
        for(int i = freqVsNum.length-1; i>=0 && k>0;i--){
           List<Integer> numList = freqVsNum[i];
           if(numList == null){
            continue;
           }
           for(int j = 0 ; j<numList.size() && k>=0;j++){
            result[--k]=numList.get(j);
           }
        }
        return result;
    }
}
