class Solution {

    public void bt(int[]nums,List<Integer> result,int index,List<List<Integer>> resultList){
        if(index==nums.length){
            resultList.add(new ArrayList<>(result));
        }
        for(int i=0;i<nums.length;i++){
            if(result.get(i)==null){
                result.set(i,nums[index]);
                bt(nums,result,index+1,resultList);
                result.set(i,null);
            }
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>(Collections.nCopies(nums.length, null));
        bt(nums,list,0,result);
        return result;
    }
}
