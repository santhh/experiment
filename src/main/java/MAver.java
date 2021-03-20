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
public class MAver {
  int windowSize;
  Deque<Integer> list;
  double sum;
  public MAver(int windowSize){
    this.windowSize = windowSize;
    list = new ArrayDeque<>();
    sum = 0.0;
  }
  public void add(int value){
    if(list.size()==windowSize){
      sum -= list.pollLast();
    }
    list.addFirst(value);
    sum += value;
  }
  public double get() {
    return sum / windowSize;
  }

  public static void main (String args[]){
    MAver mv = new MAver(3);

  }
}
