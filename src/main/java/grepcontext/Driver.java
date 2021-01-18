package grepcontext;

import static grepcontext.GrepWithContextStreaming.printMatches;
import static java.util.Arrays.asList;

public class Driver {
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
