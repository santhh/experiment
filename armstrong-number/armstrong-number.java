class Solution {
    public boolean isArmstrong(int n) {
        String value = String.valueOf(n);
        int length = value.length();  
        int result =0;
        for (char c: value.toCharArray()){
            result += Math.pow(Integer.parseInt(String.valueOf(c)), length);
        }
        
        return n==result;
    }
}