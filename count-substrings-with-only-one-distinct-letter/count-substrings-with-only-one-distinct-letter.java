class Solution {
    public int countLetters(String S) {
    
        int sum =1;
        int count =1;
        for (int i =1; i< S.length(); i++){
            if(S.charAt(i)==S.charAt(i-1)){
                count +=1;
            }else {
                count =1;
            }
            sum += count;
        }
        
        return sum;
    
    }
}