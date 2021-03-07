class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, Integer> bMap = new HashMap<>();
        List<Integer> result = new ArrayList<>(); 
        for (int i =0; i< B.length; i++){
           bMap.put(B[i], i);
        }
        for (int i =0; i< A.length; i++){
            result.add(bMap.get(A[i]));
        }
        
        return result.stream().mapToInt(Integer::intValue).toArray();
    }
}