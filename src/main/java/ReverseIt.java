import java.util.Arrays;

public class ReverseIt {

  public static int[] reverseInPlace(int [] values){

    int n = values.length;
    int index = n;
    for (int i =0; i< n/2; i++){
      int temp = values[i];
      values[i] = values[index-1];
      values[index-1] = temp;
      index--;
    }
    return values;
  }

  public static void main (String args[]) {
    int[] nums = new int[]{1, 2, 3, 4};
    int n = nums.length;
    int [] nums_rev =  new int[n];
    for (int i =0; i< n; i++){
      nums_rev[n-i-1] = nums[i];
    }
    System.out.println(Arrays.toString(nums_rev));
    System.out.println(Arrays.toString(reverseInPlace(nums)));
  }

}
