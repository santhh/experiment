import java.util.Comparator;
import java.util.Deque;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class HighWaterMark {
  int hw;
  Set<Integer> ack;
  // tree map using sorted list
  PriorityQueue<Integer> ackSorted;

  public HighWaterMark(int start){
    hw = start;
    ack = new HashSet<>();
    ackSorted = new PriorityQueue<>(Comparator.comparingInt(a->a));
  }
  public void acked(int num){
    ack.add(num);
  }

  public void ackedSorted(int num){
    ackSorted.add(num);
  }
// o(1)
  public int getHWMSorted(){
    while(!ackSorted.isEmpty() && ackSorted.peek()==hw+1){
      hw = hw+1;
      ackSorted.poll();

    }
    return hw;
  }
 // o(n)
  public int gtHWM(){
   while(ack.contains(hw+1)) {
     hw = hw+1;
     ack.remove(hw);


   }
    return hw;
  }

  public static void main (String args[]){
    HighWaterMark wm = new HighWaterMark(0);
    System.out.println(wm.gtHWM());
    wm.acked(2);
    System.out.println(wm.gtHWM());
    wm.acked(1);
    System.out.println(wm.gtHWM());
    wm.acked(3);
    System.out.println(wm.gtHWM());
    wm.acked(7);
    System.out.println(wm.gtHWM());
    wm.acked(5);
    System.out.println(wm.gtHWM());
    wm.acked(6);
    System.out.println(wm.gtHWM());
    wm.acked(4);
    System.out.println(wm.gtHWM());
    System.out.println();
    HighWaterMark wm1 = new HighWaterMark(0);
    System.out.println(wm1.getHWMSorted());
    wm1.ackedSorted(2);
    System.out.println(wm1.getHWMSorted());
    wm1.ackedSorted(1);
    System.out.println(wm1.getHWMSorted());
    wm1.ackedSorted(3);
    System.out.println(wm1.getHWMSorted());
    wm1.ackedSorted(7);
    System.out.println(wm1.getHWMSorted());
    wm1.ackedSorted(5);
    System.out.println(wm1.getHWMSorted());
    wm1.ackedSorted(6);
    System.out.println(wm1.getHWMSorted());
    wm1.ackedSorted(4);
    System.out.println(wm1.getHWMSorted());



  }

}
