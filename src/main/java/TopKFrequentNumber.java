import java.util.*;

class TopKFrequentNumbers {

  public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
    List<Integer> topNumbers = new ArrayList<>(k);
    Map<Integer, Integer> numMap = new HashMap<>();
    PriorityQueue<Map.Entry<Integer, Integer>> minHeap = new PriorityQueue<>(
        Comparator.comparingInt(Map.Entry::getValue));
    for (int num : nums){
      numMap.put(num, numMap.getOrDefault(num,0)+1);
    }
   for (Map.Entry<Integer,Integer> entry : numMap.entrySet()){
     minHeap.offer(entry);
     if (minHeap.size()>k){
       minHeap.poll();
     }
   }

   while (!minHeap.isEmpty()){
     topNumbers.add(minHeap.poll().getKey());
   }

    return topNumbers;
  }

  public static void main(String[] args) {
    List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);

    result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);
  }
}