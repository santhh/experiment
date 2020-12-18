import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class FTEScore {
  static Map<Integer, List<Integer>> reportMap =
      Map.of(
          123, List.of(234, 345),
          234, List.of(456, 789),
          345, List.of(),
          456, List.of(),
          789, List.of());

  static Map<Integer,Integer> saveMap = new HashMap<>();
// dfs
public static int fteScoreDfs( int eid){
 if(saveMap.containsKey(eid)) return saveMap.get(eid);
  int score =1;
  List<Integer> directReports = reportMap.get(eid);
  for (int reportEid : directReports){
     score += fteScoreDfs(reportEid);
  }
  saveMap.put(eid,score);
  return  score;
}

public static void fteScoreWithoutEid(){
    for (int eid : reportMap.keySet()){
      if(!saveMap.containsKey(eid)){
         fteScoreDfs(eid);
      }
    }
  return;
}
public static int fteScoreBfs(int eid){
  int score =0;
  Queue<Integer> queue = new LinkedList<>();
  queue.add(eid);
  while (!queue.isEmpty()){
    int currentEid = queue.poll();
    score++;
    for (int reportEid : reportMap.get(currentEid)){
      queue.add(reportEid);

    }
  }

  return score;
}

  public static void main (String args[]){
    // System.out.println(fteScoreDfs(123));
    // System.out.println(fteScoreDfs(234));
    // System.out.println(fteScoreDfs(345));
    // System.out.println(fteScoreDfs(456));
    // System.out.println(fteScoreDfs(789));
    fteScoreWithoutEid();
    System.out.println(saveMap.values().toString());
    // System.out.println("*****");
    // System.out.println(fteScoreBfs(123));
    // System.out.println(fteScoreBfs(234));
    // System.out.println(fteScoreBfs(345));
    // System.out.println(fteScoreBfs(456));
    // System.out.println(fteScoreBfs(789));
  }
}
