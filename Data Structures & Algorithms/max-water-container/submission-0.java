class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        for(int i=heights.length-1;i>0;i--){
            for(int j=0;j+i<heights.length;j++){
                int curArea = Integer.min(heights[i+j],heights[j])*i;
                maxArea=Integer.max(maxArea,curArea);
            }
        }
        return maxArea;
    }
}
