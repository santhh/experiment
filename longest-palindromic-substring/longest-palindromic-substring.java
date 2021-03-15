class Solution {
    public String longestPalindrome(String s) {
        int [] maxLength = new int[2];
        maxLength[0]=0;
        maxLength[1]=1;
        
        for (int i=1;i<s.length();i++){
            int [] oddLength = checkPalindrome(i-1,i+1,s);
            int [] evenLength = checkPalindrome(i-1,i,s);
            int [] currentLength = 
                (oddLength[1]-oddLength[0]>evenLength[1]-evenLength[0])?oddLength:evenLength;
            maxLength = (maxLength[1]-maxLength[0]>currentLength[1]-currentLength[0])?maxLength:currentLength;
        }
        
        return s.substring(maxLength[0],maxLength[1]);
        
        
    }
    
    public static int[] checkPalindrome(int left, int right, String s){
        while(left>=0 && right <=s.length()-1){

                if (s.charAt(left)!=s.charAt(right)){
                    break;
                }
            left --;
            right++;
        }
        return new int []{left+1,right};
    }
    
    
}