class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int step1=cost[0],step2=cost[1];
        for(int i=2;i<cost.length;i++){
            int step3 = Math.min(step1,step2) +cost[i] ;
            step1=step2;
            step2=step3;
        }

        return Math.min(step1,step2);
    }
}
