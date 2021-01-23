import com.google.common.collect.ImmutableList;

import java.util.Stack;

public class CalculatorP {

  public static int calculate(String s){
    int res =0;
    StringBuilder sb = new StringBuilder();
    Stack<Integer> digit = new Stack<>();
    char prevOp = '+';
    ImmutableList<Character> opList = ImmutableList.of('+','-','*','/');
    for (int i =0; i<s.length();i++){
      char c = s.charAt(i);
      if(Character.isDigit(c)){
        sb.append(c);
      }
      if(opList.contains(c) || i==s.length()-1){
        if(prevOp=='+'){
          digit.push(Integer.valueOf(sb.toString()));

        }else if (prevOp=='-'){
          digit.push(0-Integer.valueOf(sb.toString()));

        }else if (prevOp=='*'){
          digit.push(digit.pop() * Integer.valueOf(sb.toString()));

        } else if (prevOp=='/'){
          digit.push(digit.pop() / Integer.valueOf(sb.toString()));

        }
        prevOp =c;
        sb = new StringBuilder();

      }

    }

    while(!digit.isEmpty()){
      res += digit.pop();
    }



    return res;
  }
  public static void main (String args[]){
      System.out.println(calculate("1+2*3*8"));
  }
}
