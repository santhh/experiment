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
    int startIndex = value.indexOf("%");
    int endIndex = value.lastIndexOf("%");
    if(startIndex >0 && endIndex >0){
      String key = value.substring(startIndex+1, endIndex);
      String replacevalue = value.substring(0,startIndex);
      return replacevalue.concat(replaceMap.get(key));
    }

    return value;
  }
  public static void main (String args[]){

    replaceMap.putAll(
        Map.ofEntries(
            Map.entry("USER","root"),
            Map.entry("HOME","usr/local/home/%USER%"),
            Map.entry("DATE", "2020-12-01")
        )
    );

    for (Map.Entry<String,String> entity: replaceMap.entrySet()) {
      String value = resolve(entity.getValue());
      entity.setValue(value);
    }
    System.out.println(stringSub("%HOME%/data/file_%DATE%.txt"));
    // usr/local/home/root/data/file_2020-12-01.txt

  }

}
