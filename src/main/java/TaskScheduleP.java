import java.util.Comparator;
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
    map.put(10,15);
    map.put(25,40);
    System.out.println(canSchedule(18,7));
    System.out.println(canSchedule(12,10));
  }
}
