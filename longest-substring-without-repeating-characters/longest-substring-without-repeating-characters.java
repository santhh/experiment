class Solution {
    public int lengthOfLongestSubstring(String s) {
      if(s.isEmpty()) return 0;
       int longest=0;
       int windowStart =0;
    Map<Character, Integer> map = new HashMap<>();
    for (int  i =0; i<s.length();i++){
      char c = s.charAt(i);
      if (map.containsKey(c)){
         windowStart = Math.max(map.get(c) +1, windowStart);
      }
       map.put(c, i);
        longest = Math.max(longest, i-windowStart +1);
        
    }
    return longest;
        
      
    }
}