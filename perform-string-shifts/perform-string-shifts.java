class Solution {
    public String stringShift(String s, int[][] shift) {
        String str = s;
        for(int j=0; j < 1; j++){
            for(int i=0; i < shift.length; i++){
                str = shift(str, shift[i][j], shift[i][j+1]);   
            }
        }
        return str;
    }
    
    private String shift(String st, int dir, int amt){
        String temp = "";
        if(dir == 0){
            temp =  st.substring(amt) + st.substring(0,amt);
        }
        else{
           temp =  st.substring(st.length()-amt, st.length()) + st.substring(0,st.length()-amt);
        }   
        return temp;
    }
}