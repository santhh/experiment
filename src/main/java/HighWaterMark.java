import java.util.HashSet;
import java.util.Set;

public class HighWaterMark {
  int hw;
  Set<Integer> ack;

  public HighWaterMark(int start){
    hw = start;
    ack = new HashSet<>();
  }
  public void acked(int num){
    ack.add(num);
  }

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


  }

}
