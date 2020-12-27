import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class ArrayBasic {

  public static int removeElement(int [] nums, int element){
    int j=0;
    for(int i =0; i<nums.length; i++){
      if(nums[i]!=element){
        nums[j++] = nums[i];
      }
    }
    return j;
  }
  public static int removeDuplicates(int [] nums){
    int i=0;
    for (int j =1; j<nums.length; j++){
      if(nums[i]!=nums[j]){
        nums[++i]= nums[j];
      }
    }
    return i+1;
  }

  public static int findDuplicate(int[] nums){
    for (int i=0; i<nums.length-1;i++){
      int j = i+1;
      while(nums[i] != j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
    }

    for (int i =0; i< nums.length; i++){
      if(nums[i] != i+1){
        return nums[i];
      }
    }
    return -1;
  }

  public static int searchElement(int [] nums , int element){
    for (int i=0; i< nums.length; i++){
      if(nums[i]==element){
        return nums[i];
      }
    }
    return -1;
  }

  public static int findValueCount(int [] nums, int index, int val){
    int rightIndex = index;
    int leftIndex = index-1;
    int count =0;
    while (rightIndex < nums.length && nums[rightIndex] ==val ){
      count ++;
      rightIndex++;
    }
    while (leftIndex>=0 && nums[leftIndex] ==val){
      count++;
      leftIndex --;
    }
    return count;
  }
  public static int binarySearch (int [] nums, int element){
    Arrays.sort(nums);
    int start =0;
    int end = nums.length-1;
    while (start<=end){
      int mid = start + (end-start)/2;
      if(nums[mid] == element){
        //return nums[mid];
        return mid;
      }else if(element > nums[mid]){
        start = mid +1;
      }else if(element < nums[mid]){
        end = mid -1;
      }

    }
    // return closest to element
   // return nums[start];
    return  -1;

  }

  public static List<Integer> findSortedIntersection(int [] nums1, int [] nums2){
    List<Integer> list = new ArrayList<>();
    Arrays.sort(nums1);
    Arrays.sort(nums2);
    int i =0;
    int j =0;
    while (i< nums1.length && j< nums2.length){
      if(nums1[i] == nums2[j]){
        list.add(nums1[i]);
        i++; j++;
      }
      else if (nums1[i] < nums2[j]) {
        i++;
      } else if (nums1[i] > nums2 [j]){
        j++;
      }
    }
    return list;


  }
  public static void main (String args[]){
   int[] nums =  new int[]{3,2,2,3}; // remove elemennt from a list
    int res =  removeElement(nums,3);
    for (int i=0;i<res;i++){
      System.out.print(nums[i]);
    }
    // nums = [0,0,1,1,1,2,2,3,3,4]- remove duplicate from sorted array
    System.out.println();
    nums = new int[]{0,0,1,1,1,2,2,3,3,4};
    res =  removeDuplicates(nums);
    for (int i=0;i<res;i++){
      System.out.print(nums[i]);
    }
    //Given an array of size N + 1, which contains integers of range 1 ~ N,
    //find any one of the duplicate integer.
    System.out.println();
    nums = new int[] {1,2,3,3,4};
    System.out.print(findDuplicate(nums));
    System.out.println();
    System.out.print(searchElement(nums, 3));
    System.out.println();
    System.out.println(binarySearch(nums, 1));
    System.out.println(findSortedIntersection(new int[]{4,9,5}, new int[] {4,8,4,9,9}).toString());
    int index =  binarySearch(nums, 4);
    if (index >=0) {
      System.out.println(findValueCount(nums, index, 4));
    }

  }
}