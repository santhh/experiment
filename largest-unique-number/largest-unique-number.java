class Solution {
    public int largestUniqueNumber(int[] A) {
       Map<Integer, Integer> map = new HashMap<>();
        for (int i=0; i< A.length; i++){
            map.put(A[i], map.getOrDefault(A[i], 0) +1 );
            
        }
        int max = -1;
        
        for (int key : map.keySet()){
            if(map.get(key)==1){
                max = Math.max(max, key);
            }
        }
        
        return max;
        
    }
}