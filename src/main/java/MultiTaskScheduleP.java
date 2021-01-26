import com.google.common.collect.ImmutableList;
import java.util.Map;
import java.util.TreeMap;

public class MultiTaskScheduleP {
 static  TreeMap<Integer,Integer> map = new TreeMap<>();
 public static boolean canSchedule(int core, int[] input){
   int start = input[0];
   int end = start + input[1];
   map.put(start,map.getOrDefault(start,0) +1);
   map.put(end,map.getOrDefault(end,0) -1);
   int active =0;
   for (Map.Entry<Integer,Integer> value : map.entrySet()){
     active += value.getValue();
     if(active>core){
       map.put(start,map.getOrDefault(start,0) - 1);
       if(map.get(start)==0){
         map.remove(start);
       }
       map.put(end,map.getOrDefault(end,0) + 1);
       if(map.get(end)==0){
         map.remove(end);
       }
       return false;
     }
   }
   return  true;
 }
  public static void main (String args[]){
    ImmutableList<int[]> inputList = ImmutableList.of(new int[]{10,5}, new int[]{5,15}, new int[]{20,15},
        new int[]{18,6}, new int[]{15,5},new int[]{12,9});
    inputList.forEach(v->{
          map.put(v[0],map.getOrDefault(v[0],0)+1);
          map.put(v[0]+v[1],map.getOrDefault(v[0]+v[1],0)-1);

    });

    System.out.println(canSchedule(4,new int[]{14,3}));
    System.out.println(canSchedule(4,new int[]{18,3}));

  }
}
