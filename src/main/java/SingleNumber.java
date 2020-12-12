import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class SingleNumber {
  public static int findSingleNumber(int[] arr) {
    Map<Integer,Integer> numSet = new HashMap<>();
    for (int i =0; i< arr.length; i++){
      numSet.put(arr[i],numSet.getOrDefault(arr[i],0)+1);
    }



    return numSet.entrySet().stream()
        .filter(entry->entry.getValue()==1)
        .findFirst()
        .get()
        .getKey();
  }

  public static void main( String args[] ) {
    System.out.println(findSingleNumber(new int[]{1, 4, 2, 1, 3, 2, 3}));
  }
}
