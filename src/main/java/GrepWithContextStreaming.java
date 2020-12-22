import grepcontext.LineProcessor;
import grepcontext.TextFile;
import java.util.ArrayDeque;
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
          final Queue<String> recentLines = new ArrayDeque<>();
          int upcomingLinesNeeded = 0;

          @Override
          public void processLine(String line) {
            if (matcher.test(line)) {
              handleMatch(line);
            } else {
              handleNonMatch(line);
            }
          }

          void handleMatch(String line) {
            recentLines.forEach(System.out::println);
            recentLines.clear();
            System.out.println(line);
            upcomingLinesNeeded = contextRequested;
          }

          void handleNonMatch(String line) {
            if (upcomingLinesNeeded > 0) {
              upcomingLinesNeeded--;
              System.out.println(line);
            } else {
              recentLines.add(line);
              if (recentLines.size() > contextRequested) {
                recentLines.remove();
              }
            }
          }
        };
    file.readLines(processor);
  }
}
