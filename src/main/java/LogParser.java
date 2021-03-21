import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
//https://g3doc.corp.google.com/company/teams/sre/hiring/interview-questions/
// L6-code-review/log-parsing.md?cl=head
public class LogParser {
  static class HostEntry {
    Map<String, Integer> counts = new HashMap<String, Integer>();
    Map<String, Double> times = new HashMap<String, Double>();
  }

  static class Pending {
    Pending(double t, String m) {
      timestamp = t;
      method = m;
    }

    double timestamp;
    String method;
  }

  public static double parseTime(String t) {
    //YYYYMMDDHHMMSS
    //LocalDateTime ldt = LocalDateTime.parse(dateInString, DateTimeFormatter.ofPattern(DATE_FORMAT));
    t = t.substring(0, t.length() - 2);
    String[] parts = t.split(":");
    return Integer.parseInt(parts[0]) * 3600
        + Integer.parseInt(parts[1]) * 60
        + Double.parseDouble(parts[2]);
  }

  public static void processFile(String filename, Map<String, HostEntry> stats)
      throws FileNotFoundException, IOException {
    String hostname = filename.split("-")[0];
    Map<String, Pending> pending = new HashMap<String, Pending>();
    BufferedReader reader = new BufferedReader(new FileReader(filename));
    String line = reader.readLine();
    if (!stats.containsKey(hostname)) {
      stats.put(hostname, new HostEntry());
    }
    HostEntry host = stats.get(hostname);
    while (line != null) {
      String[] parts = line.split(" ");
      double timestamp = parseTime(parts[1]);
      if (parts[2] == "enter") {
        pending.put(parts[3], new Pending(timestamp, parts[4]));
      } else if (parts[2] == "exit") {
        Pending entry = pending.get(parts[3]);
        if (host.counts.containsKey(entry.method)) {
          host.counts.put(entry.method, host.counts.get(entry.method) + 1);
          host.times.put(
              entry.method, host.times.get(entry.method) + (timestamp - entry.timestamp));
        } else {
          host.counts.put(entry.method, 1);
          host.times.put(entry.method, timestamp - entry.timestamp);
        }
      }
      line = reader.readLine();
    }
  }

  public static void main(String[] args) {
    HashMap<String, HostEntry> hostEntries = new HashMap<String, HostEntry>();
    for (String filename : args) {
      try {
        processFile(filename, hostEntries);
      } catch (FileNotFoundException e) {
        // omitted
      } catch (IOException e) {
        // omitted
      }
    }
    for (Map.Entry<String, HostEntry> host : hostEntries.entrySet()) {
      System.out.printf("Statistics for %s%n", host.getKey());
      for (Map.Entry<String, Integer> calls : host.getValue().counts.entrySet()) {
        double processingTime = host.getValue().times.get(calls.getKey());
        System.out.printf("%s: %.2f%n", calls.getKey(), processingTime / calls.getValue());
      }
    }
  }
}
