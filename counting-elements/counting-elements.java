class Solution {
    public int countElements(int[] arr) {
        Set<Integer> set = new HashSet<>();
        int count =0;
        for (int i =0; i< arr.length; i++){
            set.add(arr[i]);
        }
        
        for (int i =0; i< arr.length; i++){
            if(set.contains(arr[i]+1)){
                count +=1;
            }
        }
        return count;
    }
}