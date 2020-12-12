import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class SingleNumber {
  public static int findSingleNumber(int[] arr) {
    Set<Integer> numSet = new HashSet<>();

    for (int i=0; i< arr.length; i++){
      if(!numSet.contains(arr[i])){
        numSet.add(arr[i]);
      }else{
        numSet.remove(arr[i]);
      }
    }
    return numSet.stream().findFirst().get();

  }

  public static void main( String args[] ) {
    System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
  }
}
