import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.atomic.AtomicLong;

public class RateLimit2 {
  static Deque<Long> callQ = new ArrayDeque<>();
  final Integer interval = 5;
  static AtomicLong timer = new AtomicLong(0L);
  String name;
  Integer numberOfcalls;
  public RateLimit2(String name, Integer numberOfcalls){
    this.name = name;
    this.numberOfcalls = numberOfcalls;

  }
  public void apply(){
    callQ.push(timer.get());
    if (timer.get()%interval == 0){
      int currentCall = 1;
      while(!callQ.isEmpty() && currentCall<=numberOfcalls){
       System.out.println("calling "+callQ.poll());
        currentCall++;
      }
    }

  }
  public static void main (String args[]){
    RateLimit2 r = new RateLimit2("f1", 10);
    while(timer.getAndIncrement()<=20){
         r.apply();
    }
  }

}
