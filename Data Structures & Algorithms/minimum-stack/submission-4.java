class MinStack {

    int[] stack;
    int[] minIdxStack;
    int top = -1;
    int minTop = -1;

    public MinStack() {
        stack = new int[1000];
        minIdxStack = new int[1000];
    }
    
    public void push(int val) {
        stack[++top] = val;

        int minSoFar = minTop == -1 || stack[minIdxStack[minTop]] > stack[top] ? top : minIdxStack[minTop]; 
        
        if(top > -1 && minTop > -1){
            System.out.println(stack[minIdxStack[minTop]] + " >" + stack[top]);
            System.out.println(minTop +" :" + (minTop == -1 || stack[minIdxStack[minTop]] > stack[top]));
        }

        minIdxStack[++minTop]=minSoFar;

        for(int i =0;i<=minTop;i++)
        System.out.print(minIdxStack[i] + "");
        System.out.println();
    }
    
    public void pop() {

        while(minTop > -1 && minIdxStack[minTop] == top){
            minIdxStack[minTop--] = 0;
        }

        stack[top--] = 0;
    }
    
    public int top() {
        return stack[top];
    }
    
    public int getMin() {
        return stack[minIdxStack[minTop]];
    }
}
