class Solution {
    public boolean checkRecord(String s) {
        char [] records = s.toCharArray();
        int absCount =1;
        int lateCount = 2;
        char prev =' ';
        for (char c: records){
            if (c=='L' && lateCount <=0 || c=='A' && absCount<=0 ){
                return false;
            }
            if (c == 'L'){
                lateCount -=1;
            } else if (c == 'A'){
                absCount -=1;
            }
            prev = c;
            if (prev !='L'){
                lateCount = 2;
            }
            
        }
        return true;
    }
}