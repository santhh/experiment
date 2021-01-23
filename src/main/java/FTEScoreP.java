import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FTEScoreP {
  static ImmutableMap<String, List<String>> fteMap = ImmutableMap.of("123", ImmutableList.of("234","345"),
      "234", ImmutableList.of("456","789"),
      "345", ImmutableList.of(),
      "456", ImmutableList.of(),
      "789", ImmutableList.of());

  static Map<String, Integer> saveMap = new HashMap<>();
  public static int findFteScore(String eid){
    int score = 0;
    if(fteMap.containsKey(eid)){
      score +=1;
      List<String> reports = (List)fteMap.get(eid);
      for (String reportEid : reports){
        score += findFteScore(reportEid);
      }
    }

    return score;
  }

  public static int findFteScoreDP(String eid){
    int score =0;
    if(saveMap.containsKey(eid)){
     return saveMap.get(eid);
    }
    if(fteMap.containsKey(eid)){
      score +=1;
      List<String> reports = fteMap.get(eid);
      for (String reportEid : reports){
        score += findFteScoreDP(reportEid);
      }
      saveMap.put(eid, score);
    }
    return score;
  }

  public static void main  (String args[]){
        // System.out.println(findFteScore("123"));
        // System.out.println(findFteScore("234"));
        // System.out.println(findFteScore("789"));
        // System.out.println();
        // System.out.println(findFteScoreDP("123"));
        // System.out.println(findFteScoreDP("234"));
        // System.out.println(findFteScoreDP("789"));
      for (String eid : fteMap.keySet()){
        System.out.println(findFteScoreDP(eid));
      }

  }
}
