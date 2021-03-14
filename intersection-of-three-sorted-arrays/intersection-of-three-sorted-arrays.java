class Solution {
    public List<Integer> arraysIntersection(int[] arr1, int[] arr2, int[] arr3) {
      Map<Integer, Integer> map = new HashMap<>();
      List<Integer> result = new ArrayList<>();  
      int index =0;
      while (index < arr1.length || index< arr2.length || index < arr3.length ){
          if (index< arr1.length){
              map.put(arr1[index], map.getOrDefault(arr1[index],0) + 1);
              
          }
         if (index< arr2.length){
              map.put(arr2[index], map.getOrDefault(arr2[index],0) + 1);
              
          }
         if (index< arr3.length){
              map.put(arr3[index], map.getOrDefault(arr3[index],0) + 1);
              
          }
          index +=1;
          
      }
        
      for (int i : map.keySet()){
          if(map.get(i)==3){
              result.add(i);
          }
      }  
        
     
      
        
     return result;  
        
       
        
    }
}