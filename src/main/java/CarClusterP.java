import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class CarClusterP {
static AtomicInteger time = new AtomicInteger(0);
  public static int numCluster(List<Integer> speedList){
    int result =0;
    int n = speedList.size();
    for (int i=n-1;i>0;i--){
      if(speedList.get(i) <= speedList.get(i-1)){
        result += 1;
      }
    }

    return result;
  }

  public static int firstCarToReachFront(List<Integer> speedList){
   int result = -1;
    int n = speedList.size()-1;
    // time overtake, index
    PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(e->e.getKey()));
    for (int i =n;i>0; i--){
      if(speedList.get(i)<=speedList.get(i-1)){
        int timeToReachFrontcar  =  overtakeTime(i-1, speedList.get(i-1),i, speedList.get(i));
        minHeap.add(Map.entry(timeToReachFrontcar,i-1));

      }
    }


    if(!minHeap.isEmpty()){
      result = minHeap.peek().getValue();
    }
    return result;
  }

  public static List<Integer> meetingOrder (List<Integer> speedList){
    LinkedList<Integer> carLinklList = new LinkedList<>();
    List<Integer> inputList = new ArrayList<>(speedList);
    PriorityQueue<Map.Entry<Integer,Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(e->e.getKey()));
    int n = inputList.size() -1;
    for (int i = n; i>0; i--){
      if(inputList.get(i)<=inputList.get(i-1)){
        int timeToCarInFront = overtakeTime(i-1, inputList.get(i-1), i, inputList.get(i));
        minHeap.add(Map.entry(timeToCarInFront,i-1));
        carLinklList.addLast(i-1);
        inputList.set(i-1,inputList.get(i));
      }
    }
    while (!minHeap.isEmpty()){
      Map.Entry entry = minHeap.poll();
      System.out.println(entry.getKey()+" " + entry.getValue());
    }
    return  carLinklList;

  }

  public static int overtakeTime(int prevD, int prevS, int currD,int currS){

    int currTime = time.get();
    // d = s * t
    while ((prevD+currTime*prevS)<(currD+currTime*currS)){
      currTime = time.incrementAndGet();
    }

    return currTime;
  }
  public static void main (String args[]){
    ImmutableList<Integer> speedList1 = ImmutableList.of(2,4,1,3);
    ImmutableList<Integer> speedList2 = ImmutableList.of(4,3,2,1);
    //System.out.println("First list: "+numCluster(speedList1));
    //System.out.println("Last List: "+numCluster(speedList2));
    // fist , second.. n th car to overtake
   // System.out.println("First Car to Pass: "+firstCarToReachFront(speedList1));
    //System.out.println("First Car to Pass: "+firstCarToReachFront(speedList2));
    System.out.println(meetingOrder(speedList1));
    System.out.println(meetingOrder(speedList2));

  }
}
