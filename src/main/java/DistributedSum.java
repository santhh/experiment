import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicInteger;

public class DistributedSum {

  public static class SumTask implements Callable<Long>{

    AtomicInteger serverId = new AtomicInteger(0);
    int fileId;
    public SumTask(int fileId){
      this.fileId = fileId;
    }
    @Override
    public Long call() throws Exception {
      return total(fileId,serverId.getAndIncrement());
    }
  }
  public static  void main (String args[]) throws ExecutionException, InterruptedException {
    ExecutorService service = Executors.newFixedThreadPool(10);
    Deque<Future<Long>> resultQueue = new ArrayDeque<>();
    int N =10;
    long sum =0;
    for (int i =0; i< N; i++){
      resultQueue.offerFirst(service.submit(new SumTask(i)));

    }
    while(!resultQueue.isEmpty()){
      Future<Long> result = resultQueue.poll();
      if(result.isDone()){
        sum += result.get();
      }else{
        resultQueue.offerLast(result);
      }
    }

    System.out.println("Sum : "+sum);
    service.shutdown();

  }
  public static long total(int fileId, int serverId){
    return new Random().nextInt(999);
  }
}
