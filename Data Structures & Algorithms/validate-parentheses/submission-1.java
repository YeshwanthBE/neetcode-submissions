class Solution {

    public char getOpeningPair(char ch){
            switch(ch){ 
                case ')': return '(';
                case '}': return '{';
                case ']': return '[';
            }
            return ' ';
        }

    public boolean isValid(String s) {

        Deque<Character> stack = new ArrayDeque<>();
        for(var ch : s.toCharArray()){
            if(ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
                continue;
            }

            if(stack.isEmpty() || stack.peek() != getOpeningPair(ch)){
                return false;
            }

            stack.pop();
        }

        return stack.isEmpty();
    }
}
