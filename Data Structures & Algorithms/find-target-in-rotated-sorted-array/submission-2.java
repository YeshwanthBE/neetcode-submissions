class Solution {
    public int search(int[] nums, int target) {
        int i=0,j=nums.length-1;

        while(i<=j){
            int mid = i + (j-i)/2;
            if(target == nums[mid]){
                return mid;
            }

            
            if(nums[mid] < nums[j] ){
                if(nums[mid] <= target && target <=nums[j]){
                    i = mid+1;
                }
                else{
                    j=mid-1;
                }  
            }

            else{
                if(nums[i] <= target && target <= nums[mid]){
                    j=mid-1;
                }
                else{
                   i = mid+1;
                }  
            } 
            
        }
        return -1;
    }
}
