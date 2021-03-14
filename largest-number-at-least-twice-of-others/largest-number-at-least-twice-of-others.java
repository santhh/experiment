class Solution {
    public int dominantIndex(int[] nums) {
        int maxNum = Integer.MIN_VALUE;
        int index =-1;
        for (int i =0; i<nums.length;i++){
            if(maxNum < nums[i]){
                maxNum = nums[i];
                index = i;
            }
            
        }
        for (int i =0; i< nums.length; i++){
            if(nums[i] != maxNum && nums[i] * 2 > maxNum ){
                return -1;
            }
        }
        return index;
    }
}