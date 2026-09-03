class Solution {
    public int rob(int[] nums) {
        int way1=0,way2=0;
        for(var i : nums){
            int cur=Math.max(way2,i+way1);
            way1=way2;
            way2=cur;
        }
        return way2;
    }
}
