import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ThreeSumP {

  public static List<List<Integer>> findTripletsFaster(int[] nums, int target) {
    Set<List<Integer>> ret = new HashSet<>();
    int n = nums.length -1;
    Arrays.sort(nums);
    for (int i = 0; i < nums.length -2 ; i++) {
      int start = i+1;
      int end = n;
      while (start < end){
        int sum = nums[i] + nums[start] + nums[end];
        if(sum==target){
          List<Integer> temp = Arrays.asList(nums[i], nums[start], nums[end]);
          ret.add(temp);
          start ++;
          end --;
        }else if (sum < target){
          start ++;
        }else{
          end --;
        }
      }

    }
      return new ArrayList<>(ret);
    }

  public static List<List<Integer>> findTriplets(int[] nums, int target) {
    Set<List<Integer>> ret = new HashSet<>();
    for (int i = 0; i < nums.length -2; i++) {
      for (int j = i + 1; j < nums.length-1; j++) {
        for (int k = j + 1; k < nums.length; k++) {
          if (nums[i] + nums[j] + nums[k] == target) {
            List<Integer> triplet = Arrays.asList(nums[i], nums[j], nums[k]);
            Collections.sort(triplet);
            ret.add(triplet);
          }
        }
      }
    }
    return new ArrayList<>(ret);
  }
  public static void main(String args[]){
    int [] nums = new int[]{-1,0,1,2,-1,-4};
    int k = 0;
    System.out.println(findTriplets(nums, k));
    System.out.println(findTripletsFaster(nums, k));
  }
}
