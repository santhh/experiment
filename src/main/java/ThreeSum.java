import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class ThreeSum {

  public static List<List<Integer>> threeSum(int[] arr) {
    Arrays.sort(arr);
    Set<List<Integer>> set = new HashSet<>();
    for (int i =0; i< arr.length-2; i++){
      if(arr[i] > 0) break;
      int j = i+1;
      int k = arr.length -1;
     while (j < k){
       if(arr[j]+arr[i]> 0) break;
       int sum = arr[i] + arr[j] + arr[k];
       if(sum==0){
         set.add(Arrays.asList(arr[i],arr[j++],arr[k--]));
       }else if  (sum > 0){
         k --;
       }else{
         j++;
       }
     }

    }
    return new ArrayList<>(set);
  }
  public static  void main  (String args[]){
    int []nums = new int[] {-1,0,1,2,-1,-4};
    System.out.println(threeSum(nums));
  }
}
