class Solution {
    public void swapValueAtIndex(int[] array,int i,int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    public void sortBasedOnPosition(int[] position, int[] speed){
        for(int i=0;i<position.length-1;i++){
            for(int j = 0;j<position.length-1-i;j++){
                if(position[j] < position[j+1]){
                    swapValueAtIndex(position,j,j+1);
                    swapValueAtIndex(speed,j,j+1);
                }
            }
        }
    }

    public int carFleet(int target, int[] position, int[] speed) {
        sortBasedOnPosition(position,speed);
        Deque<Double> stack = new ArrayDeque<>();
        int fleet = 0;
        for(int i=0;i<position.length;i++){
            double curTime = (double)(target - position[i]) / speed[i];
            if(stack.isEmpty() || curTime > stack.peek()){
                stack.push(curTime);
            }
        }
        return stack.size();
    }
}
