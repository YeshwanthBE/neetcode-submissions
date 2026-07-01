class Solution {

    public int getMax(int[] array){
        int max = array[0];

        for (int i = 1; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }

        return max;
    }

    public int calTotalTime(int[] piles, int eatingSpeed){
        int totalTime =0;
        for(int i :piles){
            totalTime += i/eatingSpeed + (i%eatingSpeed == 0 ? 0 : 1);
        }
        return totalTime;
    }

    public int minEatingSpeed(int[] piles, int h) {
        int i = 1,j = getMax(piles);
        int minEatingSpeed = -1;
        while(i<=j){
            int mid = (i+j)/2;
            int curTimeTaken = calTotalTime(piles,mid);
            if(curTimeTaken <= h){
                minEatingSpeed = mid;
                j=mid-1;
                
            }
            else{
                i=mid+1;
            }
        }
        return minEatingSpeed;
    }
}
