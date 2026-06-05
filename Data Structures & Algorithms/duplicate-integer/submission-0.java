class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> temp = new HashSet<>();
        for(var i : nums){
            if(!temp.add(i)){
                return true;
            }
        }
        return false;
    }
}