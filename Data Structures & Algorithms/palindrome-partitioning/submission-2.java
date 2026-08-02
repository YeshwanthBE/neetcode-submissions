class Solution {

    public boolean isPalindrome(String s){
        int i=0,j=s.length()-1;
        while(i<j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;j--;
        }
        return true;
    }

    public void p(String s,int start,List<String> result,List<List<String>> resultList){

            if(start==s.length()){
                resultList.add(new ArrayList<>(result));
                return;
            }

        for(int end=start;end<s.length();end++){
            String s2 = s.substring(start,end+1);
            if(isPalindrome(s2)){
                result.add(s2);
                p(s,end+1,result,resultList);
                result.remove(result.size()-1);
            }
        }
    }

    public List<List<String>> partition(String s) {
        List<List<String>> resultList = new ArrayList<>();
        p(s,0,new ArrayList<>(),resultList);
        return resultList;
    }
}
