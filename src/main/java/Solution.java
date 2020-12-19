import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
class Element {

  int listIndex;
  int valueIndex;

  public Element(int lastIndex, int valueIndex) {
    this.listIndex = listIndex;
    this.valueIndex = valueIndex;
  }
}
class Solution {

  public static int[] findSmallestRange(List<List<Integer>> nums) {
    PriorityQueue<Element> minHeap = new PriorityQueue<>(
        Comparator.comparingInt(e -> nums.get(e.listIndex).get(e.valueIndex)));
    int currentMax = Integer.MIN_VALUE;
    int rangeStart = 0;
    int rangeEnd = Integer.MAX_VALUE;

    for (int i = 0; i < nums.size(); i++) {
      minHeap.offer(new Element(i, 0));
      int value = nums.get(i).get(0);
      currentMax = Math.max(currentMax, value);
    }

    while (minHeap.size() == nums.size()) {
      Element current = minHeap.poll();
      int value = nums.get(current.listIndex).get(current.valueIndex);
      if ((rangeEnd - rangeStart) > (currentMax - value)) {
        rangeStart = value;
        rangeEnd = currentMax;

      }

      current.valueIndex++;
      if (nums.get(current.listIndex).size() > current.valueIndex) {
        minHeap.offer(new Element(current.listIndex, current.valueIndex));
        currentMax = Math.max(currentMax, nums.get(current.listIndex).get(current.valueIndex));
      }
    }

    return new int[]{rangeStart, rangeEnd};

  }

  public static void main(String[] args) {
    Integer[] l1 = new Integer[]{4, 10, 15, 24, 26};
    Integer[] l2 = new Integer[]{0, 9, 12, 20};
    Integer[] l3 = new Integer[]{5, 18, 22, 30};
    List<List<Integer>> lists = new ArrayList<>();
    lists.add(Arrays.asList(l1));
    lists.add(Arrays.asList(l1));
    lists.add(Arrays.asList(l1));
    int[] result = Solution.findSmallestRange(lists);
    System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
  }
}
