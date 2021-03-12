class Solution {
    public int missingNumber(int[] arr) {
        int minDiff = Integer.MAX_VALUE;
        int n = arr.length-1;
        minDiff = Math.min(Math.abs(arr[1] - arr[0]), Math.abs(arr[n]-arr[n-1]));
        Arrays.sort(arr);
        for (int i =0; i<n; i++){
            if(arr[i] + minDiff != arr[i+1]){
                return arr[i] + minDiff;
            }
        } 
                           
         return arr[0];                   
                           
    }
}