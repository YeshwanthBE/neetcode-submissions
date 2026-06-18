class Solution {
    public int trap(int[] height) {
        int maxWater = 0;

        for (int i = 1; i < height.length - 1; i++) {

            int leftMax = 0;
            for (int j = 0; j <= i; j++) {
                leftMax = Math.max(leftMax, height[j]);
            }

            int rightMax = 0;
            for (int j = i; j < height.length; j++) {
                rightMax = Math.max(rightMax, height[j]);
            }

            maxWater += Math.min(leftMax, rightMax) - height[i];
        }

        return maxWater;
    }
}