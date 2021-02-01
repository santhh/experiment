import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class TopTalkativeUsers {

  public static Map<String, Integer>  parseContents(String input){
    Map<String, Integer> userWordCountMap = new HashMap<>();
    Scanner scan = new Scanner(input);
    scan.useDelimiter("\n");
    while (scan.hasNext()){
      String line = scan.next();
      String userName = line.substring(line.indexOf("<")+1,line.indexOf(">"));
      String word = line.substring(line.indexOf(">")+1).trim();
      String [] count = word.split("[^\\w']+");
      userWordCountMap.put(userName, userWordCountMap.getOrDefault(userName,0) + count.length);

    }
    return userWordCountMap;
  }
  public static void findTopKUser(String input, int n) {
    Map<String,Integer> userWordCountMap =  parseContents(input);
    PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>(Comparator.comparingInt(e->
        e.getValue()));
    int count = 0;
    Iterator<Map.Entry<String,Integer>> itr = userWordCountMap.entrySet().iterator();
    // create a min heap with k element
    while (itr.hasNext() && count < n){
      Map.Entry<String,Integer> entry = itr.next();
      minHeap.offer(entry);
      itr.remove();
      count++;
    }

    for (Map.Entry<String, Integer> entry : userWordCountMap.entrySet()){
      if(!minHeap.isEmpty() && minHeap.peek().getValue() < entry.getValue()){
        minHeap.poll();
        minHeap.offer(entry);
      }
    }
    // print
    while (!minHeap.isEmpty()){
      Map.Entry<String,Integer> entry = minHeap.poll();
      System.out.println(entry.getKey() +" "+entry.getValue());
    }
  }
  public static void main (String ags[]){
    StringBuilder fileContents = new StringBuilder();
    fileContents.append("[10:30] <john> hello there!");
    fileContents.append("\n");
    fileContents.append("Wed 05/31 @ server01 <martha> hello!hello!hello!");
    fileContents.append("\n");
    fileContents.append("[10:30] <bob> hello");

    findTopKUser(fileContents.toString(), 2);




  }
}
