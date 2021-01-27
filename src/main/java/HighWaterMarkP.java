import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class HighWaterMarkP {

 Set<Integer> ack;
  int start;
  int hwm;
  public HighWaterMarkP(int start){
    this.start = start;
    hwm = start;
    ack = new HashSet<>();
  }

  public void ack(int n){
    ack.add(n);
  }

  public int getHWM(){

    while (ack.contains(hwm+1)){
      hwm = hwm +1;
    }
    return hwm;

  }
  public static void  main (String args[]){
    HighWaterMarkP hw = new HighWaterMarkP(0);
    System.out.println(hw.getHWM());
    hw.ack(2);
    System.out.println(hw.getHWM());
    hw.ack(1);
    System.out.println(hw.getHWM());
    hw.ack(3);
    System.out.println(hw.getHWM());
    hw.ack(7);
    System.out.println(hw.getHWM());
    hw.ack(5);
    System.out.println(hw.getHWM());
    hw.ack(6);
    System.out.println(hw.getHWM());
    hw.ack(4);
    System.out.println(hw.getHWM());






  }
}
