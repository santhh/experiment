import java.util.*;

class KLargestNumbers {
  static PriorityQueue<Integer> numQ ;

  // public static List<Integer> findKLargestNumbers(int[] nums, int k) {
  //  List<Integer> res = new ArrayList<>();
  //  Arrays.sort(nums);
  //  int length = nums.length;
  //
  //  for (int i = length; i>=length-k+1; i--){
  //    res.add(nums[i-1]);
  //  }
  //  return res;
  // }
  public static List<Integer> findKLargestNumbers(int[] nums, int k) {
    PriorityQueue<Integer> numQ = new PriorityQueue<>();
    for (int i =0; i< k; i++){
      numQ.offer(nums[i]);
    }

    for (int i =k ; i<nums.length; i++){
      if(nums[i]>numQ.peek()){
        numQ.offer(nums[i]);
        numQ.poll();
      }
    }

    return new ArrayList<>(numQ);
  }

  public static void main(String[] args) {
   List<Integer> result = KLargestNumbers.findKLargestNumbers(new int[] { 3, 1, 5, 12, 2, 11 }, 3);
   System.out.println("Here are the top K numbers: " + result);

    result  = KLargestNumbers.findKLargestNumbers(new int[] { 5, 12, 11, -1, 12 }, 3);
    System.out.println("Here are the top K numbers: " + result);
  }
}
