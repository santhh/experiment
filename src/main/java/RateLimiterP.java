import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicInteger;

public class RateLimiterP {
  static AtomicInteger timer = new AtomicInteger(0);
  static Deque<Integer> queue = new ArrayDeque<>();
  public Integer nextExecutionTime;
  public String name;
  public Integer delay;
  public Integer numberOfRequest;


  public RateLimiterP(String name, Integer delay){
    this.name = name;
    this.delay = delay;
    this.nextExecutionTime =0;
    this.numberOfRequest =0;
  }
  public RateLimiterP(String name, Integer delay, Integer numberOfRequest){
    this.name = name;
    this.delay = delay;
    this.nextExecutionTime =0;
    this.numberOfRequest =numberOfRequest;
  }
  public void apply(){

       if(timer.get()>=nextExecutionTime){
         System.out.println("Called "+timer.get());
         nextExecutionTime = timer.get()+delay;
       }else{
         System.out.println("Not Allowed "+timer.get());
       }

  }

  public void applyN(){
    System.out.println("Receive Call: "+timer.get());
    queue.addLast(timer.get());
    if(timer.get()>=nextExecutionTime){
      int currentCall =1;
      while(!queue.isEmpty() && currentCall<=numberOfRequest){
        System.out.println("Procssing Call: "+ queue.pollFirst());
      }
      nextExecutionTime = timer.get() +delay;
    }
  }

  public static void main (String ags[]){
    // 1 req / 5 sec
    // RateLimiterP r = new RateLimiterP("f",5);
    // while(timer.get()<20){
    //   r.apply();
    //   timer.getAndIncrement();
    // }
    // n req /sec
    RateLimiterP r1 = new RateLimiterP("f",5, 10);
    while(timer.get()<20){
      r1.applyN();
      timer.getAndIncrement();
    }


  }
}
