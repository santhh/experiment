import java.util.*;

class Subsets {

  public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    backtrack(subsets, new ArrayList<>(),0,nums);
    return subsets;



  }
  public static void backtrack(List<List<Integer>> subsets,  List<Integer> temp, int start,int[] nums){
    subsets.add(new ArrayList<>(temp));
    for (int i=start; i<nums.length;i++){
      temp.add(nums[i]);
      backtrack(subsets,temp,i+1,nums);
      temp.remove(temp.size()-1);
    }

  }


  public static void main(String[] args) {
    List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
    System.out.println("Here is the list of subsets: " + result);

    result = Subsets.findSubsets(new int[] { 1, 5, 3 });
    System.out.println("Here is the list of subsets: " + result);
  }
}
