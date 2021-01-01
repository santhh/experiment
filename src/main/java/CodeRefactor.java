import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Replacement {
  int start;
  String before;
  String after;
  public Replacement(int start, String before, String after){
    this.start = start;
    this.before = before;
    this.after = after;
  }
}


public class CodeRefactor {

  public static String refactor(List<Replacement> input, String s){
    StringBuilder sb = new StringBuilder();
    int index=0;
    int i=0;
  while (i<s.length()){
      if( index < input.size() && i == input.get(index).start){
        //num -> start
        sb.append(input.get(index).after);
        i +=  input.get(index++).before.length();
      }else {
        sb.append(s.charAt(i++));
      }

    }
    return sb.toString();
  }

  public static void main (String args[]){
    List<Replacement> input = Arrays.asList(new Replacement[]{
        new Replacement(0,"num", "start"),new Replacement(4,"foo","bar")});
    Collections.sort(input, Comparator.comparingInt(r->r.start));
    System.out.println(refactor(input,"num foo"));



  }
}
