import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;


public class CPUTasks {

  public static List<String> cpuTask(Task [] tasks) {
    List<String> result = new ArrayList<>();
    PriorityQueue<Task> minHeap = new PriorityQueue<>(Comparator.comparing(task->task.exectime));
    Arrays.sort(tasks, Comparator.comparingInt(task->task.qtime));
    int currentTime = 0;
    int index =0;
   while (tasks.length != result.size()){
     while (index < tasks.length && tasks[index].qtime <= currentTime) {
       minHeap.offer(tasks[index++]);
     }
     if(minHeap.isEmpty()){
       currentTime = tasks[index].qtime;
     }
     while (!minHeap.isEmpty()) {
       Task current = minHeap.poll();
       currentTime += current.exectime;
       result.add(current.id);
     }
   }


    return result;
  }


  public static void main(String args[]) {
    Task t1 = new Task("id1", 2, 10);
    Task t2 = new Task("id2", 3, 7);
    Task t3 = new Task("id3", 6, 3);
    Task [] tasks = new Task[]{t1,t2,t3};
    System.out.println(CPUTasks.cpuTask(tasks));

  }
}
  class Task {

    String id;
    int qtime;
    int exectime;

    public Task(String id, int qtime, int exectime) {
      this.id = id;
      this.qtime = qtime;
      this.exectime = exectime;
    }
  }







