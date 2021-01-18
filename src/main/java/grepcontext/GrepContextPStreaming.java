package grepcontext;

import static java.util.Arrays.asList;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.function.Predicate;

public class GrepContextPStreaming {

  static void printMatches(TextFile file, Predicate<String> matcher, int contextRequested) {
    LineProcessor processor =
        new LineProcessor() {
           Deque<String> q = new ArrayDeque<>();
           int counter =0;
          @Override
          public void processLine(String line) {
            if (matcher.test(line)) {
              q.push(line);
              while (!q.isEmpty()){
                System.out.println(q.poll());
              }
              counter = contextRequested;

            } else{
              if(counter>=0){
                System.out.println(line);
                counter --;
              }else{
                q.push(line);
                if(q.size()>contextRequested){
                  q.poll();
                }
              }

            }
          }
        };
    file.readLines(processor);
  }

    public static void main(String[] args) {
      for (int contextRequested = 0; contextRequested <= 2; contextRequested++) {
        printMatches(
            processor ->
                asList("organize", "it", "and", "make", "it", "accessible", "and", "useful")
                    .forEach(processor::processLine),
            "it"::equals,
            contextRequested);
        System.out.println();
      }
    }

}
