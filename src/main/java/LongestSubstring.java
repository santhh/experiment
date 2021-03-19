import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstring {

  public static int longestSubString(String s) {
    int longest=0;
    int windowStart =0;
    Map<Character, Integer> map = new HashMap<>();
    for (int  i =0; i<s.length();i++){
      char c = s.charAt(i);
      if (map.containsKey(c)){
        windowStart = Math.max(map.get(c) +1, windowStart);

      }
      map.put(c,i);
      longest =Math.max(longest, i-windowStart+1);

    }
    return longest;
  }
  public static void main (String args[]){
    System.out.println(longestSubString("abcabcbb"));
    System.out.println(longestSubString("bbbbb"));
    System.out.println(longestSubString("pwwkew"));
    System.out.println(longestSubString("aab"));
    //System.out.println(longestSubString(""));
    //System.out.println(longestSubString(" "));

  }
}
