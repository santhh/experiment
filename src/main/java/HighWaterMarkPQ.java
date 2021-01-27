import java.util.Comparator;
import java.util.PriorityQueue;

public class HighWaterMarkPQ {
  int start;
  int hwm;
  PriorityQueue<Integer> minHeap;


  public HighWaterMarkPQ(int start){
    this.start = start;
    this.hwm = this.start;
    minHeap = new PriorityQueue<>(Comparator.comparingInt(a->a));
  }

  public void ack(int n){
    minHeap.add(n);
  }

  public  int getHWM(){
    while(!minHeap.isEmpty() && minHeap.peek() == hwm+1){
      hwm = minHeap.poll();

    }
    return hwm;
  }
  public static void main (String args []){
    HighWaterMarkPQ hw = new HighWaterMarkPQ(0);
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
