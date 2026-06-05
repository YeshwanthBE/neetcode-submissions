class Solution {
    public int[] twoSum(int[] nums, int target) {
      Map<Integer,Integer> temp = new HashMap<>();
      for(int i=0 ; i< nums.length; i++){
        int complementIndex = temp.getOrDefault(target-nums[i],-1) ;
        if(complementIndex != -1){
          return new int[] { complementIndex, i };
        }
        temp.put(nums[i],i);
      }  
      return new int[2];
    }
}
