package grepcontext;

import static java.lang.Math.max;
import static java.lang.Math.min;

import java.util.List;
import java.util.function.Predicate;

final class GrepWithContextInList {
  // Note that this has O(n) time complexity only if the input List's get(index) is O(1).
  static void printMatches(List<String> lines, Predicate<String> matcher, int contextRequested) {
    if (contextRequested < 0) {
      throw new IllegalArgumentException(
          "contextRequested must not be negative: " + contextRequested);
    }

    int lastPrinted = -1;
    for (int i = 0; i < lines.size(); i++) {
      String line = lines.get(i);

      if (matcher.test(line)) {
        int first = max(i - contextRequested, lastPrinted + 1);
        int last = min(lines.size() - 1, i + contextRequested);
        for (int j = first; j <= last; j++) {
          System.out.println(lines.get(j));
        }

        lastPrinted = last;
      }
    }
  }
}