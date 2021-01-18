package grepcontext;

import static java.util.Arrays.asList;

import java.util.List;
import java.util.function.Predicate;

public class GrepContextP {

  static void printMatches(List<String> lines, Predicate<String> matcher, int contextRequested){
    int previousEnd =0;
    for (int i =0; i< lines.size(); i++){
      String word  = lines.get(i);
      if (matcher.test(word)){
        int start = i-contextRequested < 0 ?0:i-contextRequested;
        int end =  i+contextRequested > lines.size()?lines.size():i+contextRequested;
        start = Math.max(previousEnd,start);
        for (int j = start ; j<= end; j++){
          System.out.println(lines.get(j));
        }
        previousEnd = end+1;


      }
    }

  }


  public static void main (String args[]){
    printMatches(
        asList("organize", "it", "and", "make", "it", "accessible", "and", "useful"),
        "it"::equals,
        /*contextRequested=*/ 1);
  }
}
