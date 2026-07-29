class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freq = new int[26];
        for(var ch : tasks){
            freq[ch-'A']++;
        }

        int[] nextCycle = new int[26];

        Queue<Integer> maxHeap = new PriorityQueue<>((a,b)->Integer.compare(freq[b],freq[a]));
              
        for(int i=0;i<26;i++){
            if(freq[i]>0){
                maxHeap.offer(i);
            }
                
        }

        Queue<Integer> queue = new ArrayDeque<>();
        
        int k=0;
        while(!maxHeap.isEmpty() || !queue.isEmpty()){

            k++;

            while(!queue.isEmpty() && nextCycle[queue.peek()]<=k){
                maxHeap.offer(queue.poll());
            }
            
            if(!maxHeap.isEmpty()){
                int ascii =maxHeap.poll();

                freq[ascii]--;

                if(freq[ascii]>0){
                    queue.offer(ascii);
                    nextCycle[ascii]=k+n+1;
                }
            }

            
        }

        return k;
        
    }
}
