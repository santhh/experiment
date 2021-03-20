import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class AdvancedOperationsStack {
  private Stack<Integer> values;
  private Stack<Integer> minValue;

  public AdvancedOperationsStack() {
    values = new Stack<>();
    minValue = new Stack<>();
  }

  public void push(int v) {
    if(minValue.isEmpty() || v < minValue.peek()){
      minValue.push(v);
    }
    values.push(v);
  }

  public Integer pop() {
    Integer top = values.pop();
    if(top.equals(minValue.peek())){
      minValue.pop();
    }

    return top;
  }

  public Integer peek() {
    return values.peek();
  }

  public Integer min() {
    return minValue.peek();
  }
}