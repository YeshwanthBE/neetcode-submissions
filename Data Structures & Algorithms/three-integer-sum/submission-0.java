class Solution {
    public void sortArray(int[] nums) {
        for(int i = nums.length - 1; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                if(nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }

    public List<List<Integer>> threeSum(int[] nums) {
        sortArray(nums);

        List<List<Integer>> resultList = new ArrayList<>();

        for(int i = 0; i < nums.length - 2; i++) {

            if(i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1;
            int k = nums.length - 1;

            while(j < k) {
                int curSum = nums[i] + nums[j] + nums[k];

                if(curSum == 0) {
                    resultList.add(Arrays.asList(nums[i], nums[j], nums[k]));

                    j++;
                    k--;

                    while(j < k && nums[j] == nums[j - 1]) {
                        j++;
                    }

                    while(j < k && nums[k] == nums[k + 1]) {
                        k--;
                    }
                }
                else if(curSum < 0) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }

        return resultList;
    }
}