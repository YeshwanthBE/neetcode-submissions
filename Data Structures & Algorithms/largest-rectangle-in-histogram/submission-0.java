class Solution {
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i <= heights.length; i++) {
            int currentHeight = (i == heights.length) ? 0 : heights[i];
            
            while(!stack.isEmpty() && heights[stack.peek()]>=currentHeight){
                int topIdx = stack.pop();
                int leftB = stack.isEmpty() ? -1 : stack.peek();
                maxArea = Math.max(maxArea, heights[topIdx] * (i - leftB - 1));
            }

            stack.push(i);
        }

        return maxArea;
    }
}
