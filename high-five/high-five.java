class Solution {
    public int[][] highFive(int[][] items) {
        TreeMap<Integer,PriorityQueue<Integer>> map = new TreeMap<>();
        
        
        for (int i =0; i< items.length;i++){
            for(int j =0; j<1; j++){
                if(!map.containsKey(items[i][0])){
                    PriorityQueue<Integer> queue = new PriorityQueue<>();
                    queue.offer(items[i][1]);
                    map.put(items[i][0], queue);
                }else{
                    PriorityQueue<Integer> queue = map.get(items[i][0]);
                    queue.offer(items[i][1]);
                     if(queue.size() > 5){
                        queue.poll();
                    }
                    map.put(items[i][0], queue);
                    
                }
            }
        }
        
        int [][]result = new int[map.size()][2];
        int index =0;
        
        for (Integer key : map.keySet()){
            result [index][0] = key;
            PriorityQueue<Integer> temp = map.get(key);
            int sum =0; 
            while (!temp.isEmpty()){
                sum += temp.poll();
            }
            result [index++][1] = sum /5;
            
        }
        
        return result; 
        
        
    }
}