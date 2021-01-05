import java.util.ArrayDeque;
import java.util.Deque;
import java.util.stream.Collectors;

public class MovingAverage {
  int size;
  Deque<Integer> list;
  Double sum =0.0;
  public MovingAverage(int size){
    this.size = size;
    list = new ArrayDeque<>();
  }
  public double next (int val){
    if(list.size()==size){
      sum -= list.pollLast();
    }
    list.addFirst(val);
    sum +=val;
    return sum/list.size();
  }
  public static void main (String ags[]){
    MovingAverage m = new MovingAverage(3);
    System.out.println(m.next(1));
    System.out.println(m.next(10));
    System.out.println(m.next(3));
    System.out.println(m.next(5));




  }
}
