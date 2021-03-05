class Solution {
    public List<Integer> addToArrayForm(int[] A, int K) {
      
        List<Integer> result = new ArrayList<>();
        int n = A.length -1; 
        for (int i=n;  i>=0;i--){
            result.add(0, (A[i] + K) % 10);
            K= (A[i] + K) / 10;
        }
        while (K>0){
            result.add(0, K % 10);
            K = K/10;
        }
        
        return result;
            
    }
}