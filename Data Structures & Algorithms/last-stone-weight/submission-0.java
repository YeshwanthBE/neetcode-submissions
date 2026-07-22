class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
        for(var i : stones){
            maxHeap.offer(i);
        }

        while(maxHeap.size()>1){
            int stone1 = maxHeap.poll();
            int stone2 = maxHeap.poll();

            int newStone = Math.abs(stone1-stone2);
            if(newStone != 0){
                maxHeap.offer(newStone);
            }
        }
        if(maxHeap.isEmpty()){
            return 0;
        }

        return maxHeap.peek();
    }
}
