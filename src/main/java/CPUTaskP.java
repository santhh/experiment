import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
class CPUTask {

  String id;
  int qTime;
  int eTime;

  public CPUTask(String id, int qTime, int eTime) {
    this.id = id;
    this.qTime = qTime;
    this.eTime = eTime;
  }
}

public class CPUTaskP {

  public static List<String> processTasks(List<CPUTask> tasks ){
    List<String> result = new ArrayList<>();
    tasks.sort(Comparator.comparingInt(t->t.qTime));
    PriorityQueue<CPUTask> minHeap = new PriorityQueue<>(Comparator.comparingInt(t->t.eTime));
    int currentTime =0;
    int index =0;
    while(result.size()!=tasks.size()){
      while (index < tasks.size() && tasks.get(index).qTime<=currentTime){
        CPUTask task = tasks.get(index++);
        minHeap.add(task);
      }
      if(minHeap.isEmpty()){
        index ++;
        continue;
      }
      while (!minHeap.isEmpty()){
          CPUTask current = minHeap.poll();
          result.add(current.id);
          currentTime += current.eTime;

      }

    }
    return result;


  }
  public static void main(String args[]){
    List<CPUTask> tasks = ImmutableList.of(
        new CPUTask("id1", 0, 10),
        new CPUTask("id2",3,7),
        new CPUTask("id3", 6, 3));
    System.out.println(processTasks(new ArrayList<>(tasks)));



  }
}
