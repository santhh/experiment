import com.google.common.collect.ImmutableMap;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class StringSubsP {
 static ImmutableMap<String, String> subMap = ImmutableMap.of("USER", "root","HOME", "/usr/local/home/%USER%","DATE", "2020-09-16 %USER%");
 // detect circular key
 static Set<String> visitedKeys = new HashSet<>();
  public static String replaceSub (String input){
    StringBuilder sb = new StringBuilder();
    Scanner scan = new Scanner(input);
    scan.useDelimiter("%");
    while(scan.hasNext()){
      String token = scan.next();
      if(subMap.containsKey(token)){
        if(!visitedKeys.isEmpty() && visitedKeys.contains(token)){
          return "Circular Key Detected";
        } else {
          sb.append(subMap.get(token));
          visitedKeys.add(token);
        }

      }else{
        sb.append(token);
      }
    }
    return sb.toString();
  }
   public static void main (String args[]){
    String input = "%HOME%/data/file_%DATE%.txt";
    String result = input;
    while (result.contains("%")){
      result = replaceSub(result);

    }
    System.out.println(result);

  }
}
