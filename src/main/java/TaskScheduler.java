import java.util.*;

class TaskScheduler {

  public static int scheduleTasks(char[] tasks, int k) {
    int count = 0;
    Map<Character, Integer> taskMap = new HashMap<>();
    PriorityQueue<Map.Entry<Character, Integer>> maxHeap = new PriorityQueue<>((a,b)-> b.getValue() - a.getValue());

    for (char task : tasks){
      taskMap.put(task, taskMap.getOrDefault(task, 0) +1 ) ;
    }
    maxHeap.addAll(taskMap.entrySet());
    while (!maxHeap.isEmpty()) {
      int interval = k + 1;
      List<Map.Entry<Character, Integer>> tempList  = new ArrayList<>();
      while (interval>0 && !maxHeap.isEmpty()){
        Map.Entry<Character, Integer> current = maxHeap.poll();
        current.setValue(current.getValue()-1);
        tempList.add(current);
        interval --;
        count ++;
      }

      for (Map.Entry<Character, Integer> taskEntity : tempList){
        if(taskEntity.getValue()>=1){
          maxHeap.offer(taskEntity);
        }
      }

      if(maxHeap.isEmpty()){
        break;
      }
      // empty cycle
      count += interval;



    }
    return count;
  }

  public static void main(String[] args) {
    char[] tasks = new char[] { 'a', 'a', 'a', 'b', 'c', 'c' };
    System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 2));

    tasks = new char[] { 'a', 'b', 'a' };
    System.out.println("Minimum intervals needed to execute all tasks: " + TaskScheduler.scheduleTasks(tasks, 3));
  }
}
