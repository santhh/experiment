import java.util.*;

class RearrangeString {

  public static String rearrangeString(String str) {
    StringBuilder sb = new StringBuilder();
    Map<Character, Integer> charMap = new HashMap<>();
    PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((a,b)->b.getValue()-a.getValue());
    for (char c : str.toCharArray()){
      charMap.put(c, charMap.getOrDefault(c,0) + 1);
    }
    maxHeap.addAll(charMap.entrySet());
    Map.Entry<Character,Integer> previous = null;
    while (!maxHeap.isEmpty()){
      Map.Entry<Character,Integer> current = maxHeap.poll();
      if(previous != null && previous.getValue()>=1){
        maxHeap.offer(previous);
      }
      sb.append(current.getKey());
      current.setValue(current.getValue()-1);
      previous = current;


    }

    return str.length()==sb.length()?sb.toString():"";
  }

  public static void main(String[] args) {
    System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
    System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
    System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
  }
}
