import com.google.common.collect.ImmutableList;
import java.util.Map;
import java.util.TreeMap;


public class TaskScheduleP {

  static TreeMap<Integer,Integer> map = new TreeMap<>();

  public static boolean canSchedule(Integer start, Integer duration){
    int end = start + duration;
    Map.Entry<Integer, Integer> floor = map.floorEntry(start);
    Map.Entry<Integer, Integer> ceiling = map.ceilingEntry(start);
    if(start < floor.getValue()) return false;
    if (end > ceiling.getKey()) return false;
    map.put(start,end);
    return true;
  }
  public static void main (String args[]){
    ImmutableList<int[]> input1 = ImmutableList.of(new int[]{10,5},new int[]{25,15});
     input1.forEach(v->{
       map.put(v[0],v[0] + v[1]);
     });

    // ImmutableList<int[]> input2 = ImmutableList.of(new int[]{5,15},new int[]{8,25},
    //     new int[]{12,8},new int[]{22,10}, new int[]{25,15});
    // input2.forEach(v->{
    //   map.put(v[0],v[0] + v[1]);
    // });


    System.out.println(canSchedule(18,7));
    System.out.println(canSchedule(12,10));
  }
}
