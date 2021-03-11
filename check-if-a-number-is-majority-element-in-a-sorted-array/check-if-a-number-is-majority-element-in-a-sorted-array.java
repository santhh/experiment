class Solution {
    public boolean isMajorityElement(int[] nums, int target) {
     
        int start =0;
        int end = nums.length-1;
        while (start<=end){
            int mid = start + (end-start)/2;
            if(nums[mid]==target){
                int count = 0; 
                for(int i =mid+1; i<nums.length; i++){
                    if(nums[mid]!= nums[i]){
                        break;
                    }
                    count +=1;
                } 
                
                for(int i=mid-1; i>=0; i--){
                    if(nums[mid]!= nums[i]){
                        break;
                    }
                    count +=1;
                }
                return count +1 > nums.length/2;
                
                
                
            }else if (target > nums[mid]){
                start = mid +1; 
            }else {
                end = mid -1;
            }
        }
        
        return false;
        
    }
}