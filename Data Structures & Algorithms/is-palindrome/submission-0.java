class Solution {
    public boolean isPalindrome(String s) {
        int i=0,j=s.length()-1;
        while(i<j){
            char ch1 = s.charAt(i), ch2=s.charAt(j);
            ch1 = (char)(ch1 >= 'a' && ch1 <='z' ? ch1 - 32 :ch1); 
            ch2 = (char)(ch2 >= 'a' && ch2 <='z' ? ch2 - 32 :ch2); 
            if(!(ch1>= '0' && ch1<= '9' ||ch1 >='A' && ch1<='Z')){
                ++i;continue;
            }
            if(!(ch2>= '0' && ch2<= '9' ||ch2 >='A' && ch2<='Z')){
                --j;continue;
            }
            if(ch1 != ch2){
                return false;
            }
            ++i;--j;
        }
        return true;
    }
}
