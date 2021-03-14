import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static  int[]  twoSum(int [] nums, int k){

     Map<Integer, Integer> map = new HashMap<>();
     for (int i =0; i< nums.length; i++){
       int temp = k -  nums[i];
       if(map.containsKey(temp)){
          return new int[]{map.get(temp),i};
       }else{
         map.put(nums[i],i);
       }

     }

     return  new int[0];
  }

  public static void main (String args[]){
    int [] nums = new int[] {2,7,11,15};
    System.out.println(Arrays.toString(twoSum(nums, 9)));
    int [] nums1 = new int[] {3,2,4};
    System.out.println(Arrays.toString(twoSum(nums1, 6)));
    int [] nums2 = new int[] {3,3};
    System.out.println(Arrays.toString(twoSum(nums2, 6)));



  }
}
