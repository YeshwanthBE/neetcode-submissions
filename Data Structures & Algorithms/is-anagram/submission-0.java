class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()){
            return false;
        }
        Map<Character,Integer> temp = new HashMap<>();
        for(var ch : s.toCharArray()){
            temp.merge(ch,1,Integer::sum);
        }
        for(var ch : t.toCharArray()){
            int curFreq = temp.getOrDefault(ch,0);
            if(curFreq == 0){
                return false;
            }
            temp.put(ch,curFreq-1);
        }
        return true;
    }
}
