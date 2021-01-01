import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Calculator {

  public static int calculate(String s){
    if (s == null || s.length() < 1) return 0;
    Stack<Integer> stack = new Stack<>();
    StringBuilder sb = new StringBuilder();
    List<Character> operators = Arrays.asList(new Character[]{'+', '-', '*', '/'});
    char prevOp = '+';
    int res =0;
    for (int i =0; i< s.length();i++){
      char c = s.charAt(i);
      if(Character.isDigit(c)){
        sb.append(c);
      }
      if(operators.contains(c) || i==s.length()-1){
        if(prevOp=='+'){
          stack.push(Integer.valueOf(sb.toString()));
        }else if(prevOp=='-'){
          stack.push(0-Integer.valueOf(sb.toString()));
        }else if (prevOp=='*'){
          stack.push(stack.pop() * Integer.valueOf(sb.toString()));
        }else if( prevOp=='/'){
          stack.push(stack.pop()/Integer.valueOf(sb.toString()));
        }
        prevOp = c;
        sb = new StringBuilder();
       }
    }
    while(!stack.isEmpty()){
      res += stack.pop();
    }

    return res;

  }
  public static void main (String args[]){
    System.out.println("Res:"+calculate("1+2"));
  }
}
