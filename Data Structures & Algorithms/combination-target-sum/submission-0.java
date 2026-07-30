class Solution {

    List<List<Integer>> result = new ArrayList<>();

    public void targetSum(int[] nums, int target, int curSum,int index, List<Integer> resultList){
        
        if(index==nums.length || curSum >target){
            return ;
        }

        if(curSum == target){
            result.add(new ArrayList<>(resultList));
            return;
        }

        resultList.add(nums[index]);
        targetSum(nums,target,curSum+nums[index],index,resultList);
        resultList.remove(resultList.size()-1);
        targetSum(nums,target,curSum,index+1,resultList);
    
    }

    public List<List<Integer>> combinationSum(int[] nums, int target) {
        targetSum(nums,target,0,0,new ArrayList<>());
        return result;
    }
}
