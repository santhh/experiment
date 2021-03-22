import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence {
  int max;
  HashMap<Integer,Integer> startMap;
  HashMap<Integer,Integer> endMap;
  Set<Integer> set;

  public LongestConsecutiveSequence(){
    max  =0;
    startMap = new HashMap<>();
    endMap = new HashMap<>();
    set = new HashSet<>();
  }
  public void addNumber(int num){
      if(set.contains(num)){
        return;
      }else{
        set.add(num);
      }

      int start = num;
      int end = num;

      if(endMap.containsKey(num -1)){
        start = endMap.get(num-1);
        endMap.remove(num -1);
      }

      if(startMap.containsKey(num +1)){
        end = startMap.get(num + 1);
        startMap.remove(num + 1);
      }
      if(end - start + 1 > max){
        max = end - start +1;
      }

      startMap.put(start,end);
      endMap.put(end, start);

  }
  public int longestConsecutive(){
      return  max;
  }
  public static void main(String args[]){
    LongestConsecutiveSequence lcs = new LongestConsecutiveSequence();
    System.out.println(lcs.longestConsecutive());
    lcs.addNumber(1);
    lcs.addNumber(2);
    System.out.println(lcs.longestConsecutive());
    lcs.addNumber(4);
    System.out.println(lcs.longestConsecutive());
    lcs.addNumber(3);
    System.out.println(lcs.longestConsecutive());







  }
}
