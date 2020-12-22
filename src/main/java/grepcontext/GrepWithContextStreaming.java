package grepcontext;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.function.Predicate;

final class GrepWithContextStreaming {
  static void printMatches(TextFile file, Predicate<String> matcher, int contextRequested) {
    if (contextRequested < 0) {
      throw new IllegalArgumentException(
          "contextRequested must not be negative: " + contextRequested);
    }

    LineProcessor processor =
        new LineProcessor() {
            Deque<String> wordQ = new ArrayDeque<>();
            int cotextCounter =0;

          @Override
          public void processLine(String line) {
            if (matcher.test(line)) {
              while(!wordQ.isEmpty()){
                System.out.println(wordQ.poll());
              }
              System.out.println(line);
              cotextCounter = contextRequested;

            }else{
              if(cotextCounter>0){
                cotextCounter --;
                System.out.println(line);
              }else{
                wordQ.push(line);
                if(wordQ.size() > contextRequested){
                  wordQ.poll();
                }
              }
            }

          }

        };
    file.readLines(processor);
  }
}

