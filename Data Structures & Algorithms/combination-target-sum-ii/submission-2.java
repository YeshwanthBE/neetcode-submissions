class Solution {

    public void targetSum(int[] nums, int target, int curSum,int index, List<Integer> resultList,List<List<Integer>> result){
        
        if(curSum == target){
            result.add(new ArrayList<>(resultList));
            return;
        }
        
        if(index>=nums.length || curSum+nums[index] >target){
            return ;
        }

        resultList.add(nums[index]);
        targetSum(nums,target,curSum+nums[index],index+1,resultList,result);
        resultList.remove(resultList.size()-1);
        
        while(index<nums.length-1 && nums[index]==nums[index+1]){
            index++;
        }
        targetSum(nums,target,curSum,index+1,resultList,result);
    
    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();Arrays.sort(candidates);
        targetSum(candidates,target,0,0,new ArrayList<>(),result);
        return result;
    }
}
