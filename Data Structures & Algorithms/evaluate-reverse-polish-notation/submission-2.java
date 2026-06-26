class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> stack = new ArrayDeque<>();
        for(var ch : tokens){
            switch(ch){
                case "+":{
                    stack.push(stack.pop()+stack.pop());
                    break;
                } 
                case "-":{
                    stack.push(-stack.pop()+stack.pop());break;
                } 
                case "*":{
                    stack.push(stack.pop()*stack.pop());break;
                }
                case "/":{
                    int a =stack.pop();
                    stack.push(stack.pop()/a);break;
                }
                default:{
                    stack.push(Integer.parseInt(ch));
                }
            }
        }
        return stack.pop();
    }
}
