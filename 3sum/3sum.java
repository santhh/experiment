class Solution {
    public List<List<Integer>> threeSum(int[] arr) {
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

 }
