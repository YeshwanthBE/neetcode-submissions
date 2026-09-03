class Solution {
    public int climbStairs(int n) {
        if(n<3){
            return n;
        }
        int way1 = 1,way2=2;
        for(int i=3;i<=n;i++){
            way2 += way1;System.out.println(way2);
            way1 = way2-way1;System.out.println(way1);
        }
        return way2;
    }
}
