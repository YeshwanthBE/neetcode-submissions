class Solution {
    public void bt(int[]nums,List<Integer> result,int index,List<List<Integer>> resultList){
        resultList.add(new ArrayList<>(result));
        if(index>=nums.length){
            return;
        }

        for(int i=index;i<nums.length;i++){
            if(i>index&&nums[i]==nums[i-1]){
                continue;
            }
            result.add(nums[i]);
            bt(nums,result,i+1,resultList);
            result.remove(result.size()-1);
        }
        
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();Arrays.sort(nums);
        bt(nums,new ArrayList<>(),0,result);
        return result;
    }
}
