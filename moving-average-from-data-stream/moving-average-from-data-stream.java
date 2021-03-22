public class MovingAverage {
  int size;
  Deque<Integer> list;
  Double sum = 0.0;
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
}   

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */