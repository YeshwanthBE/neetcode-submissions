class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> temp = new HashSet<>();
        for (int num : nums) {
            temp.add(num);
        }
        int longestSequence = 0;
        for(var i : nums){
            if(temp.contains(i-1)){
                continue;
            }
            int curLS = 0;
            for(int j = i+1,k=1;k<nums.length&&temp.contains(j);k++,j++,++curLS);
            longestSequence = Integer.max(++curLS,longestSequence);
        }
        return longestSequence;
    }
}
