class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {

        if(prerequisites == null || prerequisites.length ==0 || prerequisites[0]==null || prerequisites[0].length ==0){
            return true;
        }

        Map<Integer,List<Integer>> courseVsPreReq = new HashMap<>();

        for(var preReq : prerequisites){
            courseVsPreReq.computeIfAbsent(preReq[0],k->new ArrayList<>()).add(preReq[1]);
            courseVsPreReq.computeIfAbsent(preReq[1],k->new ArrayList<>());
        }

        int[] isVisited = new int[1000];
        for(var course : courseVsPreReq.keySet()){
            isVisited[course] = 1;
            if(!dfs(courseVsPreReq,course,isVisited)){
                return false;
            }
            isVisited[course] = 2;
        }
        return true;
    }

    public boolean dfs(Map<Integer,List<Integer>> courseVsPreReq,int course,int[] isVisited){
        List<Integer> prerequisites = courseVsPreReq.get(course);
        for(var pr : prerequisites){
            switch(isVisited[pr]){
                case 0:{
                    isVisited[pr] = 1;
                    if(!dfs(courseVsPreReq,pr,isVisited)){
                        return false;
                    }
                    isVisited[pr] = 2;
                    break;    
                }
                case 1:{
                    return false;
                }
            }
        }
        return true;
    }
}
