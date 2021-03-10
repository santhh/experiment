class Solution {
      
    public boolean canPermutePalindrome(String s) {
        
        Map<Character, Integer> map = new HashMap<>();
        for (char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        int count=0; 
        for (Integer value : map.values()){
            count += value % 2;
        }
        return count <=1;
     
    }
}