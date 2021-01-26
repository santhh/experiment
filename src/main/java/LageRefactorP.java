import com.google.common.collect.ImmutableList;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class R{
  int start;
  String before;
  String after;
  public R(int start, String before, String after){
    this.start = start;
    this.before = before;
    this.after = after;
  }
}
public class LageRefactorP {

  public static String replacement(String input, List<R> replacements){
      StringBuilder builder = new StringBuilder();
      int index =0;
      for (R replace : replacements){
        int startIndex = replace.start;
        int endIndex = startIndex + replace.before.length();
        builder.append(input, index, startIndex);
        builder.append(replace.after);
        index = endIndex;

      }
      return builder.toString();
  }
  public static void main (String args[]){
    R r1 = new R(0,"num", "String");
    R r2 = new R(4, "foo", "bar");

    ImmutableList<R> replacements = ImmutableList.of(r1,r2);
    Collections.sort(new ArrayList<>(replacements), Comparator.comparingInt(l->l.start));
    String input = "num foo";
    System.out.println(replacement(input, replacements));

  }
}
