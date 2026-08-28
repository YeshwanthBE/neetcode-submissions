class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        Deque<int[]> pQueue = new ArrayDeque<>();
        Deque<int[]> aQueue = new ArrayDeque<>();

        boolean[][] isPacific = new boolean[heights.length][heights[0].length];
        boolean[][] isAtlantic = new boolean[heights.length][heights[0].length];

        for(int i=0;i<heights.length;i++){
            pQueue.offer(new int[]{i,0});
            aQueue.offer(new int[]{i,heights[0].length-1});

            isPacific[i][0]= isAtlantic[i][heights[0].length-1] = true;
        }
        for(int j=0;j<heights[0].length;j++){
            pQueue.offer(new int[]{0,j});
            aQueue.offer(new int[]{heights.length-1,j});

            isPacific[0][j]= isAtlantic[heights.length-1][j] = true;
        }

        bfs(pQueue,isPacific,heights);
        bfs(aQueue,isAtlantic,heights);

        List<List<Integer>> resultList = new ArrayList<>();
        for(int i=0;i<heights.length;i++){
            for(int j=0;j<heights[0].length;j++){
                if(isPacific[i][j] && isAtlantic[i][j]){
                    resultList.add(Arrays.asList(i,j));
                }
            }
        }
        return resultList;
    }

    public void bfs(Queue<int[]>queue,boolean[][] isOcean,int [][]heights){ 

        int[][] directions = {
            {1, 0},
            {-1, 0},
            {0, 1},
            {0, -1}
        };

        while(!queue.isEmpty()){
            int[] curDir = queue.poll();
            
            for(var dir : directions){
                int nr = curDir[0]+dir[0];
                int nc = curDir[1]+dir[1];
                
                if (nr < 0 || nr >= isOcean.length ||
                    nc < 0 || nc >= isOcean[0].length) {
                    continue;
                }

                if (isOcean[nr][nc]) {
                    continue;
                }

                if(heights[nr][nc]>=heights[curDir[0]][curDir[1]]){
                    isOcean[nr][nc]=true;
                    queue.offer(new int[]{nr,nc});
                }
            }
        }
    }
}
