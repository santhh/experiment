import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PlusOne {

  public static int[]  plusOne(int[] nums){

    for (int  i = nums.length-1; i>=0; i--){
      if(nums[i] <9){
          nums[i] = nums[i] +1;
          return nums;
      }
      nums[i] =0;
    }
    int [] result = new int[nums.length +1];
    result[0] =1;
    return result;




  }
  public static void main (String args[]){
    int [] nums = new int [] {9,9,9};
    System.out.println(Arrays.toString(plusOne(nums)));
  }
}
