import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class CPUTask {

  PriorityQueue<Task> maxHeap;

 
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


