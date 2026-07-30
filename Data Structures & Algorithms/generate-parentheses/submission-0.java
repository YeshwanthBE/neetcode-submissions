class Solution {

    public void gp(int open,int close,StringBuilder pair,List<String> result){
        if(close==0){
            result.add(new String(pair.toString()));
        }
        if(open>0){
            pair.append("(");
            gp(open-1,close,pair,result);
            pair.deleteCharAt(pair.length()-1);
        }
        if(close>open && close>0){
            pair.append(")");
            gp(open,close-1,pair,result);
            pair.deleteCharAt(pair.length()-1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        gp(n,n,new StringBuilder(),result );
        return result;
    }
}
