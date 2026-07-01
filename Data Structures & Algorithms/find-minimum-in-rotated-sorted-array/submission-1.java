class Solution {
    public int findMin(int[] nums) {
        int i = 1,j=nums.length;
        int min = nums[0];
        while(i<=j){
            int mid = (i+j)/2;
            if(nums[mid-1]<min){
                min = nums[mid -1];
                j=mid-1;
            }
            else{
                i=mid+1;
            }
        }
        return min;
    }
}
