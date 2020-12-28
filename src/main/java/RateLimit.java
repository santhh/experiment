import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

public class RateLimit {
  static AtomicLong counter = new AtomicLong(0L);
  static Map<String, Long> funcMap = new HashMap<>();
  String name;
  Long delay;
  public RateLimit (Long delay, String name){
    this.delay = delay;
    this.name = name;
    funcMap.put(name, 0L);

  }

  public boolean apply(){
    Long lastExecutionTime = funcMap.get(name);
    if(lastExecutionTime>0 &&  lastExecutionTime + delay >= counter.get() ){
      return false;
    }
    funcMap.put(name, counter.get());
    return true;
  }


  public static void main (String args[]){

    RateLimit r = new RateLimit(5L, "f1");

    while (counter.get()<=12){
      counter.incrementAndGet();
      System.out.println(r.apply());
    }


  }

}
