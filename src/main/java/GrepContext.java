import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class GrepContext {

  public static void printMatches(List<String> lines, Predicate<String> matcher, int contextRequested){
     if(contextRequested < 0){
         return;
     }
     int lastPrint =-1;
        for (int i=0; i<lines.size();i++){
          if(matcher.test(lines.get(i))){
            int prevBound =  Math.max(i - contextRequested, lastPrint + 1);
            int nextBound = Math.min(i + contextRequested, lines.size() - 1);
            for (int j=prevBound; j<=nextBound; j++){
              System.out.println(lines.get(j));
            }
            lastPrint = nextBound;

          }
        }
  }
  public static void main (String args[]){

    printMatches(
        Arrays.asList("organize", "it", "and", "make", "it", "accessible", "and", "useful"),
        "it"::equals, 2);

  }
}
