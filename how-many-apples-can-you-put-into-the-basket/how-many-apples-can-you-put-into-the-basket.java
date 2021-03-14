class Solution {
    public int maxNumberOfApples(int[] arr) {
        int remain =5000;
        int count =0;
        Arrays.sort(arr);
        for (int i=0; remain > 0 && i<arr.length; i++){
            remain = remain - arr[i];
            if (remain>0) count+=1;
        }
      return count;
    }
}