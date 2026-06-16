class Solution {
    public int maxArea(int[] heights) {
        int maxArea = Integer.MIN_VALUE;
        int i=0,j=heights.length-1;
        while(i<j){
            int curArea = Integer.min(heights[i],heights[j])*(j-i);
            maxArea=Integer.max(maxArea,curArea);
            if(heights[i]>heights[j]){
                j--;
            }
            else{
                i++;
            }
        }
        return maxArea;
    }
}
