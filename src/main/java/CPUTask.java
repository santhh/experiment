import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CPUTask {

  PriorityQueue<Task> maxHeap;

  public CPUTask(List<Task> tasks) {
    maxHeap = new PriorityQueue<>(new TaskComparator());
    for (Task task : tasks) {
      maxHeap.offer(task);
    }

  }
  public  List<String> printTaskId(){
    List<String> result = new ArrayList<>();
    while (!maxHeap.isEmpty()){
      result.add(maxHeap.poll().id);
    }
    return result;
  }
  public static void main(String args[]){
    Task t1 = new Task("id1", 0, 10);
    Task t2 = new Task("id2", 3, 7);
    Task t3 = new Task("id3", 6, 3);
    CPUTask tasks = new CPUTask(Arrays.asList(t1,t2,t3));
    System.out.println(tasks.printTaskId());

  }


}
  class Task{
    String id;
    int qtime;
    int exectime;
    public Task(String id, int qtime, int exectime){
      this.id = id;
      this.qtime = qtime;
      this.exectime = exectime;
    }
  }

  class TaskComparator implements Comparator<Task> {
    @Override
    public int compare(Task o1, Task o2) {
      return o1.exectime - o2.exectime;
    }

  }


