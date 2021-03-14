import java.util.HashMap;
import java.util.Map;

public class CountLetter {

  public static int countLetters  (String S){
    Map<String, Integer> map = new HashMap<>();
    for (int i=0;i< S.length()-1;i++){
      for (int j =i+1; j<S.length(); j++){
        String temp = S.substring(i, j);
        map.put(temp, map.getOrDefault(temp, 0)+1);
      }
    }
    int sum =0;
    for (Integer value : map.values()){
      sum += value;
    }
    return sum;

}
  public static void main (String args[]){
      System.out.println(countLetters("aaaba"));
  }
}
