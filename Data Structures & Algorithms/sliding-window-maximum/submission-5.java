class Solution {
    class MonoQ<E extends Comparable<E>> extends ArrayDeque<E> {
    public boolean insert(E e) {
        while (!isEmpty() &&
               peekLast().compareTo(e) < 0) {
            pollLast();
        }
        return offerLast(e);
    }
}
    public int[] maxSlidingWindow(int[] nums, int k) {
        MonoQ<Integer> monoQ = new MonoQ<>();
        for(int i=0;i<k;i++){
            monoQ.insert(nums[i]);
        }
        ArrayList<Integer> resultList = new ArrayList<>();
        resultList.add(monoQ.peek());

        for(int i = k;i<nums.length;i++){
            
            if(!monoQ.isEmpty() && monoQ.peek() == nums[i-k]){
                monoQ.poll();
            }

            // System.out.println(i+":"+monoQ);

            monoQ.insert(nums[i]);
            
            resultList.add(monoQ.peek());
        }

        return resultList.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        
    }
}
