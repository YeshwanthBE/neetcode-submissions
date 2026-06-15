class Solution {
    public int[] productExceptSelf(int[] nums) {
        long allProduct = 1;
        int zeroIndex = -1;
        for(int i = 0; i<nums.length;i++){
            
            if(nums[i] != 0){
                allProduct *= nums[i];        
                continue;
            }
        
            if(zeroIndex != -1){
                return new int[nums.length];
            }

            zeroIndex = i;
        }
        int[] result = new int[nums.length];

        if(zeroIndex != -1){
            result[zeroIndex]= (int)allProduct;
            return result;
        }

        for(int i = 0; i<nums.length;i++){
            result[i] = (int)allProduct /nums[i];
        }
        return result;
    }
}  
