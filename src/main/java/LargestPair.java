import java.util.*;

class LargestPairs {


  public static List<int[]> findKSmallestPairs(int[] nums1, int[] nums2, int k) {
    PriorityQueue<int[]> maxHeap = new PriorityQueue<>((n1,n2) -> (n2[0]+n2[1]) - (n1[0]+n1[1]));
    for (int i =0; i<k & i<nums1.length;i++){
      for (int j=0; j<k && i < nums2.length;j++){
        if(maxHeap.size()<k){
          maxHeap.offer(new int[]{nums1[i],nums2[j]});
        } else if (nums1[i]+nums2[j] > maxHeap.peek()[0]+maxHeap.peek()[1]){
          break;
        } else{
          maxHeap.poll();
          maxHeap.offer(new int[]{nums1[i], nums2[j]});
        }


      }
    }

    return new ArrayList<>(maxHeap);

  }
  public static List<int[]> findKLargestPairs(int[] nums1, int[] nums2, int k) {

    PriorityQueue<int[]> minHeap = new PriorityQueue<>(Comparator.comparingInt(n->n[0]+n[1]));
    for (int i =0; i<k;i++){
      for (int j=0; j<k;j++){
       if(minHeap.size()<k){
         minHeap.offer(new int[]{nums1[i],nums2[j]});
       } else if (nums1[i]+nums2[j] <  minHeap.peek()[0]+minHeap.peek()[1]){
         break;
       } else{
         minHeap.poll();
         minHeap.offer(new int[]{nums1[i], nums2[j]});
       }

      }
    }

    return new ArrayList<>(minHeap);
  }

  public static void main(String[] args) {
    int[] l1 = new int[] { 2,1,1 };
    int[] l2 = new int[] { 3,2,1 };
    List<int[]> result = LargestPairs.findKLargestPairs(l1, l2, 2);
    System.out.println("Pairs with largest sum are: ");
    for (int[] pair : result)
      System.out.println("[" + pair[0] + ", " + pair[1] + "] ");

    int[] l3 = new int[] { 1,1,2 };
    int[] l4 = new int[] { 1,2,3 };
    List<int[]> result_1 = LargestPairs.findKSmallestPairs(l3, l4, 2);
    System.out.println("Pairs with smallest sum are: ");
    for (int[] pair : result_1)
      System.out.print("[" + pair[0] + ", " + pair[1] + "] ");

  }
}