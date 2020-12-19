// import java.util.*;
//
// class Node {
//   int elementIndex;
//   int arrayIndex;
//
//   Node(int elementIndex, int arrayIndex) {
//     this.elementIndex = elementIndex;
//     this.arrayIndex = arrayIndex;
//   }
// }
//
// class SmallestRange {
//
//   public static int[] findSmallestRange(List<Integer[]> lists) {
//     PriorityQueue<Node> minHeap = new PriorityQueue<Node>(
//         Comparator.comparingInt(n -> lists.get(n.arrayIndex)[n.elementIndex]));
//
//     int rangeStart = 0, rangeEnd = Integer.MAX_VALUE, currentMaxNumber = Integer.MIN_VALUE;
//     // put the 1st element of each array in the min heap
//     for (int i = 0; i < lists.size(); i++)
//       if (lists.get(i) != null) {
//         minHeap.add(new Node(0, i));
//         currentMaxNumber = Math.max(currentMaxNumber, lists.get(i)[0]);
//       }
//
//     // take the smallest (top) element form the min heap, if it gives us smaller range, update the ranges
//     // if the array of the top element has more elements, insert the next element in the heap
//     while (minHeap.size() == lists.size()) {
//       Node node = minHeap.poll();
//       if (rangeEnd - rangeStart > currentMaxNumber - lists.get(node.arrayIndex)[node.elementIndex]) {
//         rangeStart = lists.get(node.arrayIndex)[node.elementIndex];
//         rangeEnd = currentMaxNumber;
//       }
//       node.elementIndex++;
//       if (lists.get(node.arrayIndex).length > node.elementIndex) {
//         minHeap.add(node); // insert the next element in the heap
//         currentMaxNumber = Math.max(currentMaxNumber, lists.get(node.arrayIndex)[node.elementIndex]);
//       }
//     }
//     return new int[] { rangeStart, rangeEnd };
//   }
//
//   public static void main(String[] args) {
//     Integer[] l1 = new Integer[] { 4,10,15,24,26};
//     Integer[] l2 = new Integer[] { 0,9,12,20 };
//     Integer[] l3 = new Integer[] { 5,18,22,30 };
//     List<Integer[]> lists = new ArrayList<Integer[]>();
//     lists.add(l1);
//     lists.add(l2);
//     lists.add(l3);
//     int[] result = SmallestRange.findSmallestRange(lists);
//     System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
//   }
// }
