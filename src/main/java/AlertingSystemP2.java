import java.util.Stack;

public class AlertingSystemP2 {
  static Double[] rates = new Double[]{
      5.0,
      10.0,
      7.0,
      15.0,
      0.0,
      60.0,
      55.0,
      60.0,
      60.0,
      60.0,
      0.0,
      5.0,
      5.0};

  public static boolean isHealthy(int threshold){
    int maxArea =0;
    Stack<Integer> stack = new Stack<>();
    stack.push(-1);
    int n = rates.length;
    for (int i =0; i<n; i++){
      while(stack.peek()!=-1 && rates[i].intValue() <= rates[stack.peek()].intValue()){
        int height = rates[stack.pop()].intValue();
        int width  = i - stack.peek() - 1;
        maxArea = Math.max(maxArea,height * width);

      }
      stack.push(i);


    }

    while (stack.peek()!=-1){
      int height = rates[stack.pop()].intValue();
      int width = n - stack.peek() - 1;
      maxArea = Math.max(maxArea, height * width);

    }

    return  maxArea>=threshold;
  }
  public static void main (String args[]){
    System.out.println(isHealthy(250));
    System.out.println(isHealthy(350));
  }
}
