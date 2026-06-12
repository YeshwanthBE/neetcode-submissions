class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb= new StringBuilder();
        for(var str : strs){
          sb.append(str.length())
          .append(';')
          .append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
      List<String> result= new ArrayList();
      for(int i = 0,k=0; i<str.length(); i++){
        char ch = str.charAt(i);
        int j = ch - '0';
        if(ch != ';'){
          k*=10;
          k+=j;
          continue;
        }
        result.add(str.substring(i+1,i+k+1));
        i+=k;
        k=0;
      }
      return result;
    }
}
