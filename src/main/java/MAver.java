import com.google.common.util.concurrent.AtomicDouble;
import java.util.ArrayDeque;
import java.util.Deque;
/*
  When drawing a time series graph, you sometimes want to "smooth out" the line.
  Instead of plotting the Y-value of each data point, you want to plot the average of the last
  N Y-values. Your task is to design a class to handle the computation of
  a moving average. The number N of values to average is called the "window".
  https://g3doc.corp.google.com/company/teams/sre/hiring/interview-questions/
  L6-code-review/moving-average.md?cl=head
 */
public final class MAver {
  private int windowSize;
  private Deque<Integer> list;
  private  AtomicDouble sum;
  public MAver(int windowSize){
    this.windowSize = windowSize;
    list = new ArrayDeque<>();
    sum = new AtomicDouble(0.0);
  }

  public void addValue(final int value){
    if(list.size()==windowSize){
      sum.set(sum.get() - value);
    }
    list.addFirst(value);
    sum.set(sum.get() + value);
  }
  public double getMovingAverage() {
    return sum.get() / windowSize;
  }

  public static void main (String args[]){
    MAver mv = new MAver(3);
     mv.addValue(1);
    // mv.addValue(2);
    // mv.addValue(90);
    // mv.addValue(10);
   System.out.println(mv.getMovingAverage());
  }
}
