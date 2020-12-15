import java.util.*;

class FrequencySort {

  public static String sortCharacterByFrequency(String str) {
    StringBuilder sb = new StringBuilder();
    PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((e1,e2)->e2.getValue()-e1.getValue());
    // KV<char and count>>
    Map<Character,Integer> charMap = new HashMap<>();
    for (char c: str.toCharArray()){
      charMap.put(c, charMap.getOrDefault(c,0)+1);
    }

    for (Map.Entry<Character,Integer> entity : charMap.entrySet()){
      maxHeap.offer(entity);
    }

    while (!maxHeap.isEmpty()){
      Map.Entry<Character,Integer> entity = maxHeap.poll();
      char c = entity.getKey();
      int value = entity.getValue();
      for (int i=0; i<value; i++){
        sb.append(c);
      }
    }



    return sb.toString();
  }

  public static void main(String[] args) {
    String result = FrequencySort.sortCharacterByFrequency("Programming");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);

    result = FrequencySort.sortCharacterByFrequency("abcbab");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);
  }
}