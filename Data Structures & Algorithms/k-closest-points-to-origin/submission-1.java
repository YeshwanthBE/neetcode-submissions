class Solution {

    class Node{
        long eucldDist;
        int x,y;

        public Node(int x, int y){
            this.x = x;
            this.y = y;
            this.eucldDist = 1L * x * x + 1L * y * y;
        }

        public Node(int[] z){
            this(z[0],z[1]);
        }
    }
    public int[][] kClosest(int[][] points, int k) {
        Queue<Node> maxHeap = new PriorityQueue<>((a, b) -> Long.compare(b.eucldDist, a.eucldDist));
        for(var row : points){ 
            maxHeap.offer(new Node(row));
            if(maxHeap.size()>k){
                maxHeap.poll();
            }
        }

        int[][] result = new int[maxHeap.size()][2];int i=0;
        while(!maxHeap.isEmpty()){
            Node node = maxHeap.poll();
            result[i][0]=node.x;result[i][1]=node.y;
            ++i;
        }

        return result;
    }
}
