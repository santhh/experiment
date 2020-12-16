import java.util.*;

class MaximumDistinctElements {

  public static int findMaximumDistinctElements(int[] nums, int k) {
    int elementCount =0;
    Map<Integer,Integer> frequencyMap = new HashMap<>();
    PriorityQueue<Integer> minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a));

    for (int num : nums){
      frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) +1);
    }

    for (Map.Entry<Integer, Integer> entity : frequencyMap.entrySet()){
      int frequency = entity.getValue();
      if(frequency>1){
        minHeap.offer(frequency);
      }else{
        elementCount++;
      }
    }

    while (k>=0 && !minHeap.isEmpty()){
      k -= minHeap.poll()-1;
      if(k>=0){
        elementCount++;
      }
    }
    if(k>0){
      elementCount -= k;
    }


    return elementCount;
  }

  public static void main(String[] args) {
    int result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 7, 3, 5, 8, 5, 3, 3 }, 2);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);

    result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 3, 5, 12, 11, 12 }, 3);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);

    result = MaximumDistinctElements.findMaximumDistinctElements(new int[] { 1, 2, 3, 3, 3, 3, 4, 4, 5, 5, 5 }, 2);
    System.out.println("Maximum distinct numbers after removing K numbers: " + result);
  }
}