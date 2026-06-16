class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int i=0;
        int j=numbers.length-1;

        while(i<j){
            int curSum = numbers[i]+numbers[j];
            if(curSum == target){
                return new int[]{i+1,j+1};
            }
            if(curSum < target){
                i++;
                continue;
            }
            j--;
        }
        return new int[2];
    }
}
