import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class MultipleSchedule {

  TreeMap<Integer,Integer> map;
  public MultipleSchedule(List<int[]> ranges){
    map = new TreeMap<>();
    // for (int[] range : ranges){
    //   map.put(range[0], range[0]+range[1]);
    // }

    for (int [] range : ranges){
     int start = range[0];
     int end = start + range[1];
     map.put(start,map.getOrDefault(start,0) +1);
     map.put(end,map.getOrDefault(end,0) -1);
    }

  }
  public  boolean canSchedule(int [] range){
    int start = range[0];
    int end = start + range[1];
    Map.Entry<Integer,Integer> floor = map.floorEntry(start);
    Map.Entry<Integer,Integer> ceiling = map.ceilingEntry(start);
    if(start < floor.getValue()) return false;
    else if(ceiling.getKey() < end) return false;
    else{
      map.put(start,end);
    }
    return true;

  }

  public boolean canSchedule1(int [] range, int k ){
   int start = range[0];
   int end = start + range[1];
   int count =0;
    map.put(start, map.getOrDefault(start,0) +1);
    map.put(end, map.getOrDefault(end,0) -1);
    for (Map.Entry<Integer, Integer> enntry : map.entrySet()){
        count += enntry.getValue();
        if(count>k){
          map.put(start, map.get(start)-1);
          if(map.get(start)==0){
            map.remove(start);
          }
          map.put(end, map.get(end) +1);
          if(map.get(end) ==0){
            map.remove(end);
          }
          return false;
        }

    }
    return true;


  }

  public static void main (String args[]){
    // List<int[]> ranges = new ArrayList<>();
    // ranges.add(new int[]{10,5});
    // ranges.add(new int[]{25,15});
    //
    // MultipleSchedule ms = new MultipleSchedule(ranges);
    //
    // System.out.println(ms.canSchedule(new int[]{18,7}));
    // System.out.println(ms.canSchedule(new int[]{12,10}));
   // Already Scheduled: P1(10, 5), P2(5, 15), P3(20, 15), P4(18, 6), P5(15, 5), P6(12, 9)
   // New Program: Q1 (14, 3) => can schedule
    // New Program: Q2 (18, 3) => cannot schedule


    // List<int[]> ranges = new ArrayList<>();
    // ranges.add(new int[]{10,5});
    // ranges.add(new int[]{5,15});
    // ranges.add(new int[]{20,15});
    // ranges.add(new int[]{18,6});
    // ranges.add(new int[]{15,5});
    // ranges.add(new int[]{12,9});
    //
    // MultipleSchedule ms = new MultipleSchedule(ranges);
    //
    // System.out.println(ms.canSchedule1(new int[]{14,3},4));
    // System.out.println(ms.canSchedule1(new int[]{18,3},4));

    // Already Scheduled: P1(5, 15), P2(8, 25), P3(12, 8), P4(22, 10), P5(25, 15), P6(10, 5)
    // New Program Q1 (18, 7) => can schedule
    // New Program Q2 (12, 12) => cannot schedule

    List<int[]> ranges = new ArrayList<>();
    ranges.add(new int[]{5,15});
    ranges.add(new int[]{8,25});
    ranges.add(new int[]{12,8});
    ranges.add(new int[]{22,10});
    ranges.add(new int[]{25,15});
    ranges.add(new int[]{10,5});

    MultipleSchedule ms = new MultipleSchedule(ranges);

    System.out.println(ms.canSchedule1(new int[]{18,7},4));
    System.out.println(ms.canSchedule1(new int[]{12,12},4));


  }
}
