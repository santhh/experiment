import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class CarCluster {
  public static int getClusterSize(List<Integer> speedList){
      int clusterSize =0;

      for (int i = speedList.size()-1; i>0 ; i--){
        if(speedList.get(i)<=speedList.get(i-1)){
          clusterSize ++;
          speedList.set(i-1,speedList.get(i));
        }
      }

      return clusterSize;
  }

  public static int findKthOverLapCar(List<Integer> speedList, int k){
    PriorityQueue<Map.Entry<Integer, Integer>> queue = new PriorityQueue<>(Comparator.comparingInt(e->e.getKey()));
    LinkedList<Integer> carLink = new LinkedList<>();
    for (int i =speedList.size()-1; i>0; i--){
      if(speedList.get(i)<=speedList.get(i-1)){
        queue.offer(Map.entry(i-1, overLapTime(i,speedList.get(i),i-1,speedList.get(i-1))));
        carLink.add(i-1);
        speedList.set(i-1,speedList.get(i));
      }
    }
    int i=0;
    while(i<k-1){
      i++;
      carLink.pollFirst();
    }
    return carLink.peek();

  }
  public static int overLapTime(int d1, int s1, int d0, int s0){
    int time =1;
    while (true){
      int newd1 = d1 + s1 * time;
      int newd0 = d0 + s0 * time;
      if(newd1 < newd0){
        return time;
      }
      time++;
    }
  }
  public static void main (String srgs[]){
      //System.out.println(getClusterSize(Arrays.asList(2,4,1,1,3)));
      System.out.println(findKthOverLapCar(Arrays.asList(2,4,1,3),1));

  }
}
