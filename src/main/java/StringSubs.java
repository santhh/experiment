import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class StringSubs {
  static Map<String, String> replaceMap = new HashMap<>();
  public static String stringSub(String s){
    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(s,"%");
    while (st.hasMoreElements()){
     String key = st.nextToken();
      if(replaceMap.containsKey(key)){
        sb.append(replaceMap.get(key));
      }else{
        sb.append(key);
      }

    }

    return sb.toString();
  }

  public static String resolve (String value){

    StringBuilder sb = new StringBuilder();
    StringTokenizer st = new StringTokenizer(value, "%");

      while(st.hasMoreTokens()){
        value = st.nextToken();
        if(replaceMap.containsKey(value)){
          sb.append(replaceMap.get(value));
        }else{
          sb.append(value);
        }

      }

    return sb.toString();
    }

  public static void main (String args[]){

    replaceMap.putAll(
        Map.ofEntries(
            Map.entry("USER","root"),
            Map.entry("HOME","usr/local/home/%USER%"),
            Map.entry("DATE", "%HOME%/2020-12-01")
        )
    );

    for (Map.Entry<String,String> entity: replaceMap.entrySet()) {
      String value = entity.getValue();
      while (value.indexOf("%")>=0) {
        value = resolve(entity.getValue());
        entity.setValue(value);
      }

    }
    System.out.println(stringSub("%HOME%/data/file_%DATE%.txt"));
    // usr/local/home/root/data/file_2020-12-01.txt

  }

}
