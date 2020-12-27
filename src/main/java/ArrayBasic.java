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
  public static void main (String args[]){
   int[] nums =  new int[]{3,2,2,3}; // remove elemennt from a list
    // int res =  removeElement(nums,3);
    // for (int i=0;i<res;i++){
    //   System.out.print(nums[i]);
    // }
    // // nums = [0,0,1,1,1,2,2,3,3,4]- remove duplicate from sorted array
    // System.out.println();
    // nums = new int[]{0,0,1,1,1,2,2,3,3,4};
    // res =  removeDuplicates(nums);
    // for (int i=0;i<res;i++){
    //   System.out.print(nums[i]);
    // }
    //Given an array of size N + 1, which contains integers of range 1 ~ N,
    // find any one of the duplicate integer.
    nums = new int[] {1,2,3,3,4};
    System.out.println(findDuplicate(nums));

  }
}