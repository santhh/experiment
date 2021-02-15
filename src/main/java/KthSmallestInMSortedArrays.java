// import java.util.*;
// class Node {
//   int listIndex;
//   int valueIndex;
//   public Node( int listIndex, int valueIndex){
//     this.listIndex = listIndex;
//     this.valueIndex= valueIndex;
//   }
// }
// class KthSmallestInMSortedArrays {
//   public static int findKthSmallest(List<Integer[]> lists, int k) {
//      PriorityQueue<Node> minHeap= new PriorityQueue<>(
//          Comparator.comparingInt(n -> lists.get(n.listIndex)[n.valueIndex]));
//      int result =0;
//      int count =0;
//      for (int i=0; i< lists.size(); i++) {
//        minHeap.offer(new Node(i, 0));
//      }
//
//      while (!minHeap.isEmpty()){
//        Node current = minHeap.poll();
//        result = lists.get(current.listIndex)[current.valueIndex];
//        count++;
//        if (count==k){
//          break;
//        }
//        current.valueIndex++;
//       if(lists.get(current.listIndex).length>current.valueIndex) {
//         Node next = new Node(current.listIndex,current.valueIndex);
//         minHeap.offer(next);
//       }
//
//
//      }
//
//
//     return result;
//   }
//
//   public static void main(String[] args) {
//     Integer[] l1 = new Integer[] { 2, 6, 8 };
//     Integer[] l2 = new Integer[] { 3, 6, 7 };
//     Integer[] l3 = new Integer[] { 1, 3, 4 };
//     List<Integer[]> lists = new ArrayList<Integer[]>();
//     lists.add(l1);
//     lists.add(l2);
//     lists.add(l3);
//     int result = KthSmallestInMSortedArrays.findKthSmallest(lists, 5);
//     System.out.print("Kth smallest number is: " + result);
//   }
// }