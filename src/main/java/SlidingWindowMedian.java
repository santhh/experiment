import java.util.*;

class SlidingWindowMedian {
  static PriorityQueue<Long>  maxHeap;
  static PriorityQueue<Long>  minHeap;
  public SlidingWindowMedian(){
     maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
     minHeap = new PriorityQueue<>();
  }
  public static void insert(int num){
    if(maxHeap.isEmpty()|| maxHeap.peek()>=num){
      maxHeap.offer(new Long(num));
    }else{
      minHeap.offer(new Long(num));
    }
  }
  public static void rebalanced(){
    if(maxHeap.size()>minHeap.size()+1){
        minHeap.offer(maxHeap.poll());
    }else if(maxHeap.size()<minHeap.size()){
      maxHeap.offer(minHeap.poll());
    }
  }
  public double findMedian(){
    if(maxHeap.size()==minHeap.size()){
      return (maxHeap.peek()+minHeap.peek())/2.0;
    }
    return maxHeap.peek();
  }
  public double[] findSlidingWindowMedian(int[] nums, int k) {
    double[] result = new double[nums.length - k + 1];
    int windowStart=0;
    for (int i=0; i<nums.length;i++){
      insert(nums[i]);
      if(i-k>=0){
        rebalanced();
      }

      if(i-k+1>=0){
        int removeElement= nums[windowStart];
        if(removeElement<=maxHeap.peek()){
          maxHeap.remove(removeElement);
        }else{
          minHeap.remove(removeElement);
        }
        rebalanced();
        result [windowStart++] = findMedian();
      }

    }
    return result;
  }

  public static void main(String[] args) {
    SlidingWindowMedian slidingWindowMedian = new SlidingWindowMedian();
    double[] result = slidingWindowMedian.findSlidingWindowMedian(new int[] {1,3,-1,-3}, 3);
    System.out.print("Sliding window medians are: ");
    for (double num : result)
      System.out.print(num + " ");
    System.out.println();

    slidingWindowMedian = new SlidingWindowMedian();
     result = slidingWindowMedian.findSlidingWindowMedian(new int[] { 1, 2, -1, 3, 5 }, 3);
    System.out.print("Sliding window medians are: ");
    for (double num : result)
      System.out.print(num + " ");
  }
 // [1,3,-1,-3,5,3,6,7]
 //     3

}