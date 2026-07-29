class MedianFinder {

    Queue<Integer> minHeap,maxHeap;

    public MedianFinder() {
        minHeap=new PriorityQueue<>();
        maxHeap=new PriorityQueue<>(Collections.reverseOrder());
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());

        if (minHeap.size() > maxHeap.size()) {
            maxHeap.offer(minHeap.poll());
        }
    }
    
    public double findMedian() {
        System.out.println(minHeap.size()+" "+maxHeap.size());
        if(minHeap.size()==maxHeap.size()){
            int x =maxHeap.peek(),y=minHeap.peek();
            return x+(y-x)/2.0;
        }

        return minHeap.size()<maxHeap.size()?maxHeap.peek():minHeap.peek();
    }
}
