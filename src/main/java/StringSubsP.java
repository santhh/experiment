import com.google.common.collect.ImmutableMap;
import java.util.Scanner;

public class StringSubsP {
 static ImmutableMap<String, String> subMap = ImmutableMap.of("USER", "root","HOME", "/usr/local/home/%USER%","DATE", "2020-09-16");

  public static String replaceSub (String input){
    StringBuilder sb = new StringBuilder();
    Scanner scan = new Scanner(input);
    scan.useDelimiter("%");
    while(scan.hasNext()){
      String token = scan.next();
      if(subMap.containsKey(token)){
        sb.append(subMap.get(token));

      }else{
        sb.append(token);
      }
    }
    return sb.toString();
  }
  public boolean checkCircular(String sub){
    Scanner scan = new Scanner(sub);


    return false;
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
